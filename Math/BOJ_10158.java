// BOJ - 10158
// Problem Sheet - https://www.acmicpc.net/problem/10158

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(bf.readLine());

        int xTime = time - (width - startX);
        int yTime = time - (height - startY);
        boolean xDirection = (xTime / width) % 2 == 1;
        boolean yDirection = (yTime / height) % 2 == 1;
        int xIncrement = xTime % width;
        int yIncrement = yTime % height;
        if(xTime <= 0) {
            xTime = time;
            xDirection = true;
            xIncrement = startX + xTime;
        }
        if(yTime <= 0) {
            yTime = time;
            yDirection = true;
            yIncrement = startY + yTime;
        }

        sb.append(xDirection ? xIncrement : width-xIncrement)
                .append(" ")
                .append(yDirection ? yIncrement : height-yIncrement);
        bw.write(sb.toString());

        bf.close();
        bw.close();
        System.exit(0);
    }
}