노트
------
### 알아두면 좋을 것 
```
1. 랭크 구하기 : rank = 1로 하고, 랭크 구할 때 자신의 배열내 다른 값과 비교하며 더 큰 값이 있다면 rank++하는 식으로 구한다.
```

### 시간복잡도
```
뜻: 알고리즘 수행 시간을 대략적으로 나타내는 방법이다.
(이는 즉 점근 표기법을 말하는데, 점근 표기법에서의 '대략적'이란 것은 최고차 항으로만 성능을 표시한다는 의미이다.
데이터의 값이 커지면 커질수록 최고차 항을 제외한 나머지의 값은 미미한 효과를 낸다고함.)

점근 표기법: O(빅오), Ω(빅오메가), θ(빅세타)

O 표기법: 알고리즘의 최악의 경우의 성능을 나타낸다.
O 표기사용법: O(데이터 크기 n에 대해 알고리즘의 수행시간이 늘어나는 비율)

* "수행 시간"의 의미 : 스톱워치를 가지고 계산하는 시간이 아닌, 작업량 즉 연산 횟수를 의미한다. 
```

#### log2N
```
데이터 범위가 계속해서 1/2로 줄어드는 계산의 경우에 적용된다.
데이터의 크기가 아무리 커도 탐색 소요시간은 미미하게 증가한다는 것을 의미한다.

데이터 크기가 n이라고 할 때, 반복 횟수를 x라고 한다면,
마지막 데이터 범위의 크기인 1은 n의 1/2의 x제곱을 곱한 값과 같다고 할 수 있다.
1 = n * (1/2)x(제곱)
이는 n = 2의 x제곱과 같으며, 로그 함수의 도움을 받아 다음과 같이 정리할 수 있다.
x = log2n (2를 x번 제곱하면 n이 나온다를 알려주는 수학 공식)
```
#### logN

### 수학
#### 점과 점 사이의 거리 공식
```
루트{(x2 - x1)2(제곱) + (y2 - y1)2(제곱)}
```
#### 자연수
```
수학에서 자연수(自然數, 영어: natural number)는 수를 셀 때나 순서를 매길 때 사용되는 수다.
양의 정수(陽-整數, 영어: positive integer) 1, 2, 3, ...로 정의되거나, 음이 아닌 정수(陰-整數, 영어: non-negative integer) 0, 1, 2, 3, ...로 정의된다. 
프로그래머스에서는 양의 정수를 의미하는 것 같다. 지문에 따라 해석해야 할 것 같다.
```
### Collection
```
시간 복잡도
정렬 : Arrays.sort -> 평균 O(nlog(n))의 시간복잡도를 가지며 최악의 경우 O(n^2)이 될 수 있다.
삽입 시 : Priority queue -> 우선순위 큐는 배열에 저장하되 삽입/ 추출 시 기존 정렬 상태를 유지하기에 O(logn)의 시간복잡도를 유지한다.

widest-vertical-area [1637. Widest Vertical Area](problems/20231105_med_le_1637.md)
for문 X(곱하기) 삽입시 시간 복잡도를 계산했어야 함. Arrays.sort(arr); 한 것이 훨씬 빨랐다.

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int arr[]=new int[points.length];
        for(int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }

        Arrays.sort(arr); // -> O(nlogn, 최악 O^2)
        int max =0;
        for(int i=0;i<points.length-1;i++){
            if(arr[i+1]-arr[i]>max){
                max=arr[i+1]-arr[i];
            }
        }
        return max;
    }
}

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<points.length; i++) {
        	pq.offer(points[i][0]); //삽입시 O (nlogn이나 위의 for O(n)과 곱할 시 n^2logn이 나올 수 있음.)
        }
        
        int prev = (int) pq.poll(); 
        int curr = 0;
       
        Object obj = null;
        while((obj = pq.poll()) != null) {
        	curr = (int) obj;
        	if(curr - prev > answer) {
        		answer = curr - prev;
        	}
        	prev = curr;
        }
        
        return answer;
    }
}
```
#### PriorityQueue
```
- 메서드
Object pq.poll() -> 왜 Object형으로 반환하나? 비어있으면 null을 반환하기에 Object obj로 받은 후, 형변환을 해야 한다.
```
### List
```
정렬/내림차순정렬 방법
total.sort(Comparator.comparing(Integer::intValue).reversed());
```
### TreeMap
```
순회 하는 방법에 대해 알아보기.
Iterator it = tree.entrySet().iterator(); 왜 set로 변환해야 하는 것일까?
```
### HashMap
```
Q. TreeMap과 HashMap은 각각 언제 쓰이는 것일까?
검색에 관한 대부분의 경우는 HashMap, 범위 검색이나 정렬이 필요한 경우는 TreeMap이라고 하는데 잘 모르겠다.
- containsKey, get -> O(1)의 복잡도를 가진다 -> 내부적으로 key -> hash (int), tree node를 구성해서 값을 저장하는 것 같다.
- HashTable보다 새로운 버전이라고 하며, 사용을 훨씬 더 많이 한다고 한다. 
- add가 아닌 put함수를 사용하여 Object타입으로 저장한다.
- 키는 중복 비허용, 데이터는 중복 허용이라고 한다.
- 순회 방법
 	  Set set = map.entrySet(); //set로 변환
        Iterator it = set.iterator();
        String answer = "";
        while(it.hasNext()) {
        	Map.Entry e = (Map.Entry) it.next(); //map의 특징 (key, value)을 묶어서 하나의 데이터(entry)로 저장함
        	answer = e.getKey().toString();
        }
```
### TreeSet과 TreeMap의 기반이 되는 binary search tree
``` 
- binary tree : 노드로 구성되어 있는 트리 구조로 자식 노드의 개수가 2개 이하이다.
- complete binary tree : 이진 트리 구조로 맨 마지막 자식을 제외한 나머지 노드는 자식 노드를 2개씩 가지고 있다.
- heap : 완전 이진 트리이며, 자식 노드들이 특정 성질을 가지고 정렬된다. (부모가 자식보다 크다면 max heap, 작다면 min heap)
- binary search tree : 이진 탐색 + 연결 리스트를 결합한 이진트리
```
### Heap
```
![binaryheap](~resources/binaryheap.jpeg)
![binarysearchheap](~resources/binarysearchheap.jpeg)
```