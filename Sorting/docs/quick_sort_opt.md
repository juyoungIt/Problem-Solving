# 퀵 정렬 최적화

퀵 정렬은 단일 구현이 아니라 **피벗 선택 전략과 파티션 스킴의 조합**에 따라 성능이 크게 달라진다. 이 문서는 Lomuto, Hoare, 랜덤 피벗 세 가지 관점에서 구현을 진행하고, 각 접근 방식이 가지는 특성과 한계를 분석한다.

---

## 원본 구현 (Lomuto 스킴)

```java
private static void quickSortByLomuto(int[] arr, int start, int end) {
    if (start >= end) return;
    int pivotIdx = partitionByLomuto(arr, start, end);
    quickSortByLomuto(arr, start, pivotIdx - 1);
    quickSortByLomuto(arr, pivotIdx + 1, end);
}

private static int partitionByLomuto(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;
    for (int j=start ; j<end ; j++) {
        if (arr[j] <= pivot) {
            i++;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    int tmp = arr[end];
    arr[end] = arr[i + 1];
    arr[i + 1] = tmp;
    return i + 1;
}
```

마지막 원소(`arr[end]`)를 피벗으로 고정한다. `i`는 피벗보다 작거나 같은 영역의 오른쪽 경계로, `j`가 순회하며 조건을 만족하는 원소를 왼쪽으로 이동시킨다. 루프 종료 후 피벗을 `arr[i+1]`에 배치하고 해당 인덱스를 반환한다. 반환값은 피벗의 **확정된 최종 위치**로, 이 인덱스를 제외하고 양쪽을 재귀 처리한다.

- Time Complexity: O(n log n) 평균, O(n²) 최악 (degenerate 입력)
- Space Complexity: O(log n) 평균 (재귀 스택), O(n) 최악

### Lomuto의 한계: 고정 피벗과 StackOverflow

`pivot = arr[end]` 고정으로 인해 특정 입력에서 파티션이 항상 극단적으로 불균형하게 분할된다.

| 배열 유형 | 문제 원인 | 반환되는 pivotIdx |
|---|---|---|
| Already Sorted | pivot이 항상 구간 최댓값 → 모두 왼쪽 | 항상 `end` |
| Reverse Sorted | pivot이 항상 구간 최솟값 → 모두 오른쪽 | 항상 `start` |
| All Same Elements | 모두 `<= pivot` → 모두 왼쪽 | 항상 `end` |

세 케이스 모두 한쪽 재귀가 매번 크기 n-1로 호출되어 재귀 깊이가 O(n)에 달한다. 이는 구현 오류가 아닌 **고정 피벗 Lomuto 방식이 원천적으로 갖는 한계**다.

```
n = 10,000  → 재귀 깊이 ~10,000  → Java 기본 스택 간신히 통과
n = 100,000 → 재귀 깊이 ~100,000 → StackOverflowError
```

병합 정렬이 동일한 재귀 구조에서도 이 문제가 없는 이유는 `mid = (left + right) / 2`로 항상 절반 분할이 보장되어 재귀 깊이가 **입력과 무관하게 O(log n)**이기 때문이다. 퀵 정렬은 피벗 선택에 따라 분할 균형이 달라지는 구조적 차이가 있다.

---

## Hoare 구현

```java
private static void quickSortByHoare(int[] arr, int start, int end) {
    if (start >= end) return;
    int pivotIdx = partitionByHoare(arr, start, end);
    quickSortByHoare(arr, start, pivotIdx);
    quickSortByHoare(arr, pivotIdx + 1, end);
}

private static int partitionByHoare(int[] arr, int start, int end) {
    int pivot = arr[start];
    int left = start - 1;
    int right = end + 1;
    while (true) {
        do { left++; } while (arr[left] < pivot);
        do { right--; } while (arr[right] > pivot);
        if (left >= right) return right;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
```

