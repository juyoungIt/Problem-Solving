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
        br.close();

        String[] caseNames = {
            "Random (duplicates, negative included)",
            "Random (duplicates, positive only)",
            "Unique (no duplicates)",
            "Already Sorted",
            "Reverse Sorted",
            "All Same Elements"
        };

        int[][] testCases = generateArray(arrSize);
        int[][] testCasesCopies = new int[testCases.length][];
        for (int i = 0; i < testCases.length; i++) {
            testCasesCopies[i] = Arrays.copyOf(testCases[i], testCases[i].length);
        }

        System.out.printf("%-40s  %12s  %6s  %12s  %6s%n", "Case", "Orig (ms)", "Valid", "Opt (ms)", "Valid");
        System.out.println("-".repeat(40) + "  " + "-".repeat(12) + "  " + "-".repeat(6) + "  " + "-".repeat(12) + "  " + "-".repeat(6));

        for (int i = 0; i < testCases.length; i++) {
            long start = System.nanoTime();
            mergeSort(testCases[i]);
            long origTime = System.nanoTime() - start;
            boolean origValid = isSorted(testCases[i]);

            start = System.nanoTime();
            optMergeSort(testCasesCopies[i]);
            long optTime = System.nanoTime() - start;
            boolean optValid = isSorted(testCasesCopies[i]);

            System.out.printf(
                "%-40s  %12.3f  %6s  %12.3f  %6s%n",
                caseNames[i],
                origTime / 1_000_000.0,
                origValid ? "OK" : "FAIL",
                optTime / 1_000_000.0,
                optValid ? "OK" : "FAIL"
            );
        }
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

    private static void optBubbleSort(int[] arr) {
        for (int i=arr.length-2 ; i>=0 ; i--) {
            boolean swapped = false;
            for (int j=0 ; j<=i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
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

    private static void optSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i=0 ; i<n/2 ; i++) {
            int minValue = arr[i], maxValue = arr[i];
            int minIdx = i, maxIdx = i;
            for (int j=i ; j<n-i ; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIdx = j;
                }
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                    maxIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
            if (maxIdx == i) maxIdx = minIdx;
            tmp = arr[n - i - 1];
            arr[n - i - 1] = arr[maxIdx];
            arr[maxIdx] = tmp;
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

    private static void optInsertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1 ; i<n ; i++) {
            int tmp = arr[i];
            int start = 0, end = i - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] <= tmp) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            for (int j=i-1 ; j>=start ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[start] = tmp;
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

    private static void optMergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] tmp = new int[arr.length];
        optMergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void optMergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        optMergeSort(arr, tmp, left, mid);
        optMergeSort(arr, tmp, mid + 1, right);
        if (arr[mid] <= arr[mid + 1]) return;
        optMerge(arr, tmp, left, mid, right);
    }

    private static void optMerge(int[] arr, int[] tmp, int left, int mid, int right) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (tmp[i] <= tmp[j]) {
                arr[k++] = tmp[i++];
            } else {
                arr[k++] = tmp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = tmp[i++];
        }
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

    private static int[][] generateArray(int size) {
        return new int[][] {
            generateRandom(size, -size, size),
            generateRandom(size, 1, size),
            generateUnique(size),
            generateSorted(size),
            generateReversed(size),
            generateAllSame(size)
        };
    }

    private static int[] generateRandom(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        int range = max - min + 1;
        for (int i=0 ; i<size ; i++) {
            arr[i] = random.nextInt(range) + min;
        }
        return arr;
    }

    private static int[] generateUnique(int size) {
        int[] arr = new int[size];
        for (int i=0 ; i<size ; i++) arr[i] = i + 1;
        Random random = new Random();
        for (int i=size-1 ; i>0 ; i--) {
            int j = random.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    private static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i=0 ; i<size ; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int[] generateReversed(int size) {
        int[] arr = new int[size];
        for (int i=0 ; i<size ; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    private static int[] generateAllSame(int size) {
        int[] arr = new int[size];
        Arrays.fill(arr, 42);
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i=1 ; i<arr.length ; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}