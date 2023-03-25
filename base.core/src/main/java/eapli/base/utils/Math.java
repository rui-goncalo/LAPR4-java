package eapli.base.utils;

import eapli.framework.util.Utility;

/**
 * The type Math.
 */
@Utility
public class Math {

    private Math() {
        //Ensure utility
    }

    /**
     * Decimal to hexadecimal string.
     *
     * @param num the num
     * @return the string
     */
    public static String decimalToHexadecimal(int num) {
        int exponent = 0;
        StringBuilder hexNum = new StringBuilder();
        if (num == 0) {
            return Integer.toString(0);
        }
        while (num != 0) {
            if (num < 16) {
                hexNum.insert(0, hexChar(num));
                break;
            }
            double div = (num / 16.0);
            int digit = (int) ((div - (int) div) * 16);
            hexNum.insert(0, hexChar(digit));
            num /= 16;
        }
        return hexNum.toString();
    }

    private static String hexChar(int digit) {
        switch (digit) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return Integer.toString(digit);
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
        }
        return null;
    }

    /**
     * Hexadecimal to decimal int.
     *
     * @param toString the to string
     * @return the int
     */
    public static int hexadecimalToDecimal(String toString) {
        int num = 0;
        int exponent = 0;
        for (int i = toString.length() - 1; i >= 0; i--) {
            int digit = decimalChar(toString.charAt(i));
            num += (int) (digit * java.lang.Math.pow(16, exponent));
            exponent++;
        }
        return num;
    }

    private static int decimalChar(char charAt) {
        charAt = Character.toUpperCase(charAt);
        StringBuilder sb = new StringBuilder();
        switch (charAt) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                sb.append(charAt);
                return Integer.parseInt(sb.toString());
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;

        }
        return -1;
    }

    /**
     * Random integer int.
     *
     * @param min the min
     * @param max the max
     * @return the int
     */
    public static int randomInteger(int min, int max) {
        return (int) java.lang.Math.round(java.lang.Math.random() * (max - min) + min);
    }


    public static byte intToByte(int codeKey) {
        return ((byte) (codeKey % 256));
    }

    public static int byteIntoUnsignedInt(byte b) {
        if (b > 0) {
            return b;
        } else {
            return 255 + b + 1;
        }

    }

    public static long millisecondsToMinutes(Long intervalOfTime) {
        return intervalOfTime * 6 * 10000;//60 * 10^3 || 6 *10^4
    }
}
