# 퀵 정렬 (Quick Sort)

## 개요

퀵 정렬은 피벗(pivot)을 선택하고, 피벗보다 작은 원소는 왼쪽, 큰 원소는 오른쪽으로 분할한 뒤 각 부분을 재귀적으로 정렬하는 분할 정복(Divide & Conquer) 알고리즘이다. 평균적으로 O(n log n)의 빠른 성능을 보이며, 캐시 효율이 좋아 실전에서 가장 빠른 정렬 중 하나다.

---

## 동작 원리

1. **피벗 선택**: 배열에서 피벗 원소를 하나 선택한다.
2. **파티션(Partition)**: 피벗을 기준으로 작은 원소는 왼쪽, 큰 원소는 오른쪽으로 재배치한다.
3. **재귀**: 피벗의 왼쪽과 오른쪽 부분 배열에 대해 위 과정을 반복한다.
4. 부분 배열의 크기가 1 이하가 되면 재귀를 종료한다.

### 예시

```
초기 배열: [5, 3, 8, 1, 2]  (피벗: 마지막 원소 2)

--- 1번째 파티션 (pivot=2) ---
i=-1, j=0: arr[0]=5 > 2 → skip
i=-1, j=1: arr[1]=3 > 2 → skip
i=-1, j=2: arr[2]=8 > 2 → skip
i=-1, j=3: arr[3]=1 ≤ 2 → i=0, swap(arr[0], arr[3]) → [1, 3, 8, 5, 2]
피벗 확정: swap(arr[1], arr[4]) → [1, 2, 8, 5, 3]  ← 2 확정 (index 1)

--- 왼쪽 [1] → 크기 1, 종료 ---

--- 오른쪽 [8, 5, 3] (pivot=3) ---
i=-1, j=0: arr[0]=8 > 3 → skip
i=-1, j=1: arr[1]=5 > 3 → skip
피벗 확정: swap(arr[0], arr[2]) → [3, 5, 8]  ← 3 확정

--- [5, 8] (pivot=8) ---
i=-1, j=0: arr[0]=5 ≤ 8 → i=0, swap(arr[0], arr[0])
피벗 확정: swap(arr[1], arr[1]) → [5, 8]  ← 8 확정

정렬 완료: [1, 2, 3, 5, 8]
```

---

## 구현 (Java)

### 기본 구현 (Lomuto 파티션)

```java
public static void quickSort(int[] arr, int low, int high) {
    if (low >= high) return;
    int pivot = partition(arr, low, high);
    quickSort(arr, low, pivot - 1);
    quickSort(arr, pivot + 1, high);
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
    return i + 1;
}
// 호출: quickSort(arr, 0, arr.length - 1);
```

### 최적화 구현 (랜덤 피벗 + Hoare 파티션)

중복 원소가 많거나 정렬된 입력에서 최악의 경우를 방지하기 위해 랜덤 피벗을 사용한다.

```java
private static final Random rand = new Random();

public static void quickSort(int[] arr, int low, int high) {
    if (low >= high) return;
    // 랜덤 피벗 선택 후 끝으로 이동
    int pivotIdx = low + rand.nextInt(high - low + 1);
    int temp = arr[pivotIdx]; arr[pivotIdx] = arr[high]; arr[high] = temp;

    int pivot = partition(arr, low, high);
    quickSort(arr, low, pivot - 1);
    quickSort(arr, pivot + 1, high);
}
```

### 3-way 파티션 (중복 원소 최적화)

동일한 원소가 많을 때 O(n log n)을 유지하는 Dutch National Flag 방식이다.

```java
public static void quickSort3Way(int[] arr, int low, int high) {
    if (low >= high) return;
    int pivot = arr[low];
    int lt = low, gt = high, i = low + 1;
    while (i <= gt) {
        if (arr[i] < pivot) {
            int temp = arr[lt]; arr[lt] = arr[i]; arr[i] = temp;
            lt++; i++;
        } else if (arr[i] > pivot) {
            int temp = arr[gt]; arr[gt] = arr[i]; arr[i] = temp;
            gt--;
        } else {
            i++;
        }
    }
    // arr[low..lt-1] < pivot == arr[lt..gt] < arr[gt+1..high]
    quickSort3Way(arr, low, lt - 1);
    quickSort3Way(arr, gt + 1, high);
}
```

