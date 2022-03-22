// BOJ - 1744
// Problem Sheet - https://www.acmicpc.net/problem/1744

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int seqSize = key.nextInt();  // 수열의 길이
        int[] seq = new int[seqSize]; // 수열
        for(int i=0 ; i<seqSize ; i++)
            seq[i] = key.nextInt();
        int i, j; // 반복문 사용을 위한 변수
        int sum = 0; // 수열의 수들에 대한 합산값


        Arrays.sort(seq);
        for(i=0 ; i<seqSize ; i+=2) {
            if(seqSize == 1)
                break;
            else if(seq[i] < 1 && seq[i+1] < 1)
                sum += seq[i] * seq[i+1];
            else
                break;
        }

        for(j=seqSize-1 ; j>0 ; j-=2) {
            if(seq[j] > 1 && seq[j-1] > 1)
                sum += seq[j] * seq[j-1];
            else
                break;
        }

        for(int k=i ; k<=j ; k++)
            sum += seq[k];
        System.out.println(sum);

        key.close(); // scanner close
        System.exit(0);
    }
}
