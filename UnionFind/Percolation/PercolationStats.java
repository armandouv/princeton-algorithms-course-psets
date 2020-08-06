import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double mean;
    private double stdev;
    private double low;
    private double high;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        Percolation x;
        double[] thresholds = new double[trials];
        int num1, num2;

        for (int i = 0; i < trials; i++) {
            x = new Percolation(n);
            while (!x.percolates()) {
                num1 = StdRandom.uniform(n) + 1;
                num2 = StdRandom.uniform(n) + 1;
                x.open(num1, num2);
            }
            thresholds[i] = x.numberOfOpenSites() / (double) (n * n);
        }

        mean = StdStats.mean(thresholds);
        stdev = StdStats.stddev(thresholds);
        low = mean - (1.96 * stdev / Math.sqrt(trials));
        high = mean + (1.96 * stdev / Math.sqrt(trials));
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stdev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return low;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return high;
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length == 2) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            PercolationStats x = new PercolationStats(num1, num2);
            System.out.println("Mean = " + x.mean());
            System.out.println("Standard deviation = " + x.stddev());
            System.out.println(
                    "95% confidence interval = [" + x.confidenceLo() + " , " + x.confidenceHi()
                            + "]");
        }
        else {
            throw new IllegalArgumentException("Use two arguments: n and trials.");
        }
    }

}
