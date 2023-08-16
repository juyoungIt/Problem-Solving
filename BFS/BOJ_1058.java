// BOJ - 1058
// Problem Sheet - https://www.acmicpc.net/problem/1058

import java.util.*;
import java.io.*;

public class Main {

    static class Person {
        private final int number;
        private final int depth;

        public Person(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }

        public int getNumber() { return this.number; }
        public int getDepth() { return this.depth; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] am = new char[N][N];
        for(int i=0 ; i<N ; i++) {
            String row = bf.readLine();
            for(int j=0 ; j<N ; j++) {
                am[i][j] = row.charAt(j);
            }
        }

        int maxFriends = 0;
        for(int i=0 ; i<N ; i++) {
            Queue<Person> queue = new LinkedList<>();
            boolean[] visit = new boolean[N];
            int curFriends = 0;

            queue.add(new Person(i, 0));
            visit[i] = true;
            while(!queue.isEmpty()) {
                Person person = queue.peek();
                if(person.getDepth() >= 2) {
                    break;
                }
                for(int j=0 ; j<N ; j++) {
                    if(am[person.getNumber()][j] == 'Y' && !visit[j]) {
                        visit[j] = true;
                        queue.add(new Person(j, person.getDepth() + 1));
                        curFriends++;
                    }
                }
                queue.poll();
            }
            maxFriends = Math.max(curFriends, maxFriends);
        }

        System.out.println(maxFriends);

        bf.close();
        System.exit(0);
    }
}