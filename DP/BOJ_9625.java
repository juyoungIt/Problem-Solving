// BOJ - 9625
// Problem Sheet - https://www.acmicpc.net/problem/9625

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine()); // 버튼을 클릭한 횟수
        ArrayList<Integer>[] dp = new ArrayList[k+1];
        for(int i=0 ; i<=k ; i++)
            dp[i] = new ArrayList<>();
        dp[0].add(1);
        dp[0].add(0);

        List<Integer> answer = getCountOfAandB(dp, k);
        System.out.println(answer.get(0) + " " + answer.get(1));

        bf.close();
        System.exit(0);
    }

    // 버튼을 K번 클릭했을 때의 A와 B의 수를 반환함
    static List<Integer> getCountOfAandB(ArrayList<Integer>[] dp, int k) {
        if(dp[k].size() > 0)
            return dp[k];
        else {
            List<Integer> countInfo = getCountOfAandB(dp, k-1);
            int aCount = countInfo.get(0);
            int bCount = countInfo.get(1);
            aCount = aCount - countInfo.get(0);
            bCount = bCount + countInfo.get(0);
            aCount = aCount + countInfo.get(1);
            dp[k].add(aCount);
            dp[k].add(bCount);
            return dp[k];
        }
    }
}