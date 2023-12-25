// BOJ - 9536
// Problem Sheet - https://www.acmicpc.net/problem/9536

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0 ; i<t ; i++) {
            Map<String, String> soundMapper = new HashMap<>();
            String[] sounds = br.readLine().split(" ");
            while(true) {
                String message = br.readLine();
                if(message.equals("what does the fox say?")) break;
                String[] soundInfo = message.split(" goes ");
                soundMapper.put(soundInfo[0], soundInfo[1]);
            }
            for(String sound : sounds) {
                boolean isWolfSound = true;
                for(String s : soundMapper.values()) {
                    if(s.equals(sound)) {
                        isWolfSound = false;
                        break;
                    }
                }
                if(isWolfSound) {
                    sb.append(sound).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}