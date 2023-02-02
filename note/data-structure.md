# Data Structure

## Index
* [Array 陣列](#array-陣列)
* [Linked list 鏈結串列](#linked-list-鏈結串列)
* [Stack 堆疊](#stack-堆疊)
* [Queue 佇列](#queue-佇列)
* [Binary Search Tree 二元搜尋樹](#binary-search-tree-二元搜尋樹)
* [Balanced Binary Search Tree (AVL Tree) 平衡二元搜尋樹](#balanced-binary-search-tree-avl-tree-平衡二元搜尋樹)
* [Red-Black Tree 紅黑樹](#red-black-tree-紅黑樹)
* [Heap 堆積](#heap-堆積)
* [HashTable 雜湊表 / HashMap 對映 / Dictionary 字典](#hashtable-雜湊表--hashmap-對映--dictionary-字典)
* [Graph 圖形](#graph-圖形)

---

## Array 陣列
Array 是元素 (element) 的集合，分配一塊連續的記憶體來儲存，以索引 (index) 對元素進行對應的儲存位址，索引值從 0 開始。

Advantages：
* 利用 `index` 可以直接取得當中的值，執行速度快 O(1)
* 由於是一塊連續的記憶體所儲存，不會因為鏈結斷裂而遺失資料
* 比 LinkedList 節省空間，因 LinkedList 需要多一個指標 pointer 來記錄下一個節點 node 的記憶體位置

Disadvantages：
* 新增/插入非最後一項的效率差 O(N)
* Array 的大小需先宣告，不夠動態，容易造成 Array 容量不夠或是預留記憶體位址造成資源浪費

### **Abstract Data Type Method**

|Method|Big O|
|---|---|
|Search 查詢|O(1)|
|Insert 插入|O(N)|
|Append 插入最後一項|O(1)|
|Remove 移除|O(N)|

### **Java Implementation**
```java
// 先宣告 array 大小在給值
int arr[] = new int[3];
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;

// 宣告 array 同時給值
int arr[] = [10, 20, 30];
```
```java
/*
ArrayList，有預設容量也可以在 new 時指定容量
若是空間用完，會依照原本容量的 1.5 倍進行擴充 (new 一個新的然後複製過去)

add() - O(1); worst-case scenario, when a new array has to be created and all the elements copied to it, O(n)
add(index, element) - O(N)
get() - O(1)
remove() - O(N)
indexOf() - O(N)
contains() - O(N)
*/
List<Integer> list = new ArrayList<>();
```

---

## Linked list 鏈結串列
Linked list 是以 node (節點) 來記錄、表示、儲存 data (資料)，並利用每個 node 中的 pointer (指標) 指向下一個node，藉此將多個 node 串連起來，形成 Linked list。
* `Node` 包含 `data` 和 `pointer` (指向的物件的記憶體位址)
* 最後一個 node 是 `NULL`

![Linked-list](/image/Linked-list.png)

Advantages：
* 可動態調整佔用的記憶體
* 在開頭插入、刪除執行速度快 O(1)，調整 node 的 pointer 即可

Disadvantages：
* 由於沒有 index，若是要查詢，只能循序存取(sequencial access)，時間複雜度為O(N)
* 需要額外的記憶體空間來儲存pointer
* 可靠性較差，連結斷裂容易遺失資料 (node 沒被其他 node 的 pointer 指到)
* 難以由後至前訪問，可用 Double Linked list 雙向鏈結串列來處理，不過會多佔用記憶體空間 (node 需多一個pointer 指向前面)


### **Abstract Data Type Method**

|Method|Big O|
|---|---|
|Search 查詢|O(N)|
|Insert 插入第一項|O(1)|
|Append 插入最後一項|O(N)|
|Remove 移除第一項|O(1)|
|Remove last 移除最後一項|O(N)|

### **Java Implementation**
```java
/*
Java 內建 Linked list，是 Double Linked list

add() - append element at the end, only update the tail, O(1)
add(index, element) - O(N)
get() - O(N)
remove(element) - need to find it first, O(N)
remove(index) - start from the beginning, O(N)
contains() - O(N)
*/
List<Integer> list = new LinkedList<>();
```
* [Implementation of SinglyLinkedList in Java](/implementation-java/src/data_structure/SinglyLinkedList.java)
* [Implementation of DoublyLinkedList in Java](/implementation-java/src/data_structure/DoublyLinkedList.java)

---

## Stack 堆疊
Stack 是一種後進先出 `LIFO` 的線型資料結構。
* 只能從堆疊的`最頂端`存取資料
* 只能從堆疊的`最頂端`新增或刪除資料
* 資料的存取必須符合`後進先出` (Last In First Out, LIFO)
* 可用 array、linked list 來實作

### **Abstract Data Type Method**

|Method|Big O|
|---|---|
|Push 新增至 stack 頂端|O(1)|
|Pop 回傳 stack 頂端資料|O(1)|
|Peek 看 stack 頂端資料且不取出|O(1)|

### **Java Implementation**
```java
/*
push() - append element at the top, O(1)
pop() - return element at the top, O(1)
peek() - retrieve element at the top without removing it, O(1) 
*/
Stack<Integer> stack = new Stack<>();
```

* [Implementation of Stack in Java](/implementation-java/src/data_structure/Stack.java)

---

## Queue 佇列
Queue 是一種先進先出 `FIFO` 的線型資料結構。
* 有兩個端點，分為`前端`與`後端`
* 後端只可`新增`資料
* 前端只可`刪除`與`讀取`資料
* 資料的存取必須符合`先進先出`(First In First Out, FIFO)
* 可用 array、linked list 來實作

### **Abstract Data Type Method**

|Method|Big O|
|---|---|
|Enqueue 新增至 queue 尾端|O(1)|
|Dequeue 回傳 queue 開頭資料|O(1)|
|Peek 看 queue 開頭資料且不取出|O(1)|

### **Java Implementation**
```java
/*
add() - append element at the end, if the capacity exceeded, throw exception, O(1)
offer() - append element at the end, if capacity exceeded, return false, O(1)
remove() - return the first element, if the queue is empty, throw exception, O(1)
poll() - return the first element, if the queue is empty, return false, O(1)
element() - retreive the first element without removing, if the queue is empty, throw exception, O(1)
peek() - retreive the first element without removing, if the queue is empty, return false, O(1)
*/
Queue<Integer> queue = new LinkedList<>();
```

* [Implementation of Queue in Java](/implementation-java/src/data_structure/Queue.java)

---

## Binary Search Tree 二元搜尋樹
Binary Search Tree 是一個基於 Binary Search 的樹狀資料結構，優點是可將時間複雜度優化至 O(logN)。若是樹的結構不平衡，查詢的 worst case (如同 LinkedList) 是 O(N)。
* 每個節點最多有兩個子節點
* 子節點有左右之分
* 左子樹的節點小於根節點、右子樹的節點大於根節點
* 節點值不重複

### **Abstract Data Type Method**

|Method|Average case|Worst case|
|---|---|---|
|Insert 新增|O(logN)|O(N)|
|Delete 刪除|O(logN)|O(N)|
|Search 查詢|O(logN)|O(N)|

### **Java Implementation**

* [Implementation of BST in Java](/implementation-java/src/data_structure/BinarySearchTree.java)

---

## Balanced Binary Search Tree (AVL Tree) 平衡二元搜尋樹
AVL Tree 是一種隨時保持平衡的樹，為了確保平衡，每個節點需新增 `Node Height`，以透過 Node Height 得知子樹的高度，進而保持平衡。
* 能保證 O(logN) 的時間複雜度
* 每次 insert, remove 都要檢查平衡，非平衡需要額外做rotation
* 判斷是否平衡：
    * 左子樹高度 - 右子樹高度 > 1: right rotation
    * 左子樹高度 - 右子樹高度 < -1: left rotation
* 不適合用在排序，時間複雜度為O(N*logN)

### **Abstract Data Type Method**

|Method|Average case|Worst case|
|---|---|---|
|Insert 插入|O(logN)|O(logN)|
|Delete 刪除|O(logN)|O(logN)|
|Search 查詢|O(logN)|O(logN)|

### **Java Implementation**

* [Implementation of AVL Tree in Java](https://github.com/geekific-official/geekific-youtube/tree/main/tree-avl/src/main/java/com/youtube/geekific)<br>
retrieved from geekific

---

## Red-Black Tree 紅黑樹
Red-Black Tree 和 AVL Tree 一樣是個可以自動平衡的樹狀資料結構，差別在於 AVL Tree 是以 `Node Height` 確認是否平衡，而 Red-Black Tree 是以 `Node Color` 和 `Node Parent` 確認樹的平衡。

相較於 AVL Tree，Red-Black Tree 犧牲了部分平衡性換取插入/刪除操作時更少的翻轉操作，整體效能較佳 (插入、刪除快)。

以下為 Red-Black Tree 的特性：
* 每個節點不是黑色就是紅色 (預設是紅色)
* 整個 tree 的 root 是一定黑色
* 每個 leaf (null 值) 視為黑色
* 紅色節點其左右兩個 children 一定是黑色(意即不會有連續兩個紅色節點做為父子關係)，黑色節點無此限制
* 樹上的任何一個節點，其任何到達 tree 的 leaf 的 simple path 上(意即只能繼續往下方路徑，不可往上迂迴)，會擁有相同數量的黑色節點

若違反以上規則，則會進行修正 (rotation or update color of node)，直到符合 Red-Black Tree 條件為止。

![Red-Black-Tree](/image/Red-black_tree.png)

### **Abstract Data Type Method**

|Method|Average case|Worst case|
|---|---|---|
|Insert 插入|O(logN)|O(logN)|
|Delete 刪除|O(logN)|O(logN)|
|Search 查詢|O(logN)|O(logN)|

### **Java Implementation**

* [Implementation of Red-Black Tree in Java](https://github.com/geekific-official/geekific-youtube/tree/main/tree-redblack/src/main/java/com/youtube/geekific)<br>
retrieved from geekific

---

## Heap 堆積
Heap 是一種完整二元樹 (complete binary tree)，通常會用 array 來實作。取得最大權重或最小權重項目 (root)，時間複雜度為 O(1)。
* 根據排序行為分成 `Min Heap` 及 `Max Heap`：
    * 最小堆積(Min heap):父節點若小於子節點
    * 最大堆積(Max heap):父節點若大於子節點
* 必須是完全二元樹 (compelete binary tree)
* 常被用來實作 `Priority Queue`

### Heap Sort 堆積排序法
* 是一種比較排序法（Comparision Sort）
* 主要優勢在於能確保O(NlogN)的時間複雜度
* 屬於原地演算法 (in-place algorithm)，缺點是每次排序都須重建heap，增加O(N)時間複雜度

|Method|Best Case|Worst Case|Average Case|
|---|---|---|---|
|Sort 排序|O(nlogn)|O(nlogn)|O(nlogn)|

### **Abstract Data Type Method**

|Method|BigO|
|---|---|
|Insert 插入|O(logN)|
|Delete 刪除|O(logN)|

### **Java Implementation**

* [Implementation of Heap in Java](https://github.com/geekific-official/geekific-youtube/tree/main/tree-heap/src/main/java/com/youtube/geekific)<br>
retrieved from geekific

---

## HashTable 雜湊表 / HashMap 對映 / Dictionary 字典
HashTable 是由成對的 `key-value` 所構成的資料結構，將資料以 `Hash` 做散列處理後，儲存至記憶體位址中。經過 `Hash Function`  的資料皆是不可逆的，且同樣的資料必然會指向同樣的記憶體位址 (deterministic)。
* 根據鍵值 (key)，並透過 Hash Function 來查詢記憶體位置
* 新增修查的時間複雜度皆為 O(1) (Collision 發生時不成立)
* 在 Java 會以 `HashMap` 作為 HashTable 的實作
* 在 Python 會以 `Dictionary` 作為 HashTable 的實作

### Collision
不一樣的資料在經過 Hash Function 計算後，得到了一樣的 Hash Address。舉例來說，key 值 A 和 key 值 B 的記憶體位址相同，因此在查詢時會造成用 key 值 A 查到 key 值 B 的 value。

有以下兩個解決方法 (時間複雜度提高)：

* Separate Chaining: 使用 Linked list 把「Hashing 到同一個 slot」的資料串起來。
* Linear Probing (Open Addressing): 使用 `Probing Method` 來尋找 Table 中「空的 slot」存放資料。

### **Abstract Data Type Method**

|Method|BigO|
|---|---|
|Insert 插入|O(1)|
|Delete 刪除|O(1)|
|Search 查詢|O(1)|

### **Java Implementation**
```java
/*
HashTable 類別在 Java Collections 出來以前就已經存在，其特性是 Synchronized，支持執行序安全。
然而目前不建議使用 HashTable 類別，因此：
* Non-Synchronized 可使用 HashMap
* Synchronized 可使用 ConcurrentHashMap。

put(key, value) - insert key-value, O(1)
remove(key) - O(1)
get(key) - retreive value by key, O(1)
*/
Map<Integer> map = new HashMap<>();
Map<Integer> map2 = new ConcurrentHashMap<>();
```

* [Implementation of HashTable in Java](/implementation-java/src/data_structure/HashTable.java)

---

## Graph 圖形
