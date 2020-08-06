public class Main {

    public static void main(String[] args) {
        unionFind x = new unionFind(10);
        x.union(3, 4);
        x.union(5, 6);
        x.union(9, 7);
        x.union(4, 7);
        x.union(3, 8);
        System.out.println(x.find(3, 6));
        System.out.println(x.find(3, 7));
        System.out.println(x.find(5, 8));
        System.out.println(x.find(9, 4));
        System.out.println(x.find(3, 0));
        x.printArr();
    }
}
