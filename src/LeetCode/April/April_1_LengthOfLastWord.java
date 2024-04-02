package LeetCode.April;

public class April_1_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();
    }
}
