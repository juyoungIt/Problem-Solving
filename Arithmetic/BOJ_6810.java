// BOJ - 6810
// Problem Sheet - https://www.acmicpc.net/problem/6810

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] unitMult = {1, 3};
        int sequence = 0;
        int[] preprocess = Arrays.stream("9780921418".split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i=0 ; i<preprocess.length ; i++) {
            sum += preprocess[i] * unitMult[i % 2];
        }

        while(true) {
            String input = br.readLine();
            if(input == null) break;
            int digit = Integer.parseInt(input);
            sum += digit * unitMult[sequence++ % 2];
        }

        System.out.printf("The 1-3-sum is %d\n", sum);

        br.close();
        System.exit(0);
    }
}