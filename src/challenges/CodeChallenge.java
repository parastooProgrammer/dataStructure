package challenges;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int complete = Math.abs(target - nums[i]);
            if (numsMap.containsKey(complete)) {
                result[0] = i;
                result[1] = numsMap.get(complete);
                return result;
            }
            numsMap.put(nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {


        String l1ST=l1.stream().map(String::valueOf).collect(Collectors.joining());
        String l2ST=l2.stream().map(String::valueOf).collect(Collectors.joining());

        StringBuilder l1STR=new StringBuilder(l1ST);
        StringBuilder l2STR=new StringBuilder(l2ST);

        Integer result=Integer.valueOf(l1STR.reverse().toString())+Integer.valueOf(l2STR.reverse().toString());
        StringBuilder resultSTR=new StringBuilder(result.toString());


        LinkedList<Integer> list = resultSTR.reverse().toString().chars()  // IntStream of character codes
                .mapToObj(c -> Character.getNumericValue(c)) // convert char to int
                .collect(Collectors.toCollection(LinkedList::new));

        return list;



    }
}
