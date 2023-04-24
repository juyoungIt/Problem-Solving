// BOJ - 2841
// Problem Sheet - https://www.acmicpc.net/problem/2841

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfFingerMoves = 0;

        List<Stack<Integer>> lines = new ArrayList<>(6);
        for(int i=0 ; i<6 ; i++) {
            lines.add(new Stack<>());
        }

        int numberOfPitchs = Integer.parseInt(st.nextToken());
        int numberOfFrets = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<numberOfPitchs ; i++) {
            st = new StringTokenizer(bf.readLine());
            int lineNumber = Integer.parseInt(st.nextToken());
            int fretNumber = Integer.parseInt(st.nextToken());

            if(lines.get(lineNumber-1).isEmpty() || lines.get(lineNumber-1).peek() < fretNumber) {
                lines.get(lineNumber-1).push(fretNumber);
                numberOfFingerMoves++;
            } else if(lines.get(lineNumber-1).peek() > fretNumber) {
                while(!lines.get(lineNumber-1).isEmpty() && lines.get(lineNumber-1).peek() > fretNumber) {
                    lines.get(lineNumber-1).pop();
                    numberOfFingerMoves++;
                }
                if(lines.get(lineNumber-1).isEmpty()) {
                    lines.get(lineNumber-1).push(fretNumber);
                    numberOfFingerMoves++;
                } else if(lines.get(lineNumber-1).peek() < fretNumber) {
                    lines.get(lineNumber-1).push(fretNumber);
                    numberOfFingerMoves++;
                }
            }
        }

        System.out.println(numberOfFingerMoves);

        bf.close();
        System.exit(0);
    }
}