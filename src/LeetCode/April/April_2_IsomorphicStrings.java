package LeetCode.April;

import java.util.*;

public class April_2_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m){
            return false;
        }
        HashMap<Character,Character> hmap=new HashMap<>();
        HashSet<Character> hset=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(hmap.containsKey(ch1) && hmap.get(ch1)!=ch2){
                return false;
            }
            else if(!hmap.containsKey(ch1) && hset.contains(ch2)){
                return false;
            }
            else{
                hmap.put(ch1,ch2);
                hset.add(ch2);
            }
        }
        return true;
    }
}
