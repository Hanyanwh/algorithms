package sort;

public class InsertionSort extends Sort{

    private int [] array;
    private String id = "插入排序";
    public InsertionSort(int[] array){
        this.array = array;
    }



    @Override
    public int[] startSort() {

        int length = array.length;
        for(int i = 1; i < length; i++){
            int key = array[i];

            int j = i - 1;
            while(j>=0 && array[j] > key){
                array[j+1] = array[j--];
            }
            array[j+1] = key;
        }
        return array;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
