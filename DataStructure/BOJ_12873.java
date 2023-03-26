// BOJ - 12873
// Problem Sheet - https://www.acmicpc.net/problem/12873

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numberOfParticipants = Integer.parseInt(bf.readLine());
        List<Integer> participants = new LinkedList<>();
        for(int i=1 ; i<=numberOfParticipants ; i++) {
            participants.add(i);
        }

        int currentIndex = 0;
        for(int i=1 ; i<numberOfParticipants ; i++) {
            long numberOfAction = (long)Math.pow(i, 3);
            currentIndex = getNextIndex(participants, currentIndex, (numberOfAction-1) % participants.size());
            participants.remove(currentIndex);
        }

        System.out.println(participants.get(0));

        bf.close();
        System.exit(0);
    }

    static int getNextIndex(List<Integer> participants, int currentIndex, long movingCount) {
        return (int)(currentIndex + movingCount) % participants.size();
    }
}