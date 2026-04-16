# 삽입 정렬 최적화

## 원본 구현

```java
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
```

정렬된 구간 `[0..i-1]`을 오른쪽에서 왼쪽으로 선형 탐색하며 삽입 위치를 찾는다. `tmp > arr[j]`가 참이면 즉시 종료하고 그 자리에 삽입한다. **비교와 shift가 같은 루프 안에 섞여 있다.**

- Time Complexity: O(n) Best / O(n²) Average / O(n²) Worst
- Space Complexity: O(1)

---

## 최적화 구현

```java
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
```

삽입 위치 탐색을 이진 탐색으로 분리한다. `[0..i-1]`은 이미 정렬된 구간이므로 이진 탐색이 가능하다. 탐색과 shift를 분리함으로써 비교 횟수를 O(n log n)으로 줄인다.

- Time Complexity: O(n log n) Best / O(n²) Average / O(n²) Worst (비교 기준)
- Space Complexity: O(1)

> **주의**: shift 횟수는 여전히 O(n²)이므로 전체 시간복잡도는 O(n²)에서 변하지 않는다.

### 핵심 구현 포인트

**1. 삽입 위치는 이진 탐색 종료 후 `start`다.**

이진 탐색의 루프 불변식은 다음과 같다.

```
루프 종료 시:
arr[0..end]  <= tmp  — tmp 이하인 원소들 (tmp 뒤에 와야 함)
arr[start..i-1] > tmp  — tmp 초과인 원소들 (오른쪽으로 shift 대상)

따라서 삽입 위치 = start
```

`arr[mid] <= tmp`일 때 추적한 `mid`는 삽입 위치보다 한 칸 앞(`end`)을 가리키므로 사용하면 안 된다.

**2. shift는 반드시 오른쪽에서 왼쪽으로 수행해야 한다.**

왼쪽에서 오른쪽으로 shift하면 `arr[start]` 값이 오른쪽으로 전파되며 기존 값들이 유실된다.

```java
// 잘못된 구현 — 왼쪽에서 오른쪽으로 shift
for (int j=start ; j<i ; j++) {
    arr[j + 1] = arr[j];  // arr[start]가 오른쪽으로 계속 복사됨
}

// 올바른 구현 — 오른쪽에서 왼쪽으로 shift
for (int j=i-1 ; j>=start ; j--) {
    arr[j + 1] = arr[j];
}
```

```
arr = [1, 3, 5, 2]  start=1

왼쪽→오른쪽: arr[2]=arr[1]=3, arr[3]=arr[2]=3 → [1, 3, 3, 3]  ✗ (5 유실)
오른쪽→왼쪽: arr[3]=arr[2]=5, arr[2]=arr[1]=3 → [1, 3, 3, 5]  ✓
```

---

## 최적화 전략

### 문제 — 비교와 shift가 결합된 구조

원본 구현은 비교(`tmp > arr[j]`)와 shift(`arr[j+1] = arr[j]`)가 같은 루프 안에 있어 비교만 따로 줄일 수 없다. 삽입 위치를 찾기 위해 항상 선형 탐색이 필요하다.

### 핵심 관찰 — 정렬된 구간에는 이진 탐색이 적용 가능하다

`[0..i-1]`은 항상 정렬된 상태를 유지한다. 이진 탐색으로 삽입 위치를 O(log i)에 찾을 수 있다.

### 개선 — 이진 탐색으로 비교 횟수 절감

탐색과 shift를 분리하고, 탐색만 이진 탐색으로 교체한다.

```
비교 횟수 변화:
원본:  1 + 2 + ... + (n-1) = n(n-1)/2 ≈ n²/2   →  O(n²)
최적화: log1 + log2 + ... + log(n-1) ≈ n log n  →  O(n log n)
```

### 효과가 나타나는 조건

| 입력 상태 | 원본 비교 | 원본 shift | 최적화 비교 | 최적화 shift | 실측 효과 |
|---|---|---|---|---|---|
| Random | O(n²) | O(n²) | O(n log n) | O(n²) | 미미 |
| Already Sorted | **O(n)** | **0** | O(n log n) | 0 | **퇴보** |
| Reverse Sorted | O(n²) | O(n²) | O(n log n) | O(n²) | 소폭 개선 |
| All Same | O(n²) | O(n²) | O(n log n) | **0** | **극적 개선** |