- Time Complexity: O(n log n) 평균, O(n²) 최악
- Space Complexity: O(log n) 평균, O(n) 최악

### 핵심 구현 포인트

**1. 초기값 `start - 1` / `end + 1`과 do-while 패턴**

포인터가 이동하기 전에 조건을 검사하면 피벗 위치에서 멈추는 경우를 별도로 처리해야 한다. `start-1` / `end+1`로 범위 밖에서 시작하고 do-while로 먼저 이동 후 조건을 확인하면 이를 자연스럽게 해결할 수 있다.

```java
int left = start - 1;  // 범위 밖 초기화
int right = end + 1;
do { left++; } while (arr[left] < pivot);   // 이동 후 확인
do { right--; } while (arr[right] > pivot);
```

**2. 엄격 비교 `<` / `>`**

`<=` / `>=`을 사용하면 피벗과 같은 값에서 포인터가 멈추지 않아 All Same Elements 케이스에서 포인터가 서로 교차하지 않고 무한루프가 발생한다. 엄격 비교로 같은 값도 지나치게 해야 양 포인터가 정상적으로 교차한다.

```java
// 잘못된 구현 — All Same에서 무한루프
do { left++; } while (arr[left] <= pivot);
do { right--; } while (arr[right] >= pivot);

// 올바른 구현 — 엄격 비교
do { left++; } while (arr[left] < pivot);
do { right--; } while (arr[right] > pivot);
```

**3. 반환값은 `right`, 재귀는 pivotIdx 포함**

Lomuto는 피벗의 확정 위치를 반환하므로 피벗을 제외하고 `(start, pivotIdx-1)` / `(pivotIdx+1, end)`로 재귀한다. Hoare는 피벗이 최종 위치에 놓이지 않고 파티션 경계점을 반환하므로 `right`를 포함해 `(start, pivotIdx)` / `(pivotIdx+1, end)`로 재귀해야 한다.

```java
// Lomuto — 피벗 확정 위치 반환, 피벗 제외 재귀
quickSortByLomuto(arr, start, pivotIdx - 1);
quickSortByLomuto(arr, pivotIdx + 1, end);

// Hoare — 파티션 경계 반환, 경계 포함 재귀
quickSortByHoare(arr, start, pivotIdx);
quickSortByHoare(arr, pivotIdx + 1, end);
```

**4. Lomuto 대비 스왑 효율**

Lomuto는 피벗보다 작은 원소를 만날 때마다 스왑하므로 평균 n/2회 스왑이 발생한다. Hoare는 양 끝에서 좁혀오며 실제로 위치가 잘못된 쌍만 스왑하므로 평균 n/6회 수준으로 스왑 횟수가 적다. 대신 파티션 로직이 더 복잡하다.

**5. 고정 피벗의 한계는 동일**

`pivot = arr[start]` 고정으로 Already Sorted 배열에서 pivot이 항상 구간 최솟값이 되어 재귀 깊이가 O(n)으로 퇴화한다. Hoare로 파티션 스킴을 바꿔도 피벗 선택 전략이 고정인 한 degenerate 입력에서의 StackOverflow 문제는 해결되지 않는다.

---

## 최적화 구현 (Hoare + 랜덤 피벗)

```java
private static void optQuickSort(int[] arr, int start, int end) {
    if (start >= end) return;
    int pivotIdx = randomPartition(arr, start, end);
    optQuickSort(arr, start, pivotIdx);
    optQuickSort(arr, pivotIdx + 1, end);
}

private static int randomPartition(int[] arr, int start, int end) {
    Random random = new Random();
    int randomIdx = start + random.nextInt(end - start + 1);
    int tmp = arr[start];
    arr[start] = arr[randomIdx];
    arr[randomIdx] = tmp;
    int pivot = arr[start];
    int left = start - 1;
    int right = end + 1;
    while (true) {
        do { left++; } while (arr[left] < pivot);
        do { right--; } while (arr[right] > pivot);
        if (left >= right) return right;
        tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
```

