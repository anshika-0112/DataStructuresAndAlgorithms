package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ipStr=br.readLine();
        String[] ip=ipStr.split(" ");
        int[] input = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            input[i] = Integer.parseInt(ip[i]);
        }
        System.out.println(findMissingNumber(n,input));
    }
    private static int findMissingNumber(int n,int[] ip){
        int xor=0;
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        for(int i=0;i<n-1;i++){
            xor^=ip[i];
        }
        return xor;
    }
}
