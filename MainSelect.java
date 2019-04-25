import orderStatistics.*;

public class MainSelect {

    public static void main(String[] args){

//          int[] array = {4, 3, 6, 7, 1, 2, 11, 9, 10 ,0, 0, 8, 4, 3, 6, 7, 1, 2, 11, 9, 10, 6};
        int num = 20000;
        int[] array = new int[num];
        for(int i = 0;i < num;i++){
            array[i] = (int)Math.floor(Math.random()*num);
        }
        int selectIndex = 10000;

        Select selectFirst = new SelectFirst(array, selectIndex);
        Select selectSecond = new SelectSecond(array, selectIndex);

        sortFunction(selectFirst);
        sortFunction(selectSecond);

    }

    public static void sortFunction(Select select){

        int newArray;
        long startTime =System.nanoTime();
        newArray = select.select();
        long endTime=System.nanoTime();
        System.out.println(select.getId() + " - 搜索结果：（时间消耗："+(endTime-startTime)+" ns）");
        System.out.println(newArray);
    }

}
