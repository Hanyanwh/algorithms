package dataStructure;

public class QueueException extends RuntimeException {
    QueueException(String event){
        if (event == "Full"){
            System.out.println("队列已满");
        }else if(event == "Null"){
            System.out.println("队列为空");
        }
    }
}
