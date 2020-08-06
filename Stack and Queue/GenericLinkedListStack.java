public class GenericLinkedListStack<Item>
{
    private Node first = null;

    private class Node
    {
        private Item x;
        private Node next;
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    private void push(Item item)
    {
        Node old = first;
        first = new Node();
        first.next = old;
        first.x = item;
    }

    private Item pop()
    {
        Item item = first.x;
        first = first.next;
        return item;
    }

    public static void main(String[] args)
    {
    }
}
