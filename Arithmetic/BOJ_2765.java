// BOJ - 2765
// Problem Sheet - https://www.acmicpc.net/problem/2765

import java.util.*;
import java.io.*;

public class Main {

    private static final String messageFormat = "Trip #%d: %.2f %.2f\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int index = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            double diameter = Double.parseDouble(st.nextToken());
            int revolveCount = Integer.parseInt(st.nextToken());
            double time = Double.parseDouble(st.nextToken());

            if (revolveCount == 0) break;

            double distance = inchToMiles(diameter) * Math.PI * revolveCount;
            double mph = distance / (time / 3600);
            sb.append(String.format(messageFormat, index++, distance, mph));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static double inchToMiles(double inch) {
        return inch / 63_360;
    }
}