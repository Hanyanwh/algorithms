import dataStructure.*;

/* 数据结构：
*
*       堆栈
*       队列
*       双向链表
*
* */
public class MainDataStructure {

    public static void main(String[] args){

        Stacks stacks = new Stacks(10);
        Queue queue = new Queue(10);
        LinkedList linkedList = new LinkedList(10);

        Double[] array = {1.0 ,2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};

        /*-------------------------堆栈-----------------------*/

        // 入栈
        stacks.push(array[0]);
        stacks.push(array[1]);
        stacks.push(array[2]);
        stacks.push(array[3]);
        stacks.push(array[4]);
        stacks.push(array[5]);
        showData (stacks.getStacks(), "入栈");

        // 出栈删除
        stacks.delete();
        stacks.delete();
        showData (stacks.getStacks(), "出栈删除");

        // 出栈
        System.out.println("出栈于是元素" + stacks.pop());
        showData (stacks.getStacks(),"出栈");

        /*-------------------------队列-----------------------*/

        // 加入元素
        for(int i = 0; i < 10; i++) queue.push(array[i]);
        showData (queue.getQueue(), "加入元素");

        // 出队删除
        for(int i = 0; i < 3; i++) queue.delete();
        showData (queue.getQueue(),"出队删除");

        // 出队
        for(int i = 0; i < 2; i++) System.out.print(queue.pop() + " ");
        System.out.println();
        showData(queue.getQueue(), "出队");

        // 入队
        for(int i = 0; i < 3; i++) queue.push(array[i]);
        showData (queue.getQueue(), "入队");

        /*-----------------------双向链表---------------------*/

        // 加入元素
        for(int i = 0; i < 10; i++) linkedList.push(array[i]);
        showData(linkedList.getPrev(), "前链接地址");
        showData(linkedList.getKey(), "键指");
        showData(linkedList.getNext(), "后链接地址");

        //删除元素
        for(Double i = 2.0; i < 6.0; i++) linkedList.delete(i);
        showData(linkedList.getPrev(), "前链接地址");
        showData(linkedList.getKey(), "键指");
        showData(linkedList.getNext(), "后链接地址");

        // 加入元素
        linkedList.push(array[3]);
        linkedList.push(array[8]);
        showData(linkedList.getPrev(), "前链接地址");
        showData(linkedList.getKey(), "键指");
        showData(linkedList.getNext(), "后链接地址");


    }

    public static <E> void showData(E[] list, String tips){
        System.out.println(tips);
        for(E element: list) System.out.print(element + "  ");
        System.out.println();
    }

}
