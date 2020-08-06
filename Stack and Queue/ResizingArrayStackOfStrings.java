import java.util.Scanner;

public class ResizingArrayStackOfStrings
{
    private String[] stack;
    private int pos;
    private Scanner scan;

    public ResizingArrayStackOfStrings(Scanner scan)
    {
        stack = new String[1];
        pos = 0;
        this.scan = scan;
    }

    public void push()
    {
        if (pos == stack.length)
        {
            grow();
        }
        stack[pos] = scan.nextLine();
        pos++;
        System.out.println("Length: " + stack.length);
    }

    public void pop()
    {
        if (isEmpty())
        {
            System.out.println("Empty stack");
        }
        else
        {
            pos--;
            System.out.println(stack[pos]);
            stack[pos] = null;
            if (pos == stack.length / 4)
            {
                shrink();
            }
        }
        System.out.println("Length: " + stack.length);
    }

    private void grow()
    {
        String[] copy = new String[stack.length * 2];
        System.arraycopy(stack, 0, copy, 0, stack.length);
        stack = copy;
    }

    private void shrink()
    {
        String[] copy = new String[stack.length / 2];
        System.arraycopy(stack, 0, copy, 0, pos);
        stack = copy;
    }

    private boolean isEmpty()
    {
        return pos == 0;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ResizingArrayStackOfStrings x = new ResizingArrayStackOfStrings(scan);
        x.pop();
        x.pop();
        x.push();
        x.push();
        x.push();
        x.push();
        x.pop();
        x.pop();
        x.pop();
        x.pop();
        x.pop();
        x.pop();
        scan.close();
    }

}
