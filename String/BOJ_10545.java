// BOJ - 10545
// Problem Sheet - https://www.acmicpc.net/problem/10545

import java.util.*;
import java.io.*;

public class Main {

    private static Map<Character, String> keyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initKeyMap();
        char[] keys = new char[10];
        String[] row = br.readLine().split(" ");
        for (int i=0 ; i<row.length ; i++) {
            int key = Integer.parseInt(row[i]);
            keys[key] = (char) ('0' + i + 1);
        }
        String s = br.readLine();
        String[] clicks = new String[s.length()];
        for (int i=0 ; i<s.length() ; i++) {
            clicks[i] = keyMap.get(s.charAt(i));
        }
        for (String click : clicks) {
            String newClick = click.replaceAll(click.charAt(0)+"", keys[click.charAt(0) - '0']+"");
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == newClick.charAt(0)) {
                sb.append("#");
            }
            sb.append(newClick);
        }

        System.out.println(sb);
        br.close();
    }

    private static void initKeyMap() {
        keyMap = new HashMap<>();
        keyMap.put('a', "2"); keyMap.put('b', "22"); keyMap.put('c', "222");
        keyMap.put('d', "3"); keyMap.put('e', "33"); keyMap.put('f', "333");
        keyMap.put('g', "4"); keyMap.put('h', "44"); keyMap.put('i', "444");
        keyMap.put('j', "5"); keyMap.put('k', "55"); keyMap.put('l', "555");
        keyMap.put('m', "6"); keyMap.put('n', "66"); keyMap.put('o', "666");
        keyMap.put('p', "7"); keyMap.put('q', "77"); keyMap.put('r', "777"); keyMap.put('s', "7777");
        keyMap.put('t', "8"); keyMap.put('u', "88"); keyMap.put('v', "888");
        keyMap.put('w', "9"); keyMap.put('x', "99"); keyMap.put('y', "999"); keyMap.put('z', "9999");
    }

}
