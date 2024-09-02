// BOJ - 11536
// Problem Sheet - https://www.acmicpc.net/problem/11536

import java.io.*;

public class Main {

    enum Status {
        INCREASING,
        DECREASING,
        NEITHER
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String prevName = br.readLine();
        String curName = br.readLine();
        int direction = prevName.compareTo(curName);
        prevName = curName;
        for (int i=2 ; i<n ; i++) {
            String name = br.readLine();
            if (isSameDirection(direction, prevName.compareTo(name))) {
                prevName = name;
            } else {
                direction = 0;
                break;
            }
        }

        if (direction > 0) {
            System.out.println(Status.DECREASING);
        } else if (direction < 0) {
            System.out.println(Status.INCREASING);
        } else {
            System.out.println(Status.NEITHER);
        }

        br.close();
        System.exit(0);
    }

    private static boolean isSameDirection(int curDirection, int status) {
        return curDirection * status > 0;
    }
}