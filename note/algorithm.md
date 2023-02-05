# Algorithm 演算法

## Index
* [Sorting Algorithm 排序演算法](#sorting-algorithm-排序演算法)

    * [Bubble Sort 氣泡排序法](#bubble-sort-氣泡排序法)
    * [Selection Sort 選擇排序法](#selection-sort-選擇排序法)
    * [Insertion Sort 插入排序法](#insertion-sort-插入排序法)
    * [Merge Sort 合併排序法](#merge-sort-合併排序法)
    * [Quick Sort 快速排序法](#quick-sort-快速排序法)

---

## Sorting Algorithm 排序演算法

![Array Sorting Algorithms](/image/Array%20Sorting%20Algorithms.png)

[reference](https://www.bigocheatsheet.com)

### Bubble Sort 氣泡排序法
Bubble Sort 是從第一筆資料開始，逐一與下一筆資料做比較，若是兩筆資料的大小順序有誤則做交換，反之則不動，並且由下一筆資料做進一步的比較，直到所有資料皆比較完畢，確保最後一筆資料是最大(最小)的。接著再回到第一筆資料做第二次比較找到倒數第二筆資料，以此類推直到排序完成。Bubble Sort 的效率較低，worst case 為 `O(n²)`。

* [Implementation of Bubble Sort in Java](/implementation-java/src/algorithm/BubbleSort.java)

### Selection Sort 選擇排序法
Selection Sort 是反覆的從未排序數列中找出最小(最大)值，並將他與未排序數列左邊的數做交換，直到排序完成。Selection Sort 的效率較低，worst case 為 `O(n²)`。

* [Implementation of Selection Sort in Java](/implementation-java/src/algorithm/SelectionSort.java)

### Insertion Sort 插入排序法



### Merge Sort 合併排序法



### Quick Sort 快速排序法
