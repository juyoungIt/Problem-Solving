# 계수 정렬 (Counting Sort)

## 개요

계수 정렬은 원소들의 값이 특정 범위 내에 있을 때, 각 값의 **등장 횟수(count)** 를 배열에 기록한 뒤 순서대로 나열하는 알고리즘이다. 비교 연산을 사용하지 않는 **비교 기반이 아닌 정렬(Non-comparison Sort)** 로, 조건이 맞을 때 O(n)에 정렬할 수 있다.

---

## 동작 원리

1. 입력 배열의 최솟값과 최댓값을 파악하여 count 배열의 크기를 결정한다.
2. 각 원소의 등장 횟수를 count 배열에 기록한다.
3. count 배열을 누적합으로 변환한다 (안정 정렬을 위해).
4. 입력 배열을 역순으로 순회하며 각 원소를 올바른 위치에 배치한다.

### 예시

```
초기 배열: [4, 2, 2, 8, 3, 3, 1]
범위: 1 ~ 8

--- Step 1: 등장 횟수 카운트 ---
index:  1  2  3  4  5  6  7  8
count: [1, 2, 2, 1, 0, 0, 0, 1]

--- Step 2: 누적합 변환 ---
index:  1  2  3  4  5  6  7  8
count: [1, 3, 5, 6, 6, 6, 6, 7]
(count[i] = 값 i 이하인 원소의 총 개수 = 값 i가 놓일 마지막 위치)

--- Step 3: 역순 배치 ---
arr[6]=1 → output[count[1]-1=0] = 1, count[1]=0
arr[5]=3 → output[count[3]-1=4] = 3, count[3]=4
arr[4]=3 → output[count[3]-1=3] = 3, count[3]=3
arr[3]=8 → output[count[8]-1=6] = 8, count[8]=6
arr[2]=2 → output[count[2]-1=2] = 2, count[2]=2
arr[1]=2 → output[count[2]-1=1] = 2, count[2]=1
arr[0]=4 → output[count[4]-1=5] = 4, count[4]=5

정렬 완료: [1, 2, 2, 3, 3, 4, 8]
```

---

## 구현 (Java)

### 기본 구현 (단순 카운트)

```java
public static void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = max - min + 1;

    int[] count = new int[range];
    for (int val : arr) count[val - min]++;

    int idx = 0;
    for (int i = 0; i < range; i++) {
        while (count[i]-- > 0) arr[idx++] = i + min;
    }
}
```

### 안정 정렬 구현 (누적합 방식)

키-값 쌍이나 원래 순서를 유지해야 할 때 사용한다.

```java
public static int[] countingSortStable(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = max - min + 1;

    int[] count = new int[range];
    for (int val : arr) count[val - min]++;

    // 누적합
    for (int i = 1; i < range; i++) count[i] += count[i - 1];

    // 역순 배치 (안정성 유지)
    int[] output = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
        output[--count[arr[i] - min]] = arr[i];
    }
    return output;
}
```

---

## 시간 복잡도 & 공간 복잡도

| 경우 | 시간 복잡도 | 설명 |
|------|------------|------|
| 최선 (Best) | O(n + k) | k = 값의 범위 (max - min + 1) |
| 평균 (Average) | O(n + k) | 항상 동일 |
| 최악 (Worst) | O(n + k) | 항상 동일 |

- **공간 복잡도**: O(n + k)
- **k ≪ n 또는 k = O(n)** 이면 사실상 O(n)으로 동작한다.
- k가 n보다 지나치게 크면 (예: k = 10⁹) 메모리 초과 및 시간 낭비가 발생한다.

---

## 안정성 (Stability)

계수 정렬은 누적합 방식으로 구현 시 **안정 정렬(Stable Sort)** 이다.

역순 배치 방식에서 동일 값의 원소들이 원래 순서를 유지한다. 기수 정렬의 서브루틴으로 사용될 때 안정성이 반드시 필요하다.

---

## 다른 정렬 알고리즘과의 비교

| 알고리즘 | 평균 시간 | 최악 시간 | 공간 | 안정 | 비고 |
|----------|----------|----------|------|------|------|
| 병합 정렬 | O(n log n) | O(n log n) | O(n) | ✅ | 비교 기반 |
| 퀵 정렬 | O(n log n) | O(n²) | O(log n) | ❌ | 비교 기반 |
| 계수 정렬 | O(n + k) | O(n + k) | O(k) | ✅ | 비비교, 범위 제한 |
| 기수 정렬 | O(d(n + k)) | O(d(n + k)) | O(n + k) | ✅ | 비비교, 자릿수 |

---

## 특징 및 실전 활용

**장점**
- 조건이 맞을 때 O(n)으로 비교 기반 정렬의 이론적 하한인 O(n log n)을 깰 수 있다.
- 안정 정렬이다.
- 구현이 단순하다.

**단점**
- **값의 범위 k가 클 때 메모리와 시간이 낭비된다** — k가 10⁶ 이상이면 주의 필요.
- 정수(또는 정수로 매핑 가능한 값)에만 적용 가능하다.
- 부동소수점, 문자열 등에는 직접 적용이 어렵다.

**실전 활용**
- BOJ 10989처럼 **값의 범위가 명시적으로 제한**된 문제에서 매우 효과적이다.
- 데이터 분포를 활용하는 **좌표 압축(Coordinate Compression)** 의 기반 아이디어.
- 기수 정렬의 서브루틴으로 각 자릿수를 정렬할 때 사용된다.

---

## 관련 개념

- **비교 기반 정렬의 하한**: 어떤 비교 기반 정렬도 최악의 경우 Ω(n log n) 비교가 필요하다는 것이 수학적으로 증명되어 있다. 계수/기수/버킷 정렬은 비교를 쓰지 않아 이 하한을 피한다.
- **좌표 압축(Coordinate Compression)**: 값의 범위가 넓을 때 실제 등장하는 값만 추려 인덱스를 재매핑하는 기법. 계수 정렬과 함께 자주 사용된다.
- **버킷 정렬(Bucket Sort)**: 값 범위를 여러 버킷으로 나눠 각 버킷 내에서 정렬하는 방식. 계수 정렬의 일반화.

---

## 관련 문제

| 문제 번호 | 제목 | 핵심 포인트 |
|-----------|------|------------|
| BOJ 10989 | 수 정렬하기 3 | 값 범위 제한(1~10,000) — 계수 정렬 최적 적용 |
| BOJ 15688 | 수 정렬하기 5 | 음수 포함, 오프셋 처리 |
| BOJ 18870 | 좌표 압축 | 계수 정렬 기반 좌표 압축 |
