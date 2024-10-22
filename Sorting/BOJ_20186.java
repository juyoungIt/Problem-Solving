// BOJ - 20186
// Problem Sheet - https://www.acmicpc.net/problem/20186

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() { return this.index; }
        public int getValue() { return this.value; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Node> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0 ; i<N ; i++) {
            numbers.add(new Node(i, Integer.parseInt(st.nextToken())));
        }
        numbers.sort((n1, n2) -> n2.getValue() - n1.getValue());

        List<Node> targets = new ArrayList<>(K);
        for (int i=0 ; i<K ; i++) {
            targets.add(numbers.get(i));
        }
        targets.sort(Comparator.comparingInt(Node::getIndex));

        int totalScore = 0;
        int selected = 0;
        for (Node node : targets) {
            totalScore += (node.getValue() - selected++);
        }
        System.out.println(totalScore);

        br.close();
    }
}