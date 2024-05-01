// BOJ - 17283
// Problem Sheet - https://www.acmicpc.net/problem/17283

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        int totalLengthOfBranches = 0;
        int prevBranchLength = l;
        int branchDepth = 1;
        while (true) {
            int curBranchLength = (int) (prevBranchLength * r * 0.01);
            if (curBranchLength <= 5) break;
            totalLengthOfBranches += curBranchLength * (int) Math.pow(2, branchDepth);
            prevBranchLength = curBranchLength;
            branchDepth++;
        }

        System.out.println(totalLengthOfBranches);

        br.close();
        System.exit(0);
    }
}