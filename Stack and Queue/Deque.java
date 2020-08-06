import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
    private Node head;
    private Node tail;
    private int size;

    // construct an empty deque
    public Deque()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Node class
    private class Node
    {
        private Item x;
        private Node previous;
        private Node next;

        private Node(Item x)
        {
            this.x = x;
            this.previous = null;
            this.next = null;
        }
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return head == null;
    }

    // return the number of items on the deque
    public int size()
    {
        return size;
    }


    // add the item to the front
    public void addFirst(Item item)
    {
        validateAdd(item);
        size++;
        Node newHead = new Node(item);
        if (isEmpty())
        {
            head = newHead;
            tail = head;
        }
        else
        {
            head.previous = newHead;
            newHead.next = head;
            head = newHead;
        }
    }

    // add the item to the back
    public void addLast(Item item)
    {
        validateAdd(item);
        size++;
        Node newTail = new Node(item);
        if (isEmpty())
        {
            head = newTail;
            tail = head;
        }
        else
        {
            tail.next = newTail;
            newTail.previous = tail;
            tail = newTail;
        }
    }

    // remove and return the item from the front
    public Item removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }
        else
        {
            Item i = head.x;
            head = head.next;
            if (head != null)
            {
                head.previous = null;
            }
            else
            {
                tail = null;
            }
            size--;
            return i;
        }
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Deque is empty");
        }
        else
        {
            Item i = tail.x;
            tail = tail.previous;
            if (tail != null)
            {
                tail.next = null;
            }
            else
            {
                head = null;
            }
            size--;
            return i;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new ListIterator(head);
    }

    // Error handling
    private void validateAdd(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("No element to add.");
        }
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item>
    {
        private Node current;

        public ListIterator(Node head)
        {
            current = head;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            Item item = current.x;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        Deque<String> test = new Deque<String>();
        System.out.println(test.isEmpty());
        test.addFirst("jeje");
        System.out.println(test.isEmpty());
        test.removeLast();
        System.out.println(test.isEmpty());
        test.addLast("jaja");
        test.removeFirst();
        System.out.println("Size: " + test.size());
        test.addFirst("jeje");
        test.addFirst("jeje");
        test.addFirst("jeje");
        test.addFirst("jeje");
        test.addFirst("jeje");
        for (String s : test)
        {
            System.out.println(s);
        }
    }
}
