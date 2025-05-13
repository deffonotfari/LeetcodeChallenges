/**
* Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
*
* The algorithm for myAtoi(string s) is as follows:
*
* Whitespace: Ignore any leading whitespace (" ").
* Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
* Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
* Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
*/

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int num = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;

        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i < s.length() && s.charAt(i) == '+'){
            i++;
        } else if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = Character.getNumericValue(s.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			num = num * 10 + digit;
			i++;
		}
		return sign * num;    
    }
}
