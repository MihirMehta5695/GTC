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
            HashMap inputStringHM = convertInputStringToMap(s);
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
        for (String word : listOfWords) {
            if (correctAns == null) {
                correctAns = word;
            }
            if (correctAns.equals(originalString))
                return correctAns;
            for (int index = 0; index < word.length(); index++) {

            }
        }
        return correctAns;
    }
}
