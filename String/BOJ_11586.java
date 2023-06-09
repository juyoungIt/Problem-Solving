// BOJ - 11586
// Problem Sheet - https://www.acmicpc.net/problem/11586

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sizeOfMirror = Integer.parseInt(bf.readLine());
        String[] mirrorState = new String[sizeOfMirror];
        for(int i=0 ; i<sizeOfMirror ; i++) {
            mirrorState[i] = bf.readLine();
        }
        int stateOfMind = Integer.parseInt(bf.readLine());
        System.out.println(getMirrorState(mirrorState, stateOfMind));

        bf.close();
        System.exit(0);
    }

    private static String getMirrorState(String[] mirrorState, int stateOfMind) {
        StringBuilder sb = new StringBuilder();

        if(stateOfMind == 1) {
            for(String stateRow : mirrorState) {
                sb.append(stateRow).append("\n");
            }
        } else if(stateOfMind == 2) {
            for(String stateRow : mirrorState) {
                for(int i=mirrorState.length-1 ; i>=0 ; i--) {
                    sb.append(stateRow.charAt(i));
                }
                sb.append("\n");
            }
        } else if(stateOfMind == 3) {
            for(int i=mirrorState.length-1 ; i>=0 ; i--) {
                for(int j=0 ; j<mirrorState.length ; j++) {
                    sb.append(mirrorState[i].charAt(j));
                }
                sb.append("\n");
            }
        } else {
            throw new IllegalArgumentException();
        }

        return sb.toString();
    }
}