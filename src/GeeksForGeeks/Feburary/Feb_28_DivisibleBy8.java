package GeeksForGeeks.Feburary;

/*
 Given a string representation of a decimal number s, check whether it is divisible by 8.

Example 1:

Input:
s = "16"
Output:
1
Explanation:
The given number is divisible by 8,
so the driver code prints 1 as the output.
 */
public class Feb_28_DivisibleBy8 {
    int DivisibleByEight(String s){
        int num=0;
        if(s.length()<3)
        {
            num=Integer.parseInt(s);
        }
        else{
            num=Integer.parseInt(s.substring(s.length()-3));
        }
        return (num%8==0)?1:-1;
    }
}
