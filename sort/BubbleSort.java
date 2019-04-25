package sort;

public class BubbleSort extends Sort{

    private int[] array;
    private String id = "冒泡排序";

    public BubbleSort(int[] array){
        this.array = array;
    }
    @Override
    public int[] startSort() {

        int length = array.length;
        int key;

        for(int i = 0; i < length; i++){
            for(int j = length-1; j > 0; j--){
                if(array[j] < array[j-1]){
                    key = array[j];
                    array[j] = array[j-1];
                    array[j-1] = key;
                }
            }
        }
        return array;
    }

    @Override
    public String getId() {
        return id;
    }
}
