// BOJ - 7567
// Problem Sheet - https://www.acmicpc.net/problem/7567

import java.io.*;

public class Main {

    private static final int PLATE_HEIGHT = 10;
    private static final int STACKED_HEIGHT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] plates = bf.readLine().toCharArray();
        int totalHeight = 0;

        char prevPlate = ' ';
        for(char plate : plates) {
            if(prevPlate != plate) {
                totalHeight += PLATE_HEIGHT;
                prevPlate = plate;
            } else {
                totalHeight += STACKED_HEIGHT;
            }
        }

        System.out.println(totalHeight);

        bf.close();
        System.exit(0);
    }
}