// BOJ - 18294
// Problem Sheet - https://www.acmicpc.net/problem/18294

import java.util.*;
import java.io.*;

public class Main {

    static class Animal implements Comparable<Animal> {
        private final String name;
        private final int count;

        public Animal(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return this.name; }
        public int getCount() { return this.count; }

        @Override
        public int compareTo(Animal animal) {
            return Integer.compare(this.count, animal.count) * -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> animalCounts = new HashMap<>();
        PriorityQueue<Animal> animals = new PriorityQueue<>();

        int numberOfAnimals = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<numberOfAnimals ; i++) {
            String animal = bf.readLine();
            if(!animalCounts.containsKey(animal)) {
                animalCounts.put(animal, 0);
            }
            animalCounts.put(animal, animalCounts.get(animal)+1);
        }

        for(Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            animals.add(new Animal(entry.getKey(), entry.getValue()));
        }

        if(animals.peek().count * 2 > numberOfAnimals) {
            System.out.println(animals.peek().getName());
        } else {
            System.out.println("NONE");
        }

        bf.close();
        System.exit(0);
    }
}