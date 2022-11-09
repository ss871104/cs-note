# Data Structure 資料結構

## Index 目錄
* [Intro 簡介](#intro-簡介)
* [Array 陣列](Array.md)
* [LinkedList 連結串列](LinkedList.md)
* [Stack 堆疊](Stack.md)
* [Queue 佇列](Queue.md)
* [Binary Tree 二元樹](BinaryTree.md)
* [Heap 堆積](Heap.md)
* [Map 對映 / Dictionary 字典](Map_Dictionary.md)
* [Hash 雜湊 / HashSet / HashMap](Hash_HashSet_HashMap.md)
* [Graph 圖形](Graph.md)

## Intro 簡介

### What is Data Structure? 什麼是資料結構？

是電腦中儲存、組織資料的方式，可以讓我們**有效地儲存資料**，並讓所有運算能最有效率地完成

演算法的運行時間是根據資料結構決定的，所以使用適當的資料結構來降低演算法的時間複雜度，如：

* 最短路徑演算法若無適當的資料結構，運行時間是O(N^2)，使用(heap/priority queue)可以大幅降低運行時間至O(N*logN)

### Abstract Data Types(ADT) 抽象資料型態

簡單而言，ADT是針對資料結構的「規範」或「描述」，像是物件導向語言裡面的interface，但不會實作細節

舉例堆疊的ADT描述：

* push(): 插入元素 item 至堆疊頂端
* pop(): 移除並回傳堆疊頂端的元素
* peek(): 看堆疊頂端的資料而不取出
* size(): 看堆疊的長度

每個ADT在底層都有相對應的資料結構去實作ADT裡定義過的行為(method)

| ADT                | Data Structures    |
|--------------------|--------------------|
| Stack              | array, linked list |
| Queue              | array, linked list |
| Priority Queue     | heap               |
| Dictionary/Hashmap | array              |