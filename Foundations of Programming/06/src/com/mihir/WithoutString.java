package com.mihir;

/***
 *
 Given two strings, base and remove,
 return a version of the base string where all instances of the remove string have been removed
 (not case sensitive).
 You may assume that the remove string is length 1 or more.
 Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".


 withoutString("Hello there", "llo") → "He there"
 withoutString("Hello there", "e") → "Hllo thr"
 withoutString("Hello there", "x") → "Hello there"
 */

public class WithoutString {

    public static void main(String[] args) {
        String base = "This is a FISH";
        String remove = "IS";

        new WithoutString().withoutString(base, remove);
    }

    public String withoutString(String base, String remove) {

        String answer = "";


        String[] afterSplitting = base.toUpperCase().split(remove.toUpperCase());
        int removeLength = remove.length();

        int indexOfS = 0;
        for (int arrayIndex = 0; arrayIndex < (afterSplitting.length); arrayIndex++) {
            int jumpIndex = afterSplitting[arrayIndex].length();
            answer = answer.concat(base.substring(indexOfS, indexOfS+jumpIndex));
            indexOfS+=jumpIndex+removeLength;
        }

        System.out.println(answer);

        return answer;
    }
}
