// BOJ - 2840
// Problem Sheet - https://www.acmicpc.net/problem/2840

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;

        int numberOfCells = Integer.parseInt(st.nextToken());
        int numberOfRotations = Integer.parseInt(st.nextToken());
        char[] cells = new char[numberOfCells];

        int curIndex = 0;
        Set<Character> letterSet = new HashSet<>();
        for(int i=0 ; i<numberOfRotations ; i++) {
            st = new StringTokenizer(bf.readLine());
            int nextStep = Integer.parseInt(st.nextToken());
            char letter = st.nextToken().charAt(0);

            curIndex = getNextIndex(cells, curIndex, nextStep);
            if(cells[curIndex] != 0 && cells[curIndex] != letter) {
                isValid = false;
                break;
            }
            cells[curIndex] = letter;
        }

        for(char letter : cells) {
            if(letter !=0 && letterSet.contains(letter)) {
                isValid = false;
                break;
            }
            letterSet.add(letter);
        }

        if(isValid) {
            for(int i=0 ; i<cells.length ; i++) {
                char letter = cells[curIndex];
                if(letter == 0) {
                    sb.append("?");
                } else {
                    sb.append(letter);
                }
                curIndex = getNextIndex(cells, curIndex, -1);
            }
        } else {
            sb.setLength(0);
            sb.append("!");
        }

        sb.append("\n");
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }

    private static int getNextIndex(char[] cells, int curIndex, int nextStep) {
        int result = (curIndex + nextStep) % cells.length;
        if(result < 0) {
            return cells.length + result;
        }
        return result;
    }
}