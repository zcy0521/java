public class SubOverrideTest {

}

class OverrideSuper {

    Number f(Integer a) {
        return a;
    }

    String f(String a) {
        return a;
    }

}

class OverrideSub extends OverrideSuper {

    /**
     * 重写父类方法，返回值必须是超类返回值类型的子类型
     */
    Integer f(Integer a) {
        return a;
    }
}
