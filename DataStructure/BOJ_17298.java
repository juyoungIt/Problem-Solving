// BOJ - 17298
// Problem Sheet - https://www.acmicpc.net/problem/17298

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] oBigNumbers = new int[n];
        Arrays.fill(oBigNumbers, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n ; i++) {
            if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    oBigNumbers[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }

        for(int oBigNumber : oBigNumbers) {
            sb.append(oBigNumber).append(" ");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}