// BOJ - 10814
// Problem Sheet - https://www.acmicpc.net/problem/10814

import java.util.*;
import java.io.*;

public class Main {

    static class Member {
        private final String name;
        private final int age;

        public Member(int age, String name) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return this.name; }
        public int getAge() { return this.age; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int numberOfMembers = Integer.parseInt(bf.readLine());
        Member[] members = new Member[numberOfMembers];
        for(int i=0; i<numberOfMembers ; i++) {
            st = new StringTokenizer(bf.readLine());
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(members, (o1, o2) -> o1.getAge() - o2.getAge());

        for(Member member : members) {
            sb.append(member.getAge())
                    .append(" ")
                    .append(member.getName())
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}