# Is It An Anagram Challenge

## Input and Output

Input will be a String type:

- Single word.
- No spaces.
- No punctuation.
- Case can be ignored i.e. 'A' is equal to 'a'.

Output will be boolean:

- If the input String is an anagram, return True.
- Otherwise, return False.

## Breaking Down The Problem

An anagram is a word that reads the same forwards and backwards. For example: "tacocat".

A String is a type made up of Chars (characters).

Characters in the String need to be compared to determine if input is an anagram.

The algorithm will need to compare the "left half" of the input String to the "right half".

In the case of odd-length String, a means to find "left half" and "right half" will need to be implemented.

Achieve this by process half of the characters in the String, so they can be compared to the second half of characters in the String.

Start an iterator that will index through one half of the character array.

In each iteration do the following:

1. Push the characters from the array into the Stack until the iterator ends.

Start a new iterator at the index where the first iterator left off, ending with the last index of the character array.

In each iteration do the following:

1. POP a character from the stack.
2. Transform the POPed character to its lower-cased version.
3. Get the next indexed item from the character array.
4. Transform the indexed item to its lower-cased version.
5. Compare the lower-cased version of the POPped character with the next character in the input "right half" character array.
6. If they are NOT equal, return False and exit the function
7. If they are equal continue with the next iteration.

Once the Stack is empty, if the algorithm is still running all items must have matched to return TRUE and exit the algorithm.

### About Stacks

See my [readme about Stacks](./readme-stacks.md) for details.

A Stack is a good data structure to use here because:

- FILO has the effect of returning items in the opposite order from how they were added.
- It is O(1) in all operations, space and time, so is fairly efficient.
- Easily utilized within an iterative construct.
- Determining when the Stack is empty, or what the next value is w/o removing it, can be helpful.

### About Strings and Characters

Chars (characters) are single-character representations, stored in memory as unicode representations.

Chars can be upper-cased or lower-cased alphabetical characters, numbers, punctuation, and some other special characters.

It is always a good idea to filter-out items in a Char Array that are not needed or could cause problems in code.

String are constructs that contain Chars as a CharSequence (like an array of Characters).

Strings can be blank, or have many Chars stored within them.

Although Strings cannot be iterated through like an array can, a Char Array *can* be iterated through.

String Type has methods that help you work with the Chars stored within the String:

- CharAt: Single Char value returned from `String.charAt(int index)`.
- CharSequence: Char Array returned from `String.subSequence(int beginIndex, int endIndex)`.
- toCharArray: Char Array returned from `String.toCharArray()`. This does the iterating for you and so presumedly is an O(n) operation.

## Pseudocode

As originally written on the whiteboard during the 40-minute challenge:

```text
ALGORITHM: isAnagram()
INPUT: String StringInput
OUTPUT: Boolean
INSTANTIATE: CharStack <- New Stack
INITIALIZE: Characters <- StringInput.toCharArray()
INITIALIZE: ArrCount <- Characters.length
INITIALIZE: HalfLength <- (ArrCount) modulus 2 Equals 0 ?
    TRUE: <- ArrCount divided by 2
    FALSE: <- (ArrCount - 1) divided by 2
ITERATE: From index 0 to HalfLength, step +1
    EXECUTE: CharStack.Push <- Characters at index
ITERATE: From HalfLength to Characters.length - 1, step +1
    INITIALIZE: TempChar <- CharStack.Pop

// Time expired
```

The following refined Algorithm was created in Pseudocode to simplify operation and leverage available Fields and Methods:

```text
ALGORITHM: isAnagram()
INPUT: String StringInput
OUTPUT: Boolean
INSTANTIATE: CharStack <- New Stack
INITIALIZE: Characters <- StringInput.toCharArray()
INITIALIZE: MaxLeftIndex <= 0;
IF: ArrCount modulo 2 does not Equal 0
    ASSIGN: MaxLeftIndex <- (MaxIndex divided by 2) - 1
ELSE:
    ASSIGN: MaxLeftIndex <- MaxIndex divided by 2
ITERATE: From index 0 up to an including MaxLeftIndex, step +1
    EXECUTE: CharStack.Push <- Characters at index
IF: ArrCount modulo 2 does not Equal 0
    ASSIGN: MaxLeftIndex <- MaxLeftIndex + 1
ELSE:
    NOOP
ITERATE: While CharStack.IsEmpty is False:
    ASSIGN: MaxLeftIndex <- MaxLeftIndex + 1
    INITIALIZE: PoppedChar <- CharStack.Pop
    INITIALIZE: IndexedChar <- Character at Characters MaxLeftIndex
    IF: TempChar.ToLowerCase NOT equals IndexedChar.ToLowerCase
        TRUE: Return false
RETURN: True
```

## Edge Cases

- Can instantiate the hosting class.
- An anagram input returns true.
- An anagram input with mixed casing returns true (proving case insensitivity).
- A word that is not an anagram input returns false.
- The method does not raise an exception.
- Very small anagram e.g. 1 or 2 characters.
- Larger anagrams of both odd and even sizes.
- Small and Large character count words that are not anagrams.

## Algorithm Analysis

Multiple execution steps are taking place:

- Internal String method `String.toCharArray()` is certainly an O(n) in time, as it must iterate through the Characters stored in the String to get the Character values and set them into an array.
- Getting the size of an array is O(1) in time.
- Calculating addition, subtraction, and division are O(1) in time.
- The For iterator operates on 50% or less of the input array, so worst case is O(n/2) in time.
- Stack operations are all O(1) in time.
- Comparing `Character.toLowerCase(char)` instances is a hidden method, but I would guess it is a O(1) math problem and an O(1) comparison of integers, so probably O(1) in time.

Overall the worst case scenario in time is O(n) due to the 'toCharArray()' method.

As for space, the same 'toCharArray()' method will always duplicate each Character in the input string, so it will be an O(n) operation, making the entire algorithm O(n) in Space.

## Code and Test Cases

[Anagram Expert Class Code](../lib/src/main/java/myJava/code/challenges/AnagramExpert.java)

[Anagram Expoer Unit Tests](../lib/src/test/java/myJava/code/challenges/TestIsAnagram.java)

## Footer

Return to [root readme](../README.md)
