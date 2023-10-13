// BOJ - 1764
// Problem Sheet - https://www.acmicpc.net/problem/1764

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] members = new String[n];
        for (int i=0 ; i<n ; i++) {
            members[i] = bf.readLine();
        }
        Arrays.sort(members);

        int containsCount = 0;
        String[] tmp = new String[m];
        for (int i=0 ; i<m ; i++) {
            String target = bf.readLine();
            if(contains(members, target)) {
                tmp[containsCount++] = target;
            }
        }

        String[] result = new String[containsCount];
        System.arraycopy(tmp, 0, result, 0, containsCount);
        Arrays.sort(result);

        sb.append(containsCount).append("\n");
        for(String member : result) {
            sb.append(member).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static boolean contains(String[] members, String target) {
        int start = 0;
        int end = members.length-1;
        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if(members[mid].equals(target)) {
                return true;
            } else if(members[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}