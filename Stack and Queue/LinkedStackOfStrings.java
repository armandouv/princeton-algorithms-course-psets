import java.util.Scanner;

public class LinkedStackOfStrings
{
    private Node first;
    private Scanner scan;

    private LinkedStackOfStrings(Scanner scan)
    {
        this.scan = scan;
        first = new Node(this.scan.nextLine());
    }

    private class Node
    {
        private String x;
        private Node next;

        private Node(String str)
        {
            this.x = str;
            this.next = null;
        }

        private Node(Node first, String str)
        {
            this.x = str;
            this.next = first;
        }
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    private void push()
    {
        if (isEmpty())
        {
            first = new Node(scan.nextLine());
        }
        else
        {
            first = new Node(first, scan.nextLine());
        }
    }

    private void pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println(first.x);
            first = first.next;
        }
    }

    private void close()
    {
        scan.close();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        LinkedStackOfStrings x = new LinkedStackOfStrings(scan);
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
        x.close();
    }
}
