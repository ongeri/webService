package japheth.ongeri.tulaa.operations;

public class StringReverser {
    /**
     * A method that takes a string to be reversed, reverses the alphabetic characters and returns the reversed result string
     *
     * @param toBeReversed The string that needs to be reversed
     * @return The reversed string
     */
    public String reverseString(final String toBeReversed) {
        final char[] charArrayToBeReversed = toBeReversed.toCharArray();//A char array to hold input, will not be modified
        //Get substring of only alphabetic characters
        String alphaLettersToBeReversed = toBeReversed.replaceAll("\\P{L}+", "");
        char[] charArrayalphaLettersToBeReversed = alphaLettersToBeReversed.toCharArray();
        //This variable holds the index of the next alphanumeric character to be inserted into the reversec characters array
        int nextAlphaChar = charArrayalphaLettersToBeReversed.length - 1;//Initialize to the last index because we will pick in reverse order
        for (int j = 0; j < charArrayToBeReversed.length && nextAlphaChar >= 0; j++) {// The nextAlphaChar > 0 check enables the loop to exit early when all chars have been placed and all remaining indices contain other symbols
            if (Character.isLetter(charArrayToBeReversed[j])) {
                char alphaCharToPlace = charArrayalphaLettersToBeReversed[nextAlphaChar];
                charArrayToBeReversed[j] = alphaCharToPlace;
                //Decrement pointer of next char to place
                nextAlphaChar--;
            }
        }
        return new String(charArrayToBeReversed);
    }
}
