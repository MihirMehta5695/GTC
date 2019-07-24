package com.mihir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Challenge -
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 * <p>
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
 * <p>
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 * <p>
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
 * <ol>
 * <li>The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".</li>
 * <li>The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.</li>
 * <li>The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.</li>
 * </ol>
 * <p>
 * Learning objectives:
 * This question gives you the chance to practice with algorithms and data structures. It’s also a good example of why careful analysis for Big-O performance is often worthwhile, as is careful exploration of common and worst-case input conditions.
 */

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String s = br.readLine();
            String[] d = br.readLine().split(" ");
            HashMap<Character, ArrayList<Integer>> inputStringHM = convertInputStringToMap(s);
            System.out.println(biggestSubString(inputStringHM, d, s));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static HashMap<Character, ArrayList<Integer>> convertInputStringToMap(String s) {
        HashMap<Character, ArrayList<Integer>> inputStringHM = new HashMap<>();
        // Big-Oh of n
        for (int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            if (inputStringHM.containsKey(character)) {
                ArrayList<Integer> listOfIndices = inputStringHM.get(character);
                listOfIndices.add(index);
                inputStringHM.put(character, listOfIndices);
                continue;
            } else {
                ArrayList<Integer> listOfIndices = new ArrayList<>();
                listOfIndices.add(index);
                inputStringHM.put(character, listOfIndices);
                continue;
            }
        }
        return inputStringHM;
    }

    private static String biggestSubString(HashMap<Character, ArrayList<Integer>> inputStringHashMap, String[] listOfWords, String originalString) {
        String correctAns = null;

        //Big-Oh of (WxL)
        //Iterating through the list of words

        for (String word : listOfWords) {

            // If the word's length is greater that originalString length, it is not possible that it is subsequence of originalString
            if (word.length() > originalString.length()) {
                continue;
            }

            // If word is exactly same as original String,we return the String as it is the perfect subsequence
            if (word.equals(originalString)) {
                return word;
            }

            // If word's length is less than originalString, there is a possibility for word being a subsequence of originalString
            else if (isValidSubsequence(word, originalString, inputStringHashMap)) {
                if ((correctAns == null) || (correctAns != null && correctAns.length() <= word.length())) {
                    correctAns = word;
                }
            }
        }
        return correctAns;
    }

    private static Boolean isValidSubsequence(String word, String s, HashMap<Character, ArrayList<Integer>> stringLetterIndexMap) {

        Boolean isValidSubseq = true;
        int currentIndexOfS = -1;
        for (int currentIndexOfWord = 0; currentIndexOfWord < word.length(); currentIndexOfWord++) {

            // Current character of Word
            char currentCharInWord = word.charAt(currentIndexOfWord);

            // If letter exists in S
            if (stringLetterIndexMap.containsKey(currentCharInWord)) {


                ArrayList<Integer> listOfIndicesForCharInS = stringLetterIndexMap.get(currentCharInWord);

                for (int i = 0; i < listOfIndicesForCharInS.size(); i++) {

                    int tempIndex = listOfIndicesForCharInS.get(i);

                    if (tempIndex > currentIndexOfS) {
                        currentIndexOfS = tempIndex;
                        break;
                    }

                    if (tempIndex < currentIndexOfS && tempIndex < (s.length() - 1)) {
                        if (i + 1 == listOfIndicesForCharInS.size() || i == listOfIndicesForCharInS.size()) {
                            isValidSubseq = false;
                            break;
                        }
                        continue;
                    }

                    if (tempIndex < currentIndexOfS && tempIndex == (s.length() - 1)) {
                        isValidSubseq = false;
                    }

                }


            } else {
                isValidSubseq = false;
            }

        }
        return isValidSubseq;
    }
}