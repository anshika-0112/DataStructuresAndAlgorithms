package GeeksForGeeks.Feburary;

import java.util.ArrayList;

/* Level -Medium (Topic - Recursion)
Problem Statement:- Given a string s and a dictionary of n words dictionary, find out if a s can be segmented into a
space-separated sequence of dictionary words. Return 1 if it is possible to break the s into a sequence of dictionary
words, else return 0.

    Input:
    n = 6
    s = "ilike"
    dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
    Output:
    1
    Explanation:
    The string can be segmented as "i like".
 */

public class Feb_20_WordBreak {
    public int wordBreak(int n,String a, ArrayList<String> b )
    {
        if(helper(a,b,0,a.length()))
            return 1;
        else return 0;
    }
    boolean helper (String a,ArrayList<String> b,int i,int n){
        if(i>=n){
            return true;
        }
        for(int j=0;j<b.size();j++){
            int len=b.get(j).length();
            String str="";
            if(i+len<=n){
                str=a.substring(i,i+len);
            }
            if(str.equals(b.get(j))){
                if(helper(a,b,i+len,n))
                    return true;
            }
        }
        return false;
    }
}
