# Hashtable

Overview of the Hashtable datastructures, and how to use them in an algorithm.

## Purpose

Use a hashtable to hold *unique* values, or as storage for dictionary items, or libraries of entries.

## About Hashtable

A Hashtable is a data structure.

A Hashtable can:

- Store key-value pairs.
- Quickly retrieve a value.
- Encode Keys using a hash of the value to create an index.
- Efficient at lookups for values.

## Terminology

- Hash: Take an incoming String and convert it into a numeric value. Could be used for security or as a key-index to a table.
- Buckets: Abstract containers located at each index of the hashtable array. Multiple key/value pairs can be stored in each Bucket as collisions occur.
- Collisions: More than one key gets hashed to the same numeric value. For a Hashtable, this means the values will be placed in the same hashtable array index or Bucket.
- Node: Alternative terminology for Bucket, but also more descriptive abstraction of how data is stored in a Bucket. Each Node holds both the Key and the Value of each data item within the Bucket.

## Methods

In a production environment there may be other methods, depending on the hashtable purpose.

Not all methods discussed here will be directly available for use from existing Java libraries.

Some methods will be abstracted within a Library, App, or Service, although the overall functionality will be there, just under a different name.

### SET

`void set(String key, obj value)`

Accepts a Key Value Pair and adds them to the backing array.

Pseudocode:

```text
ALGORITHM: set()
INPUT: String: key, Integer: value
OUTPUT: void
INITIALIZE: hashedIndex <- hash(key)
INSTANTIATE: entry <- new Pair types String, Integer
ADD: BackingArray at hashedIndex <- entry
```

*Remember*: Each backing array index "bucket" might be a linked list so just get a reference to the Bucket and use its existing functions to process the current item.

### GET

`int get(String key)`

Accepts a Key and finds the hashed index for that key, iterates through the Bucket to find the key and returns the value, or null if not found.

In my implementation, the Datatype will be a tuple-like type, similar to Pair:

```text
Pair<String, Integer> newPair = new Pair<>(key, value);
```

Pseudocode:

```text
ALGORITHM: get
INPUT: String: key
OUTPUT: Integer
INITIALIZE: Integer hashedIndex <- output of function Hash(String: key)
INITIALIZE: Bucket <- output of Get(Integer: hashedIndex) on BackingArray
INITIALIZE: BucketContents <- output of Get(String: key) on Bucket
RETURN: BucketContents.Value
```

### HAS

`boolean has(String key)`

Accepts a Key and returns boolean if the key exists in the hashtable.

Pseudocode:

```text
ALGORITHM: has
INPUT: String: key
OUTPUT: Boolean
ASSIGN: hashedIndex <- Hash(String: key)
IF: Result of get(String key) on BackingArray is not NULL
RETURN: TRUE
ELSE: Return FALSE
```

### KEYS

`collection<String> keys()`

Returns a collection of unique hash keys.

The CodeFellows curriculum states 'Keys() returns a collection (array) of unique hash keys'.

One approach is to just iterate through the backing array and return all the indexes (hashed Keys) and return those number.

A complete approach might be to return an Array of the actual keys that are stored *in the buckets* (see *[Wikipedia article on Linked Lists]*).

So, the following Pseudocode attempts to get all bucket Keys and return them to the caller.

```text
FUNCTION: keys()
INPUT: none
OUTPUT: collection of Integers
ITERATE: For each bucket in backing array
    INITIALIZE: NewArray type: Integer
    INITIALIZE: CurrentNode <- bucket.head
    ITERATE: While CurrentNode is not NULL
        ADD: NewArray <- CurrentNode.data
        REASSIGN: CurrentNode <- CurrentNode.Next()
    END ITERATE
END ITERATE
RETURN: NewArray
```

A more efficient approach would be:

1. Create a property in the Hashtable that is a collection type, called keysCollection.
2. Every time an item is added, copy the key to the keysCollection.
3. Any time an item is *removed*, remove that item's key from the keysCollection.
4. When keys() is called, just return the collection directly to the caller (an O(1) operation).

```text
FUNCTION: keys()
INPUT: none
OUTPUT: collection of Integers
RETURN: KeysCollection
```

