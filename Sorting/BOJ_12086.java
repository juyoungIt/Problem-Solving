// BOJ - 12086
// Problem Sheet - https://www.acmicpc.net/problem/12086

import java.io.*;

public class Main {

    private static final String OUTPUT_FORMAT = "Case #%d: %d\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=1 ; i<=T ; i++) {
            int N = Integer.parseInt(br.readLine());
            int dollers = 0;
            String lastCard = null;
            for (int j=0 ; j<N ; j++) {
                String name = br.readLine();
                if (lastCard != null && lastCard.compareTo(name) >= 0) {
                    dollers++;
                } else {
                    lastCard = name;
                }
            }
            sb.append(String.format(OUTPUT_FORMAT, i, dollers));
        }

        System.out.println(sb);
        br.close();
    }
}