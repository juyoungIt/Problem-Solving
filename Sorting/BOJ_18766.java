// BOJ - 18766
// Problem Sheet - https://www.acmicpc.net/problem/18766

import java.util.*;
import java.io.*;

public class Main {

    private static final String CHEATER = "CHEATER";
    private static final String NOT_CHEATER = "NOT CHEATER";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            int n = Integer.parseInt(br.readLine());
            List<String> before = getSortedCardList(br, n);
            List<String> after = getSortedCardList(br, n);
            sb.append(validateIntegrity(before, after) ? NOT_CHEATER : CHEATER).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static List<String> getSortedCardList(BufferedReader br, int n) throws IOException {
        List<String> cards = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j=0 ; j<n ; j++) {
            cards.add(st.nextToken());
        }
        Collections.sort(cards);
        return cards;
    }

    private static boolean validateIntegrity(List<String> cardsA, List<String> cardsB) {
        return cardsA.equals(cardsB);
    }
}