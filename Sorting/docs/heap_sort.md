# 힙 정렬 (Heap Sort)

## 개요

힙 정렬은 최대 힙(Max Heap) 자료구조를 이용하여 정렬하는 알고리즘이다. 배열로 힙을 구성한 뒤, 힙의 루트(최댓값)를 반복적으로 추출하여 정렬된 결과를 만든다. 항상 O(n log n)을 보장하면서도 추가 메모리가 필요 없는 제자리 정렬이다.

---

## 동작 원리

**1단계 — 힙 구성(Build Heap)**
- 배열 전체를 최대 힙으로 만든다.
- 마지막 내부 노드 `(n/2 - 1)`부터 루트까지 `heapify`를 역순으로 적용한다.

**2단계 — 정렬(Sort)**
- 루트(최댓값)를 배열의 마지막 원소와 교환한다.
- 힙 크기를 1 줄이고, 루트에서 다시 `heapify`를 수행한다.
- 힙 크기가 1이 될 때까지 반복한다.

### 예시

```
초기 배열: [5, 3, 8, 1, 2]

--- Build Max Heap ---
heapify(index=1): [5, 3, 8, 1, 2] → 3의 자식 중 최대 없음
heapify(index=0): 8이 최대 → swap(arr[0], arr[2])
최대 힙: [8, 3, 5, 1, 2]

--- 정렬 단계 ---
swap(arr[0], arr[4]) → [2, 3, 5, 1, 8]  ← 8 확정
heapify(index=0, size=4): 5가 최대 → [5, 3, 2, 1, 8]

swap(arr[0], arr[3]) → [1, 3, 2, 5, 8]  ← 5 확정
heapify(index=0, size=3): 3이 최대 → [3, 1, 2, 5, 8]

swap(arr[0], arr[2]) → [2, 1, 3, 5, 8]  ← 3 확정
heapify(index=0, size=2): 2가 최대 → [2, 1, 3, 5, 8]

swap(arr[0], arr[1]) → [1, 2, 3, 5, 8]  ← 2 확정

정렬 완료: [1, 2, 3, 5, 8]
```

---

## 구현 (Java)

### 기본 구현

```java
public static void heapSort(int[] arr) {
    int n = arr.length;
    // 1단계: 최대 힙 구성 (마지막 내부 노드부터 루트까지)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
    // 2단계: 루트(최댓값)를 끝으로 보내고 힙 복구
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
        heapify(arr, i, 0);
    }
}

// size 크기의 힙에서 index를 루트로 하는 서브트리를 최대 힙으로 복구
private static void heapify(int[] arr, int size, int index) {
    int largest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    if (left < size && arr[left] > arr[largest]) largest = left;
    if (right < size && arr[right] > arr[largest]) largest = right;
    if (largest != index) {
        int temp = arr[index]; arr[index] = arr[largest]; arr[largest] = temp;
        heapify(arr, size, largest);  // 교환된 자식 서브트리도 복구
    }
}
```

### 반복 heapify (스택 오버플로우 방지)

```java
private static void heapifyIterative(int[] arr, int size, int index) {
    while (true) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;
        if (largest == index) break;
        int temp = arr[index]; arr[index] = arr[largest]; arr[largest] = temp;
        index = largest;
    }
}
```

---

## 시간 복잡도 & 공간 복잡도

| 경우 | 시간 복잡도 | 설명 |
|------|------------|------|
| 최선 (Best) | O(n log n) | 항상 동일 |
| 평균 (Average) | O(n log n) | 항상 동일 |
| 최악 (Worst) | O(n log n) | 항상 동일 |

- **공간 복잡도**: O(1) — 추가 메모리 없이 제자리(in-place) 정렬
- Build Heap 단계: O(n) (선형 시간)
- 정렬 단계: n번의 heapify, 각 O(log n) → O(n log n)

---

## 안정성 (Stability)

힙 정렬은 **불안정 정렬(Unstable Sort)** 이다.

힙 구성 및 루트 추출 과정에서 원소들이 비연속적으로 교환되어 동일 값의 상대적 순서가 뒤바뀔 수 있다.

---

## 다른 정렬 알고리즘과의 비교

| 알고리즘 | 평균 시간 | 최악 시간 | 공간 | 안정 |
|----------|----------|----------|------|------|
| 삽입 정렬 | O(n²) | O(n²) | O(1) | ✅ |
| 병합 정렬 | O(n log n) | O(n log n) | O(n) | ✅ |
| 퀵 정렬 | O(n log n) | O(n²) | O(log n) | ❌ |
| 힙 정렬 | O(n log n) | O(n log n) | O(1) | ❌ |

힙 정렬은 **최악 O(n log n) + 공간 O(1)** 을 동시에 만족하는 유일한 비교 기반 정렬이다.

---

## 특징 및 실전 활용

**장점**
- 최악의 경우에도 O(n log n)을 보장한다.
- O(1)의 추가 공간만 사용한다.
- 메모리가 제한적인 환경에서 병합 정렬의 대안으로 사용 가능하다.

**단점**
- 불안정 정렬이다.
- 캐시 비지역성(Cache Unfriendly) — 힙 트리를 따라 이동할 때 메모리 접근 패턴이 불규칙하여 실제 속도가 퀵 정렬보다 느린 경우가 많다.
- 코딩 테스트에서 직접 구현할 기회가 적다.

**실전 활용**
- **우선순위 큐(Priority Queue)** 의 핵심 자료구조인 힙을 직접 이해하기 위한 필수 알고리즘.
- **k번째 최솟값/최댓값** 문제에서 `PriorityQueue`를 사용하는 원리.
- 힙 구조를 이해하면 다익스트라, 프림 알고리즘 등에서의 `PriorityQueue` 활용도 자연스럽게 이해된다.

---

## 힙(Heap) 자료구조 핵심 정리

```
배열 인덱스 기준 (0-indexed):
- 부모 노드: (i - 1) / 2
- 왼쪽 자식: 2 * i + 1
- 오른쪽 자식: 2 * i + 2

최대 힙 성질: 모든 노드에서 부모 ≥ 자식
```

---

## 관련 개념

- **최대 힙(Max Heap)**: 루트가 항상 최댓값인 완전 이진 트리.
- **heapify**: 특정 노드를 루트로 하는 서브트리를 힙 성질에 맞게 복구하는 연산. O(log n).
- **Build Heap**: 임의의 배열을 힙으로 만드는 과정. O(n) (각 heapify가 트리 아래쪽에서 수행되어 합산 시 선형).
- **우선순위 큐(Priority Queue)**: 힙을 기반으로 삽입 O(log n), 최솟값/최댓값 추출 O(log n).

---

## 관련 문제

| 문제 번호 | 제목 | 핵심 포인트 |
|-----------|------|------------|
| BOJ 11279 | 최대 힙 | 최대 힙 직접 구현 |
| BOJ 1927 | 최소 힙 | 최소 힙 직접 구현 |
| BOJ 11286 | 절댓값 힙 | 커스텀 비교 기준 힙 |
| BOJ 2696 | 중앙값 구하기 | 최대 힙 + 최소 힙 동시 활용 |
