// BOJ - 1202
// Problem Sheet - https://www.acmicpc.net/problem/1202

import java.io.*;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    private int weight;
    private int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Jewel jewel) {
        if(this.value > jewel.getValue())
            return 1;
        else if(this.value < jewel.getValue())
            return -1;
        return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석의 수
        int k = Integer.parseInt(st.nextToken()); // 가방의 수
        PriorityQueue<Jewel> jQueue = new PriorityQueue<>(Collections.reverseOrder());

        int[][] jArr = new int[n][2];
        int[] bArr = new int[k];
        long answer = 0;
        int jewelIdx = 0;
        
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            jArr[i][0] = Integer.parseInt(st.nextToken());
            jArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<k ; i++)
            bArr[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(bArr);
        Arrays.sort(jArr, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0]-o2[0];
        });

        for(int i=0 ; i<k ; i++) {
            while(jewelIdx < n && jArr[jewelIdx][0] <= bArr[i]) {
                jQueue.add(new Jewel(jArr[jewelIdx][0], jArr[jewelIdx][1]));
                jewelIdx++;
            }
            if(!jQueue.isEmpty())
                answer += jQueue.poll().getValue();
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}