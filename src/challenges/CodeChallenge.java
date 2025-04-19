package challenges;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CodeChallenge {

    public static int longestSubarrayWith2DistinctItemDiffOne(List<Integer> arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < arr.size(); right++) {
            int curr = arr.get(right);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);

            // Shrink window until valid
            while (!isValid(freqMap)) {
                int leftVal = arr.get(left);
                freqMap.put(leftVal, freqMap.get(leftVal) - 1);
                if (freqMap.get(leftVal) == 0) {
                    freqMap.remove(leftVal);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    private static boolean isValid(Map<Integer, Integer> freqMap) {
        if (freqMap.size() <= 1) return true;
        if (freqMap.size() > 2) return false;

        Iterator<Integer> it = freqMap.keySet().iterator();
        int a = it.next();
        int b = it.next();
        return Math.abs(a - b) <= 1;
    }


    public static void canBeMadeSmallerBySwapping(List<String> usernames) {

        usernames.forEach(word -> {
            boolean canBeSmaller = false;

            for (int i = 0; i < word.length(); i++) {
                for (int j = i + 1; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    // Swap characters at i and j
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;

                    String swapped = new String(chars);
                    if (swapped.compareTo(word) < 0) {
                        canBeSmaller = true;
                        break;
                    }
                }
                if (canBeSmaller) break;
            }

            System.out.println("Word: " + word + " -> Can be made smaller by swapping? " + canBeSmaller);
        });

    }

    public static boolean isPalindrome(String input) {


        String normalaized=input.toLowerCase();
        return IntStream.range(0,normalaized.length()/2).allMatch(i-> normalaized.charAt(i)==normalaized.charAt(normalaized.length()-1-i));


    }

    public static boolean isPalindromeByBuilder(String input) {
        String normalized = input.toLowerCase();
        StringBuilder reversed = new StringBuilder(normalized).reverse();
        return normalized.equals(reversed.toString());
    }
}
