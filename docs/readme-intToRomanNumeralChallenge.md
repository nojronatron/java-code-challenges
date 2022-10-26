# Convert Integer to Roman Numeral Challenge

Write a function that will take an integer input and return a String representation of the Roman Numeral of the same value.

## About This Challenge

The initial challenge question asserted the input to the method will be an Integer, but the sample inputs were actually Strings, so my solution assumes the calling method will send a String representation of a valid integer.

There was a maximum number limitation of 5,000. This meant the highest-order Roman Numeral that would be used is a "V" with a bar across the top, which I will depict using a tilde: "~V".

Another limitation is to not use built-in methods. I'm pretty sure this is not possible and is there to frustrate the candidate in working through this challenge.

The solution(s) I write about here:

1. Will not necessarily be the best in performance nor efficiency.
2. Might have adjusted requirements (that will be called out) so a slightly different approach can be taken.
3. Show efforts from white boarding solutions to the problem domain.
4. Demonstrate implementing good practices such as test-driven development, problem-solving before coding, leveraging the power of Java along the way.

## Design Approaches and Solutions

### First and Second Attempts

My first attempts at solving this challenge were miserable failures. I actually forgot about trying this 3 times before getting close to an answer.

I worked on other tasks and aspirations for a few days before each attempt so that I could approach it with a clear mind each time.

### Third Attempt

My third attempt was also a failure in that I ran out of time before documenting enough elements of technical discussion, and not having a viable solution in code.

Although this was another failed attempt, a good deal of progress was made, so I took an extra 90 minutes (yes, tripling the time originally allowed) to come up with what could be a viable solution.

My reasoning is this:

- Test my problem-solving skills, to see if I was on a viable course.
- Review my solution from the unit testing perspective, which will help find holes in my logic.
- Review my solution while coding it in an IDE, so I can learn from mistakes, as well as reaffirm good decisions made during the challenge.

#### Try 3 Overview

My overall approach was:

1. Better analyze Roman Numerals to ensure I understood how they worked.
2. Find the areas in Roman Numeral counting where unique decisions had to be made, and group them together.
3. Find the areas in Roman Numeral counting where similar/same decisions had to be made and refine the solution step(s) so they meet as many cases as possible.
4. Step through my algorithm in great detail. Every variable, iteration, and result was tracked, using two sample input values.
5. There is overlap in how Roman Numerals define digit values, and how Integers do as well, so reverse-order the input and apply conversion rules from least-significant to most-significant digit places.
6. Ignore absolute efficiency and instead concentrate on solving the problem. Efficiency can be built in later.

The Algorithm was then designed to:

1. Push individual digits into a Stack. This enabled returning them in last-in-first-out order.
2. Use a lookup table that will enable finding the current character-placement value, as well as the once-more-significant value, and the once-less significant value, to apply the correct numbering characters accordingly.
3. Leverage the very inefficient String concatenation to force-together the Roman Numerals, once the algorithm finds what it needs based on the input.

#### Try 3 Pseudocode

The following pseudocode was developed in its entirety within the initial 40-minute time limit:

```text
DECLARE: Method ToRomanNumerals
INPUT: String InputNumbers
OUTPUT: String Result

DECLARE: Result <- String ""
INSTANTIATE: RomanNumerals <- new Array [ "I", "V", "X", "L", "C", "D", "M", "~V" ]
DECLARE: IDX <- Integer 0
INSTANTIATE: NumberStack <- new Stack of type Integer
ITERATE: For each Char item in InputNumbers:
    EXECUTE: NumberStack <- Push Item cast as an Integer // could throw
ITERATE: While NumberStack is not empty:
    ASSIGN: CurrentValue <- NumberStack Pop
    ASSIGN: IDX <- IDX + 2
    IF: CurrentValue greater than 0 and less than 4:
        ITERATE: From 0 to CurrentValue times:
            ASSIGN: Result <- RomanNumerals[IDX-2] + Result
    ELSE IF: CurrentValue is 4:
        ASSIGN: Result <- RomanNumerals[IDX-2] + Result
        ASSIGN: Result <- RomanNumerals[IDX-1] + Result
    ELSE IF: CurrentValue is greater than 4 and less than 9:
        DECLARE: TempRN <- RomanNumerals[IDX-1]
        REASSIGN: CurrentValue <- CurrentValue - 5
        ITERATE: From 0 to CurrentValue:
            ASSIGN: Result <- RomanNumerals[IDX-1] + Result
    ELSE: // value is 9
        ASSIGN: Result <- RomanNumerals[IDX-2] + Result
        ASSIGN: Result <- RomanNumerals[IDX] + Result
RETURN: Result
```