- Time Complexity: O(n log n) 기댓값, O(n²) 최악 (확률적으로 무시 가능)
- Space Complexity: O(log n) 기댓값

### 핵심 구현 포인트

**1. 랜덤 인덱스를 `arr[start]`로 스왑 후 기존 Hoare 파티션 재사용**

`[start, end]` 범위에서 랜덤 인덱스를 선택해 `arr[start]`와 교환한다. 이후 Hoare 파티션 로직은 그대로 사용할 수 있다. 파티션 코드를 수정하지 않고 피벗 위치만 바꾸는 방식이라 구조가 깔끔하다.

```java
int randomIdx = start + random.nextInt(end - start + 1);
// arr[randomIdx]를 arr[start]로 이동 → 이후 Hoare 파티션 동일하게 진행
```

**2. `new Random()`은 호출마다 생성하지 말 것**

현재 구현은 재귀 호출마다 `new Random()`을 생성한다. 논리적 오류는 아니지만 재귀 깊이만큼 객체가 생성되어 최적화 버전의 의도와 어긋난다. 클래스 레벨 `static` 필드로 선언하거나 메서드 진입 시 한 번만 생성해 파라미터로 전달하는 방식이 적절하다.

```java
// 개선 방향
private static final Random RANDOM = new Random();
```

**3. 랜덤화가 degenerate 케이스를 해결하는 원리**

고정 피벗은 특정 입력 패턴에서 항상 최악의 분할을 선택한다. 랜덤 피벗은 피벗 선택이 입력 값과 무관해지므로 어떤 입력이 들어와도 특정 패턴이 반복적으로 최악 분할을 유발할 수 없다. n번의 파티션에서 O(n) 깊이의 재귀 체인이 만들어질 확률은 지수적으로 낮아 실용적으로는 O(log n) 깊이가 보장된다.

```
고정 피벗 — 입력 패턴이 결과를 결정: sorted → 항상 최악
랜덤 피벗 — 입력 패턴이 결과에 영향 없음: sorted → 기댓값 O(log n)
```

---

## 최적화 전략

### 문제 — 고정 피벗의 O(n) 재귀 깊이

피벗이 항상 구간의 최솟값 또는 최댓값으로 선택되면 파티션이 0 : n-1로 분할된다. n번의 재귀 호출이 선형으로 이어져 재귀 깊이가 O(n)에 달하고, 배열 크기가 커질수록 StackOverflow가 발생한다.

### 핵심 관찰 — 분할 균형이 재귀 깊이를 결정한다

| 분할 비율 | 재귀 깊이 | n = 100,000 기준 |
|---|---|---|
| 항상 0 : n-1 (최악) | O(n) | ~100,000 → StackOverflow |
| 항상 1 : 2 (편향) | O(log n) | ~17 |
| 항상 1 : 1 (이상적) | O(log n) | ~17 |

완벽한 균등 분할이 아니어도 재귀 깊이는 O(log n)으로 수렴한다. 문제는 항상 한쪽으로만 치우치는 경우다.

### 개선 1 — Lomuto → Hoare (스왑 횟수 감소)

파티션 스킴을 변경해 불필요한 스왑을 줄인다. Hoare는 실제로 위치가 잘못된 쌍만 교환하므로 Lomuto 대비 약 3배 적은 스왑이 발생한다. 단, 피벗 선택이 고정인 경우 degenerate 문제는 그대로 남는다.

### 개선 2 — 고정 피벗 → 랜덤 피벗 (재귀 깊이 보장)

피벗을 랜덤하게 선택해 특정 입력 패턴이 지속적으로 최악 분할을 유발하는 상황을 확률적으로 제거한다. 기존 Hoare 파티션 로직은 그대로 유지하고 피벗 위치만 스왑으로 교체하는 방식이라 코드 변경이 최소화된다.

