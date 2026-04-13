// BOJ - 33990
// Problem Sheet - https://www.acmicpc.net/problem/33990

import java.util.*;
import java.io.*;

public class Main {

    static class MyHeap {
        int[] arr;
        int size;

        public MyHeap(int size) {
            this.arr = new int[size + 1];
            this.size = 0;
        }

        public void add(int x) {
            arr[++size] = x;
            int cur = size;
            while (cur > 1) {
                int parent = cur / 2;
                if (arr[parent] <= arr[cur]) break;
                swap(parent, cur);
                cur = parent;
            }
        }

        public int poll() {
            if (size == 0) throw new IllegalStateException();
            int root = arr[1];
            arr[1] = arr[size--];
            int cur = 1;
            while (cur * 2 <= size) {
                int left = cur * 2;
                int right = left + 1;
                int child = (right <= size && arr[left] > arr[right]) ? right : left;
                if (arr[cur] <= arr[child]) break;
                swap(cur, child);
                cur = child;
            }
            return root;
        }

        private void swap(int idx1, int idx2) {
            int tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = generateArray(arrSize);
        long start = System.nanoTime();
        radixSort(arr);
        long end = System.nanoTime();
        System.out.println("Elapsed: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println(isSorted(arr) ? "Success" : "Failed");
        br.close();
    }

    private static void bubbleSort(int[] arr) {
        for (int i=arr.length-2 ; i>=0 ; i--) {
            for (int j=0 ; j<=i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i=arr.length-1 ; i>=0 ; i--) {
            int maxIdx = 0, maxValue = arr[0];
            for (int j=0 ; j<=i ; j++) {
                if (arr[j] > maxValue) {
                    maxIdx = j;
                    maxValue = arr[j];
                }
            }
            int tmp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i=1 ; i<arr.length ; i++) {
            int tmp = arr[i], j;
            for (j=i-1 ; j>=0 ; j--) {
                if (tmp > arr[j]) {
                    break;
                }
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        int[] arr1 = new int[arr.length / 2];
        int[] arr2 = new int[arr.length - arr1.length];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr.length/2, arr2, 0, arr2.length);
        mergeSort(arr1);
        mergeSort(arr2);
        int[] merged = merge(arr1, arr2);
        System.arraycopy(merged, 0, arr, 0, arr.length);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        int arr1Index = 0, arr2Index = 0, arrIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] <= arr2[arr2Index]) {
                newArr[arrIndex++] = arr1[arr1Index++];
            } else {
                newArr[arrIndex++] = arr2[arr2Index++];
            }
        }
        while (arr1Index < arr1.length) newArr[arrIndex++] = arr1[arr1Index++];
        while (arr2Index < arr2.length) newArr[arrIndex++] = arr2[arr2Index++];
        return newArr;
    }

    private static void heapSort(int[] arr) {
        int[] newArr = new int[arr.length];
        MyHeap heap = new MyHeap(arr.length);
        for (int element : arr) {
            heap.add(element);
        }
        for (int i=0 ; i<arr.length ; i++) {
            newArr[i] = heap.poll();
        }
        System.arraycopy(newArr, 0, arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (left <= end && arr[left] < pivot) left++;
            while (left < right && arr[right] > pivot) right--;
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        if (arr[left] > pivot) {
            int tmp = arr[left];
            arr[left] = arr[end];
            arr[end] = tmp;
        } else {
            left = end;
        }
        return left;
    }

    private static void radixSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int element : arr) {
            min = Math.min(min, element);
            max = Math.max(max, element);
        }
        if (min < 0) {
            for (int i=0 ; i<arr.length ; i++) {
                arr[i] -= min;
            }
            max -= min;
        }
        for (int i=1 ; max / i > 0 ; i *= 10) {
            sortByDigits(arr, i);
        }
        if (min < 0) {
            for (int i=0 ; i<arr.length ; i++) {
                arr[i] += min;
            }
            max += min;
        }
    }

    private static void sortByDigits(int[] arr, int digit) {
        int n = arr.length;
        int[] newArr = new int[n];
        int[] counts = new int[10];
        for (int element : arr) {
            counts[(element / digit) % 10]++;
        }
        for (int i=1 ; i<10 ; i++) {
            counts[i] += counts[i - 1];
        }
        for (int i=n-1 ; i>=0 ; i--) {
            int value = (arr[i] / digit) % 10;
            newArr[--counts[value]] = arr[i];
        }
        System.arraycopy(newArr, 0, arr, 0, n);
    }

    private static void countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int element : arr) {
            min = Math.min(min, element);
            max = Math.max(max, element);
        }
        int[] counts = new int[max - min + 1];
        for (int element : arr) {
            counts[element - min]++;
        }
        int idx = 0;
        for (int i=0 ; i<counts.length ; i++) {
            int count = counts[i];
            for (int j=0 ; j<count ; j++) {
                arr[idx++] = i + min;
            }
        }
    }

    private static int[] generateArray(int size) {
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[size];
        Random random = new Random();
        int index = 0;
        while (index < size) {
            int element = random.nextInt(size) + 1;
            if (set.contains(element)) continue;
            set.add(element);
            arr[index++] = element;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i=1 ; i<arr.length ; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }
}