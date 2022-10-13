// BOJ - 1679
// Problem Sheet - https://www.acmicpc.net/problem/1679

import java.util.*;
import java.io.*;

class Node {
    private final int num;
    private final int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }

    public int getNum() { return this.num; }
    public int getDepth() { return this.depth; }
}

public class Main {
    private static int n; // 사용하는 정수의 수
    private static int[] nums; // 사용하는 정수
    private static int k; // 최대사용 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>(); // 얻을 수 있는 수의 set
        String[] winner= {"holsoon", "jjaksoon"};

        // 동작에 필요한 값을 입력받아 구성함
        n = Integer.parseInt(bf.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<n ; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(bf.readLine());

        bfs(set);

        // 도달하지 못한 수를 찾음
        int count = 1;
        while(set.contains(count)) { count++; }
        System.out.println(winner[count%2] + " win at " + count);

        bf.close();
        System.exit(0);
    }

    static void bfs(HashSet<Integer> set) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0));
        while(!queue.isEmpty()) {
            int curNum = queue.peek().getNum();
            int curDepth = queue.peek().getDepth();
            for(int num : nums) {
                int tNum = curNum + num;
                if(curDepth+1<=k && !set.contains(tNum)) {
                    set.add(tNum);
                    queue.add(new Node(tNum, curDepth+1));
                }
            }
            queue.poll();
        }
    }
}