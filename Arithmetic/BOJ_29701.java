// BOJ - 29701
// Problem Sheet - https://www.acmicpc.net/problem/29701

import java.util.*;
import java.io.*;

public class Main {

    private static final Map<String, String> morseMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        setup();

        int n = Integer.parseInt(br.readLine());
        String[] codes = br.readLine().split(" ");
        for(String code : codes) {
            if(!morseMapper.containsKey(code)) {
                throw new IllegalArgumentException();
            }
            sb.append(morseMapper.get(code));
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static void setup() {
        morseMapper.put(".-", "A");
        morseMapper.put("-...", "B");
        morseMapper.put("-.-.", "C");
        morseMapper.put("-..", "D");
        morseMapper.put(".", "E");
        morseMapper.put("..-.", "F");
        morseMapper.put("--.", "G");
        morseMapper.put("....", "H");
        morseMapper.put("..", "I");
        morseMapper.put(".---", "J");
        morseMapper.put("-.-", "K");
        morseMapper.put(".-..", "L");
        morseMapper.put("--", "M");
        morseMapper.put("-.", "N");
        morseMapper.put("---", "O");
        morseMapper.put(".--.", "P");
        morseMapper.put("--.-", "Q");
        morseMapper.put(".-.", "R");
        morseMapper.put("...", "S");
        morseMapper.put("-", "T");
        morseMapper.put("..-", "U");
        morseMapper.put("...-", "V");
        morseMapper.put(".--", "W");
        morseMapper.put("-..-", "X");
        morseMapper.put("-.--", "Y");
        morseMapper.put("--..", "Z");
        morseMapper.put(".----", "1");
        morseMapper.put("..---", "2");
        morseMapper.put("...--", "3");
        morseMapper.put("....-", "4");
        morseMapper.put(".....", "5");
        morseMapper.put("-....", "6");
        morseMapper.put("--...", "7");
        morseMapper.put("---..", "8");
        morseMapper.put("----.", "9");
        morseMapper.put("-----", "0");
        morseMapper.put("--..--", ",");
        morseMapper.put(".-.-.-", ".");
        morseMapper.put("..--..", "?");
        morseMapper.put("---...", ":");
        morseMapper.put("-....-", "-");
        morseMapper.put(".--.-.", "@");
    }
}