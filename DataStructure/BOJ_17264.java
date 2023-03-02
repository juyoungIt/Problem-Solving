// BOJ - 17264
// Problem Sheet - https://www.acmicpc.net/problem/17264

import java.util.*;
import java.io.*;

public class Main {

    private static final String SUCCESS = "I AM NOT IRONMAN!!";
    private static final String FAILED = "I AM IRONMAN!!";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> playerInfo = new HashMap<>();
        int currentScore = 0;
        boolean levelUp = false;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int numberOfGames = Integer.parseInt(st.nextToken());
        int numberOfPlayerInfos = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int winningScore = Integer.parseInt(st.nextToken());
        int losingScore = Integer.parseInt(st.nextToken());
        int nextLevelScoreFromIron = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<numberOfPlayerInfos ; i++) {
            st = new StringTokenizer(bf.readLine());
            String playerName = st.nextToken();
            String winningCode = st.nextToken();
            playerInfo.put(playerName, winningCode);
        }

        for(int i=0 ; i<numberOfGames ; i++) {
            String playerName = bf.readLine();
            if(playerInfo.containsKey(playerName) && playerInfo.get(playerName).equals("W")) {
                currentScore = win(currentScore, winningScore);
            } else {
                currentScore = lose(currentScore, losingScore);
            }
            if(currentScore >= nextLevelScoreFromIron) {
                levelUp = true;
                break;
            }
        }

        if(levelUp) {
            System.out.println(SUCCESS);
        } else {
            System.out.println(FAILED);
        }

        bf.close();
        System.exit(0);
    }

    private static int win(int currentScore, int winningScore) {
        return currentScore + winningScore;
    }

    private static int lose(int currentScore, int losingScore) {
        return Math.max(currentScore - losingScore, 0);
    }
}