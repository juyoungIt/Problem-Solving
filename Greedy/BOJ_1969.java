// BOJ - 1969
// Problem Sheet - https://www.acmicpc.net/problem/1969

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder(); // DNA 구성에 사용하기 위한 StringBuilder
        char[] amino_list = {'A', 'C', 'G', 'T'}; // 배치 가능한 아미노산의 리스트

        int n = Integer.parseInt(st.nextToken()); // DNA의 수
        int m = Integer.parseInt(st.nextToken()); // 문자열의 길이
        String[] dna_list = new String[n];
        for(int i=0 ; i<n ; i++)
            dna_list[i] = bf.readLine();
        int sum = 0;

        // 길이 m에 대하여 다음을 반복함
        for(int i=0 ; i<m ; i++) {
            int minHamming_dist = n;
            int minIdx = 0;
            for(int j=0 ; j<4 ; j++) {
                int hamming_dist = 0;
                for(int k=0 ; k<n ; k++) {
                    if(dna_list[k].charAt(i) != amino_list[j])
                        hamming_dist++;
                }
                if(minHamming_dist > hamming_dist) {
                    minHamming_dist = hamming_dist;
                    minIdx = j;
                }
            }
            sb.append(amino_list[minIdx]);
            sum += minHamming_dist;
        }

        System.out.println(sb);
        System.out.println(sum);

        bf.close();
        System.exit(0);
    }
}