Pseudocode commentary:

- I should have called StringBuilder or used a Char primitive Array to store and concatenate to variable Result.
- Using String is time and space heavy especially within nested loops.
- Instead of writing 'Result <- RomanNumerals[IDX-1] + Result' etc, I should have written 'Result <- RomanNumerals at IDX-1 and concatenate Result' (sticking with Strings of course).
- I am not totally certain that Casting Char Item to an Integer is going to throw.
- In Java code I would test for valid inputs so a throw is unlikely that far into an algorithm.
- TempRN is never called, so capturing it ensures a bad result when the input value ends in 5, 6, 7, or 8.
- 

#### Try 3 Implementation

See JAVA Class [Integer to Roman Numeral Class](..lib/src/main/java/myJava/code/challenges/IntegerToRomanNumeral.java)

#### Try 3 BigO Analysis

Time: O(n*m)

- Nested loops.
- Outer loop depends on input size.
- Inner loop depends on value (1-3 or 6-8).
- Some cases might be O(n^2), other cases O(n*m).

Space: O(n^2)

- New Stack of size n.
- Array of size supported digit places *2 (1's, 5's, 10's, 50's, 100's, 500's, etc).

#### Try 3 Test Approach and Test Cases

For Java code I implement JUnit Jupiter.

Happy Path Tests:

- Input "1900" returns "MCM"
- Input "634" returns "DCXXXIV"
- Input "2020" returns "MMXX"
- Input "2099" returns "MMXCIX"

Edge Cases:

- Zero-length input does not throw.
- Negative integer input does not throw.
- Input "0" returns an empty String.
- Input 1, 2, or 3 returns only "I" characters.
- 10's characters ending in 4 return "IV" characters at the end.
- 100's characters ending in 9 return "IX" characters at the end.
- Input "4999" returns "M~VCMXCIX"

Note: Additional test cases added while writing this readme:

- "5000" returns "~V".
- Any input greater than 5000 returns an empty string (since output is a String, it could be "sorry dave I can't do that").

#### Try 3 Retrospective

##### What Went Well

- Was able to complete a viable algorithm within the time limit.
- Was able to complete Pseudocode within the time limit.
- Step-through was complete and clear, and I was able to walk through it 2 times to verify the algorithm would work.
- The depiction of the problem solution was effective in generating a reasonable algorithm, as well as whittle down the code branches from 10 down to 4, without writing any code.

##### How To Do Better Next Time

- When I don't understand the challenge, or I think there is a lot of ambiguity, I need to ask more questions and make note of the answers on the whiteboard.
- Chars and Strings are closely related. Whenever dealing with portions of a String, I need to remember to consider the Char primitive to help with stepping through String values.
- If I am going to concatenate Strings, then I need to reflect the poor time performance in my BigO analysis.
- Write an out-of-bounds test-case statement, since the highest number supported in this challenge was 5000, that should have been easy to do and taken very little time to write.
- I need to remember to transform String inputs to character arrays using `stringInput.toCharArray()`. It is not possible to iterate through a String directly.
- Ask: What is the maximum number Roman Numerals support?
- Follow-up question: What if the input is above that number, what are the expectations?
- Go faster. :smiley:

## Overall Takeaways From This Experience

Turns out that Roman Numerals only count up to 3999 *[Mozilla.org]* and *[en.wikipedia.org]* without significant modification of characters, or simply extending usage of "M" (thousands).

## Footer

Return to [Root README](../README.md)
