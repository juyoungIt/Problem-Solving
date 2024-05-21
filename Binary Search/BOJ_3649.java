// BOJ - 3649
// Problem Sheet - https://www.acmicpc.net/problem/3649

import java.util.*;
import java.io.*;

public class Main {

    enum ResultType {
        danger, yes
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = null;
        while ((input = br.readLine()) != null) {
            int width = Integer.parseInt(input) * 10_000_000;
            int n = Integer.parseInt(br.readLine());
            int[] lengths = new int[n];
            for (int i=0 ; i<n ; i++) {
                lengths[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(lengths);

            boolean isFinished = false;
            int solutionA = 0, solutionB = 0;
            for (int i=0 ; i<n ; i++) {
                int left = i+1, right = n-1;
                if (isFinished) break;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (lengths[i] + lengths[mid] < width) {
                        left = mid + 1;
                    } else if(lengths[i] + lengths[mid] == width) {
                        solutionA = lengths[i];
                        solutionB = lengths[mid];
                        isFinished = true;
                        break;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            if (isFinished) {
                sb.append(ResultType.yes)
                        .append(" ")
                        .append(solutionA)
                        .append(" ")
                        .append(solutionB)
                        .append("\n");
            } else {
                sb.append(ResultType.danger).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}