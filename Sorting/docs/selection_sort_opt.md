# 선택 정렬 최적화

## 원본 구현

```java
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
```

매 패스마다 미정렬 구간에서 최댓값 하나만 찾아 오른쪽 끝에 배치한다. n-1번의 패스를 수행하며 각 패스에서 비교 횟수는 i번이므로 총 비교 횟수는 항상 n(n-1)/2로 고정된다.

- Time Complexity: O(n²) — Best / Average / Worst 모두 동일
- Space Complexity: O(1)

---

## 최적화 구현

```java
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
```

한 패스에서 최솟값과 최댓값을 동시에 찾아 각각 왼쪽 끝(`arr[i]`)과 오른쪽 끝(`arr[n-i-1]`)에 배치한다. 패스마다 양쪽 끝이 동시에 확정되므로 n/2번의 패스로 정렬이 완료된다.

- Time Complexity: O(n²) — Best / Average / Worst 모두 동일
- Space Complexity: O(1)

### 핵심 구현 포인트

`maxIdx == i`인 경우 첫 번째 swap 이후 반드시 `maxIdx`를 보정해야 한다.

최솟값을 `arr[i]`로 옮기는 첫 번째 swap이 완료된 시점에, `maxIdx == i`였다면 최댓값은 이미 `arr[minIdx]`로 이동한 상태다. 보정 없이 두 번째 swap을 수행하면 최댓값이 아닌 다른 값이 오른쪽 끝에 배치된다.

```java
// 잘못된 구현 — maxIdx 보정 누락
int tmp = arr[i];
arr[i] = arr[minIdx];
arr[minIdx] = tmp;
// maxIdx == i 인 경우, arr[maxIdx]는 이미 최댓값이 아님
tmp = arr[n - i - 1];
arr[n - i - 1] = arr[maxIdx];  // 최솟값이 오른쪽 끝에 배치됨
arr[maxIdx] = tmp;
```

```
예시: [3, 1, 2]  i=0, minIdx=1, maxIdx=0

첫 번째 swap: arr[0] ↔ arr[1] → [1, 3, 2]
(maxIdx=0이었던 자리에 이제 1이 있고, 3은 arr[1]로 이동)

보정 없이 두 번째 swap: arr[2] ↔ arr[maxIdx=0] → [2, 3, 1]  ✗

보정 후 (maxIdx=minIdx=1) 두 번째 swap: arr[2] ↔ arr[1] → [1, 2, 3]  ✓
```

---

## 최적화 전략

### 문제 — 한 패스에 한 원소만 확정

원본 구현은 패스마다 최댓값 하나만 찾아 오른쪽 끝에 배치한다. 미정렬 구간의 반대쪽 끝(최솟값)에 대한 정보는 버려진다. 따라서 n개 원소를 확정하려면 n-1번의 패스가 반드시 필요하다.

```
n = 100,000 기준
총 비교 횟수: 100,000 × 99,999 / 2 ≈ 50억 회 (입력 상태와 무관하게 고정)
```

### 핵심 관찰 — 한 번의 탐색으로 양 끝을 동시에 확정할 수 있다

같은 구간을 순회하면서 최솟값과 최댓값을 동시에 기록하면, 추가 탐색 없이 두 원소를 한 패스에 확정할 수 있다. 탐색 비용은 동일하게 O(n)이지만 패스 횟수가 절반으로 줄어든다.

### 개선 — 양방향 선택 (Double-ended Selection)

`left`와 `right` 포인터를 양쪽에서 좁혀가며, 각 패스에서 범위 `[i, n-i-1]`의 최솟값과 최댓값을 동시에 찾아 배치한다.

```
비교 횟수 변화:
원본:  (n-1) + (n-2) + ... + 1 = n(n-1)/2 ≈ n²/2
최적화: (n-1) + (n-3) + ... ≈ n²/4
```

### 효과가 나타나는 조건

버블 정렬 최적화와 달리 입력 상태와 무관하게 **모든 케이스에서 항상** 비교 횟수가 약 절반으로 줄어든다. 선택 정렬은 비적응적이므로 특정 케이스에서만 효과가 집중되지 않는다.

