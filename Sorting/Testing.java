public class Testing
{
    public static void main(String[] args)
    {
        Comparable[] test = {2, 5, 634, 6, 3, 1, 7, 8, 9, 7, 0, 9, 7, 4, 1, -5, 3, 5423, 65, 4, 5, 4, 23};
        Sort.shell(test);
        for (Comparable x : test)
        {
            System.out.println(x);
        }
    }
}