---

## 시간 복잡도 & 공간 복잡도

| 경우 | 시간 복잡도 | 설명 |
|------|------------|------|
| 최선 (Best) | O(n log n) | 피벗이 항상 중앙값일 때 |
| 평균 (Average) | O(n log n) | 무작위 피벗 선택 시 기댓값 |
| 최악 (Worst) | O(n²) | 피벗이 항상 최솟값 또는 최댓값 (이미 정렬된 배열 + 고정 피벗) |

- **공간 복잡도**: O(log n) — 재귀 호출 스택 (최악 O(n))
- 실전에서는 랜덤 피벗으로 최악 케이스를 거의 피할 수 있다.

---

## 안정성 (Stability)

퀵 정렬은 **불안정 정렬(Unstable Sort)** 이다.

파티션 과정에서 원소를 교환할 때 동일한 값을 가진 원소들의 상대적 순서가 바뀔 수 있다.

---

## 다른 정렬 알고리즘과의 비교

| 알고리즘 | 평균 시간 | 최악 시간 | 공간 | 안정 |
|----------|----------|----------|------|------|
| 버블 정렬 | O(n²) | O(n²) | O(1) | ✅ |
| 선택 정렬 | O(n²) | O(n²) | O(1) | ❌ |
| 삽입 정렬 | O(n²) | O(n²) | O(1) | ✅ |
| 병합 정렬 | O(n log n) | O(n log n) | O(n) | ✅ |
| 퀵 정렬 | O(n log n) | O(n²) | O(log n) | ❌ |
| 힙 정렬 | O(n log n) | O(n log n) | O(1) | ❌ |

---

## 특징 및 실전 활용

**장점**
- 평균적으로 병합 정렬보다 빠르다 — 캐시 지역성(Cache Locality)이 좋음.
- 제자리 정렬에 가까워 메모리 효율이 좋다 (O(log n) 스택).
- 랜덤 피벗 사용 시 최악 케이스 확률이 극히 낮다.

**단점**
- 최악의 경우 O(n²) — 정렬된 배열에 고정 피벗 사용 시.
- 불안정 정렬이다.
- 재귀 깊이가 깊어지면 스택 오버플로우 위험이 있다.

**실전 활용**
- Java의 `Arrays.sort(int[])` (기본 타입 배열)는 Dual-Pivot 퀵 정렬을 사용한다.
- 코딩 테스트에서 직접 구현보다는 `Arrays.sort()` 활용이 일반적이다.
- 퀵 선택(Quick Select) 알고리즘으로 응용 — k번째 원소를 O(n) 평균에 찾기.

---

## 관련 개념

- **Dual-Pivot 퀵 정렬**: 피벗을 2개 사용해 배열을 3구간으로 분할. Java 기본 타입 정렬에 사용.
- **퀵 선택(Quick Select)**: 퀵 정렬의 파티션을 이용해 k번째 원소를 평균 O(n)에 찾는 알고리즘.
- **Dutch National Flag**: 3-way 파티션의 원형. 중복 원소 처리에 최적.
- **캐시 지역성(Cache Locality)**: 인접 메모리를 연속해서 접근하므로 CPU 캐시 히트율이 높아 실제로 빠름.

---

## 관련 문제

| 문제 번호 | 제목 | 핵심 포인트 |
|-----------|------|------------|
| BOJ 11004 | K번째 수 | 퀵 선택(Quick Select) 또는 `Arrays.sort` 활용 |
| BOJ 24061 | 알고리즘 수업 - 퀵 정렬 1 | 퀵 정렬 동작 시뮬레이션 |
