import java.util.Scanner;

public class StringsOperations {

    Scanner sc = new Scanner(System.in);
    private int index = 0; //index to track the alphabet position in array
    /*
     * compare two Strings
     * @param str1 as first string
     * @param str2 as second string
     * @return 1 if both strings are equal
     * @return 0 if both Strings are unequal
     */
    public int compare(String str1, String str2) {
        int i = 0;
        if (str1.length() != str2.length()) {
            return 0;
        } else {
            for (i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    break;
                } else {
                    continue;
                }
            }
        }
        if (i == str1.length()) {
            return 1;
        } else {
            return 0;
        }
    }
    

    /*
     * Reverse the string given into parameter
     * @param str as user input
     * @return reversed string of the input string
     */
    public String reverse(String str) {
        String reverseString = "";
        for (int i = (str.length() - 1); i >= 0; i--) {
            reverseString += str.charAt(i);
        }
        return reverseString;
    }

    
    /*
     * Reverse the string given into parameter
     * @param str as user input
     * @return reversed string of the input string
     */
    public String updateString(String str) {
        String updatedString = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isUpperCase(ch)) {
                ch = (char)((ch + 32));
                System.out.println("upper::::" + ch);
            } else if (isLowerCase(ch)) {
                ch = (char)((ch - 32));
                System.out.println("lower::::" + ch);
            } else {
                updatedString += ch;
                continue;
            }
            updatedString += ch;
        }
        return updatedString;
    }
    

    /*
     * finds the longest word in length
     * @param str as user input
     * @return longest word from the input string
     */
    public String findLongestWord(String str) {
        String longestWord = "";
        String[] word = str.split(" ");
        longestWord = word[0];
        for (int i = 0; i < word.length; i++) {
            if (longestWord.length() <= word[i].length()) {
                longestWord = word[i];
            }

        }

        return longestWord;
    }

    private boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public void showChoiceMenu() {
        String str = null;
        System.out.println("Enter your choice\n1.Compare Strings  2.Reverse the String  3.Update String lower and upper case characters  4.Find the largest word ");
        int Choice = sc.nextInt();
        switch (Choice) {
            case 1:
                System.out.println("Enter the first string: ");
                String str1 = sc.next();
                System.out.println("Enter the second string:");
                String str2 = sc.next();
                System.out.println(compare(str1, str2));
                break;
            case 2:
                System.out.println("Enter the string: ");
                str = sc.next();
                System.out.println("\nReversed String: "+reverse(str));
                break;
            case 3:
                System.out.println("Enter the string: ");
                str = sc.next();
                System.out.println("\nUpdated String: "+updateString(str));
                break;
            case 4:
                System.out.println("Enter the string: ");
                sc.nextLine();
                str = sc.nextLine().trim();
                System.out.println("Longest word: "+findLongestWord(str));
                break;
            default:
                System.out.println("Incorrect choice...");
        }

    }
}