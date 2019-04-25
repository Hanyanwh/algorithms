package sort;

// 适用于数组最大值为o(n)
public class CountSort extends Sort {

    private int[] array;
    private String id = "计数排序";
    private int maxElement;

    public CountSort(int[] array, int maxElement){
        this.array = array;
        this.maxElement = maxElement;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int[] startSort() {

        int[] recode = new int[maxElement + 1];
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            recode[array[i]] += 1;
        }

        for(int i = 1; i < recode.length; i++){
            recode[i] += recode[i - 1];
        }

        for(int i = 0; i < array.length; i++){
            newArray[recode[array[i]] - 1] = array[i];
            recode[array[i]] -= 1;
        }
        return newArray;
    }


}
