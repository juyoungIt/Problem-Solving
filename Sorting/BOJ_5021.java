// BOJ - 5021
// Problem Sheet - https://www.acmicpc.net/problem/5021

import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static String founder;
    private static List<String> candidates;
    private static Map<String, List<String>> al;
    private static Map<String, Integer> indegree;
    private static Map<String, Double> similarities;

    static class Node {
        private final String child;
        private final double similarity;

        public Node(String child, double similarity) {
            this.child = child;
            this.similarity = similarity;
        }

        public String getChild() { return this.child; }
        public double getSimilarity() { return this.similarity; }
    }

    public static void main(String[] args) throws IOException {
        setup();
        Queue<Node> queue = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : indegree.entrySet()) {
            String name = entry.getKey();
            if(entry.getValue() == 0) {
                queue.add(new Node(name, name.equals(founder) ? 1 : 0));
            }
        }

        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            String curName = curNode.getChild();
            double curSimilarity = curNode.getSimilarity();
            for(String nextName : al.get(curName)) {
                indegree.put(nextName, indegree.get(nextName) - 1);
                similarities.put(nextName, similarities.get(nextName) + curSimilarity / 2);
                if(indegree.get(nextName) == 0) {
                    queue.add(new Node(nextName, similarities.get(nextName)));
                }
            }
        }

        String heir = "none";
        double maxSimilarity = 0.0;
        for(String candidate : candidates) {
            if(!similarities.containsKey(candidate)) continue;
            if(maxSimilarity < similarities.get(candidate) && !candidate.equals(founder)) {
                maxSimilarity = similarities.get(candidate);
                heir = candidate;
            }
        }
        System.out.println(heir);
        System.exit(0);
    }

    private static void setup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        founder = br.readLine();
        indegree = new HashMap<>();
        al = new HashMap<>();
        similarities = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parentA = st.nextToken();
            String parentB = st.nextToken();

            if(!indegree.containsKey(child)) {
                indegree.put(child, 0);
                al.put(child, new LinkedList<>());
                similarities.put(child, child.equals(founder) ? 1.0 : 0.0);
            }
            if(!indegree.containsKey(parentA)) {
                indegree.put(parentA, 0);
                al.put(parentA, new LinkedList<>());
                similarities.put(parentA, parentA.equals(founder) ? 1.0 : 0.0);
            }
            if(!indegree.containsKey(parentB)) {
                indegree.put(parentB, 0);
                al.put(parentB, new LinkedList<>());
                similarities.put(parentB, parentB.equals(founder) ? 1.0 : 0.0);
            }

            indegree.put(child, indegree.get(child) + 2);
            al.get(parentA).add(child);
            al.get(parentB).add(child);
        }

        candidates = new ArrayList<>(m);
        for(int i=0 ; i<m ; i++) {
            candidates.add(br.readLine());
        }

        br.close();
    }
}