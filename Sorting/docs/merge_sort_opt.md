# 병합 정렬 최적화

## 원본 구현

```java
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
```

매 재귀 호출마다 분할용 배열 2개(`arr1`, `arr2`)와 병합용 배열 1개(`newArr`)를 새로 할당한다. 재귀 깊이가 O(log n)이고 각 레벨에서 총 n개 원소만큼 할당하므로 **전체 메모리 할당 횟수가 O(n log n)**이다. 사용 후 버려지는 배열들이 GC 대상으로 누적된다.

- Time Complexity: O(n log n) — Best / Average / Worst 모두 동일
- Space Complexity: **O(n log n)** — 재귀 레벨마다 배열 할당

---

## 최적화 구현

```java
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
```

크기 n의 보조 배열(`tmp`)을 딱 한 번만 할당하고 모든 재귀 호출에서 공유한다. 분할은 실제 복사 대신 인덱스 범위로 표현하며, 병합 시에만 `tmp`를 임시 버퍼로 사용한다.

- Time Complexity: O(n log n) — Best / Average / Worst 모두 동일 (Random 기준)
- Space Complexity: **O(n)** — 보조 배열 단일 할당 + 재귀 스택 O(log n)

### 핵심 구현 포인트

**1. 분할을 인덱스 범위로 표현한다.**

원본은 분할마다 새 배열을 만들어 복사한다. 최적화 버전은 `arr` 자체를 공유하고 `left`, `right`로 구간을 표현해 복사 없이 분할한다.

```java
// 원본 — 매 호출마다 복사
int[] arr1 = new int[arr.length / 2];
System.arraycopy(arr, 0, arr1, 0, arr1.length);

// 최적화 — 인덱스 범위로 구간 표현
optMergeSort(arr, tmp, left, mid);
optMergeSort(arr, tmp, mid + 1, right);
```

**2. 우측 잔여 원소 복사가 필요 없다.**

병합 루프 종료 후 우측 잔여 원소(`j..right`)는 별도 복사 없이 이미 올바른 위치에 있다. 병합 과정에서 쓰기 포인터 `k`와 우측 읽기 포인터 `j`에 대해 `k <= j`가 항상 성립하므로, 우측 원소들이 아직 덮어쓰이지 않은 채로 남아 있기 때문이다.

```java
// 좌측 잔여만 복사하면 충분
while (i <= mid) {
    arr[k++] = tmp[i++];
}
// while (j <= right) 불필요
```

**3. 조기 종료로 정렬된 구간을 건너뛴다.**

병합 직전 `arr[mid] <= arr[mid + 1]`이면 두 구간이 이미 올바른 순서로 붙어 있으므로 병합이 불필요하다.

```java
if (arr[mid] <= arr[mid + 1]) return;
optMerge(arr, tmp, left, mid, right);
```

`<` 대신 반드시 `<=`를 사용해야 한다. `arr[mid] == arr[mid + 1]`인 경우에도 병합이 필요 없기 때문이다.

---

## 최적화 전략

### 문제 — O(n log n)번의 메모리 할당

원본 구현의 메모리 흐름을 n=8 기준으로 추적하면 다음과 같다.

```
mergeSort([5,3,8,1,2,7,4,6])
  arr1=new int[4], arr2=new int[4]          ← 2회 할당
  mergeSort([5,3,8,1])
    arr1=new int[2], arr2=new int[2]        ← 2회 할당
    mergeSort([5,3])
      arr1=new int[1], arr2=new int[1]      ← 2회 할당
      merge() → newArr=new int[2]           ← 1회 할당
    ...
```

재귀 레벨마다 분할 배열 2개 + 병합 배열 1개가 생성되고 즉시 버려진다. 전체 할당 횟수는 O(n log n)이며, 이 배열들은 모두 GC 대상이 된다.

### 핵심 관찰 1 — 보조 배열 하나로 모든 병합을 처리할 수 있다

병합 시 필요한 임시 공간은 병합 대상 구간의 크기뿐이다. 크기 n의 배열 하나를 미리 할당해두면 모든 재귀 레벨의 병합에서 공유해 쓸 수 있다.

