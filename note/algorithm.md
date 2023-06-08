# Algorithm 演算法

## Index
* [Sorting Algorithm 排序演算法](#sorting-algorithm-排序演算法)
    * [Bubble Sort 氣泡排序法](#bubble-sort-氣泡排序法)
    * [Selection Sort 選擇排序法](#selection-sort-選擇排序法)
    * [Insertion Sort 插入排序法](#insertion-sort-插入排序法)
    * [Merge Sort 合併排序法](#merge-sort-合併排序法)
    * [Quick Sort 快速排序法](#quick-sort-快速排序法)

* [Tree Traversal 樹的遍歷](#tree-traversal-樹的遍歷)
    * [BFS 廣度優先搜尋 for tree](#bfs-breadth-first-search-廣度優先搜尋-for-tree)
    * [DFS 深度優先搜尋 for tree](#dfs-depth-first-search-深度優先搜尋-for-tree)

* [Graph Algorithm 圖演算法](#graph-algorithm-圖演算法)
    * [BFS 廣度優先搜尋 for graph](#bfs-breadth-first-search-廣度優先搜尋-for-graph)
    * [DFS 深度優先搜尋 for graph](#dfs-depth-first-search-深度優先搜尋-for-graph)
    * [Dijkstra’s Algorithm](#dijkstras-algorithm)

---

## Sorting Algorithm 排序演算法

![Array Sorting Algorithms](/image/Array%20Sorting%20Algorithms.png)

[reference](https://www.bigocheatsheet.com)

### Bubble Sort 氣泡排序法
**Bubble Sort** 是從第一筆資料開始，逐一與下一筆資料做比較，若是兩筆資料的大小順序有誤則做交換，反之則不動，並且由下一筆資料做進一步的比較，直到所有資料皆比較完畢，確保最後一筆資料是最大(最小)的。接著再回到第一筆資料做第二次比較找到倒數第二筆資料，以此類推直到排序完成。Bubble Sort 的效率較低，worst case 為 `O(n²)`，空間複雜度為 `O(1)`。

#### **Java Implementation**

* [Implementation of Bubble Sort in Java](/implementation-java/src/sorting_algorithm/BubbleSort.java)

### Selection Sort 選擇排序法
**Selection Sort** 是反覆的從未排序數列中找出最小(最大)值，並將他與未排序數列左邊的數做交換，直到排序完成。Selection Sort 的效率較低，worst case 為 `O(n²)`，空間複雜度為 `O(1)`。

#### **Java Implementation**

* [Implementation of Selection Sort in Java](/implementation-java/src/sorting_algorithm/SelectionSort.java)

### Insertion Sort 插入排序法
**Insertion Sort** 是逐一將原始資料加入已排序好資料中，並逐一與已排序好的資料作比較，找到對的位置插入。Insertion Sort 的效率較低，worst case 為 `O(n²)`，空間複雜度為 `O(1)`。

#### **Java Implementation**

* [Implementation of Insertion Sort in Java](/implementation-java/src/sorting_algorithm/InsertionSort.java)

### Merge Sort 合併排序法
**Merge Sort** 是會先將原始資料分割成兩個資料列，接著再將兩個資料繼續分割成兩個資料列，依此類推，直到無法再分割，也就是每組都只剩下一筆資料時，再兩兩合併各組資料，合併時也會進行該組排序，每次排序都是比較最左邊的資料，將較小的資料加到新的資料列中，依此類推，直到最後合併成一個排序好的資料列為止。Merge Sort 的 worst case 為 `O(n log n)`，其中分割是 `O(log n)`，合併是 `O(n)`，空間複雜度為 `O(n)`，是空間換取時間的演算法。

#### **Java Implementation**

* [Implementation of Merge Sort in Java](/implementation-java/src/sorting_algorithm/MergeSort.java)

### Quick Sort 快速排序法
**Quick Sort** 又稱分割交換排序法，使用了分治法(Divide and Conquer)的概念。原理是先從原始資料列中找一個基準值(Pivot)，接著逐一將資料與基準值比較，小於基準值的資料放在左邊，大於基準值的資料放在右邊，再將兩邊區塊分別再找出基準值，重複前面的步驟，直到排序完為止。Quick Sort 的 average case 為 `O(n log n)`，其中移動資料是 `O(n)`，移動次數是 `O(log n)`，空間複雜度為 `O(1)`，比起 Merge Sort 空間複雜度處理的更好。若是用 Quick Sort 處理 sorted array 的話將會是 worst case `O(n²)`。

#### **Java Implementation**

* [Implementation of Quick Sort in Java](/implementation-java/src/sorting_algorithm/QuickSort.java)

---

## Tree Traversal 樹的遍歷
**Tree Traversal** 是指對樹中的所有節點進行訪問，並且每個節點僅訪問一次。其中有 `BFS` 和 `DFS` 兩種搜尋方式。

### BFS (Breadth First Search) 廣度優先搜尋 for tree
**BFS** 是從起始的節點開始，要先搜尋完第一層所有的節點後 (相鄰的節點)，才開始搜尋下一層的節點，所以整個搜尋會從起點向外層層擴展。可以用 Queue 實現。

#### **Java Implementation**

* [Implementation of BFS in Java](/implementation-java/src/tree_traversal/BFS.java)

### DFS (Depth First Search) 深度優先搜尋 for tree
**DFS** 是從根節點(樹的情況)，或任意節點(圖的情況)開始，盡可能搜尋所有可以抵達的子節點，直到分支的盡頭、沒有子節點的地方，再回溯進行同樣的搜尋。可以用 Recursion or Stack 實現。其中有 `PreOrder 前序`, `PostOrder 後序`, `InOrder 中序` 三種不同順序的訪問方式。

* **DFS PreOrder:** DFS 前序遍歷是從根節點開始往左邊的節點向下擴展，直到左邊沒有節點便會去搜尋前一個節點的右節點，並繼續搜尋他的左節點，持續進行同樣的搜尋。
* **DFS PostOrder:** DFS 後序遍歷是從最左邊最深處的節點為起點進行搜尋，接著會回到前一個節點搜尋是否有右節點，有的話便會向此節點前進並搜尋是否有左節點，持續進行同樣的搜尋。最後一個節點必定為根節點。
* **DFS InOrder:** DFS 中序遍歷同樣是從最左邊最深處的節點作為起點進行搜尋，並且在前往上一個節點時無論是否有右節點也會將此節點訪問，並且持續進行如同 PostOrder 的搜尋。可確保在二元樹的資料結構中遍歷的順序是排序的。

#### **Java Implementation**

* [Implementation of DFS PreOrder in Java](/implementation-java/src/tree_traversal/DFSPreOrder.java)
* [Implementation of DFS PostOrder in Java](/implementation-java/src/tree_traversal/DFSPostOrder.java)
* [Implementation of DFS InOrder in Java](/implementation-java/src/tree_traversal/DFSInOrder.java)

---

## Graph Algorithm 圖演算法


### BFS (Breadth First Search) 廣度優先搜尋 for graph


### DFS (Depth First Search) 深度優先搜尋 for graph


### Dijkstra’s Algorithm

