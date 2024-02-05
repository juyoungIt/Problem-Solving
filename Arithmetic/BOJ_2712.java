// BOJ - 2712
// Problem Sheet - https://www.acmicpc.net/problem/2712

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            double value = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();
            if(unit.equals("kg")) sb.append(String.format("%.4f lb", kgTolb(value)));
            else if(unit.equals("lb")) sb.append(String.format("%.4f kg", lbTokg(value)));
            else if(unit.equals("l")) sb.append(String.format("%.4f g", lTog(value)));
            else sb.append(String.format("%.4f l", gTol(value)));
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static double kgTolb(double kg) { return kg * 2.2046; }
    private static double lbTokg(double lb) { return lb * 0.4536; }
    private static double lTog(double l) { return l * 0.2642; }
    private static double gTol(double g) { return g * 3.7854; }
}