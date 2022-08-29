public class AbstractTest {
}

abstract class AbstractSuper {

    void methodA() {}

    void methodB() {}
}

class AbstractSubA extends AbstractSuper {

    void methodA() {}

    void methodB() {}
}

class AbstractSubB extends AbstractSubA {
}
