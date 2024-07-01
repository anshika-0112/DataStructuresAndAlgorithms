package cses;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
        } else {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    even.append(i).append(" ");
                } else {
                    odd.append(i).append(" ");
                }
            }

            System.out.println(even.toString().trim() + " " + odd.toString().trim());
        }
    }
}

