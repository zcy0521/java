public class SubConstructorTest {
}

class ConstructorSuper{
    String str;

    ConstructorSuper() {
        this.str = "a";
    }

    ConstructorSuper(String str) {
        this.str = str;
    }
}

class ConstructorSub extends ConstructorSuper {

    int a;

    ConstructorSub() {
        // 没有显示调用，调用Super类无参构造方法
        this.a = 10;
    }

    ConstructorSub(int a) {
        // super(); this(); 只能同时存在一个
        // super(); this(); 必须在构造方法第一行
        super();
        this.a = a;
    }
}
