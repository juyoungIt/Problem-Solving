// BOJ - 2018
// Problem Sheet - https://www.acmicpc.net/problem/2018

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int left = 0, right = 0;
        int sum = 0;
        int answer = 0;
        while(left <= right && right <= n) {
            if(sum == n) {
                sum -= left;
                left++;
                right++;
                sum += right;
                answer++;
            } else if(sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}