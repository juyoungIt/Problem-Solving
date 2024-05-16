// BOJ - 10420
// Problem Sheet - https://www.acmicpc.net/problem/10420

import java.time.LocalDate;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LocalDate startDate = LocalDate.of(2014, 4, 2);
        LocalDate anniversary = startDate.plusDays(n - 1);
        System.out.printf("%d-%02d-%02d\n",
                anniversary.getYear(),
                anniversary.getMonthValue(),
                anniversary.getDayOfMonth());

        br.close();
        System.exit(0);
    }
}