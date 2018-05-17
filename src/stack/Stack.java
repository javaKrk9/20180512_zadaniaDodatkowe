package stack;

public class Stack {

    private Integer[] stack;
    private int stackLevel=0;

    public Stack(int count)
    {
        stack = new Integer[count];
    }

    public void push(Integer e)
    {
        if(!isFull())
        {
            stack[stackLevel] = e;
            stackLevel++;
        }
        else
            System.out.println("Stack is full");
    }

    public Integer pop()
    {
        if(!isEmpty())
        {
            Integer returnInt = stack[stackLevel];
            stack[stackLevel] = 0;
            stackLevel--;
            return returnInt;
        }
        else
            System.out.println("Stack is empty");
        return null;
    }

    public boolean isEmpty()
    {
        if(stackLevel==0)return true;
        else return false;
    }

    public boolean isFull()
    {
        if(stackLevel==stack.length)return true;
        else return false;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i= stackLevel; i>=0; i--)
        {
            sb.append(stack[i]+";");
        }
        return sb.toString();
    }

}
