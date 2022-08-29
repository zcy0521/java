import java.util.HashSet;

public class StringTest {

    public static void main(String[] args) {
        String m = new String("xyz");
        String n = new String("xyz");
        System.out.println(m == n);

        m = "xyz";
        n = "xyz";
        System.out.println(m == n);

        String x1 = "xyz" + "abc";
        String x2 = "xyz" + "abc";
        System.out.println(x1 == x2);

        String y1 = m + "abc";
        String y2 = n + "abc";
        System.out.println(y1 == y2);



        String a = "aaa";
        System.out.println(append(a));
        System.out.println(a);

        StringBuilder b = new StringBuilder("aaa");
        System.out.println(append(b));
        System.out.println(b);


        HashSet<StringBuilder> hs = new HashSet<>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);
        System.out.println(hs);

        StringBuilder sb3 = sb1;
        sb3.append("bbb");
        hs.add(sb3);
        System.out.println(hs);

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = "abc" + "def" + 47;
        String s4 = "abc" + "def" + 47;
        System.out.println(s3 == s4);

        String s5 = s1 + "def" + 47;
        String s6 = s1 + "def" + 47;
        System.out.println(s5 == s6);

        String s7 = "abcdef47";
        System.out.println(s3 == s7);
        System.out.println(s5 == s7);


        String greeting = "Hello";
        System.out.println(greeting.length());
        System.out.println(greeting.codePointCount(0, greeting.length()));

        int index = greeting.offsetByCodePoints(0, 3);
        System.out.println(greeting.codePointAt(index));

        String aaa = "ab";
        String bbb = "⑪";
        System.out.println(aaa.charAt(1));
        System.out.println(bbb.charAt(0));
    }

    public static String append(String s) {
        // String 不变，作为参数值不会改
        s += "bbb";
        return s;
    }

    public static String append(StringBuilder sb) {
        // sb为对象，值可修改
        sb.append("bbb");
        return sb.toString();
    }

}
