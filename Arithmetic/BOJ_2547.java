// BOJ - 2547
// Problem Sheet - https://www.acmicpc.net/problem/2547

import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            br.readLine(); /* 처음에 있는 빈 라인을 처리하는 부분 */
            int numberOfStudents = Integer.parseInt(br.readLine());
            BigInteger totalNumberOfCandies = BigInteger.ZERO;
            for (int j=0 ; j<numberOfStudents ; j++) {
                totalNumberOfCandies = totalNumberOfCandies.add(new BigInteger(br.readLine()));
            }
            if (totalNumberOfCandies.mod(new BigInteger(Integer.toString(numberOfStudents))).equals(BigInteger.ZERO)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}