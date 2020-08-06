import java.util.Scanner;

public class ResizingArrayQueueOfStrings
{
    private int head;
    private int tail;
    private int size;
    private Scanner scan;
    private String[] queue;

    private ResizingArrayQueueOfStrings()
    {
        scan = new Scanner(System.in);
        head = 0;
        tail = 1;
        size = 0;
        queue = new String[1];
    }

    private void grow()
    {
        String[] copy;
        if (queue.length == size)
        {
            copy = new String[queue.length * 2];
        }
        else
        {
            copy = new String[queue.length];
        }
        System.arraycopy(queue, head, copy, 0, size);
        queue = copy;
        head = 0;
        tail = size;
    }

    private void shrink()
    {
        String[] copy = new String[queue.length / 2];
        System.arraycopy(queue, head, copy, 0, size);
        queue = copy;
        head = 0;
        tail = size;
    }

    private boolean isEmpty()
    {
        return queue[head] == null;
    }

    private void enqueue()
    {
        if (isEmpty())
        {
            queue[head] = scan.nextLine();
        }
        else
        {
            if (tail == queue.length)
            {
                grow();
            }
            queue[tail] = scan.nextLine();
            tail++;
        }
        size++;
    }

    private void dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println(queue[head]);
            queue[head] = null;
            head++;
            size--;
            if (size == queue.length / 4)
            {
                shrink();
            }
        }
    }

    private void close()
    {
        scan.close();
    }

    public static void main(String[] args)
    {
        ResizingArrayQueueOfStrings x = new ResizingArrayQueueOfStrings();
        x.dequeue();
        x.dequeue();
        x.enqueue();
        x.enqueue();
        x.enqueue();
        x.enqueue();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.close();
    }
}
