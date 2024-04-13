// BOJ - 4714
// Problem Sheet - https://www.acmicpc.net/problem/4714

import java.io.*;

public class Main {

    private static final String messageFormat = "Objects weighing %.2f on Earth will weigh %.2f on the moon.\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            double weightOnEarth = Double.parseDouble(br.readLine());
            if (weightOnEarth < 0) break;
            double weightOnMoon = weightOnEarth * 0.167;
            sb.append(String.format(messageFormat, weightOnEarth, weightOnMoon));
        }

        System.out.print(sb);

        br.close();
        System.exit(0);
    }
}