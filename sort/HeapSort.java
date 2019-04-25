package sort;

public class HeapSort extends Sort {

    private int[] array;
    private String id = "堆排序";

    public HeapSort(int[] array){
        this.array = array;
    }

    @Override
    public int[] startSort() {
        return heapSort(array);
    }

    @Override
    public String getId() {
        return id;
    }

    // 最大堆，从子树根节点开始构造最大堆
    private int[] maxHeap(int[] array, int node, int heapSize){
        int maxLeaf;
        int r = rightChild(node);
        int l = leftChild(node);

        // 获取子树中最大元素，并将其标记为maxLeaf
        if(r < heapSize && array[r] > array[node]){
            maxLeaf = r;
        }else {
            maxLeaf = node;
        }

        if(l < heapSize && array[l] > array[maxLeaf]){
            maxLeaf = l;
        }

        // 判断最大元素引索是否与子树根节点引索相同，若相同程序结束，否则以maxLeaf为根节点递归
        if(maxLeaf != node) {
            int key = array[maxLeaf];
            array[maxLeaf] = array[node];
            array[node] = key;
            array = maxHeap(array, maxLeaf, heapSize);
        }
            return array;
    }

    // 构建最大堆
    private int[] buildMaxHeap(int[] array){
        int tailRoot = array.length / 2;    // 最大根节点的引索为数组总长度除以2向下取整
        int[] arrayHeap = array;

        // 对每一个根节点从后往前依次构建最大堆
        for(int i = tailRoot; i >= 0; i--){
            arrayHeap = maxHeap(array, i, array.length);
        }

        return arrayHeap;
    }

    // 堆排序
    private int[] heapSort(int[] array){
        int[] maxHeapArray = buildMaxHeap(array);       // 在原数组上构建最大堆
        int heapSize = array.length;        // 设堆的长度为数组长度
        int key ;
        for(int i = array.length-1; i > 0; i--){
            // 交换根节点元素与数组末尾元素
            key = maxHeapArray[0];
            maxHeapArray[0] = maxHeapArray[i];
            maxHeapArray[i] = key;

            // 减小一个单位的堆长
            heapSize -= 1;

            // 构建最大堆
            maxHeapArray = maxHeap(maxHeapArray, 0, heapSize);
        }
        return maxHeapArray;
    }

    private int leftChild(int i){
        return 2 * i;
    }

    private int rightChild(int i){
        return 2 * i + 1;
    }
}
