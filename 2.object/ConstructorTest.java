public class ConstructorTest {

    String str = "a";

    ConstructorTest() {
        System.out.println("执行构造方法");
        this.str = "b";
    }

    {
        System.out.println("执行初始化");
        str = "c";
    }



    public static void main(String[] args) {
        ConstructorTest test = new ConstructorTest();
        System.out.println(test.str);
    }

}