| | Lomuto (고정) | Hoare (고정) | Hoare (랜덤) |
|---|---|---|---|
| 파티션 스킴 | 단방향 포인터 | 양방향 포인터 | 양방향 포인터 |
| 피벗 선택 | arr[end] 고정 | arr[start] 고정 | 랜덤 |
| 스왑 횟수 | 평균 n/2 | 평균 n/6 | 평균 n/6 |
| degenerate 재귀 깊이 | O(n) | O(n) | O(log n) 기댓값 |
| n=100,000 정렬/역정렬/동일 | StackOverflow | StackOverflow | 정상 |

---

## 테스트 결과 (n = 100,000)

Lomuto(고정 피벗)와 Hoare(고정 피벗)는 Already Sorted, Reverse Sorted, All Same Elements 케이스에서 재귀 깊이 O(n)으로 StackOverflow가 발생했다. n = 10,000까지는 Java 기본 스택에서 간신히 통과했으나 n = 100,000에서 실패가 재현된다.

| Case | Lomuto (고정) | Hoare (고정) | Hoare (랜덤) |
|---|---|---|---|
| Random (duplicates, negative included) | 정상 | 정상 | 정상 |
| Random (duplicates, positive only) | 정상 | 정상 | 정상 |
| Unique (no duplicates) | 정상 | 정상 | 정상 |
| Already Sorted | StackOverflow | StackOverflow | 정상 |
| Reverse Sorted | StackOverflow | StackOverflow | 정상 |
| All Same Elements | StackOverflow | StackOverflow | 정상 |

---

## 분석

### Already / Reverse Sorted — Lomuto와 Hoare 동일하게 실패

두 방식 모두 고정 피벗을 사용하는 한 sorted 계열 배열에서 같은 이유로 실패한다. Hoare의 파티션 스킴 개선은 스왑 횟수를 줄이지만 피벗 선택 문제를 해결하지 않는다.

### All Same Elements — Lomuto는 StackOverflow, 기존 quickSort는 무한루프

이전에 존재하던 `quickSort()` / `partition()`은 All Same Elements에서 `left`와 `right` 포인터가 이동하지 않아 외부 while 루프를 탈출하지 못하는 **무한루프** 버그가 있었다. Lomuto 구현으로 전환 후 이 버그는 사라졌고 대신 StackOverflow로 실패 양상이 바뀌었다. 이는 구현이 올바르게 개선된 것이며, Hoare의 엄격 비교(`<` / `>`)도 동일하게 무한루프 없이 동작한다.

### 랜덤 피벗이 degenerate 케이스를 해결하는 이유

고정 피벗은 입력이 결정적(deterministic)이면 피벗 선택도 결정적이 되어 최악 케이스를 외부에서 의도적으로 만들 수 있다. 랜덤 피벗은 피벗 선택과 입력 값 사이의 상관관계를 끊는다. 최악 케이스(O(n²) 시간, O(n) 깊이)가 불가능해지는 게 아니라, 그 케이스가 나타날 확률이 어떤 고정 입력에서도 지수적으로 낮아진다.

### 결론

퀵 정렬의 핵심 최적화는 알고리즘 로직보다 **피벗 선택 전략**에 있다. Lomuto → Hoare는 스왑 효율의 개선이고, 고정 피벗 → 랜덤 피벗이 degenerate 입력에서의 안정성을 확보하는 진짜 최적화다.

| | Lomuto (고정) | Hoare (고정) | Hoare (랜덤) |
|---|---|---|---|
| 구현 정확성 | O | O | O |
| 스왑 효율 | n/2 | **n/6** | **n/6** |
| 최악 재귀 깊이 | O(n) | O(n) | **O(log n) 기댓값** |
| 실용적 안정성 | 낮음 | 낮음 | **높음** |

퀵 정렬이 실무에서 표준으로 쓰이는 형태는 **Hoare 파티션 + 랜덤 피벗(또는 median-of-three)** 조합이다. 이번 구현이 바로 그 형태에 해당한다.
