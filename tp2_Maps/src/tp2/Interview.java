package tp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Interview {

    /**
     * TODO Worst Case : O(n)
     * Is valid if you flip the number upside down.
     */
    //  Character.getNumericValue()
    public static boolean isValidFlipped(String listOfNumbers) {
        char[] array = new char[listOfNumbers.length()];
        char[] flippedArray = new char[listOfNumbers.length()];

        for(int i = 0; i < listOfNumbers.length(); i++) {
            array[i] = listOfNumbers.charAt(i);
        }

        for(int i = 0; i < listOfNumbers.length(); i++){
            if(array[i] == '3' || array[i] == '4' || array[i] == '7')
                return false;
            else if(array[i] == '0')
                flippedArray[listOfNumbers.length() - i] = '0';
            else if(array[i] == '1')
                flippedArray[listOfNumbers.length() - i] = '1';
            else if(array[i] == '2')
                flippedArray[listOfNumbers.length() - i] = '2';
            else if(array[i] == '5')
                flippedArray[listOfNumbers.length() - i] = '5';
            else if(array[i] == '6')
                flippedArray[listOfNumbers.length() - i] = '9';
            else if(array[i] == '8')
                flippedArray[listOfNumbers.length() - i] = '8';
            else if(array[i] == '9')
                flippedArray[listOfNumbers.length() - i] = '6';
        }

        if(java.util.Arrays.equals(array, flippedArray) == true)
            return true;
        return false;
    }

    /**
     * TODO Worst Case : O(n)
     * Could be valid if you try to flip the number upside down with one of the combinations.
     */
    public static boolean isValidFlippedWithPermutation(String listOfNumbers) {
        return false;
    }
}
