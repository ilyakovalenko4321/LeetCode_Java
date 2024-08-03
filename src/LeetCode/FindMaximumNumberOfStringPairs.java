package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindMaximumNumberOfStringPairs {

    private static final LinkedList<Character> characterLinkedList = new LinkedList<>();

    static {
        // Заполнение characterLinkedList
        for (char c = 'a'; c <= 'z'; c++) {
            characterLinkedList.add(c);
        }
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int result=0;
        List<Integer> repeatedCharacters = new ArrayList<>();

        for(String i: words){
            int hash = hashCode(i);
            if(!repeatedCharacters.contains(hash)){
                repeatedCharacters.add(hash);
            }else{
                result++;
                repeatedCharacters.remove(Integer.valueOf(hash));
            }
        }
        return result;
    }

    public int hashCode(String stringToDivideOnCharacters){
        char[] charArray = stringToDivideOnCharacters.toCharArray();
        int x = characterLinkedList.indexOf(charArray[0])+13;
        int y = characterLinkedList.indexOf(charArray[1])+13;
        return Math.abs((x+y)*(x-y)) + x + y;
    }
}
