package cses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeirdAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        List<Long> ans = weirdAlgo(n);
        StringBuilder sb = new StringBuilder();
        for (long i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static List<Long> weirdAlgo(long n) {
        List<Long> ans = new ArrayList<>();
        ans.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            ans.add(n);
        }
        return ans;
    }
}
