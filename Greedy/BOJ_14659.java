// BOJ - 14659
// Problem Sheet - https://www.acmicpc.net/problem/14659

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] heights = new int[n];
        for(int i=0 ; i<n ; i++)
            heights[i] = Integer.parseInt(st.nextToken());

        int myHeight;
        int count = 0;
        int answer = 0;

        for(int i=0 ; i<n ; i++) {
            myHeight = heights[i];
            for(int j=i+1 ; j<n ; j++) {
                if(myHeight < heights[j])
                    break;
                count++;
            }
            if(answer < count)
                answer = count;
            count = 0;
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}