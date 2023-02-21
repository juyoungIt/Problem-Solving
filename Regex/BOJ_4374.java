// BOJ - 4374
// Problem Sheet - https://www.acmicpc.net/problem/4374

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {

    private final static String END_OF_TEXT = "EndOfText";
    private final static String NO_WORDS = "There is no such word.";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> wordCountMapper = new HashMap<>();
        int targetCount = 0; // 찾고자 하는 단어의 등장횟수
        boolean isCaseStarted = false; // 본문이 시작되었는 가?

        String input = "";
        while((input = bf.readLine()) != null) {
            if(input.equals(END_OF_TEXT)) {
                List<String> results = findCountedWords(wordCountMapper, targetCount);
                if(results.size() == 0) {
                    System.out.println(NO_WORDS);
                } else {
                    for(String word : results) {
                        System.out.println(word);
                    }
                }
                System.out.println();
                wordCountMapper.clear(); // 재사용을 위해 초기화
                isCaseStarted = false;
            } else {
                if(!isCaseStarted) {
                    targetCount = Integer.parseInt(input);
                    isCaseStarted = true;
                } else {
                    String[] words = input
                            .trim()
                            .toLowerCase()
                            .replaceAll("[^a-z\\s]", " ")
                            .split(" ");
                    for(String word : words) {
                        if(wordIsValid(word)) {
                            addToMapper(wordCountMapper, word);
                        }
                    }
                }
            }
        }

        bf.close();
        System.exit(0);
    }

    private static List<String> findCountedWords(Map<String, Integer> wordCountMapper, int targetCount) {
        List<String> result = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : wordCountMapper.entrySet()) {
            if(entry.getValue() == targetCount) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result); // 구성된 단어를 사전 순으로 정렬
        return result;
    }

    private static void addToMapper(Map<String, Integer> wordCountMapper, String word) {
        if(wordCountMapper.containsKey(word)) {
            wordCountMapper.put(word, wordCountMapper.get(word) + 1);
        } else {
            wordCountMapper.put(word, 1);
        }
    }

    private static boolean wordIsValid(String word) {
        return Pattern.matches("[a-z]*$", word) && !word.equals("");
    }
}