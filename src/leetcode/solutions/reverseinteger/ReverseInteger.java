package leetcode.solutions.reverseinteger;

public class ReverseInteger {

    public int reverse(int x) {
        // converting to string solution
        try {
            StringBuilder string_num = new StringBuilder();
            string_num.append(Math.abs(x)).reverse();

            int rev = Integer.parseInt(string_num.toString());
            if (x < 0) {
                return rev * (-1);
            }
            return rev;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int x = -123;
        System.out.println(solution.reverse(x));
    }
}
