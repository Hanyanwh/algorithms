package dataStructure;

public class LinkedList {
    // 双向链表（数组实现）
    // 假设无重复元素

    private Integer[] next;
    private Integer[] prev;
    private Double[] key;
    private int head = 0;
    private int tail = 0;
    private Stacks free;

    public Double[] getKey(){ return key; }

    public Integer[] getNext(){ return next; }

    public Integer[] getPrev(){ return prev; }

    public LinkedList(int size){
        this.key = new Double[size];
        this.next = new Integer[size];
        this.prev = new Integer[size];
        this.free = new Stacks(size);
        for(int i = 0; i < size; i++){
            free.push(i);
        }
    }

    public void push(double element){
        int tab;
        if (free.getNumElement() == key.length){
            tab = (int)free.pop();
            key[tab] = element;
            next[tab] = -1;
            prev[tab] = -1;
            head = tab;
            tail = tab;
        }else if (free.getNumElement() != 0){
            tab = (int)free.pop();
            key[tab] = element;
            next[tab] = -1;
            prev[tab] = tail;

            next[tail] = tab;
            tail = tab;
        }else {
            throw new LinkedListException("Full");
        }

    }

    // 若没有检索到元素返回-1
    public int search(double element){
        int searchIndex = head;
        while (searchIndex != tail){
            if (key[searchIndex] == element){
                return searchIndex;
            }else {
                searchIndex = next[searchIndex];
            }
        }

        if (key[tail] == element) return tail;

        return -1;
    }

    public void delete(double element){
        int deleteIndex = search(element);
        if (deleteIndex == -1) throw new LinkedListException("Null");

        free.push(deleteIndex);
        if (prev[deleteIndex] != -1) next[prev[deleteIndex]] = next[deleteIndex];
        if (next[deleteIndex] != -1) prev[next[deleteIndex]] = prev[deleteIndex];

        key[deleteIndex] = 0.0;
        next[deleteIndex] = 0;
        prev[deleteIndex] = 0;

    }

}
