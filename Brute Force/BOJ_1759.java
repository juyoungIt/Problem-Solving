// BOJ - 1759
// Problem Sheet - https://www.acmicpc.net/problem/1759

import java.util.*;
import java.io.*;

public class Main {

    private static int l;
    private static int c;
    private static char[] letters;
    private static StringBuilder passwordBuffer;
    private static StringBuilder resultBuffer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        passwordBuffer = new StringBuilder();
        resultBuffer = new StringBuilder();

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        letters = new char[c];
        st = new StringTokenizer(bf.readLine());
        for(int i=0 ; i<c ; i++) {
            letters[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(letters);

        generatePassword(0, 0);
        System.out.println(resultBuffer);

        bf.close();
        System.exit(0);
    }

    private static void generatePassword(int curLen, int lastIdx) {
        if(curLen == l) {
            if(isValid(passwordBuffer.toString())) {
                resultBuffer.append(passwordBuffer).append("\n");
            }
            return;
        }
        for(int i=lastIdx ; i<c ; i++) {
            passwordBuffer.append(letters[i]);
            generatePassword(curLen + 1, i + 1);
            passwordBuffer.setLength(curLen);
        }
    }

    private static boolean isValid(String password) {
        int consonantCnt = 0;
        int vowelCnt = 0;
        char[] letters = password.toCharArray();
        for(char letter : letters) {
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                vowelCnt++;
            } else {
                consonantCnt++;
            }
        }
        return vowelCnt >= 1 && consonantCnt >= 2;
    }
}