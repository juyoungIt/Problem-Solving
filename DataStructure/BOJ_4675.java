// BOJ - 4675
// Problem Sheet - https://www.acmicpc.net/problem/4675

import java.util.*;
import java.io.*;

public class Main {

    private static final String END_OF_WORD_OF_INPUT = "XXXXXX";
    private static final String END_OF_WORD_OF_OUTPUT = "******";
    private static final String INVALID = "NOT A VALID WORD";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, List<String>> elementMapper = new HashMap<>();
        while (true) {
            String word = br.readLine();
            if (word.equals(END_OF_WORD_OF_INPUT)) break;
            String sortedElementString = getSortedElementString(word);
            if (!elementMapper.containsKey(sortedElementString)) {
                elementMapper.put(sortedElementString, new ArrayList<>());
            }
            elementMapper.get(sortedElementString).add(word);
        }

        for (Map.Entry<String, List<String>> entry : elementMapper.entrySet()) {
            Collections.sort(entry.getValue());
        }

        while (true) {
            String candidate = br.readLine();
            if (candidate.equals(END_OF_WORD_OF_INPUT)) break;
            candidate = getSortedElementString(candidate);
            if (elementMapper.containsKey(candidate)) {
                for (String element : elementMapper.get(candidate)) {
                    sb.append(element).append("\n");
                }
            } else {
                sb.append(INVALID).append("\n");
            }
            sb.append(END_OF_WORD_OF_OUTPUT).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    private static String getSortedElementString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] elements = word.toCharArray();
        Arrays.sort(elements);
        sb.append(elements);
        return sb.toString();
    }
}