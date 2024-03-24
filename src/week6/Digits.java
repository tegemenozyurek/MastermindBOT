package week6;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TODO: Implement Digits class representing a number by storing its digits in an array
 */
public class Digits {
    private int[] digits; // Digits of the number

    public Digits(int[] digits) {
        this.digits = digits;
    }

    public Digits(Digits copied) {
        digits = new int[copied.digits.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = copied.digits[i];
        }
    }


    public Digits(int n)
    {
        digits = digitsOf(n);
    }

    public int toInt()
    {
        return valueOf(digits);
    }

    /**
     * A dangerous getter returning address of attribute
     * @return
     */
    public int[] getDigits() {
        return digits;
    }

    public int digitCount()
    {
        return digits.length;
    }

    public static int[] digitsOf(int n)
    {
        int digitCount = (int)Math.log10(n) +1;
        int[] digits= new int[digitCount];

        for (int d = 0; d < digitCount; d++) {
            digits[d] = n%10;
            n /=10;
        }
        return digits;
    }

    public static int valueOf(int[] digits)
    {
        int n =0;

        for (int d = digits.length-1; d >=0 ; d--) {
            n *=10;
            n += digits[d];
        }

        return n;
    }

    @Override
    public String toString() {
        return toInt()+ "";
    }

    public static Digits fromInt(int n)
    {
        return new Digits(n);
    }


    public static void main(String[] args) {
        Digits d1 = new Digits(1047);
        Digits d2 = new Digits(9714);

        System.out.println(Arrays.toString(d1.getDigits()));
        System.out.println(Arrays.toString(d2.getDigits()));

        System.out.println(d1);
        System.out.println(d2);
    }
}
