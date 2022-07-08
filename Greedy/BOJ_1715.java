// BOJ - 1715
// Problem Sheet - https://www.acmicpc.net/problem/1715

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int tmp;
		int answer = 0;
		for(int i=0 ; i<n ; i++)
			pq.add(Integer.parseInt(bf.readLine()));
		

		while(pq.size() > 1) {
			tmp = pq.poll() + pq.poll();
			answer += tmp;
			pq.add(tmp);
		}
		
		System.out.println(answer);
		bf.close();
		System.exit(0);
    }
}
