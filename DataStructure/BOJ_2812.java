// BOJ - 2812
// Problem Sheet - https://www.acmicpc.net/problem/2812

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 입력 숫자의 자리 수
        int k = Integer.parseInt(st.nextToken()); // 빼야하는 수의 갯수
        String tmp = bf.readLine(); // 입력 숫자
        Stack<Integer> stack = new Stack<>(); // 선정된 수를 유지하는 리스트

        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(tmp.charAt(i)+"");
            while(!stack.isEmpty() && stack.peek() < num && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<stack.size()-k ; i++)
            sb.append(stack.get(i));
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}