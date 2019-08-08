/**
 * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
 * <p>
 * <p>
 * sumNumbers("abc123xyz") → 123
 * sumNumbers("aa11b33") → 44
 * sumNumbers("7 11") → 18
 */
public class SumNumbers {

    public static void main(String[] args) {
        String inputString = "Chocolate";
        System.out.println(new SumNumbers().sumNumbers(inputString));
    }

    public int sumNumbers(String str) {
        int sum = 0;
        String numbersOnlyWithSpace = (str.replaceAll("[^0-9]", " ").replaceAll(" +", " ").trim());
        String[] numbersInString = numbersOnlyWithSpace.split(" ");
        for (int index = 0; index < numbersInString.length; index++) {
            if(numbersInString[index].equals("")){
                continue;
            }
            sum = Integer.parseInt(numbersInString[index]) + sum;
        }
        return sum;
    }
}
