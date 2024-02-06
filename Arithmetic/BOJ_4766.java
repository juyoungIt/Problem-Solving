// BOJ - 4766
// Problem Sheet - https://www.acmicpc.net/problem/4766

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double prevTemperature = 0.0;
        boolean isFisrtNumber = true;
        while(true) {
            double temperature = Double.parseDouble(br.readLine());
            if(temperature == 999) {
                break;
            }
            if(isFisrtNumber) {
                prevTemperature = temperature;
                isFisrtNumber = false;
                continue;
            }
            sb.append(String.format("%.2f", temperature - prevTemperature)).append("\n");
            prevTemperature = temperature;
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}