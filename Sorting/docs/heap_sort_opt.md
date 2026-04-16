# 힙 정렬 최적화

## 원본 구현

```java
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
```

외부 `MyHeap` 자료구조에 원소를 하나씩 삽입해 힙을 구성한 뒤, 전부 꺼내 별도 배열에 담고 원본에 복사한다. `add()`를 n번 호출하므로 Build Heap 비용이 O(n log n)이며, 추가 배열 2개(MyHeap 내부 배열 + `newArr`)가 필요하다.

- Time Complexity: O(n log n) — Build O(n log n) + 정렬 O(n log n)
- Space Complexity: O(n) — MyHeap 배열 + newArr

---

## 최적화 구현

```java
private static void optHeapSort(int[] arr) {
    int n = arr.length;
    for (int i=n/2-1 ; i>=0 ; i--) {
        heapify(arr, n, i);
    }
    for (int i=n-1 ; i>0 ; i--) {
        int tmp = arr[0];
        arr[0] = arr[i];
        arr[i] = tmp;
        heapify(arr, i, 0);
    }
}

private static void heapify(int[] arr, int size, int root) {
    int left = root * 2 + 1;
    if (left >= size) return;
    int right = left + 1;
    int child = (right < size && arr[left] < arr[right]) ? right : left;
    if (arr[root] < arr[child]) {
        int tmp = arr[root];
        arr[root] = arr[child];
        arr[child] = tmp;
        heapify(arr, size, child);
    }
}
```

입력 배열 자체를 최대 힙으로 구성하고(Build Heap), 루트(최댓값)를 배열 끝과 교환하며 정렬한다. 외부 자료구조 없이 배열의 인덱스 관계만으로 힙 연산을 수행한다.

- Time Complexity: O(n log n) — Build O(n) + 정렬 O(n log n)
- Space Complexity: **O(1)** — 추가 배열 없음, 재귀 스택 O(log n)

### 핵심 구현 포인트

**1. 최대 힙을 사용하는 이유**

In-place 정렬에서는 배열의 인덱스 0이 힙의 루트로 고정된다. 확정된 원소를 앞에서부터 쌓으려면 루트를 바꿔야 하지만, 이 경우 나머지 원소들의 부모/자식 인덱스 관계가 무너진다. 최대 힙은 확정 구간을 뒤에서부터 쌓기 때문에 루트(인덱스 0) 기준 힙 구조가 유지된다.

```
[힙 영역 | 확정 영역]
  0~i-1  |  i~n-1     ← 루트(0)가 항상 힙 영역의 시작
```

**2. Build Heap은 n/2-1부터 역순으로**

완전 이진 트리에서 인덱스 `n/2 ~ n-1`은 리프 노드(자식 없음)이므로 heapify가 불필요하다. 마지막 내부 노드인 `n/2-1`부터 루트(0)까지 역순으로 heapify하면 모든 내부 노드를 한 번씩 처리한다.

```
마지막 내부 노드 인덱스 = (마지막 노드의 부모) = (n-1-1)/2 = n/2-1
```

이 방식의 Build Heap은 O(n)이다. 트리 아래쪽 노드일수록 heapify 비용이 작아 합산 시 O(n log n)이 아닌 O(n)으로 수렴한다.

**3. heapify의 base case**

`root`가 리프 노드(`left >= size`)이면 즉시 반환해야 한다. 이 체크 없이 `arr[left]`에 접근하면 ArrayIndexOutOfBoundsException이 발생한다.

```java
int left = root * 2 + 1;
if (left >= size) return;  // 반드시 left 계산 후 체크
```

**4. heapify의 관심사**

heapify는 `root`와 두 자식 사이의 관계만 처리한다. swap이 발생하면 내려간 자리에서 같은 문제가 생길 수 있으므로 재귀적으로 반복한다. 각 단계에서 "나와 내 자식만 본다"는 단순한 규칙이 재귀를 통해 서브트리 전체로 전파된다.

```java
int child = (right < size && arr[left] < arr[right]) ? right : left;
if (arr[root] < arr[child]) {
    swap(root, child);
    heapify(arr, size, child);  // 내려간 자리에서 재귀
}
```

**5. 정렬 루프 종료 조건은 `i > 0`**

`i = 0`일 때 `arr[0]`과 `arr[0]` 교환(무의미) 후 `heapify(arr, 0, 0)`이 호출된다. size=0이면 left=1 >= 0이므로 base case로 즉시 반환되지만 불필요한 호출이다. `i > 0`으로 한 칸 일찍 종료한다.

---

## 최적화 전략

### 문제 1 — Build Heap O(n log n)

