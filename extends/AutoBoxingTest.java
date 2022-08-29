public class AutoBoxingTest {

    public static void main(String[] args) {
        Integer a = new Integer(-128);
        Integer b = new Integer(-128);
        System.out.println(a == b);

        a = -128;
        b = -128;
        System.out.println(a == b);

        a = 127;
        b = 127;
        System.out.println(a == b);

        a = 128;
        b = 128;
        System.out.println(a == b);




        Integer c = 3;
        Integer d = 3;
        System.out.println(c == d);

        Long l1 = 1L;
        Long l2 = 2L;
        System.out.println(l1 == l2);



        Integer x1 = 3 + 2;
        Integer x2 = 3 + 2;
        System.out.println(x1 == x2);

        Integer y1 = c + 2;
        Integer y2 = d + 2;
        System.out.println(y1 == y2);


        Integer e = 127 + 2;
        Integer f = 127 + 2;
        System.out.println(e == f);

        Integer z1 = a + 2;
        Integer z2 = b + 2;
        System.out.println(z1 == z2);

        int m = 3;
        triple(m);
        System.out.println(m);
        Integer n = 300;
        triple(n);
        System.out.println(n);


        System.out.printf(Integer.toString(20, 8));
    }

    public static void triple(int x) {
        x = 3 * x;
        System.out.println("int 'x' value: " + x);
    }

    public static void triple(Integer x) {
        x = 3 * x;
        System.out.println("Integer 'x' value: " + x);
    }

}
