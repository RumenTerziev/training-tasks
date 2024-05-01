package org.example;

public class IndexOfMatchingSubstring {
    public static void main(String[] args) {

        String given = "PeshoGoshoToshoLosho";
        String searched = "*osho";

        System.out.println(solve(given, searched));
    }

    private static int solve(String given, String searched) {
        char[] givenArr = given.toCharArray();
        char[] searchedArr = searched.toCharArray();

        for (int i = 0; i < givenArr.length; i++) {
            for (int j = 0; j < searchedArr.length; j++) {

                if (i + j > givenArr.length - 1) {
                    break;
                }
                char currentGiven = givenArr[i + j];
                char currentSearched = searchedArr[j];
                boolean isStar = currentSearched == '*';
                boolean isMatchingLetter = currentGiven == currentSearched;
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
