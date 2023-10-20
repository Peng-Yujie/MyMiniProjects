package houserental.utils;

// The function of this class is to handle various user input situations

import java.util.*;

public class Utility {
    // Static variable scanner is used to read user input
    private static Scanner scanner = new Scanner(System.in);


    /**
     * read the user input of a character, which should be in the range of 1-5
     * @return 1-5
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);// A string contains one character
            c = str.charAt(0);// Convert the string to a character
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("Invalid input, please enter again: ");
            } else break;
        }
        return c;
    }

    /**
     * read the user input of a character, which should be a character
     * @return one character
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);// limit = 1, blankReturn = false
        return str.charAt(0);
    }

    /**
     * return the user input, otherwise return the default value
     * @param defaultValue default value
     * @return a character or default value
     */

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);// a string contains one character or blank
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * read the user input of an integer, of which the length should be less than 10
     * @return 整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);// an integer should be less than 10 digits
            try {
                n = Integer.parseInt(str);// Convert the string to an integer
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, please enter again: ");
            }
        }
        return n;
    }
    /**
     * read the user input of an integer, otherwise return the default value
     * @param defaultValue default value
     * @return an integer or default value
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            // Handle the NumberFormatException
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, please enter again: ");
            }
        }
        return n;
    }

    /**
     * read the user input of a string in a given length
     * @param limit the length of the string
     * @return a string
     */

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * read the user input of a string in a given length, otherwise return the default value
     * @param limit the length of the string
     * @param defaultValue default value
     * @return a string or default value
     */

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }


    /**
     * read the choice of the user, which should be Y or N
     * @return Y / N
     */
    public static char readConfirmSelection() {
        System.out.println("Please enter Y/N");
        char c;
        for (; ; ) {
            // Infinite loop
            // Read the first character of the string and convert it to upper case
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Invalid input, please enter again: ");
            }
        }
        return c;
    }

    /**
     * read a string from the keyboard
     * @param limit the length of the string
     * @param blankReturn whether to return a blank string
     *                    true: return a blank string
     *                    false: return a string
     * if the input is blank or the length of the input is greater than limit, it will prompt to re-enter.
     * @return a string
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            // If the user input is blank, and blankReturn = true, return a blank string
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            // If the string length is greater than limit or less than 1, prompt to re-enter
            // Otherwise, return the string
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The input length should be less than" + limit + "), please enter again: ");
                continue;
            }
            break;
        }

        return line;
    }
}

