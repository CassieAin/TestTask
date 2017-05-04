/**
 * Created by roksolana on 04.05.17.
 */

import java.util.*;

public class Main {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input the string: ");
        String input = scanner.nextLine();

        Map<Character, Integer> map = countOccurences(input);
        Character minKey = findLeastFrequentSymbol(map);
        System.out.println(minKey);
    }

    private static Map<Character, Integer> countOccurences(String str){
        int length = str.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(Math.min(length, 26));

        for (int i = 0; i < length; ++i)
        {
            char charAt = str.charAt(i);

            if (!map.containsKey(charAt))
            {
                map.put(charAt, 1);
            }
            else
            {
                map.put(charAt, map.get(charAt) + 1);
            }
        }
        return map;
    }

    private static Character findLeastFrequentSymbol(Map<Character, Integer> inputMap){
        int minValue = Collections.min(inputMap.values());
        Character minKey = null;
        for (Map.Entry<Character, Integer> mapEntry : inputMap.entrySet()) {
            if (mapEntry.getValue() == minValue) {
                minKey = mapEntry.getKey();
            }
        }
        return minKey;
    }

}
