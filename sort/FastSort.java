package sort;

public class FastSort extends Sort {

    private int[] array;
    private String id = "快速排序";

    public FastSort(int[] array){
        this.array = array;
    }
    @Override
    public int[] startSort() {

        return fastSort(array, 0, array.length - 1);
    }

    @Override
    public String getId() {
        return id;
    }

    private int[] fastSort(int[] array, int head, int tail){
//        int indexTab = (int)Math.floor(head + (tail - head + 1) * Math.random());
        int indexTab = tail;
        int key, tab = head;
        for(int j = head;j <= tail; j++){
            if(j != indexTab && array[j] <= array[indexTab]){
                key = array[tab];
                array[tab++] = array[j];
                array[j] = key;
            }
        }
        key = array[tab];
        array[tab] = array[indexTab];
        array[indexTab] = key;
        if(tab > head){
            array = fastSort(array, head, tab - 1);
        }
        if(tab < tail){
            array = fastSort(array, tab + 1, tail);
        }

        return array;
    }

}
