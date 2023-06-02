// BOJ - 1769
// Problem Sheet - https://www.acmicpc.net/problem/1769

import java.io.*;

public class Main {

    private static int convertCount = 0;

    enum Message {
        YES, NO
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        while(number.length() > 1) {
            number = convert(number);
            convertCount++;
        }

        System.out.println(convertCount);
        System.out.println(Integer.parseInt(number) % 3 == 0 ? Message.YES : Message.NO);

        bf.close();
        System.exit(0);
    }

    private static String convert(String number) {
        int result = 0;

        char[] digits = number.toCharArray();
        for(char digit : digits) {
            result += Character.getNumericValue(digit);
        }

        return Integer.toString(result);
    }
}