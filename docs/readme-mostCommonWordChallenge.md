# Most Common Word Challenge

Write a function that finds the most commonly used word in a book.

Punctuation is ignored.

Input and output should be case-insensitive.

## Input and Output

Input: String "The quick brown fox jumps over the lazy dog."

Expected Output: String "the".

## Breaking Down The Problem

Since the problem domain deals with uniqueness, hashtable datastructures are good candidates to finding a solution.

### About Hashtable

In training, we learned how to create datastructures with the following features and capabilities:

- They are Key-Value pair datastructures that handle Key-Value pairs.
- They can detect unique or duplicate entries.
- A backing array stores the actual data within the hashtable.
- Within each index of the backing array is another data structure to store actual K-V items. In this case I will use a Linked List as the Bucket data structure.
- Backing array has a large size e.g. 1024 to help reduce collisions. In this case the size might need to be much larger.
- The hash method accepts a String and hashes it, performs a calculation on the hash, then performs a modulo of the size of the backing array, and returns an integer within the capacity of the backing array.
- Collisions are when the hashing algorithm stores data in the same backing array index. Duplicate items are stored in a Bucket's Linked List.
- In my development work, I've learned to create a 'count' property in the Linked List, so it can tell me how many items are in it.
- A HAS method accepts a Key and returns true if the Key exists in the backing array, false if not.
- A GET method that returns a reference to the Key-Value pair that is stored in the backing array's Linked List.
- A SET method that accepts a Key-Value pair, hashes the Key, and stores the Key-Value pair in the hashtable at the hashed index location.

### About Strings

Strings can have upper-case or lower-cased letters (characters or Chars).

Strings also encompass punctuation e.g. '.,:;!?@#' etc.

Items to Note:

1. Case sensitivity should be properly handled give the problem domain.
2. Punctuation might need to be stripped, ignored, or acknowledged and processed, depending on the problem domain.

Whenever performing a comparison between Strings:

1. Explicitly set the case as the same (i.e. lower) for case *in*sensitivity.
2. Do not alter the casing for case *sensitivity* processing.
3. Aggressively parse-*out* punctuation if that is unnecessary for the context/situation.

### Create Local Variable to Store Most Commonly Occurring Word and its Count

Initialize a 'Pair' (or similar Key-Value) type with a Key of '' and a Value of 0.

Name this local variable Most-Common-Word.

### Break Up The Input String Into Words

Utilize an existing Java String method such as `String.split(String regex)`.

Capture the results in a collection named WordList, so it can be iterated through.

### Implement a HashTable To Store Unique Words

Instantiate a Hashtable and use methods Has, Get, and Set.

Each entry in the Hashtable will consist of:

- Key: String: 'word'
- Value: Integer: a count of times word has been encountered

### Iterate Through Collection

Set up a For-Each or Advanced For Loop to iterate through WordList.

The following subsections detail the actions to take within each iteration.

#### Process Each Word In Collection

Every new Word in the collection is checked against the hashtable using HAS.

If HAS returns false:

- This means the word is not already in the hashtable (unique).
- Add the Word and an integer 1 to the hashtable using the SET method.

If HAS returns true, other code will run that will help find the most commonly occurring word.

##### Update Most Commonly Occurring Word and Count

When HAS returns true, use GET method and store in a reference variable.

Update the reference variable Value integer by one.

Test whether the current word Value (count) is greater than or less than the Most-Common-Word variable:

- Greater than: Replace Most-Common-Word Key and Value with that of the Word (in iteration) and the reference variable Value.
- Equal or Less than: Do nothing. The algorithm is looking for the 1st found most commonly occurring word.

Since the reference is updated directly, there is no need to execute the SET method to store the data change - it is done by reference.

### Exit Iterations and Return Result

Whatever Key-Value pair is in Most-Common-Word at this point will be:

- The most commonly occurring word of all input.
- A count of the times the word occurred in the input.

## PseudoCode

Designing a workable function requires writing some pseudocode to help work out bugs before writing any real code.

Here is my first shot at a possible working algorithm:

```text
ALGORITHM: getMostCommonWord()
INPUT: String
OUTPUT: String
INSTANTIATE: hashtable
INITIALIZE: delimiterString <- " "
INITIALIZE: wordList <= intputString.split using delimiterString
INITIALIZE: Pair mostCommonWord of type String, Integer
ASSIGN: mostCommonWord <- Key "", Value 0
ITERATE: FOR each word in wordList
    INSTANTIATE: tempWord <- word stripped(punctuation)
    ASSIGN: tempWord <- word to lowercase
    IF: hashtable.HAS tempWord
        INSTANTIATE: existingWord <- hashtable.GET tempWord
        INCREMENT: existingWord.Value by one
        IF: existingWord.Value is greater than mostCommonWord.Value
            ASSIGN: mostCommonWord.Key <- tempWord
            ASSIGN: mostCommonWord.Value <- existingWord.Value
        END IF
    ELSE: hashtable.SET tempWord
END ITERATE
RETURN: mostCommonWord.Key
```

After testing this on a whiteboard (briefly), it seemed to be ready to put to code.

Turns out there were some bugs that needed attention.

## Edge Cases and Input Cleansing

When working with Strings it is important to recall some REGEX terminology:

- Character Classes: Number, Letters, Whitespace, and other characters.
- Boundaries and Achors: Word boundaries and character boundaries.
- Recurring patterns or quantifiers: Sometimes there are multiple characters in a row that we want to include with, or exclude from, a substring.

Also keep in mind that splitting or replacing characters in a String might have some side effects:

```java
class Example {
    public void foo(String inputString) {
        // break up the String into array elements based on the space character
        final String wordList = inputString.split(" ");

        // now forced to check for puctuation on every single iteration of this advanced for loop
        for (
                String word : wordList) {
            String punctuationFreeWord = word.replaceAll("[^a-zA-Z0-9_\\s]");
        }
    }
}
```

Another way to do it, with a different side-effect:

```java
class Example {
    public void foo(String inputString) {
        // remove the punctuation from the entire string
        String puctuationFreeString = inputString.replaceAll("[^a-zA-Z0-9_\\s]");

        // split the string into an array
        String wordList = punctuationFreeString.split(" ");

        // still have to check for empty string or " " string entries (but that might be acceptable)
        for (String word: wordList) {
            if (word.equals("") || word.equals(" ")) {
                //  this is a fairly inexpensive solution that simply skips ahead to the next iteration
                continue;
            }
        }
    }
}
```

So consider the term "String" to be an alarm bell for a *bunch* of easy questions to ask during a technical interview.

Responses to questions like these will give you time to think about how to solve the problem, and might even provide additional clues to solving it:

- Will it matter if a capitalized or all upper-cased word matches an all lower-cased word?
- Will the input string contain any punctuation or other special characters that my algorithm needs to strip or process?
- If my algorithm receives an empty String, or one-or-more space characters, should it return what it received or null or something else?

etc...
