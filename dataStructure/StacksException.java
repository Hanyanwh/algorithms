package dataStructure;

public class StacksException extends RuntimeException{
        StacksException(String event){
            if(event == "Full"){
                System.out.print("堆栈已满无法插入元素");
            }else  if(event == "Null"){
                System.out.print("栈空无出栈元素");
            }
        }
}
