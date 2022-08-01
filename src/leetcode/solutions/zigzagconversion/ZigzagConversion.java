package leetcode.solutions.zigzagconversion;


public class ZigzagConversion {

    public String convert(String s, int numRows) {

        // create array for storing strings
        String[] stringArray = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            stringArray[i] = "";
        }
        int index = 0;
        boolean add = true;

        for (int i = 0; i < s.length(); i++) {
            stringArray[index] = stringArray[index] + s.charAt(i);

            if (add) {
                index++;
                if (index > numRows - 1) {
                    add = false;
                    index = index - 2;
                    if (index < 0) {
                        return s;
                    }
                }

            } else {
                index--;
                if (index == -1) {
                    add = true;
                    index = index + 2;
                }
            }
        }
        StringBuilder solution = new StringBuilder();
        for (String value : stringArray) {
            solution.append(value);
        }
        return solution.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(solution.convert(s, numRows));
    }
}