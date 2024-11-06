// BOJ - 1966
// Problem Sheet - https://www.acmicpc.net/problem/1966

import java.util.*;
import java.io.*;

public class Main {

    static class Document implements Comparable<Document> {
        private final int id;
        private final int importance;

        public Document(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }

        public int getId() { return this.id; }
        public int getImportance() { return this.importance; }

        @Override
        public int compareTo(Document d) {
            return d.getImportance() - this.importance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<Document> queue = new LinkedList<>();
            Document[] documents = new Document[N];
            input = br.readLine().split(" ");
            for (int i=0 ; i<N ; i++) {
                documents[i] = new Document(i, Integer.parseInt(input[i]));
                queue.add(documents[i]);
            }
            Arrays.sort(documents);

            int curSeq = 0;
            while (!queue.isEmpty()) {
                if (queue.peek().getImportance() == documents[curSeq].getImportance()) {
                    Document printed = queue.poll();
                    curSeq++;
                    if (printed.getId() == M) {
                        break;
                    }
                } else {
                    queue.add(queue.poll());
                }
            }
            sb.append(curSeq).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}