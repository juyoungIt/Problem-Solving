// BOJ - 26559
// Problem Sheet - https://www.acmicpc.net/problem/26559

import java.util.*;
import java.io.*;

public class Main {

    static class Friend implements Comparable<Friend> {
        private final String name;
        private final int intimacy;

        public Friend(String name, int intimacy) {
            this.name = name;
            this.intimacy = intimacy;
        }

        public String getName() { return this.name; }
        public int getIntimacy() { return this.intimacy; }

        @Override
        public int compareTo(Friend friend) {
            return Integer.compare(this.intimacy, friend.getIntimacy()) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringJoiner sj;
        StringTokenizer st;

        int numberOfDataSets = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfDataSets ; i++) {
            int numberOfFriends = Integer.parseInt(bf.readLine());
            List<Friend> friends = new ArrayList<>(numberOfFriends);
            sj = new StringJoiner(", ");
            for(int j=0 ; j<numberOfFriends ; j++) {
                st = new StringTokenizer(bf.readLine());
                friends.add(new Friend(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(friends);
            for(Friend friend : friends) {
                sj.add(friend.getName());
            }
            sb.append(sj).append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}