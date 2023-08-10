// BOJ - 13866
// Problem Sheet - https://www.acmicpc.net/problem/13866

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] skillLevels = new int[4];
        for(int i=0 ; i<4 ; i++) {
            skillLevels[i] = Integer.parseInt(st.nextToken());
        }

        int skillLevelA = skillLevels[0] + skillLevels[3];
        int skillLevelB = skillLevels[1] + skillLevels[2];
        System.out.println(Math.abs(skillLevelA - skillLevelB));

        bf.close();
        System.exit(0);
    }
}