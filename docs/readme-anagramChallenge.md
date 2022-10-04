# Is It An Anagram Challenge

This effort is the result of re-attempting the Anagram Challenge.

The previous time I attempted this, I mistook anagram for palindrome, so I've created a separate solution for that in the [palindrome expert class](../lib/src/main/java/myJava/code/challenges/PalindromeExpert.java).

## Input and Output

Input will be a String type:

- Single word.
- No spaces.
- No punctuation.
- Case can be ignored i.e. 'A' is equal to 'a'.

Note: An updated version accepts *two* input strings and determine if one is an anagram of the other.

Output will be boolean:

- If the input String is a palindrome, return True.
- Otherwise, return False.

## Breaking Down The Problem

An anagram is a pair of words that share the same characters, such as "debit card" and "bad credit".

A String is a type made up of Chars (characters).

Characters in the String need to be compared to determine if input is an anagram.

The algorithm will need to compare the two String inputs.

Since we are checking if characters in one String exist within another String, a hashtable will be implemented for rapid storage, retrieval, and comparison.

1. Filter *out* any punctuation from both String inputs.
2. Filter *out* space characters.
3. Compare the lengths of the two String inputs and if they are different, then they cannot be an anagram so return false and exit.
4. Break the String inputs into their own Character arrays, one for each.
5. Iterate through the characters in the 1st array, adding each to a hashtable instance, until all 1st array characters have been added.
6. Iterate through the 2nd array, checking the hashtable if each character already in there.
7. If the current iteration's character is *not* found in the hashtable, return false and exit the function.
8. Once the 2nd character array has been iterated through completely and the function has not already exited, return true and exit.

### About Hash Tables

See my [readme about hash tables](./readme-hashtable.md) for details.

A Hash Table is a good data structure to use here because:

- Adding items to the hash table is an O(1) operation.
- Checking to see if a value is already in the hash table is O(1).
- The space used by a hash table can be large to start, but storage is efficient even with very large inputs.
- Hash tables guarantee ability to test for non-uniqueness in a collection of items.

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
INPUT: String Input1, String Input2
OUTPUT: Boolean
INSTANTIATE: Hashtable <- New Hashtable Character, Integer
INITIALIZE: FirstInput <- Input1 replace non-word-characters with blank string
INITIALIZE: SecondInput <- Input2 replace non-word-characters with blank string
IF: FirstInput length is NOT EQUAL to SecondInput length
    RETURN: False
ELSE:
    CONTINUE
INITIALIZE: InputArr1 <- FirstInput toCharArray()
INITIALIZE: InputArr2 <- SecondInput toCharArray()
ITERATE: Index 0 through InputArr1 length - 1, step +1
    EXECUTE: Hashtable.add <- InputArr1 at Index
ITERATE: Index 0 through InputArr2 length - 1, step +1
    ASSIGN: Result <- hashtable has <- InputArr2 at Index
    IF: Result EQUALS FALSE
        RETURN: False
    ELSE:
        CONTINUE
RETURN: True
```

There are a few issues with this algorithm that I did not catch due to time pressures:

1. Testing for upper vs lower case. This is a simple one-line test e.g. Character.toLowerCase(char c) Equals ...
2. String.replace() is pretty good but in order to use a REGEX (as implied) the actual method in Java is `String.replaceAll(regex, replacement)`.
3. Utilize Enhanced For or ForEach (depending on language) to avoid having to index through the array(s).

The following refined Algorithm was created in Pseudocode to simplify operation and leverage available Fields and Methods:

```text
ALGORITHM: isAnagram()
INPUT: String Input1, String Input2
OUTPUT: Boolean
INSTANTIATE: Hashtable <- New Hashtable Character, Integer
INITIALIZE: FirstInput <- Input1 replace all non-word-characters with blank string
INITIALIZE: SecondInput <- Input2 replace all non-word-characters with blank string
IF: FirstInput length is NOT EQUAL to SecondInput length
    RETURN: False
ELSE:
    CONTINUE
INITIALIZE: InputArr1 <- FirstInput toCharArray()
INITIALIZE: InputArr2 <- SecondInput toCharArray()
ITERATE: For each Item in InputArr1:
    EXECUTE: Hashtable.add <- Item toLowerCase
ITERATE: For each Item in InputArr2
    ASSIGN: Result <- hashtable has <- InputArr2 at Index
    IF: Result EQUALS FALSE
        RETURN: False
    ELSE:
        CONTINUE
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

- Internal String replacement method `String.replaceAll(regex, replacement)` is likely an O(n) operation on each input, so O(2 * n).
- Internal String method `String.toCharArray()` is certainly an O(n) in time, as it must iterate through the Characters stored in the String to get the Character values and set them into an array.
- Getting the size of an array is O(1) in time.
- The For iterator operates on each input array, so worst case is O(2 * n) in time.
- Hash Table operations are all O(1) in time.
- Comparing `Character.toLowerCase(char)` instances is a hidden method, but I would guess it is a O(1) math problem and an O(1) comparison of integers, so probably O(1) in time.

Overall the worst case scenario in time is O(n * 6) due to the 'toCharArray()' method calls, the replaceAll method calls, and the 2 custom For iterators to interact with the hash table with O(1) operations. Final algorithmic efficiency in time is O(n).

As for space, multiple operations store and operate on the inputs. In a worst-case scenario the duplication is fully both inputs at each assignment, and while adding items to the hashmap, which is perhaps as bad as O(n * 5). Final algorithmic efficiency in space is O(n).

## Code and Test Cases

[Anagram Expert Class Code](../lib/src/main/java/myJava/code/challenges/AnagramExpert.java)

[Anagram Expert Unit Tests](../lib/src/test/java/myJava/code/challenges/TestIsAnagram.java)


## Footer

Return to [root readme](../README.md)
