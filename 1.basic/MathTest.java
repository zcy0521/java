public class MathTest {

    public static void main(String[] args) {
        System.out.println(14%2);
        System.out.println(13%2);
        System.out.println((-13)%2);

        System.out.println(12 % 4);

        System.out.println(Math.floorMod(14, 2));
        System.out.println(Math.floorMod(13, 2));
        System.out.println(Math.floorMod(-13, 2));

        int n = 10;
        int fourthBitFromRight = (n & 0b1000) / 0b1000;
        System.out.println(fourthBitFromRight);


        System.out.println((5&2) == 0);
        System.out.println((-5&-2));
        System.out.println((5|2) == 7);
        System.out.println((5^2) == 7);
        System.out.println((-5^2));
        System.out.println((~2));
        System.out.println((~-2));

        System.out.println(5<<2);
        System.out.println(-5<<2);
        System.out.println(5>>2);
        System.out.println(-5>>2);
        System.out.println(-5>>>2);
    }

}
