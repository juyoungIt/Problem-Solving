// BOJ - 29863
// Problem Sheet - https://www.acmicpc.net/problem/29863

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sleepTime = Integer.parseInt(br.readLine());
        int wakeTime = Integer.parseInt(br.readLine());
        int diff = wakeTime - sleepTime;

        System.out.println(diff >= 0 ? diff : diff + 24);
        br.close();
    }
}
