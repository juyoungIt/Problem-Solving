// BOJ - 10552
// Problem Sheet - https://www.acmicpc.net/problem/10552

import java.util.*;
import java.io.*;

public class Main {
    private static boolean isCycle = false; // 사이클 발생여부 저장
    private static int channelSwitch = 0;   // 채널변경횟수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); // 시청자의 수
        int m = Integer.parseInt(st.nextToken()); // tv 채널의 수
        int p = Integer.parseInt(st.nextToken()); // 시작하는 채널번호

        int[] loveCHs = new int[100000+1];   // 좋아하는 채널
        boolean[] visit = new boolean[m+1]; // 해당 채널의 방문여부
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            int loveCH = Integer.parseInt(st.nextToken());
            int hateCH = Integer.parseInt(st.nextToken());
            if(loveCHs[hateCH] == 0)
                loveCHs[hateCH] = loveCH;
        }

        dfs(loveCHs, visit, p);
        System.out.println((isCycle) ? -1 : channelSwitch);

        bf.close();
        System.exit(0);
    }

    public static void dfs(int[] loveCHs, boolean[] visit, int start) {
        if(visit[start])
            isCycle = true;
        else if(loveCHs[start] != 0) {
            channelSwitch++;
            visit[start] = true;
            dfs(loveCHs, visit, loveCHs[start]);
        }
    }
}