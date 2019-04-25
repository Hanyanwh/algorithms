package sort;

// mmp，List自动排序。。。。
public class DivideAndConquer extends Sort {

    private int[] array;
    private String id = "分治法排序";

    public DivideAndConquer(int[] array){
        this.array = array;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int[] startSort() {
        int[] arrayInput = this.array;
        int[] result = divideAndConquer(arrayInput);
        return result;
    }

    public int[] divideAndConquer(int[] subArray) {

        int firstLength = subArray.length / 2;
        int secondLength = subArray.length - firstLength;

        // 分解
        int[] firstArray = new int[firstLength];
        int[] secondArray = new int[secondLength];
        for(int i = 0;i < firstLength;i++){
            firstArray[i] = subArray[i];
        }
        for(int i = firstLength;i <subArray.length;i++){
            secondArray[i-firstLength] = subArray[i];
        }
        int[] conquerFirstArray ;
        int[] conquerSecondArray ;
        int[] bossArray;
        if (firstLength == 1){
            conquerFirstArray = firstArray;
        }else{
            conquerFirstArray = divideAndConquer(firstArray);
        }

        if(secondLength == 1){
            conquerSecondArray = secondArray;
        }else{
            conquerSecondArray = divideAndConquer(secondArray);
        }

        //归并
        if (conquerFirstArray.length == 1 && conquerSecondArray.length == 1) {
            bossArray = new int[2];
            if (conquerFirstArray[0] < conquerSecondArray[0]) {
                bossArray[0] = conquerFirstArray[0];
                bossArray[1] = conquerSecondArray[0];
            } else {
                bossArray[0] = conquerSecondArray[0];
                bossArray[1] = conquerFirstArray[0];
            }
        } else {
            bossArray = new int[conquerFirstArray.length+conquerSecondArray.length];
            int i = 0,j = 0, m = 0;
            while(i < conquerFirstArray.length && j < conquerSecondArray.length){
                if(conquerFirstArray[i] < conquerSecondArray[j]){
                    bossArray[m++] = conquerFirstArray[i++];
                }else {
                    bossArray[m++] = conquerSecondArray[j++];
                }
            }
            if(i == conquerFirstArray.length){
                for(;j < conquerSecondArray.length;j++){
                    bossArray[m++] = conquerSecondArray[j];
                }
            }else if(j == conquerSecondArray.length){
                for(;i < conquerFirstArray.length;i++){
                    bossArray[m++] = conquerFirstArray[i];
                }
            }
        }


        return bossArray;
    }



}
