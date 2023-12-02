// BOJ - 1516
// Problem Sheet - https://www.acmicpc.net/problem/1516

import java.util.*;
import java.io.*;

public class Main {

    static class Building {

        private final int number;
        private int buildTime;
        private int prevBuildingCnt;
        private final List<Building> nextBuildings;

        public Building(int number, int buildTime) {
            this.number = number;
            this.buildTime = buildTime;
            this.prevBuildingCnt = 0;
            this.nextBuildings = new LinkedList<>();
        }

        public int getNumber() { return this.number; }
        public int getBuildTime() { return this.buildTime; }
        public int getPrevBuildCnt() { return this.prevBuildingCnt; }
        public List<Building> getNextBuildings() { return this.nextBuildings; }
        public void setBuildTime(int buildTime) { this.buildTime = buildTime; }
        public void setPrevBuildCnt(int prevBuildCnt) { this.prevBuildingCnt = prevBuildCnt; }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Building[] buildings = new Building[n + 1];
        int[] accBuildTime = new int[n + 1];
        for(int i=1 ; i<=n ; i++) {
            buildings[i] = new Building(i, 0);
        }

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            int buildTime = Integer.parseInt(st.nextToken());
            buildings[i].setBuildTime(buildTime);
            while(st.hasMoreTokens()) {
                int prevBuildingNumber = Integer.parseInt(st.nextToken());
                if(prevBuildingNumber == -1) break;
                buildings[prevBuildingNumber].getNextBuildings().add(buildings[i]);
                buildings[i].setPrevBuildCnt(buildings[i].getPrevBuildCnt() + 1);
            }
        }

        Queue<Building> waiting = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(buildings[i].getPrevBuildCnt() == 0) {
                waiting.add(buildings[i]);
                accBuildTime[i] = buildings[i].getBuildTime();
            }
        }

        while(!waiting.isEmpty()) {
            Building cur = waiting.poll();
            for(Building building : cur.getNextBuildings()) {
                accBuildTime[building.getNumber()] = Math.max(
                        accBuildTime[building.getNumber()],
                        accBuildTime[cur.getNumber()] + building.getBuildTime());
                building.setPrevBuildCnt(building.getPrevBuildCnt() - 1);
                if(building.getPrevBuildCnt() == 0) {
                    waiting.add(building);
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            sb.append(accBuildTime[i]).append("\n");
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}