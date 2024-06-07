// BOJ - 14954
// Problem Sheet - https://www.acmicpc.net/problem/14954

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        Set<String> resultSet = new HashSet<>();
        String result = n;
        resultSet.add(result);
        while(true) {
            result = getDigitSquareSum(result);
            if (result.equals("1")) {
                System.out.println("HAPPY");
                br.close();
                System.exit(0);
            }
            if (resultSet.contains(result)) {
                System.out.println("UNHAPPY");
                br.close();
                System.exit(0);
            }
            resultSet.add(result);
        }
    }

    private static String getDigitSquareSum(String n) {
        return Integer.toString(Arrays.stream(n.split(""))
                .mapToInt(d -> (int) Math.pow(Integer.parseInt(d), 2))
                .sum());
    }
}