package org.example.matchingsubstring;

public class FindIndexOfMatchingSubstring {

    public static void main(String[] args) {

        String given = "asdIvan";
        String searched = "*van";

        System.out.println(getResult(searched, given));
    }

    private static int getResult(String searched, String given) {

        char[] charArray = given.toCharArray();
        char[] searchedArr = searched.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < searchedArr.length; j++) {

                boolean isStar = searchedArr[j] == '*';
                boolean isMatchingLetter = charArray[i + j] == searchedArr[j];
                if (!isStar && !isMatchingLetter) {
                    break;
                }
                if (j == searchedArr.length - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
