package leetcode.solutions.stringtoInteger;


import static java.lang.Character.isDigit;


public class StringToInteger {

    static final String MAX_VALUE_STRING = Integer.toString(Integer.MAX_VALUE);
    static final String MIN_VALUE_STRING = Integer.toString(Integer.MIN_VALUE);

    static final int MAX_VALUE = Integer.MAX_VALUE;
    static final int MIN_VALUE = Integer.MIN_VALUE;
    public int myAtoi(String s) {
        Boolean isPositive;

        s = ignoreLeedingWhitespace(s);

        if (s.isEmpty()) {
            return 0;
        }

        isPositive = checkIfPositiveOrNegative(s);

        s = deleteZerosFromTheBeginning(s);
        s = justNumberAsString(s);
        s = checkIfTooBigForInt(s, isPositive);


        int num = convertStringToNumber(s, isPositive);

        return num;
    }

    private String deleteZerosFromTheBeginning(String s) {
        if (s.isEmpty()) {
            return "0";
        }

        int i = 0;
        for (i =0; i<s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                i++;
            } else break;
        }

        if (i == 0) {
            return s;
        }

        if (isDigit(s.charAt(i-1))) {
            return s.substring(i-1);
        }

        return "0";
    }
    private int convertStringToNumber(String s, Boolean isPositive) {
        if (s.isEmpty()) {
            return 0;
        }

        int aa = Integer.parseInt("-2147483648");
        int num = Integer.parseInt(s);

        return num;
    }

    public String checkIfTooBigForInt(String s, Boolean isPositive) {
        if (s.isEmpty()) {
            return "0";
        }

        if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            return "0";
        }

        double  num_long = Double.parseDouble(s);

        if (num_long > MAX_VALUE) {
            return MAX_VALUE_STRING;
        }

        if (num_long < MIN_VALUE) {
            return MIN_VALUE_STRING;
        }
        return s;
    }


    private String ignoreLeedingWhitespace(String s) {
        return s.stripLeading();
    }

    private Boolean checkIfPositiveOrNegative(String s) {
        if (s.charAt(0) == '-') {
            return false;
        }
        return true;
    }

    private String justNumberAsString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
                continue;
            }
            if (!isDigit(s.charAt(i))) {
                s = s.substring(0, i);
                return s;
            }
        }
        return s;
    }


    public static void main(String args[]) {
        String input_s = "0000042a1234";
        var obj = new StringToInteger();
        System.out.print((obj.myAtoi(input_s)));
    }
}
