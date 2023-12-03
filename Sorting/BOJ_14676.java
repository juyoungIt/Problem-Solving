// BOJ - 14676
// Problem Sheet - https://www.acmicpc.net/problem/14676

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer>[] al = new List[n + 1];
        for(int i=1 ; i<=n ; i++) {
            al[i] = new LinkedList<>();
        }
        int[] prevBuildingCnt = new int[n + 1];
        int[] curBuildingCnt = new int[n + 1];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al[x].add(y);
            prevBuildingCnt[y]++;
        }

        boolean isValid = true;
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int buildingNum = Integer.parseInt(st.nextToken());

            if(command == 1) {
                if(prevBuildingCnt[buildingNum] == 0) {
                    if(curBuildingCnt[buildingNum] == 0) {
                        for(int nextBuilding : al[buildingNum]) {
                            prevBuildingCnt[nextBuilding]--;
                        }
                    }
                    curBuildingCnt[buildingNum]++;
                } else {
                    isValid = false;
                    break;
                }
            } else {
                if(curBuildingCnt[buildingNum] > 0) {
                    curBuildingCnt[buildingNum]--;
                    if(curBuildingCnt[buildingNum] == 0) {
                        for(int nextBuilding : al[buildingNum]) {
                            prevBuildingCnt[nextBuilding]++;
                        }
                    }
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        System.out.println(isValid ? "King-God-Emperor" : "Lier!");

        br.close();
        System.exit(0);
    }
}