| 입력 상태 | 원본 비교 횟수 | 최적화 비교 횟수 | 효과 |
|---|---|---|---|
| Random | n²/2 | n²/4 | 항상 ~절반 |
| Already Sorted | n²/2 | n²/4 | 항상 ~절반 |
| Reverse Sorted | n²/2 | n²/4 | 항상 ~절반 |
| All Same Elements | n²/2 | n²/4 | 항상 ~절반 |

---

## 테스트 결과 (n = 100,000)

| Case | Orig (ms) | Opt (ms) | Speedup |
|---|---|---|---|
| Random (duplicates, negative included) | 2620.886 | 1606.551 | ~1.63x |
| Random (duplicates, positive only) | 2604.181 | 1606.310 | ~1.62x |
| Unique (no duplicates) | 1059.335 | 904.952 | ~1.17x |
| Already Sorted | 2888.752 | 1793.342 | ~1.61x |
| Reverse Sorted | 1901.946 | 1387.183 | ~1.37x |
| All Same Elements | 1002.826 | 897.343 | ~1.12x |

---

## 분석

### 모든 케이스에서 고른 개선 — 버블 정렬 최적화와의 차이

버블 정렬 최적화는 Already Sorted / All Same에서만 극적인 효과(~28,000x, ~48,000x)가 나타났고 나머지 케이스는 ~1x였다. 반면 이번 최적화는 입력 상태와 무관하게 비교 횟수가 항상 절반으로 줄어들기 때문에 **모든 케이스에서 고르게 ~1.1x ~ 1.6x 개선**된다.

### 이론상 2x이지만 실측 ~1.6x인 이유

비교 횟수는 이론상 절반(n²/4)이 되지만 실측 speedup은 ~1.6x에 그친다. 양방향 선택에서는 매 원소마다 `if` 분기를 두 번(`< minValue`, `> maxValue`) 수행하므로 단순 비교 횟수 절감이 분기 및 인덱스 갱신 오버헤드로 일부 상쇄된다.

### Already Sorted가 가장 느린 이유 — maxValue 갱신 빈도

선택 정렬은 비적응적이므로 Already Sorted가 빨라야 할 이유는 없다. 그런데 실측에서 Already Sorted가 두 버전 모두에서 가장 느리다. 이는 **maxValue 갱신 빈도** 때문이다.

정렬된 배열 `[1, 2, 3, ..., n]`에서 패스 시작 시 `maxValue = arr[0] = 1`로 초기화된다. 이후 매 원소가 이전 원소보다 크므로 `maxValue`와 `maxIdx`가 패스 내 매 단계마다 갱신된다.

```
Already Sorted, 패스 i=n-1:
arr[0]=1 → arr[1]=2>1 → arr[2]=3>2 → ... → maxIdx가 n-1번 갱신
```

반면 Reverse Sorted `[n, n-1, ..., 1]`에서는 첫 원소가 최댓값이라 maxIdx 갱신이 즉시 멈춘다. 이 갱신 빈도 차이가 누적되어 Already Sorted가 가장 느린 케이스가 된다.

### Unique / All Same에서 speedup이 낮은 이유

Unique와 All Same은 절대 수행 시간 자체가 낮다(~1,000ms). 이 범위에서는 비교 횟수 절감의 이득이 비교적 작게 드러나고, 양방향 추적의 오버헤드 비율이 상대적으로 커서 speedup이 ~1.1x 수준에 머문다.

### 결론

이번 최적화의 본질은 **비교 횟수를 상수 계수 수준에서 절감**하는 것이다. 버블 정렬처럼 특정 케이스에서 O(n²) → O(n)으로 복잡도 자체를 바꾸는 것이 아니며, 모든 케이스에서 고르게 ~1.5x 수준의 개선을 얻는 대신 극적인 speedup은 기대할 수 없다. 선택 정렬의 Average / Worst case O(n²) 한계는 이 방식으로 극복할 수 없다.

이 최적화는 "Double Selection Sort" 또는 "Cocktail Selection Sort"로 알려진 변형이지만, 버블 정렬의 Early Exit처럼 표준 최적화로 굳어진 기법은 아니다. 실전 코딩 테스트에서는 선택 정렬 자체를 쓸 일이 거의 없으므로, 이 최적화의 의의는 알고리즘의 구조적 개선 가능성을 이해하는 데 있다.