---

## 테스트 결과 (n = 100,000)

| Case | Orig (ms) | Opt (ms) | 배율 |
|---|---|---|---|
| Random (duplicates, negative included) | 1589.506 | 1379.488 | ~1.15x |
| Random (duplicates, positive only) | 1583.643 | 1631.713 | ~0.97x |
| Unique (no duplicates) | 1590.823 | 1602.101 | ~1.0x |
| Already Sorted | 0.213 | 1.636 | **~0.13x (퇴보)** |
| Reverse Sorted | 3128.015 | 2620.746 | ~1.19x |
| All Same Elements | 901.387 | 1.613 | **~558x** |

---

## 분석

### Random / Unique — 개선 없음

shift가 O(n²)로 병목이기 때문에 비교 횟수를 O(n log n)으로 줄여도 실측 개선이 없다. int 배열에서 비교 연산 자체가 단일 명령어 수준으로 빠르기 때문에 비교 횟수 절감의 효과가 shift 비용에 묻힌다. 이진 탐색 오버헤드로 인해 근소하게 느려지는 케이스도 나타난다.

### Already Sorted — 적응성 손실로 인한 퇴보

삽입 정렬의 핵심 강점인 적응성이 사라진다.

```
원본: tmp > arr[j] → 즉시 break → 비교 1회, shift 0회 → O(n) 전체
최적: 이진 탐색 O(log i) → start = i → shift 0회 → O(n log n) 전체
```

shift는 둘 다 0회이지만 비교 비용이 O(n) → O(n log n)으로 증가한다. 삽입 정렬이 Tim Sort의 핵심 구성 요소로 쓰이는 이유가 이 적응성 때문인데, 이진 탐색 버전은 그 강점을 정면으로 훼손한다.

### All Same — 동등 원소 처리 방식의 차이로 인한 극적 역전

원본이 ~901ms인데 최적화가 ~1.6ms로 558배 빠른 것은 두 구현이 동등 원소를 처리하는 방식이 다르기 때문이다.

```
원본 조건: tmp > arr[j]  →  42 > 42 = false  →  break 없음  →  O(n) shift 발생
최적 조건: arr[mid] <= tmp  →  42 <= 42 = true  →  start = i  →  shift 0회
```

원본은 `>`(strict)를 사용하므로 동등 원소에서 절대 break하지 않는다. 이로 인해 All Same 배열에서 매 패스마다 전체 shift가 발생하여 O(n²)로 동작한다. 반면 이진 탐색은 `<=` 조건으로 동등 원소를 만나면 start를 오른쪽으로 밀어 결국 start=i가 되어 shift가 전혀 발생하지 않는다.

이 역전은 어느 쪽이 더 낫다고 단순히 말할 수 없음을 보여준다. 동등 원소가 많은 데이터에서는 이진 탐색 버전이 압도적이지만, 거의 정렬된 데이터에서는 원본이 훨씬 빠르다.

### 결론

이진 탐색 삽입 정렬은 엄밀히 말해 **최적화가 아니라 트레이드오프**다.

| | 원본 | 이진 탐색 |
|---|---|---|
| 비교 횟수 | O(n²) | O(n log n) |
| shift 횟수 | O(n²) | O(n²) |
| Already Sorted | **O(n)** | O(n log n) ← 퇴보 |
| All Same | O(n²) | **O(n log n)** ← 개선 |
| 적응성 | **보존** | 손실 |
| int 배열 실효성 | — | 낮음 |

원본의 선형 탐색은 단순해 보이지만, 정렬에 가까운 데이터에서 즉시 break하는 적응성이 삽입 정렬의 본질적 강점이다. 비교가 비싼 객체 정렬에서는 이진 탐색이 의미 있을 수 있으나, int 배열에서는 shift 비용이 지배적이어서 비교 횟수 절감의 실효성이 낮다.

이 사실은 **알고리즘의 복잡도 표기만으로는 실제 성능을 예측하기 어렵다**는 점을 잘 보여준다. O(n²)라는 동일한 표기 아래서도 비교·shift·적응성의 조합이 어떻게 구성되느냐에 따라 실측 결과가 크게 달라진다.
