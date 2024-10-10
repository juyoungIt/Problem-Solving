// BOJ - 12891
// Problem Sheet - https://www.acmicpc.net/problem/12891

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int[] criteria = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] curCount = new int[4];
        for (int i=0 ; i<p ; i++) {
            int index = getIndex(dna.charAt(i));
            if (index >= 0) {
                curCount[index]++;
            }
        }

        int answer = 0;
        for (int i=0 ; i<=dna.length() - p ; i++) {
            if (isValid(criteria, curCount)) {
                answer++;
            }
            if (i + p >= dna.length()) break;
            int removeIndex = getIndex(dna.charAt(i));
            int addIndex = getIndex(dna.charAt(i + p));
            if (removeIndex >= 0) {
                curCount[removeIndex]--;
            }
            if (addIndex >= 0) {
                curCount[addIndex]++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static int getIndex(char code) {
        if (code == 'A') return 0;
        else if (code == 'C') return 1;
        else if (code == 'G') return 2;
        else if (code == 'T') return 3;
        else return -1;
    }

    private static boolean isValid(int[] criteria, int[] counts) {
        boolean isValid = true;
        for (int i=0 ; i<criteria.length ; i++) {
            if (criteria[i] > counts[i]) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}