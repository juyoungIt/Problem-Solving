// BOJ - 20114
// Problem Sheet - https://www.acmicpc.net/problem/20114

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row = br.readLine().split(" ");
        int n = Integer.parseInt(row[0]);
        int h = Integer.parseInt(row[1]);
        int w = Integer.parseInt(row[2]);
        String[] note = new String[h];
        char[] result = new char[n];
        for (int i=0 ; i<h ; i++) {
            note[i] = br.readLine();
        }
        for (int i=0 ; i<n*w ; i+=w) {
            result[i / w] = '?';
            for (int j=0 ; j<h ; j++) {
                if (result[i / w] != '?') break;
                for (int k=i ; k<i+w ; k++) {
                    if (result[k / w] != '?') break;
                    if (result[k / w] == note[j].charAt(k)) continue;
                    result[k / w] = note[j].charAt(k);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<n ; i++) {
            sb.append(result[i]);
        }
        System.out.println(sb);
        br.close();
    }
}