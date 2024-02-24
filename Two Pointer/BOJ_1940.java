// BOJ - 1940
// Problem Sheet - https://www.acmicpc.net/problem/1940

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] ingredients = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(ingredients);
        int left = 0, right = n-1;
        while(left < right) {
            int combination = ingredients[left] + ingredients[right];
            if(combination == m) {
                answer++;
                left++;
                right--;
            } else if(combination < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);

        br.close();
        System.exit(0);
    }
}