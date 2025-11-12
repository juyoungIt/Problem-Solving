// BOJ - 18388
// Problem Sheet - https://www.acmicpc.net/problem/18388

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> mappingTable = getMappingTable();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            for (int i=0 ; i<token.length() ; i++) {
                char c = token.charAt(i);
                if (Character.isLowerCase(c)) sb.append(c);
                else sb.append(mappingTable.get(c));
            }
            sb.append(" ");
        }
        br.close();
        System.out.println(sb);
    }

    private static Map<Character, Character> getMappingTable() {
        Map<Character, Character> mappingTable = new HashMap<>();
        mappingTable.put('Q', 'W'); mappingTable.put('W', 'E'); mappingTable.put('E', 'R');
        mappingTable.put('R', 'T'); mappingTable.put('T', 'Y'); mappingTable.put('Y', 'U');
        mappingTable.put('U', 'I'); mappingTable.put('I', 'O'); mappingTable.put('O', 'P');
        mappingTable.put('A', 'S'); mappingTable.put('S', 'D'); mappingTable.put('D', 'F');
        mappingTable.put('F', 'G'); mappingTable.put('G', 'H'); mappingTable.put('H', 'J');
        mappingTable.put('J', 'K'); mappingTable.put('K', 'L');
        mappingTable.put('Z', 'X'); mappingTable.put('X', 'C'); mappingTable.put('C', 'V');
        mappingTable.put('V', 'B'); mappingTable.put('B', 'N'); mappingTable.put('N', 'M');
        return mappingTable;
    }

}