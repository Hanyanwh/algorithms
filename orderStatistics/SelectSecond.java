package orderStatistics;

public class SelectSecond extends Select{

    private int[] array;
    private int selectIndex;
    private String id = "快速排序法改进-顺序统计算法";

    public SelectSecond(int[] array, int selectIndex){
        this.array = array;
        this.selectIndex = selectIndex - 1;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int select(){
        int[] newArray = subSelectSecond(array, 0, array.length-1);

        return newArray[selectIndex];
    }

    private int[] subSelectSecond(int[] array, int head, int tail){
        int key;
        int middleNum = selectMiddle(array, head, tail);

        int j = head;
        for(int i = head; i < tail; i++){
            if(array[i] <= middleNum){
                key = array[j];
                array[j++] = array[i];
                array[i] = key;
            }
        }

        if (selectIndex > j){
            array = subSelectSecond(array, j, tail);
        }else if(selectIndex < j){
            array = subSelectSecond(array, head, j-1);
        }

        return array;
    }

    private int selectMiddle(int[] array, int head, int tail){
        int key, middleNum;
        int[] middleArray = new int[(int)Math.ceil((double)(tail-head+1) / (double) 5)];
        for(int i = head, m = 0; i <= tail ; i = i + 5){
            if(tail-i < 5){
                for(int j = i + 1; j <= tail;j++){
                    key = array[j];
                    int n = j - 1;

                    while (n >= i && array[n] > key){
                        array[n+1] = array[n--];
                    }
                    array[n+1] = key;
                }
                middleArray[m++] = array[i+(tail-i)/2];
            }else {
                for(int j = i + 1; j < i + 5;j++){
                    key = array[j];
                    int n = j - 1;

                    while (n >= i && array[n] > key){
                        array[n+1] = array[n--];
                    }
                    array[n+1] = key;
                }
                middleArray[m++] = array[i+3];
            }
        }

        if (middleArray.length > 1){
            middleNum = selectMiddle(middleArray, 0, middleArray.length - 1);
        }else {
            middleNum = middleArray[0];
        }

        return middleNum;
    }

}
