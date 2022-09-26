# Unique Characters In String Challenge

Write a function that will determine if the given string is full of unique characters.

## Design Approach

Utilize a hashmap to efficiently check for uniqueness.

- Ignore spaces.
- Case-sensitivity is a factor.
- Punctuation does not count as a character to check for uniqueness.
- Return type should be boolean type.

Examples:

```text
INPUT: "a b c d e f g"
OUTPUT: true

INPUT: "abcdefg"
OUTPUT: true

INPUT: "a.b,c!d?ef g"
OUTPUT: true

INPUT: "aAbBcCdD"
OUTPUT: true

INPUT: "aab"
OUTPUT: false

INPUT: "abcdDb"
OUTPUT: false
```

## Test Approach

Use JUnit Jupiter

Verify input-output examples above pass accordingly using unit tests.

### Link to Unit Tests

## Algorithm

During the interview challenge I assumed there was a need to implement hashmap functions, so my algorithm took too long to write.

Below is the algorithm without the additional hashmap functions:

1. Instantiate a hashtable.
2. Process input string in an iterator to break string into characters.
3. For each character check if it is a space and if so, go to next iteration, otherwise go to next step.
4. If hashmap 'has(character)' returns true: Function should return false and exit, otherwise continue to next step.
5. Use hashmap 'add(character)' function to add the character to the table.
6. When the iterations reach the end of the input array, exit the function and return true.

## Pseudocode

Time had expired before I could finish writing the pseudocode during the challenge, so that will not be added here.

For purposes of completing this challenge, exercising pseudocode skills, and preparing to write and test actual Java, the following pseudocode was written post-challenge.

Pseudocode:

```text
DECLARE: Function uniqueCharacters()
INPUT: String strInput
RETURNS: boolean

INSTANTIATE: hashmap <- new Hashmap
ITERATE: For each character in strInput:
    TEST: Character is '?!.,' ?
        TRUE: Remove character
    TEST: Character is '' ?
        TRUE: Remove character
    TEST: hashmap.Has() <- character
        TRUE: Return FALSE and exit function
    EXECUTE: hashmap.Add() <- character
RETURN: TRUE and exit function
```

## BigO Analysis

## Implementation

### Link to Code

## Scoring

## What Went Well

## How To Do Better Next Time

## Final Comments

## Footer

Return to root [readme](../README.md)
