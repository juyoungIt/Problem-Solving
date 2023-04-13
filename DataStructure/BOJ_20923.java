// BOJ - 20923
// Problem Sheet - https://www.acmicpc.net/problem/20923

import java.util.*;
import java.io.*;

public class Main {

    private static final String DODOWIN = "do";
    private static final String SUYEONWIN = "su";
    private static final String DRAW = "dosu";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int winnerCode = -1; // -1: 결정되지 않은 상태, 0: 도도, 1: 수연, 2: 무승부

        int numberOfCards = Integer.parseInt(st.nextToken());
        int numberOfTurns = Integer.parseInt(st.nextToken());
        List<Deque<Integer>> decks = new ArrayList<>(2);
        for(int i=0 ; i<2 ; i++) {
            decks.add(new LinkedList<>());
        }
        List<Deque<Integer>> grounds = new ArrayList<>(2);
        for(int i=0 ; i<2 ; i++) {
            grounds.add(new LinkedList<>());
        }

        for(int i=0 ; i<numberOfCards ; i++) {
            st = new StringTokenizer(bf.readLine());
            decks.get(0).addFirst(Integer.parseInt(st.nextToken()));
            decks.get(1).addFirst(Integer.parseInt(st.nextToken()));
        }

        int currentPlayerIndex = 1;
        for(int i=0 ; i<numberOfTurns ; i++) {
            currentPlayerIndex = getNextPlayer(currentPlayerIndex);
            grounds.get(currentPlayerIndex)
                    .addFirst(decks.get(currentPlayerIndex).pollFirst());
            if(decks.get(currentPlayerIndex).isEmpty()) {
                winnerCode = getNextPlayer(currentPlayerIndex);
                break;
            }
            int status = eventChecker(grounds);
            if(status < 2) {
                merge(decks, grounds, status);
            }
        }

        if(winnerCode == -1) {
            if(decks.get(0).size() < decks.get(1).size()) {
                winnerCode = 1;
            } else if(decks.get(0).size() > decks.get(1).size()) {
                winnerCode = 0;
            } else {
                winnerCode = 2;
            }
        }

        if(winnerCode == 0) {
            System.out.println(DODOWIN);
        } else if(winnerCode == 1) {
            System.out.println(SUYEONWIN);
        } else {
            System.out.println(DRAW);
        }

        bf.close();
        System.exit(0);
    }

    private static int getNextPlayer(int currentPlayer) {
        if(currentPlayer == 0) {
            return 1;
        }
        return 0;
    }

    private static int eventChecker(List<Deque<Integer>> grounds) {
        if(!grounds.get(0).isEmpty() && grounds.get(0).getFirst() == 5
                || !grounds.get(1).isEmpty() && grounds.get(1).getFirst() == 5) {
            return 0;
        } else if(!grounds.get(0).isEmpty()
                && !grounds.get(1).isEmpty()
                && grounds.get(0).getFirst() + grounds.get(1).getFirst() == 5) {
            return 1;
        } else {
            return 2;
        }
    }

    private static void merge(List<Deque<Integer>> decks, List<Deque<Integer>> grounds, int pusher) {
        while(!grounds.get(getNextPlayer(pusher)).isEmpty()) {
            decks.get(pusher).add(grounds.get(getNextPlayer(pusher)).pollLast());
        }
        while(!grounds.get(pusher).isEmpty()) {
            decks.get(pusher).add(grounds.get(pusher).pollLast());
        }
    }
}