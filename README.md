# Problem-Solving

알고리즘 문제 풀이 저장소입니다.
Java 11 기준으로 작성된 풀이를 알고리즘 유형별로 분류하여 관리합니다.

## 출처

| 접두사 | 서비스 |
|---|---|
| `BOJ` | 백준 온라인 저지 |
| `PGS` | 프로그래머스 |

## 구성

| 카테고리 | 설명 |
|---|---|
| [Arithmetic](./Arithmetic) | 사칙연산, 기본 수학 문제 |
| [DataStructure](./DataStructure) | 스택, 큐, 맵, 셋 등 자료구조 활용 |
| [Sorting](./Sorting) | 정렬 알고리즘 및 정렬 기반 풀이 |
| [Implementation](./Implementation) | 조건에 따른 구현 문제 |
| [String](./String) | 문자열 처리 및 파싱 |
| [BFS](./BFS) | 너비 우선 탐색 (0-1 BFS 포함) |
| [Greedy](./Greedy) | 그리디 알고리즘 |
| [Binary Search](./Binary%20Search) | 이진 탐색 |
| [DFS](./DFS) | 깊이 우선 탐색 |
| [DP](./DP) | 동적 프로그래밍 |
| [Brute Force](./Brute%20Force) | 완전 탐색 |
| [Dijkstra](./Dijkstra) | 다익스트라 최단경로 |
| [Two Pointer](./Two%20Pointer) | 투 포인터 기법 |
| [Math](./Math) | 수학적 접근이 필요한 문제 |
| [Prefix Sum](./Prefix%20Sum) | 누적합 |
| [Simulation](./Simulation) | 시뮬레이션 |
| [Recursion](./Recursion) | 재귀 |
| [Divide-And-Conquer](./Divide-And-Conquer) | 분할 정복 |
| [Tree](./Tree) | 트리 탐색 및 조작 |
| [Backtracking](./Backtracking) | 백트래킹 |
| [Sliding Window](./Sliding%20Window) | 슬라이딩 윈도우 |
| [Union-Find](./Union-Find) | 유니온-파인드(DSU) |
| [Regex](./Regex) | 정규표현식 |

## 파일 명명 규칙

```
BOJ_{문제번호}.java
PGS_{문제번호}.java
```

동일 문제에 대해 여러 풀이가 있는 경우 접미사를 붙여 구분합니다.

```
BOJ_1012.java
BOJ_1012_BFS.java
PGS_12345.java
PGS_12345_BFS.java
```

## 코드 주석

각 파일 상단에 문제 번호와 문제 링크를 주석으로 작성합니다.

```java
// BOJ - {문제번호}
// Problem Sheet - https://www.acmicpc.net/problem/{문제번호}
```

```java
// PGS - {문제번호}
// Problem Sheet - https://school.programmers.co.kr/learn/courses/30/lessons/{문제번호}
```

## 커밋 컨벤션

```
{type}[BOJ - Q.{문제번호}]: {설명}
{type}[PGS - Q.{문제번호}]: {설명}
```

타입만으로 명세가 충분한 경우 설명을 생략합니다.

| 타입 | 설명 |
|---|---|
| `Solution` | 신규 풀이 추가 |
| `Refactor` | 기존 풀이 개선 (가독성, 실행시간, 메모리 등) |
| `Fix` | 오류 수정 |
| `Rename` | 파일명 변경 |
| `Move` | 파일 경로 변경 |
| `Delete` | 파일 삭제 |
| `Backup` | 참고용 코드 보관 |
