package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip=br.readLine();
        System.out.println(findLongestRepetition(ip));
    }
    static int findLongestRepetition(String ip){
        char currChar=ip.charAt(0);
        int max=0;
        int len=0;
        for(int i=0;i<ip.length();i++){
            char ch=ip.charAt(i);
            if(ch==currChar){
                len+=1;
            }
            else{
                max=Math.max(max,len);
                len=1;
                currChar=ch;
            }
        }
        max=Math.max(max,len);
        return max;
    }
}