```
원본:  레벨마다 새 배열 할당 → O(n log n)번 할당
최적화: 시작 시 1번 할당    → O(1)번 할당
```

### 핵심 관찰 2 — 이미 정렬된 구간은 병합할 필요가 없다

`[left..mid]`와 `[mid+1..right]`가 각각 정렬된 상태에서 `arr[mid] <= arr[mid+1]`이면 전체 구간도 이미 정렬되어 있다. 이 조건을 병합 전에 확인하면 불필요한 병합을 건너뛸 수 있다.

```
Already Sorted 입력 기준:
모든 재귀 레벨에서 arr[mid] <= arr[mid+1] 성립
→ 병합이 한 번도 수행되지 않음
→ O(n log n) → O(n) 수준으로 동작
```

### 효과가 나타나는 조건

| 입력 상태 | 보조 배열 재사용 효과 | 조기 종료 효과 |
|---|---|---|
| Random | 메모리 할당 감소 → 간접 시간 개선 | 없음 |
| Already Sorted | 메모리 할당 감소 | **O(n log n) → O(n)** |
| Reverse Sorted | 메모리 할당 감소 | 없음 |
| All Same Elements | 메모리 할당 감소 | **O(n log n) → O(n)** |

---

## 테스트 결과 (n = 100,000)

| Case | Orig (ms) | Opt (ms) | Speedup |
|---|---|---|---|
| Random (duplicates, negative included) | 16.364 | 17.161 | ~1.0x |
| Random (duplicates, positive only) | 10.382 | 7.236 | ~1.43x |
| Unique (no duplicates) | 11.283 | 7.314 | ~1.54x |
| Already Sorted | 5.481 | 0.284 | **~19x** |
| Reverse Sorted | 3.702 | 2.177 | ~1.70x |
| All Same Elements | 4.110 | 0.243 | **~17x** |

---

## 분석

### 이번 최적화의 본질 — 공간복잡도 개선, 시간 개선은 부산물

두 최적화의 성격을 분리하면 다음과 같다.

| 최적화 | 주된 개선 | 복잡도 변화 |
|---|---|---|
| 보조 배열 재사용 | **공간** | O(n log n) → **O(n)** 할당 |
| 조기 종료 | **시간** | O(n log n) → **O(n)** (Already Sorted) |

Random 케이스에서 나타나는 ~1.4~1.5x 시간 개선은 보조 배열 재사용의 **부수적 효과**다. 메모리 할당과 GC 비용이 줄어든 덕분이지, 알고리즘적 시간복잡도가 바뀐 것이 아니다. 시간복잡도 차원의 실질적 개선은 조기 종료로 인한 Already Sorted / All Same 케이스에 한정된다.

### Already Sorted / All Same — 조기 종료의 효과

모든 재귀 레벨에서 `arr[mid] <= arr[mid+1]`이 성립하므로 병합이 단 한 번도 수행되지 않는다. 분할·재귀 비용만 남아 사실상 O(n) 수준으로 동작한다.

### Random — 보조 배열 재사용의 간접 효과

조기 종료는 동작하지 않는다. ~1.4x 개선은 O(n log n)번의 메모리 할당이 1번으로 줄어 JVM GC 부담이 감소한 결과다. n이 클수록 이 효과가 더 뚜렷하게 나타난다.

### 결론

병합 정렬은 O(n²) 알고리즘과 달리 구현 수준의 최적화로 시간복잡도 자체를 바꾸기 어렵다. 이번 최적화의 핵심 의의는 **공간복잡도를 O(n log n)에서 O(n)으로 개선**한 것이며, 조기 종료는 특정 입력에서 추가로 시간을 절감하는 보완적 역할을 한다.

병합 정렬을 실질적으로 개선하는 방향은 알고리즘 수준의 변형(Tim Sort — 삽입 정렬 혼합, 자연 병합)이며, 이는 구현 최적화의 범위를 넘어선다.
