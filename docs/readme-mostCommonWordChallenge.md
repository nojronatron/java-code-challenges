# Hashtables

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

## Big-O Analysis

Lookup a Value: O(1) in time, because the hash reproduces the index that locates the value in the array in one step.

Arrays are fast, but searching for data without knowing the index of the data ahead of time is slow - an O(n) operation.

Knowing the exact location of the data in an array is an O(1) operation!

Hashing Function: O(1) in Time.

Set a Value: O(1) in Time because the Hashing function locates the index of where to store the data -- an O(1) operation.

