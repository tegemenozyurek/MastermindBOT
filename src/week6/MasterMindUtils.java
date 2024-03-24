package week6;

import week6.utils.RandomSource;

public class MasterMindUtils {
    public static boolean hasDuplicates(int[] arr )
    {
        for (int f1 = 0; f1 < arr.length - 1; f1++) {
            for (int f2 = f1+1; f2 <arr.length ; f2++) {
                if (arr[f1]== arr[f2])
                    return true;
            }
        }

        return false;
    }

    public static boolean hasDuplicates(Digits d)
    {
        return hasDuplicates(d.getDigits());
    }

    public static boolean isValid(Digits d, int digitCount)
    {
        return d.digitCount() == digitCount && !hasDuplicates(d);
    }

    public static Digits randomNumber(int digitCount)
    {
        int n;
        RandomSource rs= new RandomSource();
        Digits d;
        do {
            n = rs.randWithDigits(digitCount);
            d = Digits.fromInt(n);
        } while ( hasDuplicates(d));

        return d;
    }

    public static int plusOf(int[] d1, int[] d2)
    {
        int plus =0;

        for (int d = 0; d < d1.length; d++) {
            if (d1[d]== d2[d])
                plus++;
        }
        return plus;
    }

    public static int minusOf(int[] d1, int[] d2)
    {
        int minus=0;

        for (int i1 = 0; i1 < d1.length; i1++) {
            for (int i2 = 0; i2 < d2.length; i2++) {
                if ( i1!=i2 && d1[i1]== d2[i2])
                    minus++;
            }
        }
        return minus;
    }


    public static MMComparison compare(Digits d1, Digits d2)
    {
        int plus = plusOf(d1.getDigits(),d2.getDigits());
        int minus = minusOf(d1.getDigits(),d2.getDigits());

        return new MMComparison(plus,minus);
    }



    public static void main(String[] args) {
        Digits d= randomNumber(5);

        System.out.println(d);
    }

}
