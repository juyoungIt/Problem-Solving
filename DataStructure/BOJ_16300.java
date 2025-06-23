// BOJ - 16300
// Problem Sheet - https://www.acmicpc.net/problem/16300

import java.io.*;

public class Main {

    private static String im, om;
    private static int k;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        im = row[0];
        k = Integer.parseInt(row[1]);
        om = br.readLine();
        br.close();
    }

    private static int solve() {
        int[] imc = parse(im);
        for (int i=0 ; i<26 ; i++) imc[i] = imc[i] * k;
        int[] omc = parse(om);
        int count = Integer.MAX_VALUE;
        for (int i=0 ; i<26 ; i++) {
            if (omc[i] == 0) continue;
            if (imc[i] == 0 && omc[i] > 0) return 0;
            count = Math.min(count, imc[i] / omc[i]);
        }
        return count;
    }

    private static int[] parse(String m) {
        int[] counts = new int[26];
        int i = 0;
        while (i < m.length()) {
            char atom = m.charAt(i++);
            int count = 0;
            while (i < m.length() && Character.isDigit(m.charAt(i))) {
                count = count * 10 + (m.charAt(i++) - '0');
            }
            counts[atom - 'A'] += (count == 0 ? 1 : count);
        }
        return counts;
    }

}