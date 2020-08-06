public class unionFind {

    private int[] id;
    private int[] size;

    public unionFind(int numElements)
    {
        id = new int[numElements];
        size = new int[numElements];
        for (int i = 0; i < numElements; i++)
        {
            /* Initialize arrays */
            id[i] = i;
            size[i] = 1;
        }
    }

    private int getRoot(int x)
    {
        while(id[x] != x)
        {
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }

    public void union(int x, int y)
    {
        int r1 = getRoot(x);
        int r2 = getRoot(y);
        if (r1 == r2)
        {
            return;
        }
        else
        {
            if (size[r1] > size[r2])
            {
                id[r2] = r1;
                size[r1] += size[r2];
            }
            else
            {
                id[r1] = r2;
                size[r2] += size[r1];
            }
        }
    }

    public boolean find(int x, int y)
    {
        return (getRoot(x) == getRoot(y));
    }

    public void printArr()
    {
        for (int i = 0; i < id.length; i++)
        {
            System.out.print(i + "  " + id[i] + "  " + size[i] + "\n");
        }
    }
}
