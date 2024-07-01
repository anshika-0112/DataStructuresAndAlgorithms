package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ipStr=br.readLine();
        String[] ip=ipStr.split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(ip[i]);
        }
        System.out.println(findMoves(n,input));
    }
    static long findMoves(int n, int[] arr) {
        long moves=0;
        for (int i = 1; i < n; i++) {
            if(arr[i]<arr[i-1]){
                moves+=arr[i-1]-arr[i];
                arr[i]=arr[i-1];
            }
        }
        return moves;
    }
}
