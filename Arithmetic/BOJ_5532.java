// BOJ - 5532
// Problem Sheet - https://www.acmicpc.net/problem/5532

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfVacationDays = Integer.parseInt(bf.readLine());
        int totalPagesOfMath = Integer.parseInt(bf.readLine());
        int totalPagesOfKorean = Integer.parseInt(bf.readLine());
        int maxMathPagesPerDay = Integer.parseInt(bf.readLine());
        int maxKoreanPagesPerDay = Integer.parseInt(bf.readLine());

        System.out.println(
                numberOfVacationDays
                        - Math.max(
                                (int)Math.ceil((double)totalPagesOfMath/maxMathPagesPerDay),
                                (int)Math.ceil((double)totalPagesOfKorean/maxKoreanPagesPerDay)));

        bf.close();
        System.exit(0);
    }
}