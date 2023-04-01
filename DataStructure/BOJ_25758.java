// BOJ - 25758
// Problem Sheet - https://www.acmicpc.net/problem/25758

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Character> characteristicsSet = new HashSet<>();
        PriorityQueue<Character> characteristics = new PriorityQueue<>();

        int numberOfGenes = Integer.parseInt(bf.readLine());
        List<Character> frontGenes = new ArrayList<>(numberOfGenes);
        List<Character> rearGenes = new ArrayList<>(numberOfGenes);

        String[] firstGenGenes = bf.readLine().split(" ");
        for(String firstGenGene : firstGenGenes) {
            char[] baseGenes = firstGenGene.toCharArray();
            frontGenes.add(baseGenes[0]);
            rearGenes.add(baseGenes[1]);
        }
        Collections.sort(frontGenes);
        Collections.sort(rearGenes);

        if(frontGenes.get(0) < rearGenes.get(0)) {
            for(int i=1 ; i<numberOfGenes ; i++) {
                if(!characteristicsSet.contains(rearGenes.get(i))) {
                    characteristicsSet.add(rearGenes.get(i));
                    characteristics.add(rearGenes.get(i));
                }
            }
            for(int i=1 ; i<numberOfGenes ; i++) {
                if(rearGenes.get(0) < frontGenes.get(i)) {
                    if(!characteristicsSet.contains(frontGenes.get(i))) {
                        characteristicsSet.add(frontGenes.get(i));
                        characteristics.add(frontGenes.get(i));
                    }
                } else {
                    if(!characteristicsSet.contains(rearGenes.get(0))) {
                        characteristicsSet.add(rearGenes.get(0));
                        characteristics.add(rearGenes.get(0));
                    }
                }
            }
        } else {
            for(int i=1 ; i<numberOfGenes ; i++) {
                if(!characteristicsSet.contains(frontGenes.get(i))) {
                    characteristicsSet.add(frontGenes.get(i));
                    characteristics.add(frontGenes.get(i));
                }
            }
            for(int i=1 ; i<numberOfGenes ; i++) {
                if(frontGenes.get(0) < rearGenes.get(i)) {
                    if(!characteristicsSet.contains(rearGenes.get(i))) {
                        characteristicsSet.add(rearGenes.get(i));
                        characteristics.add(rearGenes.get(i));
                    }
                } else {
                    if(!characteristicsSet.contains(frontGenes.get(0))) {
                        characteristicsSet.add(frontGenes.get(0));
                        characteristics.add(frontGenes.get(0));
                    }
                }
            }
        }

        sb.setLength(0);
        while(!characteristics.isEmpty()) {
            sb.append(characteristics.poll()).append(" ");
        }
        sb.append("\n");

        System.out.println(characteristicsSet.size());
        System.out.println(sb);

        bf.close();
        System.exit(0);
    }
}