And within the Add() function:

```text
CALL: KeysCollection <- Add Key
```

And within a Remove() function:

```text
ITERATE: For each item in KeysCollection
    IF: Item.value equals Key
    CALL: KeysCollection.Remove
    RETURN: TRUE
RETURN: FALSE
```

### HASH

A Hashing function takes a key and returns an integer.

This is used as a means to find an index in a collection.

`number hash(String key)`

Accepts a key as a String, hashes it, and returns an integer.

This can be used to determine where the key-value-pair should be placed in a collection.

Pseudocode:

```text
ALGORITHM: hash()
INPUT: String: key
OUTPUT: Integer
INITIALIZE: Integer hashedIndex <- key.hashCode()
ASSIGN: hashedIndex <- hashedIndex multiplied by 599;
ASSIGN: hashedIndex <- modulus the size of the backing array
RETURN: hashedIndex
```

### Additional Methods

- Public Boolean: isEmpty -> Quickly determine if there are items in the hashtable.
- Private Void initializeBuckets: Sets empty LinkedLists into every index of the array so they can be queried and have values added to them.
- Public Float getLoadFactor(): Optional. Returns a decimal number between 0 and 1 representing the ratio of Buckets with at least 1 item, to the total size of the backing array.
- Public getBucketCount(): Optional. Returns the total number of indexes in the backing array. Does *not* include the number of items within buckets.
- Public getItemCount(): Optional. Returns the total number of items stored in all buckets.
- Public removeItem(): Optional. Finds an item with a specific Key and Value and removes it from the HashTable.

## Properties

A hashtable needs a few built-in properties to be a functional:

- A backing array of a particular size.
- Buckets made up of a Linked Lists (other types are possible).

### Backing Array

An array of a set size that will store the data.

Code Fellows curriculum suggests a size of 1024 to start, but this is really up to the application.

A smaller array with a larger unique dataset will result in many hashing collisions.

A larger array with a smaller unique dataset will leave lots of unused Buckets, wasting memory.

Hashtable should have access to the size of the backing array to be able to calculate a useful hashed index.

### Buckets

This is really a property of the Backing Array.

This solution will be a Linked List type made of Nodes that will store the Key and the Value of each unique input added to the hashtable.

```text
LinkedList<Pair<Integer, String>> bucket = new LinkedList<>();
```

### Load Factor

The Code Fellows curriculum introduces this idea but does not address it. From other research, the laod factor represents how "full" the hashtable is, particularly the backing array and its buckets.

In the past I've used a simple calculation of (_total_buckets_ / _count_of_keys_), which ignores the total number of items within each bucket, which might/not be a problem, depending on the goals of the hashmap design.

The purpose of Load Factor is to determine when to balance the hashtable.

For this codebase I will implement Load Factor as a simple way to determine how full (or empty) the hashtable is, but no re-balancing will be done.

## Big-O Analysis

Lookup a Value: O(1) in time, because the hash reproduces the index that locates the value in the array in one step.

> Arrays are fast, but searching for data without knowing the index of the data ahead of time is slow - an O(n) operation.

> Knowing the exact location of the data in an array is an O(1) operation!

Hashing Function: O(1) in Time.

Set a Value: O(1) in Time because the Hashing function locates the index of where to store the data -- an O(1) operation.

## Code

[My Hash Table class](../lib/src/main/java/myJava/code/models/MyHashtable.java)

[PairLinkedList Class](../lib/src/main/java/myJava/code/models/PairLinkedList.java) for storing tuple-type Key-value pairs.

## Tests

[My Hash Table Unit Tests](../lib/src/test/java/myJava/code/models/TestMyHashtable.java)

[Pair Linked List Unit Tests](../lib/src/test/java/myJava/code/models/TestPairLinkedList.java)

## Resources and Acknowledgements

- Baeldung.com article: [Using Pair in Java](https://www.baeldung.com/java-pairs)
- Code Fellows Common Curriculum.
- [Wikipedia - Collision Resolution](https://en.wikipedia.org/wiki/Hash_table#Collision_resolution) indicates that the keys themselves *should* be returned, since they contain useful data and would never be null-valued.


## Footer

Return to [root readme](../README.md)
