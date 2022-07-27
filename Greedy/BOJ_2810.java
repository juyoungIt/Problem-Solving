// BOJ - 2810
// Problem Sheet - https://www.acmicpc.net/problem/2810

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String seat = bf.readLine();
        int count = 0; // 컵 홀더의 수

        for(int i=0 ; i<seat.length() ; i++) {
            if(seat.charAt(i) == 'S')
                count++;
            else if(seat.charAt(i) == 'L') {
                i++; // 인덱스 값을 1증가 (사이를 건너뛰기 위함)
                count++;
            }
        }
        count += 1; // 왼쪽 끝에 위치하는 홀더

        System.out.println(Math.min(n, count));

        bf.close();
        System.exit(0);
    }
}
