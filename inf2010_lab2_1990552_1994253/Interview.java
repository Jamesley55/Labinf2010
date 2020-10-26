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
            int flippedPos = listOfNumbers.length() - i - 1;
            if(array[i] == '3' || array[i] == '4' || array[i] == '7')
                return false;
            else if(array[i] == '0')
                flippedArray[flippedPos] = '0';
            else if(array[i] == '1')
                flippedArray[flippedPos] = '1';
            else if(array[i] == '2')
                flippedArray[flippedPos] = '2';
            else if(array[i] == '5')
                flippedArray[flippedPos] = '5';
            else if(array[i] == '6')
                flippedArray[flippedPos] = '9';
            else if(array[i] == '8')
                flippedArray[flippedPos] = '8';
            else if(array[i] == '9')
                flippedArray[flippedPos] = '6';
        }
        System.out.println( flippedArray);
        if(java.util.Arrays.equals(array, flippedArray) == true)
            return true;
        return false;
    }

    /**
     * TODO Worst Case : O(n)
     * Could be valid if you try to flip the number upside down with one of the combinations.
     */

    public static boolean isValidFlippedWithPermutation(String listOfNumbers) {
        char [] permutationList = new char[listOfNumbers.length()];
        int permutationListIterator = listOfNumbers.length()-1;

        for( int i =0 ; i < listOfNumbers.length() ; i++){
            permutationList[i] =listOfNumbers.charAt(permutationListIterator);
            permutationListIterator--;
        }
        for(int i =0; i < listOfNumbers.length(); i++){
            if(permutationList[i] == listOfNumbers.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
