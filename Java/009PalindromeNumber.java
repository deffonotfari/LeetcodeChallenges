import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * */

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || x > 0 && x % 10 == 0){
          //return false as x is not a palindrome  
          return false;
        }

        int y = 0;
        for (; y < x; x/=10){
            y = y * 10 + x % 10;
        }

        //return true, as x is a palindrome
        return x == y || x == y / 10;
    }
}
