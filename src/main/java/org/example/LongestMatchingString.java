package org.example;

public class LongestMatchingString {
    public static void main(String[] args) {

        String first = "PeshoGoshoTosho";
        String second = "PeshoStoqnGoshoTosho";

        System.out.println(solve(first, second));
    }

    private static String solve(String first, String second) {
        char[] firstArr;
        char[] secondArr;
        if (first.length() > second.length()) {
            firstArr = first.toCharArray();
            secondArr = second.toCharArray();
        } else {
            firstArr = second.toCharArray();
            secondArr = first.toCharArray();
        }

        String longestMatch = "";
        for (int i = 0; i < firstArr.length; i++) {
            StringBuilder currentMatch = new StringBuilder();
            for (int j = 0; j < secondArr.length; j++) {

                if (i + j > firstArr.length - 1) {
                    break;
                }
                char currentGiven = firstArr[i + j];
                char currentSearched = secondArr[j];
                boolean isStar = currentSearched == '*';
                boolean isMatchingLetter = currentGiven == currentSearched;
                if (isStar || isMatchingLetter) {
                    currentMatch.append(currentGiven);
                } else {
                    currentMatch = new StringBuilder();
                }
                if (currentMatch.length() > longestMatch.length()) {
                    longestMatch = currentMatch.toString();
                }
            }
        }

        return longestMatch;
    }
}
