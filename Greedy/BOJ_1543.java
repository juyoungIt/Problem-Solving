// BOJ - 1543
// Problem Sheet - https://www.acmicpc.net/problem/1543

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String document = bf.readLine();    // 입력된 문서의 내용
        String searchWord = bf.readLine();  // 입력된 검색단어의 내용
        int curIdx = 0; // 현재 참조 중인 문자열의 index
        int answer = 0;

        int length = searchWord.length();
        while(curIdx < document.length()) {
            try {
                if(document.substring(curIdx, curIdx + length).equals(searchWord)) {
                    answer++;
                    curIdx += length;
                    continue;
                }
                curIdx++;
            }
            catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        System.out.println(answer);

        bf.close();
        System.exit(0);
    }
}