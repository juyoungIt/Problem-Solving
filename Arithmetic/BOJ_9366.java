// BOJ - 9366
// Problem Sheet - https://www.acmicpc.net/problem/9366

import java.util.*;
import java.io.*;

public class Main {

    enum RectType {
        equilateral, isosceles, scalene
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            int[] sides = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(sides);
            sb.append(String.format("Case #%d: %s\n", i+1, getRectType(sides)));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String getRectType(int[] sides) {
        if(sides[0] + sides[1] <= sides[2]) {
            return "invalid!";
        } else if(sides[0] == sides[1] && sides[1] == sides[2]) {
            return RectType.equilateral.toString();
        } else if(sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
            return RectType.isosceles.toString();
        } else {
            return RectType.scalene.toString();
        }
    }
}