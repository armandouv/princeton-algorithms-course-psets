import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] queue;
    private int head;
    private int tail;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue()
    {
        queue = (Item[]) new Object[2];
        head = 0;
        tail = 1;
        size = 0;
    }


    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return size;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (item == null)
        {
            throw new IllegalArgumentException("No item to enqueue");
        }

        if (isEmpty())
        {
            queue[head] = item;
        }
        else
        {
            if (tail == queue.length)
            {
                grow();
            }
            queue[tail] = item;
            tail++;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty queue");
        }

        int selected = StdRandom.uniform(head, tail);

        while (queue[selected] == null)
        {
            selected = StdRandom.uniform(head, tail);
        }

        Item dq = queue[selected];
        queue[selected] = null;
        size--;

        if (!isEmpty())
        {
            if (selected == head)
            {
                head++;
            }
            else if (selected == tail - 1)
            {
                tail--;
            }

            if (queue.length / 4 == size)
            {
                shrink();
            }
        }
        return dq;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Empty queue");
        }

        int selected = StdRandom.uniform(head, tail);
        while (queue[selected] == null)
        {
            selected = StdRandom.uniform(head, tail);
        }
        return queue[selected];
    }

    private void grow()
    {
        Item[] copy;
        if (size == tail)
        {
            copy = (Item[]) new Object[size * 2];
            System.arraycopy(queue, 0, copy, 0, size);
        }
        else
        {
            copy = (Item[]) new Object[queue.length];
            int copyIndex = 0;
            for (int i = head; i < tail; i++)
            {
                if (queue[i] != null)
                {
                    copy[copyIndex++] = queue[i];
                }
            }
            head = 0;
            tail = size;
        }

        queue = copy;
    }

    private void shrink()
    {
        Item[] copy = (Item[]) new Object[queue.length / 2];
        int copyIndex = 0;
        for (int i = head; i < tail; i++)
        {
            if (queue[i] != null)
            {
                copy[copyIndex++] = queue[i];
            }
        }
        head = 0;
        tail = size;
        queue = copy;
    }


    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Item[] copy;
        private int current;

        public ListIterator()
        {
            copy = (Item[]) new Object[size];
            int j = 0;
            for (int i = head; i < tail; i++)
            {
                if (queue[i] != null)
                {
                    copy[j++] = queue[i];
                }
            }
            StdRandom.shuffle(copy);
            current = 0;
        }

        public boolean hasNext()
        {
            return current != copy.length;
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
            Item item = copy[current++];
            return item;
        }
    }

    private void printSize()
    {
        System.out.print("Queue size: " + size());
        System.out.println("     Array size: " + queue.length + "     Head: " + head + "     Tail: " + tail);
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        RandomizedQueue<String> x = new RandomizedQueue<>();
        x.enqueue("jaja");
        x.printSize();
        x.enqueue("jeje");
        x.printSize();
        x.enqueue("jiji");
        x.printSize();
        x.enqueue("jojo");
        x.printSize();
        x.dequeue();
        x.printSize();
        x.dequeue();
        x.printSize();
        x.dequeue();
        x.printSize();
        x.dequeue();
        x.printSize();
        System.out.println("Empty? " + x.isEmpty());
        x.enqueue("juju");
        x.printSize();
        x.enqueue("jaja");
        x.printSize();
        x.enqueue("jeje");
        x.printSize();
        x.enqueue("jiji");
        x.printSize();
        x.enqueue("jojo");
        x.printSize();
        x.enqueue("juju");
        x.printSize();
        x.enqueue("jaja");
        x.printSize();
        System.out.println("Sample: " + x.sample());
        System.out.println("Sample: " + x.sample());
        System.out.println("Sample: " + x.sample());
        System.out.println("Sample: " + x.sample());
        for (String s : x)
        {
            System.out.println(s);
        }
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.printSize();
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.printSize();
    }

}
