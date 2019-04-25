package divideAndConquerStrategy;

public class MaximumSubArray {

    private int[] array;
    private String id = "分治策略-最大子数组";

    public MaximumSubArray(int[] array){
        this.array = array;
    }

    public String getId(){
        return this.id;
    }

    public int[] lookup(){
        return search(this.array);
    }

    // 分治算法
    private int[] search(int[] array){
        int[] result = {};
        int[] leftArray = new int[array.length / 2];
        for(int i = 0; i < array.length / 2; i++){
            leftArray[i] = array[i];
        }
        int[] rightArray = new int[array.length - array.length / 2];
        for(int i = array.length / 2, j = 0; i < array.length; i++, j++ ){
            rightArray[j] = array[i];
        }

        int[] leftMax, rightMax;

        // 左边数组递归搜索
        if(leftArray.length <= 1){
            leftMax = leftArray;
        }else {
            leftMax = search(leftArray);
        }
        int leftSum = 0;
        for(int element: leftMax){
            leftSum += element;
        }

        // 右边数组递归搜索
        if(rightArray.length <= 1){
            rightMax = rightArray;
        }else {
            rightMax = search(rightArray);
        }
        int rightSum = 0;
        for(int element: rightMax){
            rightSum += element;
        }

        // 中间数组搜索
        int[] middleMax = middleSearch(array);
        int middleSum = 0;
        for(int element: middleMax){
            middleSum += element;
        }

        // 判断最子数组并输出
        if(leftSum >= rightSum){
            if(leftSum >= middleSum){
                result = leftMax;
            }else {
                result = middleMax;
            }
        }else if(leftSum < rightSum){
            if(rightSum < middleSum){
                result = middleMax;
            }else {
                result = rightMax;
            }
        }

        return result;
    }

    // 搜索中间最大子数组
    private int[] middleSearch(int[] array){
        int middleIndex = array.length / 2;
        int leftKey = 0, rightKey = 0;

        // 初始化最大子数组和为32位整数最小负数
        for(int i = 0, maxSum = Integer.MIN_VALUE, subSum; i < middleIndex; i++){
            subSum = 0;
            for(int j = i;j < middleIndex; j++){
                subSum += array[j];
            }
            leftKey = subSum > maxSum ? i: leftKey;
            maxSum = subSum > maxSum ? subSum: maxSum;
        }

        for(int i = middleIndex, maxSum = Integer.MIN_VALUE, subSum; i < array.length; i++){
            subSum = 0;
            for(int j = middleIndex;j <= i; j++){
                subSum += array[j];
            }
            rightKey = subSum > maxSum ? i: rightKey;
            maxSum = subSum > maxSum ? subSum: maxSum;
        }

        int[] maxSubArray = new int[rightKey - leftKey + 1];
        for(int i = leftKey, j = 0; i <= rightKey; i++, j++){
            maxSubArray[j] = array[i];
        }

        return maxSubArray;
    }
}
