public class Sort
{
    public static void selection(Comparable[] arr)
    {
        int N = arr.length;
        int smallest;

        for (int i = 0; i < arr.length - 1; i++)
        {
            smallest = i;

            for (int j = i + 1; j < arr.length; j++)
            {
                if (lessThan(arr[j], arr[smallest]))
                {
                    smallest = j;
                }
            }

            swap(i, smallest, arr);
        }
    }

    public static void insertion(Comparable[] arr)
    {
        int curr;
        int prev;

        for (int i = 1; i < arr.length; i++)
        {
            curr = i;
            prev = curr - 1;
            while (lessThan(arr[curr], arr[prev]))
            {
                swap(curr, prev, arr);
                curr--;
                prev--;

                if (prev < 0)
                {
                    break;
                }
            }
        }
    }

    public static void shell(Comparable[] arr)
    {
        int N = arr.length;
        int x = 1;

        while (x < N / 3)
        {
            x = x * 3 + 1;
        }

        int curr, prev;

        while (x >= 1)
        {
            for (int i = x; i < N; i++)
            {
                curr = i;
                prev = curr - x;
                while (lessThan(arr[curr], arr[prev]))
                {
                    swap(curr, prev, arr);
                    curr -= x;
                    prev = curr - 1;

                    if (prev < 0)
                    {
                        break;
                    }
                }
            }
            x /= 3;
        }
    }

    private static boolean lessThan(Comparable x, Comparable y)
    {
        return x.compareTo(y) < 0;
    }

    private static void swap(int x, int y, Comparable[] arr)
    {
        Comparable tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
