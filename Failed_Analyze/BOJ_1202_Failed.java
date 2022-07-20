// BOJ - 1202
// Problem Sheet - https://www.acmicpc.net/problem/1202

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Jewel> jQueue = new PriorityQueue<>(Collections.reverseOrder());   // 가능한 보석을 저장하는 Queue
        PriorityQueue<Integer> bQueue = new PriorityQueue<>(); // 가방을 저장하는 Queue
        StringTokenizer st;

        int n, k;
        long answer = 0;

        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] jArr = new int[n][2];
        int jCount = n;
        int minBag;
        int lastIdx = 0;

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(bf.readLine());
            jArr[i][0] = Integer.parseInt(st.nextToken());
            jArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<k ; i++)
            bQueue.add(Integer.parseInt(bf.readLine()));
        
        Arrays.sort(jArr, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        
        while(bQueue.size() > 0 && jCount > 0) {

            minBag = bQueue.poll();

            for(int i=lastIdx ; i<n ; i++) {
                if(jArr[i][0] <= minBag && jArr[i][0] >= 0)
                    jQueue.add(new Jewel(jArr[i][0], jArr[i][1], i));
                lastIdx = i;
            }
            
            if(jQueue.size() <= 0) {
                bQueue.poll();
                continue;
            }

            answer += jQueue.peek().getValue();
            jArr[jQueue.peek().getIndex()][0] = -1;
            jCount--;
            jQueue.clear();
        }
        
        System.out.println(answer);
    
        bf.close();
        System.exit(0);
	}
}

class Jewel implements Comparable<Jewel> {

    private int weight;
    private int value;
    private int index;

    public Jewel(int weight, int value, int index) {
        this.weight = weight;
        this.value = value;
        this.index = index;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
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