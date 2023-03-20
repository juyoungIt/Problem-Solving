// BOJ - 14426
// Problem Sheet - https://www.acmicpc.net/problem/14426

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private final Map<Character, Node> childs;
        private boolean isEnd;

        public Node(boolean isEnd) {
            this.childs = new HashMap<>();
            this.isEnd = isEnd;
        }

        public Map<Character, Node> getChilds() { return this.childs; }
        public boolean getIsEnd() { return this.isEnd; }
        public void setIsEnd(boolean isEnd) { this.isEnd = isEnd; }
    }

    static class Trie {
        private final Node root;

        public Trie() {
            this.root = new Node(false);
        }

        public void insert(String str) {
            Node node = this.root;
            for(int i=0 ; i<str.length() ; i++) {
                char character = str.charAt(i);
                if (!node.getChilds().containsKey(character)) {
                    node.getChilds().put(character, new Node(false));
                }
                node = node.getChilds().get(character);
            }
            node.setIsEnd(true);
        }

        public boolean findPrefix(String str) {
            Node node = this.root;
            for(int i=0 ; i<str.length() ; i++) {
                char character = str.charAt(i);
                if(!node.getChilds().containsKey(character)) {
                    return false;
                }
                node = node.getChilds().get(character);
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfPrefix = 0;

        Trie trie = new Trie();

        int numberOfWords = Integer.parseInt(st.nextToken());
        int numberOfRequests = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<numberOfWords ; i++) {
            trie.insert(bf.readLine());
        }

        for(int i=0 ; i<numberOfRequests ; i++) {
            if(trie.findPrefix(bf.readLine())) {
                numberOfPrefix++;
            }
        }

        System.out.println(numberOfPrefix);

        bf.close();
        System.exit(0);
    }
}