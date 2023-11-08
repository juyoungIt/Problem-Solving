// BOJ - 2251
// Problem Sheet - https://www.acmicpc.net/problem/2251

import java.util.*;
import java.io.*;

public class Main {

    static class Bottle {

        private final int bottleA;
        private final int bottleB;
        private final int bottleC;

        public Bottle(int bottleA, int bottleB, int bottleC) {
            this.bottleA = bottleA;
            this.bottleB = bottleB;
            this.bottleC = bottleC;
        }

        public int getBottleStatusById(int index) {
            if(index == 0) return this.bottleA;
            else if(index == 1) return this.bottleB;
            else return this.bottleC;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] capas = new int[3];
        capas[0] = Integer.parseInt(st.nextToken());
        capas[1] = Integer.parseInt(st.nextToken());
        capas[2] = Integer.parseInt(st.nextToken());
        boolean[] isGenerated = new boolean[capas[2] + 1];

        Set<String> set = new HashSet<>();
        Stack<Bottle> stack = new Stack<>();
        stack.push(new Bottle(0, 0, capas[2]));
        isGenerated[capas[2]] = true;
        while(!stack.isEmpty()) {
            Bottle curStatus = stack.peek();
            int src=0, dest=0;
            for(src=0 ; src<3 ; src++) {
                if(curStatus.getBottleStatusById(src) == 0) continue;
                for(dest=0 ; dest<3 ; dest++) {
                    int[] bottles = new int[3];
                    bottles[0] = curStatus.getBottleStatusById(0);
                    bottles[1] = curStatus.getBottleStatusById(1);
                    bottles[2] = curStatus.getBottleStatusById(2);
                    if(dest == src || capas[dest] == bottles[dest]) continue;
                    int quantity = Math.min(capas[dest] - bottles[dest], bottles[src]);
                    bottles[src] -= quantity;
                    bottles[dest] += quantity;
                    if(!set.contains(Arrays.toString(bottles))) {
                        stack.push(new Bottle(bottles[0], bottles[1], bottles[2]));
                        set.add(Arrays.toString(bottles));
                        if(bottles[0] == 0 && !isGenerated[bottles[2]]) {
                            isGenerated[bottles[2]] = true;
                        }
                        break;
                    }
                }
                if(dest <= 2) break;
            }
            if(src > 2 && dest > 2) {
                stack.pop();
            }
        }

        for(int i=0 ; i<isGenerated.length ; i++) {
            if(isGenerated[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}