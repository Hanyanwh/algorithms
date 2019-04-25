package dataStructure;

public class LinkedListException extends RuntimeException{
    LinkedListException(String event){
        if(event == "Full"){
            System.out.print("链表已满");
        }else  if(event == "Null"){
            System.out.print("链表为空");
        }
    }
}
