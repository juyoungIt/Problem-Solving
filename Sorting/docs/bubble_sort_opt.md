# 버블 정렬 최적화

## 원본 구현

```java
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
```

항상 `n-1`번의 패스를 수행한다. 이미 정렬된 배열이라도 종료 조건이 없으므로 모든 비교 연산을 끝까지 수행한다.

- Time Complexity: O(n²) — Best / Average / Worst 모두 동일
- Space Complexity: O(1)

---

## 최적화 구현

```java
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
```

각 패스가 끝난 후 `swapped` 플래그를 확인한다. 해당 패스에서 swap이 한 번도 발생하지 않았다면 모든 인접 원소가 정렬된 상태이므로 즉시 종료한다.

- Time Complexity: O(n) Best / O(n²) Average / O(n²) Worst
- Space Complexity: O(1)

### 핵심 구현 포인트

`swapped`는 반드시 outer loop 내부에서 패스마다 초기화해야 한다. outer loop 바깥에서 초기화하면 첫 swap 이후 모든 패스가 조기 종료되어 정렬이 완료되지 않는다.

```java
// 잘못된 구현 — swapped를 outer loop 바깥에서 초기화
boolean swapped = false;
for (int i=arr.length-2 ; i>=0 ; i--) {
    // swapped가 한 번 true가 되면 이후 패스에서 즉시 break
    if (!swapped) break;  // 첫 swap 이후 다음 패스 전부 건너뜀
    ...
}
```

---

## 최적화 전략

### 문제 — 불필요한 패스 반복

원본 구현은 배열이 이미 정렬된 상태여도 종료 조건이 없어 `n-1`번의 패스를 모두 수행한다. 각 패스에서 `n-1`, `n-2`, ..., `1`번의 비교가 발생하므로 총 비교 횟수는 항상 `n*(n-1)/2`에 수렴한다.

```
n = 100,000 기준
총 비교 횟수: 100,000 * 99,999 / 2 ≈ 50억 회 (입력 상태와 무관하게 고정)
```

### 핵심 관찰 — swap 없는 패스 = 정렬 완료

한 번의 패스에서 swap이 한 번도 발생하지 않았다는 것은, 모든 인접 원소가 `arr[j] <= arr[j+1]`을 만족한다는 의미다. 즉 배열 전체가 이미 정렬된 상태이므로 이후 패스는 수행할 필요가 없다.

### 개선 — 조기 종료(Early Exit)

`swapped` 플래그로 각 패스의 swap 발생 여부를 추적하고, 패스 종료 후 swap이 없었다면 즉시 반복을 중단한다.

```
성능 개선이 발생하는 지점:
패스 k에서 swap이 없음 감지
→ 남은 (n-1-k)번의 패스 전체를 생략
→ 생략된 비교 횟수만큼 실행시간 단축
```

### 효과가 나타나는 조건

최적화의 효과는 **얼마나 일찍 swap 없는 패스가 등장하는가**에 달려 있다.

| 입력 상태 | swap 없는 패스 등장 시점 | 생략되는 패스 수 | 효과 |
|---|---|---|---|
| Already Sorted | 첫 번째 패스 | n-2번 | 최대 |
| All Same Elements | 첫 번째 패스 | n-2번 | 최대 |
| 거의 정렬된 배열 | 초반 패스 | 다수 | 큼 |
| Random | 마지막 패스 근처 | 거의 없음 | 없음 |
| Reverse Sorted | 마지막 패스 | 없음 | 없음 |

---

## 테스트 결과 (n = 100,000)

| Case | Orig (ms) | Opt (ms) | Speedup |
|---|---|---|---|
| Random (duplicates, negative included) | 13036.622 | 13009.387 | ~1x |
| Random (duplicates, positive only) | 13453.620 | 13863.657 | ~1x |
| Unique (no duplicates) | 11632.961 | 11285.866 | ~1x |
| Already Sorted | 1589.459 | 0.055 | **~28,900x** |
| Reverse Sorted | 8960.242 | 9258.024 | ~1x |
| All Same Elements | 1590.888 | 0.033 | **~48,200x** |

---

## 분석

### Already Sorted / All Same — 극적인 개선

첫 번째 패스에서 swap이 한 번도 발생하지 않으므로 즉시 종료한다. 비교 횟수가 `n-1`회로 줄어들어 사실상 O(n)으로 동작한다.

```
원본:  n*(n-1)/2 ≈ 50억 회 비교 (n=100,000)
최적화: n-1 = 99,999회 비교
```

### Random / Reverse Sorted — 효과 없음

매 패스마다 swap이 발생하므로 조기 종료 조건이 충족되지 않는다. 원본과 동일한 횟수의 패스를 수행하며, `swapped` 초기화와 `if (!swapped) break` 체크가 패스마다 추가되는 미세한 오버헤드로 인해 오히려 근소하게 느린 결과가 나타나기도 한다.

### Random 케이스에서 Reverse Sorted보다 느린 이유 — CPU 분기 예측

원본 기준으로 Random(~13초) > Reverse Sorted(~9초)인 이유는 swap 횟수가 아닌 **CPU 분기 예측 실패(branch misprediction)** 때문이다.

현대 CPU는 파이프라인 구조로 동작하며 `if` 조건의 결과를 미리 예측해서 다음 명령을 선처리한다. 예측이 틀리면 파이프라인을 비우고 재시작하는 패널티(10~20 사이클)가 발생한다.

| Case | `arr[j] > arr[j+1]` 결과 | 분기 예측 성공률 |
|---|---|---|
| Random | ~50% true / ~50% false | ~50% (최악) |
| Reverse Sorted | 항상 true | ~100% |
| Already Sorted | 항상 false | ~100% |

Random 케이스는 분기 예측이 절반 가까이 실패하여 25억 회의 파이프라인 재시작 비용이 누적된다. Reverse Sorted는 항상 swap이 발생하므로 예측이 일관되어 패널티가 거의 없다.

### 결론

`optBubbleSort`의 최적화 효과는 **입력이 이미 정렬되었거나 정렬에 가까울수록** 극대화된다. Random이나 Reverse Sorted처럼 swap이 지속적으로 발생하는 케이스에서는 실질적인 이득이 없다. 이번 최적화의 본질은 **Best case를 O(n²)에서 O(n)으로 단축**한 것이며, 버블 정렬의 Average / Worst case O(n²) 한계는 이 방식으로 극복할 수 없다.
