// BOJ - 16099
// Problem Sheet - https://www.acmicpc.net/problem/16099

import java.util.*;
import java.io.*;

public class Main {

    enum ResultMessage {
        Eurecom, TelecomParisTech, Tie
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i=0 ; i<t ; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            long telecomParisTechArea = getTotalFacilityArea(length, width);
            length = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            long eurecomArea = getTotalFacilityArea(length, width);
            sb.append(getResult(telecomParisTechArea, eurecomArea)).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static long getTotalFacilityArea(int length, int width) {
        return (long) length * width;
    }

    private static String getResult(long telecomParisTechArea, long eurecomArea) {
        if (telecomParisTechArea > eurecomArea) {
            return ResultMessage.TelecomParisTech.name();
        } else if (telecomParisTechArea < eurecomArea) {
            return ResultMessage.Eurecom.name();
        } else {
            return ResultMessage.Tie.name();
        }
    }
}