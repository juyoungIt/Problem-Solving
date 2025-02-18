// BOJ - 3584
// Problem Sheet - https://www.acmicpc.net/problem/3584

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer>[] al;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            al = new List[N + 1];
            for (int i=1 ; i<=N ; i++) {
                al[i] = new LinkedList<>();
            }
            visited = new boolean[N + 1];
            for (int i=0 ; i<N-1 ; i++) {
                String[] row = br.readLine().split(" ");
                int A = Integer.parseInt(row[0]);
                int B = Integer.parseInt(row[1]);
                al[B].add(A);
            }
            String[] row = br.readLine().split(" ");
            int nodeA = Integer.parseInt(row[0]);
            int nodeB = Integer.parseInt(row[1]);
            sb.append(findNCA(nodeA, nodeB)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int findNCA(int nodeA, int nodeB) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nodeA);
        stack.push(nodeB);
        int nca = -1;
        while (!stack.isEmpty()) {
            int topNode = stack.pop();
            if (visited[topNode]) {
                nca = topNode;
                break;
            }
            visited[topNode] = true;
            for (int node : al[topNode]) {
                stack.push(node);
            }
        }
        return nca;
    }
}