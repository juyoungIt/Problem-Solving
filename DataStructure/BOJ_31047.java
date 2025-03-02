// BOJ - 31047
// Problem Sheet - https://www.acmicpc.net/problem/31047

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static class Toy {
        private final String name;
        private int shipment;

        public Toy(String name, int shipment) {
            this.name = name;
            this.shipment = shipment;
        }

        public String getName() { return this.name; }
        public int getShipment() { return this.shipment; }
        public void addToy(int shipment) { this.shipment += shipment; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Map<String, Toy> toyMapper = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i=0 ; i<N ; i++) {
                String[] row = br.readLine().split(" ");
                String name = row[0];
                int shipment = Integer.parseInt(row[1]);
                if (!toyMapper.containsKey(name)) {
                    toyMapper.put(name, new Toy(name, shipment));
                } else {
                    toyMapper.get(name).addToy(shipment);
                }
            }
            List<Toy> toys = toyMapper.values().stream()
                    .sorted((t1, t2) -> {
                        if (t1.getShipment() == t2.getShipment()) return t1.getName().compareTo(t2.getName());
                        return t2.getShipment() - t1.getShipment();
                    })
                    .collect(Collectors.toList());
            sb.append(toys.size()).append("\n");
            for (Toy toy : toys) {
                sb.append(toy.getName()).append(" ").append(toy.getShipment()).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}