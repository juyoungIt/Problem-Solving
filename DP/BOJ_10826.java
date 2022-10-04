// BOJ - 10826
// Problem Sheet - https://www.acmicpc.net/problem/10826

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] dp = new String[n+1]; // dp를 위해 사용하는 저장소

        dp[0] = "0";
        if(n >= 1) dp[1] = "1";
        System.out.println(fibo(dp, n));

        bf.close();
        System.exit(0);
    }

    static String fibo(String[] dp, int n) {
        if(n == 0) return dp[0];
        else if(n == 1) return dp[1];
        else {
            if(dp[n] != null) return dp[n];
            else return dp[n] = adder(fibo(dp, n-2), fibo(dp, n-1));
        }
    }

    static String adder(String exp1, String exp2) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> expStack1 = new Stack<>(); // Exp1에 대한 정보를 저장
        Stack<Integer> expStack2 = new Stack<>(); // Exp2에 대한 정보를 저장
        int carry = 0; // 연산과정에서 발생하는 carry

        for(int i=0 ; i<exp1.length() ; i++)
            expStack1.add(Integer.parseInt(exp1.charAt(i)+""));
        for(int i=0 ; i<exp2.length() ; i++)
            expStack2.add(Integer.parseInt(exp2.charAt(i)+""));

        while(!expStack1.isEmpty() && !expStack2.isEmpty()) {
            int tmp = expStack1.pop() + expStack2.pop() + carry;
            if(tmp >= 10) {
                carry = 1;
                tmp -= 10;
            }
            else carry = 0;
            sb.insert(0, tmp);
        }

        // 나머지 수들은 자연스럽게 더함
        while(!expStack1.isEmpty()) {
            sb.insert(0, expStack1.pop() + carry);
            carry = 0;
        }
        while(!expStack2.isEmpty()) {
            sb.insert(0, expStack2.pop() + carry);
            carry = 0;
        }
        if(carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}