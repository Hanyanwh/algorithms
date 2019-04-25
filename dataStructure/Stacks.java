package dataStructure;

public class Stacks {
    private Double[] stacks;
    private int top = 0;

    public Stacks(int size){
        this.stacks = new Double[size];
    }

    public Double[] getStacks(){
        return stacks;
    }

    public void push(double element){
        if (top == stacks.length) throw new StacksException("Full");
        stacks[top] = element;
        top += 1;
    }

    public void delete(){
        if (top == 0) throw new StacksException("Null");
        stacks[--top] = null;
    }

    public double pop(){
        if (top == 0) throw new StacksException("Null");
        Double key = stacks[top - 1];
        stacks[--top] = null;
        return key;
    }

    public int getNumElement(){
        return top;
    }


}
