import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int openSites;
    private WeightedQuickUnionUF unionFind;
    private int supNode;
    private int infNode;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        openSites = 0;
        unionFind = new WeightedQuickUnionUF(n * n + 2);
        supNode = n * n;
        infNode = supNode + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int r, int c) {
        validate(r, c);
        int row = r - 1;
        int col = c - 1;

        if (!grid[row][col]) {
            grid[row][col] = true;
            openSites++;
            int max = grid.length - 1;
            int site = numSqr(row, col);

            if (row == 0) {
                unionFind.union(site, supNode);

            }
            else if (grid[row - 1][col]) {
                unionFind.union(site, numSqr(row - 1, col));

            }

            if (row == max) {
                unionFind.union(site, infNode);

            }
            else if (grid[row + 1][col]) {
                unionFind.union(site, numSqr(row + 1, col));

            }

            if (col > 0) {
                if (grid[row][col - 1]) {

                    unionFind.union(site, numSqr(row, col - 1));
                }
            }

            if (col < max) {
                if (grid[row][col + 1]) {

                    unionFind.union(site, numSqr(row, col + 1));
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int r, int c) {
        validate(r, c);
        int row = r - 1;
        int col = c - 1;

        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int r, int c) {
        validate(r, c);
        int row = r - 1;
        int col = c - 1;
        int site = numSqr(row, col);
        return unionFind.connected(site, supNode);
        /* boolean cLow = unionFind.connected(site, infNode);
        return (cTop && cLow); */
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionFind.connected(supNode, infNode);
    }

    private int numSqr(int row, int col) {
        return row * grid.length + col;
    }

    private void validate(int row, int col) {
        if (!(row > 0 && row <= grid.length && col > 0 && col <= grid.length)) {
            throw new IllegalArgumentException();
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation x = new Percolation(6);
        int[] arr = {
                1, 6,
                2, 6,
                3, 6,
                4, 6,
                5, 6,
                5, 5,
                4, 4,
                3, 4,
                2, 4,
                2, 3,
                2, 2,
                2, 1,
                3, 1,
                4, 1,
                5, 1,
                5, 2,
                6, 2,
                5, 4
        };
        int i = 0;
        while (!(x.percolates())) {
            System.out.println(arr[i] + " " + arr[i + 1]);
            x.open(arr[i], arr[i + 1]);
            i += 2;
        }
    }
}
