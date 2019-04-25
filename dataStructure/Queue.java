package dataStructure;

public class Queue {

    private Double[] queue;
    private int head = 0;
    private int tail = 0;

    public Double[] getQueue(){
        return queue;
    }

    public Queue(int size){
        this.queue = new Double[size];
    }

    public void push(double element){
        if(tail == head && queue[head] != null) throw new QueueException("Full");
        queue[tail++] = element;
        if(tail >= queue.length){
            tail = tail - queue.length;
        }
    }

    public void delete(){
        if (head == tail&& queue[head] == null) throw new QueueException("Null");
        queue[head++] = 0.0;

    }

    public double pop(){
        Double key = queue[head];
        queue[head++] = 0.0;
        return key;
    }
}
