public class ParamsTest {

    public static void main(String[] args) {
        String a = "a";
        callByValue(a);
        System.out.println(a);

        StringBuilder b = new StringBuilder("b");
        callByReference(b);
        System.out.println(b);
    }

    static void callByValue(String a) {
        a += "c";
    }

    static void callByReference(StringBuilder b) {
        b.append("c");
        System.out.println("===" + b);

        b = new StringBuilder("a");
        b.append("c");
        System.out.println("===" + b);
    }

}