원본은 `add()`를 n번 호출해 힙을 구성한다. 각 `add()`는 삽입 후 루트까지 올라가는 sift-up을 수행하므로 O(log n)이고, 전체 Build Heap 비용은 O(n log n)이다.

### 문제 2 — 추가 배열 O(n)

`MyHeap` 내부 배열과 결과를 담을 `newArr` 두 개의 O(n) 배열이 필요하다.

### 핵심 관찰 — 배열과 힙은 인덱스 관계로 대응된다

0-indexed 배열에서 인덱스 관계만으로 완전 이진 트리의 부모/자식 관계를 표현할 수 있다.

```
부모:        (i - 1) / 2
왼쪽 자식:   2 * i + 1
오른쪽 자식: 2 * i + 2
```

별도 자료구조 없이 배열 자체가 힙이 되므로 추가 메모리가 필요 없다.

### 개선 1 — Build Heap O(n)

sift-up(아래→위) 대신 sift-down(위→아래, heapify)을 역순으로 적용하면 Build Heap을 O(n)에 수행할 수 있다. 리프 노드는 건너뛰고 내부 노드만 처리하며, 아래쪽 노드일수록 heapify 비용이 작아 전체 합산이 O(n)으로 수렴한다.

```
원본:  n번 add() (sift-up) → O(n log n)
최적화: n/2번 heapify (sift-down) → O(n)
```

### 개선 2 — In-place 정렬 O(1) 공간

최대 힙의 루트(최댓값)를 배열 끝과 교환하면 최댓값이 확정 구간에 놓인다. 힙 크기를 1 줄이고 루트에서 heapify를 수행해 힙 성질을 복구한다. 배열 하나로 힙과 정렬 결과를 동시에 관리한다.

```
[힙 영역         | 확정 영역  ]
[5, 4, 3, 2, 1  |           ]  Build Heap 완료
[4, 2, 3, 1,    | 5         ]  swap + heapify
[3, 2, 1,       | 4, 5      ]  swap + heapify
[2, 1,          | 3, 4, 5   ]  swap + heapify
[1,             | 2, 3, 4, 5]  swap + heapify
[               | 1, 2, 3, 4, 5]  완료
```

---

## 테스트 결과 (n = 100,000)

| Case | Orig (ms) | Opt (ms) | Speedup |
|---|---|---|---|
| Random (duplicates, negative included) | 16.196 | 11.098 | ~1.46x |
| Random (duplicates, positive only) | 9.239 | 8.338 | ~1.11x |
| Unique (no duplicates) | 8.785 | 7.751 | ~1.13x |
| Already Sorted | 5.716 | 4.397 | ~1.30x |
| Reverse Sorted | 6.952 | 4.506 | ~1.54x |
| All Same Elements | 0.462 | 0.199 | ~2.32x |

---

## 분석

### 모든 케이스에서 고른 개선

Build Heap O(n) 개선과 추가 배열 제거가 입력 상태와 무관하게 항상 적용되므로 모든 케이스에서 고르게 개선된다.

### All Same — 가장 큰 개선 (~2.32x)

동등 원소에서 `arr[root] < arr[child]`가 항상 false라 heapify가 즉시 반환된다. Build Heap과 정렬 단계 모두 heapify 비용이 극히 낮고, 추가 배열 할당 제거 효과까지 합산되어 가장 큰 개선이 나타난다.

### Build Heap O(n) 개선인데 ~1.1~1.5x에 그치는 이유

Build Heap이 O(n log n) → O(n)으로 개선되었지만 **정렬 단계가 O(n log n)으로 전체를 지배**한다. Build Heap 비용은 전체의 일부에 불과하므로 개선 효과가 희석된다.

추가로 힙 정렬은 구조적으로 **캐시 비지역성** 문제가 있다. heapify가 트리를 따라 이동할 때 메모리 접근 패턴이 불규칙해 CPU 캐시 히트율이 낮다. 이로 인해 같은 O(n log n)인 병합·퀵 정렬보다 실측 성능이 낮게 나오는 경우가 많다.

### 결론

이번 최적화의 본질은 병합 정렬과 마찬가지로 **공간복잡도 O(n) → O(1)** 개선이다. Build Heap의 시간 개선은 정렬 단계에 가려져 실측 효과가 제한적이다.

| | 원본 | 최적화 |
|---|---|---|
| Build Heap | O(n log n) | **O(n)** |
| 정렬 단계 | O(n log n) | O(n log n) |
| 공간 | O(n) | **O(1)** |

힙 정렬은 **최악 O(n log n) + 공간 O(1)** 을 동시에 만족하는 유일한 비교 기반 정렬이다. 이 두 조건을 모두 충족하는 구현이 이번 최적화의 진짜 의의다.
