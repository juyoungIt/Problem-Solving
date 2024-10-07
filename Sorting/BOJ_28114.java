// BOJ - 28114
// Problem Sheet - https://www.acmicpc.net/problem/28114

import java.util.*;
import java.io.*;

public class Main {

    static class Member {
        private final int solvedCount;
        private final int joinYear;
        private final String firstName;

        public Member(int solvedCount, int joinYear, String firstName) {
            this.solvedCount = solvedCount;
            this.joinYear = joinYear;
            this.firstName = firstName;
        }

        public int getSolvedCount() { return this.solvedCount; }
        public int getJoinYear() { return this.joinYear; }
        public String getFirstName() { return this.firstName; }
    }

    public static void main(String[] args) throws IOException {
        List<Member> members = getMembersFromInput();
        String firstTeamName = getTeamNameByRemainder(members);
        String secondTeamName = getTeamNameByFirstName(members);
        System.out.printf("%s\n%s", firstTeamName, secondTeamName);
    }

    private static List<Member> getMembersFromInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Member> members = new ArrayList<>(3);
        for (int i=0 ; i<3 ; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            members.add(new Member(p, y, s));
        }

        br.close();
        return members;
    }

    private static String getTeamNameByRemainder(List<Member> members) {
        StringBuilder sb = new StringBuilder();
        List<Integer> remainders = new ArrayList<>(members.size());
        members.forEach(m -> remainders.add(m.getJoinYear() % 100));
        Collections.sort(remainders);
        remainders.forEach(sb::append);
        return sb.toString();
    }

    private static String getTeamNameByFirstName(List<Member> members) {
        StringBuilder sb = new StringBuilder();
        members.sort((m1, m2) -> m2.getSolvedCount() - m1.getSolvedCount());
        members.forEach(m -> sb.append(m.getFirstName().charAt(0)));
        return sb.toString();
    }
}