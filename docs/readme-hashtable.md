# Hashtable

Overview of the Hashtable datastructures, and how to use them in an algorithm.

## Terminology

- Hash: Take an incoming String and convert it into a numeric value. Could be used for security or as a key-index to a table.
- Buckets: Abstract containers located at each index of the hashtable array. Multiple key/value pairs can be stored in each Bucket as collisions occur.
- Collisions: More than one key gets hashed to the same numeric value. For a Hashtable, this means the values will be placed in the same hashtable array index or Bucket.
- Node: Alternative terminology for Bucket, but also more descriptive abstraction of how data is stored in a Bucket. Each Node holds both the Key and the Value of each data item within the Bucket.

## Purpose

Use a hashtable to hold *unique* values, or as storage for dictionary items, or libraries of entries.

## About Hashtable

A Hashtable is a datastructures.

A Hashtable can:

- Store key-value pairs.
- Quickly retrieve a value.
- Encode Keys using a hash of the value to create an index.
- Efficient at lookups for values.

A Hashtable has:

Hashing Function: Takes a key and returns an integer.

## Methods

In a production environment there may be other methods, depending on the hashtable purpose. Similarly, some of the following methods might not be directly available for use, or will be otherwise abstracted within a Library, App, or Service.

### SET

`void set(String key, obj value)`

Accepts a Key Value Pair and adds then hashtable.

Pseudocode:

```text
ALGORITHM: set()
INPUT: String: key, Integer: value
OUTPUT: void
INITIALIZE: hashedIndex <- hash(key)
INSTANTIATE: entry <- new Pair types String, Integer
ADD: BackingArray at hashedIndex <- entry
```

### GET

`int get(String key)`

Accepts a Key and finds the hashed index for that key, iterates through the Bucket to find the key and returns the value, or null if not found.

Datatype will be the built-in Java type, Pair:

```text
Pair<String, Integer> newPair = new Pair<>(key, value);
```

Pseudocode:

```text
ALGORITHM: get
INPUT: String: key
OUTPUT: Integer
INITIALIZE: Integer hashedIndex <- output of function Hash(String: key)
INITIALIZE: LinkedList <- output of Get(Integer: hashedIndex) on BackingArray
INITIALIZE: llHead <- LinkedList.Head
ITERATE: While llHead is not NULL:
    IF: llHead value equals key => return llHead value and exit
    ELSE: ASSIGN llHead <- llHead.Next()
END ITERATE
RETURN: NULL
```

### HAS

`boolean has(String key)`

Accepts a Key and returns boolean if the key exists in the hashtable.

Pseudocode:

```text
ALGORITHM: has
INPUT: String: key
OUTPUT: Boolean
IF: Result of get(String key) is not NULL
RETURN: TRUE
ELSE: Return true
```

### KEYS

`collection<String> keys()`

Returns a collection of unique hash keys.

Pseudocode:

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

## HASH

`number hash(String key)`

Accepts a key as a String, hashes it, and returns an index of the array where the key-value-pair should be placed.

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

## Properties

A hashtable needs a few built-in properties to be a functional: A backing array of a particular size, Buckets made up of a Linked Lists (other types are possible).

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

For this codebase I will implement Load Factor as a simple way to determine how full (or empty) the hashtable is, but no rebalancing will be done.

## Big-O Analysis

Lookup a Value: O(1) in time, because the hash reproduces the index that locates the value in the array in one step.

Arrays are fast, but searching for data without knowing the index of the data ahead of time is slow - an O(n) operation.

Knowing the exact location of the data in an array is an O(1) operation!

Hashing Function: O(1) in Time.

Set a Value: O(1) in Time because the Hashing function locates the index of where to store the data -- an O(1) operation.

## Code

[My Hash Table class](../lib/src/main/java/myJava/code/challenges/MyHashtable.java)

## Tests

[My Hash Table Unit Tests](../lib/src/test/java/myJava/code/challenges/TestMyHashtable.java)

## Resources and Acknowledgements

- Baeldung.com article: [Using Pair in Java](https://www.baeldung.com/java-pairs)
- Code Fellows Common Curriculum.
