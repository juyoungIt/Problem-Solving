// BOJ - 4999
// Problem Sheet - https://www.acmicpc.net/problem/4999

import java.io.*;

public class Main {

    private static final String VALID = "go";
    private static final String INVALID = "no";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String patient = bf.readLine();
        String doctor = bf.readLine();

        System.out.println((patient.length() >= doctor.length()) ? VALID : INVALID);

        bf.close();
        System.exit(0);
    }
}