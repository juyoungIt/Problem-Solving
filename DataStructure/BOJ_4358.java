// BOJ - 4358
// Problem Sheet - https://www.acmicpc.net/problem/4358

import java.util.*;
import java.io.*;

public class Main {

    static class Tree implements Comparable<Tree> {
        private final String name; // 종의 이름
        private final int count; // 갯수

        public Tree(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return this.name; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(Tree tree) {
            return this.name.compareTo(tree.getName());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> treeCountMapper = new HashMap<>();
        List<Tree> treeCountInfo = new ArrayList<>();

        int totalCount = 0; // 전체 나무의 수

        while(true) {
            String tree = bf.readLine();
            if(tree == null) break;
            totalCount++;
            if(treeCountMapper.get(tree) == null)
                treeCountMapper.put(tree, 1);
            else
                treeCountMapper.put(tree, treeCountMapper.get(tree)+1);
        }

        for (Map.Entry<String, Integer> treeInfo : treeCountMapper.entrySet())
            treeCountInfo.add(new Tree(treeInfo.getKey(), treeInfo.getValue()));
        Collections.sort(treeCountInfo); // 이름 순으로 정렬함

        // 종합한 결과를 출력함
        for (Tree tree : treeCountInfo)
            System.out.printf("%s %.4f\n", tree.getName(), (double)tree.getCount() / totalCount * 100);

        bf.close();
        System.exit(0);
    }
}