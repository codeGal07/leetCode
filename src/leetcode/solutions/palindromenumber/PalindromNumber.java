package leetcode.solutions.palindromenumber;

public class PalindromNumber {

    public static boolean isPalindrome(int x) {
        StringBuilder num_s = new StringBuilder(Integer.toString(x));
        return num_s.toString().equals(String.valueOf(num_s.reverse()));
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
    }
}
