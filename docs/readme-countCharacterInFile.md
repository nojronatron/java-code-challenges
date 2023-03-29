# Count Character Instances in a Text File

This challenge came about from reading Oracle Java Documentation on Streams.

## Goal

Write an example that counts the number of times a particular character (e.g. 'e') appears in a file.

Character can be specified at the command line.

## How To Use

### Requirements

- Path to a local file of MIME type text.
- Gradle 7.4.2
- JVM: Eclipse Adoptium 17.0.6+10 or newer
- OpenJDK: 17.0.6 or newer

This project is a component of a much larger project, so you will need to build and execute Package "myJava.code.challenges" class "CountCharsInFile".

If you execute with Gradle: `./gradlew run --args "filename c"

Note: 'filename' needs to be the full filepath to an existing text file and 'c' is the character you want to find.

If you build using Java -C then you can execute the file natively as an executable and the input arguments will be the same as above.

## Design

There are Byte Streams that can be used to read file contents.

For reading Text from a file, use Character Stream instead.

Use Try-Catch-Finally semantics to handle Exceptions and avoid memory leaks.

Utilize `java.io.FileReader` to read-in 'characters' from the text file.

Use modular design techniques.

## Pseudocode

```text
DECLARE: Class CountCharactersInFile

DECLARE: Static Method Main
INPUT: String Array inputArgs
OUTPUT: void
INSTANTIATE: String filename <- args at index 0
INSTANTIATE: String searchChar <- arg at index 1
TEST: filename length greater than 1 AND searchChar length equals 1
    ELSE: Write to terminal "Invalid input. Enter a filename with path and extension, and a single-character search term."
    RETURN: Exit method
TRY:
    INSTANTIATE: Number count <- GetCount <- filename, searchChar
    RETURN: "Found _letter_ _count_ times."
CATCH:
    RETURN: "An error occurred: Could not find or access _filename_"

DECLARE: Static Method GetCount
INPUT: String filename, String letter
OUTPUT: Number counter
THROWS: IOException
INSTANTIATE: FileReader inputStream <- null
INITIALIZE: Number character
INITIALIZE: Number counter <- 0
TRY: 
    REASSIGN: inputStream <- FileReader <- filename
    ITERATE: While 
        ASSIGN: character <- inputStream <- read
        TEST: character NOT equals -1
            TEST: character equals letter
                INCREMENT: counter <- +1
FINALLY:
    TEST: fileReader NOT null
        EXECUTE: inputStream <- close
RETURN: counter
```

## Test Approach

Design a specific text-only file with 'Lorem ipsum' or similar text snippet.

Run the executable selecting different characters (e.g. 'a') and ensure the proper count is returned.

```text
Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
```

Test golden path: Count of 'a' in Lorem Ipsum file returns 7.

Other tests:
- Count of 'o' in Lorem Ipsum: 10
- Count of 'z' in Lorem Ipsum: 0
- Count of '1' in Lorem Ipsum: 0
- Empty file input does not throw in main (should return message 'cannot process file').
- Empty file input throws IOException in GetCount method
- Count of capital 'L' in Lorem Ipsum: 1
- Count of lowercase 'l' in Lorem Ipsum: 5

## Retrospective Comments

- A console app has a main entrypoint, and by default many IDE templates select `public static void main(String[] args)` when in some instances a return other than void might be necessary, or inputs other than an array of String is required.
- If my main entrypoint _does_ require a result, then go ahead and change the void to the return type!
- Designing the solution on the whiteboard first helped to keep my pseudocoding on track.
- Using my pseudocode as a guide helped to keep my actual code writing on track.
- Pseudocode stated Main was going to return `void` but then I went ahead and returned a String anyway - this means I am not paying close enough attention to the method signature while designing and/or coding.
- Transformation of a single character String to a Char type does not work! Char types are character _codes_ and Strings do not expose this directly.
- Use `string.toCharArray()` to expose the array of character codes that the String object stores internally, then access the array through indexing.

Total time spent from design through documentation, implementation, testing and retrospective: Approx 3 hours.

## Footer

Return to [Root README](../README.html)
