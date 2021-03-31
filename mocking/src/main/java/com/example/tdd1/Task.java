package com.example.tdd1;

public class Task {
    /*
    String Calculator

2) Create a simple String calculator with a method int add(string numbers):
- The method can take 0, 1 or 2 numbers, and will return their sum.
- For an empty string it will return 0

Start with the simplest test case.
Remember to solve things as simple as possible so that you force yourself to write
tests you did not think about.
Remember to refactor after each passing test.

3) Allow the add method to handle an unknown amount of numbers.

4) Allow the add method to handle new lines between numbers (instead of commas):
- the following input is ok: 1\n2,3 (will equal 6)
- the following input is NOT ok: 1,\n (no need to prove it - just clarifying)

5) Support different delimiters.
To change a delimiter, the beginning of the string will contain a separate line that
looks like this:
//[delimiter]\n[numbers]
For example: //;\n1;2 should return 3, where the delimiter is ;.

The first line is optional. All existing requirements should still be supported.

6) Calling add with a negative number.
This will throw an exception with message "Negatives not allowed" and the negative
that was passed.
If there are multiple negatives, show all of them in the exception message.

-------------
Stop here if you are a beginner.
Continue if you can finish the steps in less than 30 minutes.
-------------

7) Additional excercises:
- Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2.
- Delimiters can be of any length, with the following format: //[delimiter]\n for
example: //[***]\n1***2***3 should return 6.
- Allow multiple one char delimiters like this: //[delim1][delim2]\n for example
//[*][%]\n1*2%3 should return 6.
- Make sure you can also handle multiple delimiters with length longer than one char.
     */
}
