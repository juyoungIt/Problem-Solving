// BOJ - 23253
// Problem Sheet - https://www.acmicpc.net/problem/23253

import java.util.*;
import java.io.*;

public class Main {

    static class Book implements Comparable<Book> {
        private final int bookNumber; // 책 번호
        private final int pileIndex; // 속한 더미의 인덱스

        public Book(int bookNumber, int pileIndex) {
            this.bookNumber = bookNumber;
            this.pileIndex = pileIndex;
        }

        public int getBookNumber() { return this.bookNumber; }
        public int getPileIndex() { return this.pileIndex; }

        @Override
        public int compareTo(Book book) {
            return Integer.compare(this.bookNumber, book.getBookNumber());
        }

        public String toString() {
            return "(" + this.bookNumber + ", " + this.pileIndex + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Book> topBooks = new PriorityQueue<>(); // 더미 중 가장 위에 있는 책들
        boolean result = true; // 결과

        int n = Integer.parseInt(st.nextToken()); // 교과서의 수
        int m = Integer.parseInt(st.nextToken()); // 교과서 더미의 수
        List<Stack<Book>> bookPile = new ArrayList<>(m);
        for(int i=0 ; i<m ; i++) {
            bookPile.add(new Stack<>());
        }

        // 입력을 통해 교과서가 쌓여있는 정보를 구성함
        for(int i=0 ; i<m ; i++) {
            int bookCnt = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int j=0 ; j<bookCnt ; j++) {
                int book = Integer.parseInt(st.nextToken());
                bookPile.get(i).add(new Book(book, i));
                if(j == bookCnt-1) {
                    topBooks.add(bookPile.get(i).peek());
                }
            }
        }

        // 순서대로 책을 꺼내는 것을 시도함
        for(int i=1 ; i<=n ; i++) {
            if(!topBooks.isEmpty() && topBooks.peek().getBookNumber() != i) {
                result = false;
                break;
            }
            bookPile.get(topBooks.peek().getPileIndex()).pop(); // stack에서 해당 책을 제거함
            if(!bookPile.get(topBooks.peek().getPileIndex()).isEmpty()) {
                topBooks.add(bookPile.get(topBooks.poll().getPileIndex()).peek()); // queue에서 책을 제거함
            } else {
                topBooks.poll();
            }
        }

        System.out.println((result) ? "Yes" : "No");

        bf.close();
        System.exit(0);
    }
}