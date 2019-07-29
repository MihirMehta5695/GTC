/**
 * Given a non-empty string like "Code" return a string like "CCoCodCode".
 * <p>
 * <p>
 * stringSplosion("Code") → "CCoCodCode"
 * stringSplosion("abc") → "aababc"
 * stringSplosion("ab") → "aab"
 */
public class StringSplosion {
    public static void main(String[] args) {
        System.out.println(new StringSplosion().stringSplosion("Code"));
    }

    public String stringSplosion(String str) {
        String newStr = "";
        for (int index = 1; index <= str.length(); index++) {
            newStr = newStr.concat(str.substring(0, index));
        }
        return newStr;
    }
}
