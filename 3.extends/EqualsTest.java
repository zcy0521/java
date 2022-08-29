import java.util.Objects;

public class EqualsTest {

    String a;

    public EqualsTest(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        EqualsTest a = new EqualsTest("A");
        EqualsTest b = new EqualsTest("A");
        System.out.println(a.equals(b));

        SubEqualsTest c = new SubEqualsTest("A");
        SubEqualsTest d = new SubEqualsTest("A");
        System.out.println(c.equals(d));


        System.out.println(null == null);
    }

//    @Override
//    public boolean equals(Object otherObject) {
//        if (this == otherObject) {
//            return true;
//        }
//
//        if (null == otherObject) {
//            return false;
//        }
//
//        if (getClass() != otherObject.getClass()) {
//            return false;
//        }
//
//        EqualsTest other = (EqualsTest) otherObject;
//        return Objects.equals(this.a, other.a);
//    }
}

class SubEqualsTest extends EqualsTest {
    public SubEqualsTest(String a) {
        super(a);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (null == otherObject) {
            return false;
        }

        // 存在非Object的超类，且超类重写了equals
//        if (!super.equals(otherObject)) {
//            return false;
//        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        SubEqualsTest other = (SubEqualsTest) otherObject;
        return Objects.equals(this.a, other.a);
    }
}
