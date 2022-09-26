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

INPUT: "DabcdDb"
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
    TEST: Character is ' ' ?
        TRUE: Remove character
    TEST: hashmap.Has() <- character
        TRUE: Return FALSE and exit function
    EXECUTE: hashmap.Add() <- character
RETURN: TRUE and exit function
```

*Note*: There may be some tweaks necessary for this Pseudocode to properly represent functional code. Updates will be made as needed.

## BigO Analysis

*Note*: For analysis of this function, hashmap will *not* be included. Refer to [readme-hashtable](readme-hashtable.md) instead.

TIME:

- Overall, the worst-case scenario is a duplicate is never found or not found until the last character in the string is checked.
- Since an Advanced For Loop (Java) is an O(n) operation in worst-case, and there is only one iterating structure, the overall efficiency of the algorithm will the O(n) -> linear.

SPACE:

- Additional space is not required for this function to perform its job (other than accepting an input of length n), so the overall efficiency of the algorithm is O(1) -> constant.

## Implementation

The solution will utilize an existing [custom hashtable .java](../lib/src/main/java/myJava/code/models/MyHashtable.java).

Solution code can be found in [Unique Characters .java](../lib/src/main/java/myJava/code/challenges/UniqueCharacters.java).

## Scoring

Time expired during the design portion of the challenge, so my score will be quite low:

Interpret the Q: 9/10

Solved the Problem: 4/12

Analysis of Solution: 5/6

Effective Communication (estimated): 11/12

Total: 29/40 (34 necessary to pass).

## Retrospective

Reviewing completed work is important to the learning process, building knowledge and skills for the future.

### What Went Well

- Due to training and practicing, I was pretty sure that a hashmap would be needed to simplify finding uniqueness.
- Talking through the problem domain while drawing the inputs and expected output(s) helped me find new questions to ask that would better refine the problem domain.
- Early on I felt comfortable writing out test approaches and several test cases.
- Drawing the problem domain and incorporating logic statements at each step, with arrows between blocks, helped visually represent an algorithm.

### How To Do Better Next Time

- I needed to ask more question, for example I missed question: "Can I rely on existing methods and features of a hashmap data structure?" (Especially Has(), Hash(), and Add()?) This would have greatly reduce time spent adding those functions to my algorithm, and I would not have walked through Big-O analysis of a hashmap (neither of which were the point of this challenge).
- Because I could not quickly remember how to use `String.replace(char)` and `String.replaceAll(regex)`, I ad-hoc leveraged an Enhanced For Loop to break the String into characters which will not work. Instead, use `String.toCharArray()` and store in a temp variable and *then* use an Enhanced For to iterate through the characters.
- The Code Fellows curriculum states that Hashtable has a `set()` method, as opposed to an `add()` method. While it is not clear this will matter in a real world challenge, I need to review these details to commit them to memory.

TODOs

- [ ] Practice String replace() function.
- [ ] Practice RegEx using String replaceAll() function.
- [ ] Study the required input types for Hashmap methods. If they require a String instead of a Char, then String.valueOf(character) will be necessary.
- [ ] Practice setting Regex in Java as a String (requires escape characters to set rule like "\\W"
- [ ] Practice setting Regex in Java using Pattern and Matcher classes.

## Final Comments

Remember: The interview process is a means for hiring managers to get to know you and how you think.

Failing (or not completing) a technical interview is not synonymous with being shown the door.

Concentrate on the problem at hand and displaying how I think through the problem in order to solve it.

## Footer

Return to root [readme](../README.md)
