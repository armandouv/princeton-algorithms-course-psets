import edu.princeton.cs.algs4.StdIn;

public class Permutation
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("Provide an integer, please.");
        }

        int k = Integer.parseInt(args[0]);
        if (k < 0) throw new IllegalArgumentException("Integer is less than 0.");
        int numW = 0;
        RandomizedQueue<String> x = new RandomizedQueue<>();
        String tmp;

        while (!StdIn.isEmpty())
        {
            tmp = StdIn.readString();
            x.enqueue(tmp);
            numW++;
        }

        System.out.println(numW);

        if (numW < k || numW == 0) throw new IllegalArgumentException("Please type a valid number of words.");

        for (String s : x)
        {
            System.out.println(s);
        }
    }
}
