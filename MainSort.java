import sort.*;

public class MainSort {
    public static void main(String[] args){

//         int[] array = {4, 3, 6, 7, 1, 2, 11, 9, 10, 8, 4, 3, 6, 7, 1, 2, 11, 9, 10, 6};
        int num = 10000;
        int[] array = new int[num];
        for(int i = 0;i < num;i++){
            array[i] = (int)Math.floor(Math.random()*num);
        }

        Sort insertionSort = new InsertionSort(array);
        Sort bubbleSort = new BubbleSort(array);
        Sort divideAndConquer = new DivideAndConquer(array);
        Sort heapSort = new HeapSort(array);
        Sort fastSort = new FastSort(array);
        Sort countSort = new CountSort(array, 10000);

        sortFunction(insertionSort);
        sortFunction(bubbleSort);
        sortFunction(divideAndConquer);
        sortFunction(heapSort);
        sortFunction(fastSort);
        sortFunction(countSort);
    }

    public static void sortFunction(Sort sort){

        int[] newArray;
        long startTime =System.nanoTime();
        newArray = sort.startSort();
        long endTime=System.nanoTime();
        System.out.println(sort.getId() + " - 排序结果：（时间消耗："+(endTime-startTime)+" ns）");
        for(int list: newArray) {
            System.out.print(list + " ");
        }System.out.println();
    }
}
