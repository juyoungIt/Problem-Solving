// BOJ - 14470
// Problem Sheet - https://www.acmicpc.net/problem/14470

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = new int[5];
        for(int i=0 ; i<5 ; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(calculateTime(inputs));

        br.close();
        System.exit(0);
    }

    private static int calculateTime(int[] inputs) {
        int totalSum = 0;
        if(inputs[0] < 0) {
            totalSum += inputs[0] * -1 * inputs[2];
            inputs[0] = 0;
        }
        if(inputs[0] == 0) {
            totalSum += inputs[3];
        }
        totalSum += (inputs[1] - inputs[0]) * inputs[4];
        return totalSum;
    }
}