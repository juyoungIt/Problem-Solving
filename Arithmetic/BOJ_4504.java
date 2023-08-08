// BOJ - 4504
// Problem Sheet - https://www.acmicpc.net/problem/4504

import java.io.*;

public class Main {

    private static final String VALID_MESSAGE = "%d is a multiple of %d.";
    private static final String INVALID_MESSAGE = "%d is NOT a multiple of %d.";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int base = Integer.parseInt(bf.readLine());
        while(true) {
            int number = Integer.parseInt(bf.readLine());
            if(number == 0) {
                break;
            }
            sb.append(((number % base) == 0)
                    ? String.format(VALID_MESSAGE, number, base)
                    : String.format(INVALID_MESSAGE, number, base))
                    .append("\n");
        }

        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}