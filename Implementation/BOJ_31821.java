// BOJ - 31821
// Problem Sheet - https://www.acmicpc.net/problem/31821

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            for (int i=1 ; i<=n ; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int m = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i=0 ; i<m ; i++) {
                sum += arr[Integer.parseInt(br.readLine())];
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
