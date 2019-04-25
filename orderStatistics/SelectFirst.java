package orderStatistics;

public class SelectFirst extends Select{

    private int[] array;
    private int selectIndex;
    private String id = "快速排序法-顺序统计算法";

    public SelectFirst(int[] array, int selectIndex){
        this.array = array;
        this.selectIndex = selectIndex - 1;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int select(){
        int[] newArray = subFastSort(array, 0, array.length - 1, selectIndex);
        return newArray[selectIndex];
    }

    private int[] subFastSort(int[] array, int head, int tail, int selectIndex){

        int key, j = head;
        for(int i = head; i < tail; i++){
            if(array[i] < array[tail]){
                key = array[j];
                array[j++] = array[i];
                array[i] = key;
            }
        }

        key = array[j];
        array[j] = array[tail];
        array[tail] = key;

        if(selectIndex > j ){
            array = subFastSort(array, j + 1, tail, selectIndex);
        }else if(selectIndex < j){
            array = subFastSort(array, head, j-1, selectIndex);
        }

            return array;

    }


}
