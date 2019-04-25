import divideAndConquerStrategy.MaximumSubArray;

public class MainDivide {

    public static void main(String[] args){
        int[] array = {10, -1, 8, -4, -15, 2, 3, 6, 1, 9, -3, 4, -1, -2};
        MaximumSubArray search = new MaximumSubArray(array);
        int[] maxSubArray = search.lookup();
        System.out.println(search.getId());
        for(int element: maxSubArray){
            System.out.print(element+ " ");
    }
}
}
