# 병합 정렬 (Merge Sort)

## 개요

병합 정렬은 배열을 절반으로 나누고, 각각을 재귀적으로 정렬한 뒤, 두 정렬된 배열을 **병합(merge)** 하여 하나의 정렬된 배열을 만드는 분할 정복(Divide & Conquer) 알고리즘이다. 항상 O(n log n)을 보장하는 대표적인 안정 정렬이다.

---

## 동작 원리

1. **분할(Divide)**: 배열을 절반으로 나눈다.
2. **정복(Conquer)**: 각 절반을 재귀적으로 정렬한다.
3. **병합(Merge)**: 두 정렬된 절반을 하나의 배열로 합친다.
   - 두 포인터를 각 절반의 시작에 두고, 더 작은 값을 순서대로 결과 배열에 복사한다.

### 예시

```
초기 배열: [5, 3, 8, 1, 2]

--- 분할 ---
[5, 3, 8, 1, 2]
├── [5, 3, 8]
│   ├── [5]
│   └── [3, 8]
│       ├── [3]
│       └── [8]
└── [1, 2]
    ├── [1]
    └── [2]

--- 병합 ---
[3] + [8]   → [3, 8]
[5] + [3, 8] → [3, 5, 8]
[1] + [2]   → [1, 2]
[3, 5, 8] + [1, 2] → [1, 2, 3, 5, 8]

정렬 완료: [1, 2, 3, 5, 8]
```

---

## 구현 (Java)

### 기본 구현 (Top-down, 재귀)

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) return;
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) temp[k++] = arr[i++];
        else temp[k++] = arr[j++];
    }
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    for (int l = 0; l < temp.length; l++) {
        arr[left + l] = temp[l];
    }
}
// 호출: mergeSort(arr, 0, arr.length - 1);
```

### 최적화 구현 (Bottom-up, 반복)

재귀 호출 오버헤드 없이 반복문으로 구현한다. 스택 오버플로우 걱정이 없어 실전에서 안정적이다.

```java
public static void mergeSortBottomUp(int[] arr) {
    int n = arr.length;
    int[] temp = new int[n];
    for (int size = 1; size < n; size *= 2) {
        for (int left = 0; left < n - size; left += size * 2) {
            int mid = left + size - 1;
            int right = Math.min(left + size * 2 - 1, n - 1);
            merge(arr, temp, left, mid, right);
        }
    }
}

private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
    for (int i = left; i <= right; i++) temp[i] = arr[i];
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
        if (temp[i] <= temp[j]) arr[k++] = temp[i++];
        else arr[k++] = temp[j++];
    }
    while (i <= mid) arr[k++] = temp[i++];
    while (j <= right) arr[k++] = temp[j++];
}
```

---

## 시간 복잡도 & 공간 복잡도

| 경우 | 시간 복잡도 | 설명 |
|------|------------|------|
| 최선 (Best) | O(n log n) | 항상 동일 |
| 평균 (Average) | O(n log n) | 항상 동일 |
| 최악 (Worst) | O(n log n) | 항상 동일 |

- **공간 복잡도**: O(n) — 병합 시 임시 배열 필요
- 재귀 깊이는 O(log n)이므로 스택 공간도 O(log n) 추가 소요.
- **항상 O(n log n)을 보장**하는 몇 안 되는 정렬 알고리즘이다.

---

## 안정성 (Stability)

병합 정렬은 **안정 정렬(Stable Sort)** 이다.

병합 시 `arr[i] <= arr[j]` 조건에서 같은 값이면 왼쪽 배열의 원소를 먼저 선택하므로, 동일 값의 상대적 순서가 보존된다.

---

## 다른 정렬 알고리즘과의 비교

| 알고리즘 | 평균 시간 | 최악 시간 | 공간 | 안정 |
|----------|----------|----------|------|------|
| 버블 정렬 | O(n²) | O(n²) | O(1) | ✅ |
| 선택 정렬 | O(n²) | O(n²) | O(1) | ❌ |
| 삽입 정렬 | O(n²) | O(n²) | O(1) | ✅ |
| 병합 정렬 | O(n log n) | O(n log n) | O(n) | ✅ |
| 퀵 정렬 | O(n log n) | O(n²) | O(log n) | ❌ |

---

## 특징 및 실전 활용

**장점**
- 최악의 경우에도 O(n log n)을 보장한다.
- 안정 정렬이다.
- 연결 리스트(Linked List) 정렬에 최적이다 — 랜덤 접근이 필요 없기 때문.
- **외부 정렬(External Sort)** 에 적합하다 — 디스크에 있는 대용량 데이터 정렬.

**단점**
- O(n)의 추가 메모리가 필요하다.
- 퀵 정렬보다 캐시 효율이 낮아 실제 속도가 느릴 수 있다.

**실전 활용**
- **역위(Inversion) 개수 세기** 문제에서 핵심 알고리즘으로 사용된다.
  - 병합 시 오른쪽 배열의 원소가 먼저 선택될 때마다 왼쪽 배열의 남은 원소 수만큼 역위가 발생한다.
- Java의 `Arrays.sort(Object[])` (Tim Sort), Python의 `sorted()` 내부에서 사용된다.

---

## 관련 개념

- **분할 정복(Divide & Conquer)**: 문제를 작은 부분으로 나눠 해결하고 합치는 전략.
- **역위(Inversion) 카운팅**: 병합 정렬 중 역위 수를 O(n log n)에 계산 가능.
- **외부 정렬(External Sort)**: 메모리에 올릴 수 없는 대용량 데이터를 디스크와 함께 정렬하는 방식. 병합 정렬 구조에 기반.
- **Tim Sort**: 삽입 정렬 + 병합 정렬의 하이브리드. 실제 데이터의 부분 정렬 특성을 활용.

---

## 관련 문제

| 문제 번호 | 제목 | 핵심 포인트 |
|-----------|------|------------|
| BOJ 2751 | 수 정렬하기 2 | O(n log n) 정렬 기본 구현 |
| BOJ 24060 | 알고리즘 수업 - 병합 정렬 1 | 병합 정렬 동작 시뮬레이션 |
| BOJ 1517 | 버블 소트 | 역위 수 세기 — 병합 정렬로 O(n log n) 해결 |
| BOJ 5719 | 거의 최단 경로 | 병합 정렬 응용 아이디어 |
