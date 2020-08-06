import java.util.Scanner;

public class LinkedQueueOfStrings
{
    private Node head;
    private Node tail;
    private Scanner scan;

    private LinkedQueueOfStrings()
    {
        scan = new Scanner(System.in);
        head = null;
        tail = null;
    }

    private class Node
    {
        private String x;
        private Node next;

        private Node()
        {
            this.x = scan.nextLine();
            this.next = null;
        }
    }

    private boolean isEmpty()
    {
        return head == null;
    }

    private void enqueue()
    {
        if (isEmpty())
        {
            head = new Node();
            tail = head;
        }
        else
        {
            tail.next = new Node();
            tail = tail.next;
        }
    }

    private void dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println(head.x);
            head = head.next;
        }
    }

    private void close()
    {
        scan.close();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        LinkedQueueOfStrings x = new LinkedQueueOfStrings();
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
