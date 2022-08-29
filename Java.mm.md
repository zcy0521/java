# Java

## Java核心技术I

### Java的基本程序设计结构

- 数据类型
    - 整形
        - byte  -2^(8-1) ~ 2^(8-1)-1
        - short -2^(16-1) ~ 2^(16-1)-1
        - int   -2^(32-1) ~ 2^(32-1)-1
        - long  -2^(64-1) ~ 2^(64-1)-1
    - 浮点型
        - float
        - double
    - char
    - boolean

- 变量
    - final声明的变量为常量，只能被赋值一次，赋值后无法被修改。习惯上,
常量名使用全大写。

- 运算符
    - 加(+)
    - 减(-)
    - 乘(*)
    - 除(/)：两个都是整数，整数除法15/2 == 7；其中一个是浮点数，浮点数除法15.0/2 == 7.5
    - 求余、取模(%)：15%2 == 1
    - 数学函数与常量
        - 平方根：Math.sqrt(x);
        - 幂运算：Math.pow(x, a);
        - floorMod：(-15)%2 == -1; Math.floorMod(-13, 2) == 1;
        - Math.sin Math.cos Math.tan Math.atan Math.atan2
        - Math.exp Math.log Math.log10
        - Math.PI
        - Math.E
    - 数值类型之间的转换
        - 如果两个操作数中有一个是double 类型， 另一个操作数就会转换为double 类型。
        - 否则， 如果其中一个操作数是float 类型， 另一个操作数将会转换为float 类型。
        - 否则， 如果其中一个操作数是long 类型， 另一个操作数将会转换为long 类型。
        - 否则， 两个操作数都将被转换为int 类型。
        - 转换不会丢失精度
            - byte->short->int->long
            - char->int
            - int->double
            - float->double
        - 转换会丢失经度
            - int->float
            - long->float
            - long->double
        - 结合赋值运算
            - x += 4 等效 x = x + 4
            - x *= 3.5 等效 x = (int)(x * 3.5)
        - 自增自减
            - int a = 2 * ++m; // m==7 结果为16 先自增再计算
            - int b = 2 * n++; // n==7 结果为14 先计算再自增
        - 逻辑运算符
            - &&： 短路与
            - ||： 短路或
            - ?：  x < y ? x : y; // 返回xy中较小的值
        - 位运算符
            - 源码、反码、补码
                - 正数：原码=反码=补码
                - 负数：
                    - 源码：二进制值         1 000 0001
                    - 反码：除符号位 按位取反 1 111 1110
                    - 补码：反码+1           1 111 1111
            - 计算规则：
                - 有负数参与计算，使用负数补码
                - 计算结果为负数，取结果补码
                - 符号位也参与计算
            - a & b：都是1，那么运算结果为1
            - a | b：都为0，那么运算结果为0
            - a ^ b：数字相同，则运算结果为0
                - a ^ b 等价 b ^ a
                - a ^ a == 0
                - 位上数字与0异或结果不变，与1异或结果相反
                - a ^ b ^ b == a
            - ~ a：每位取反。
            - a << b：左移，低位补0
                - a << b == a * (2^b)
                - byte/short/int最多支持31位的位移运算，如果位移数超过31，则虚拟机会对位移数按连续减去32，直到得到一个小于32并且大于等于0的数。
            - a >> b：右移，正数高位补0，负数高位补1
            - a >>> b：右移，高位补0                                                  

- 字符串
    - 截取：substring(0, 3); //index0~2
    - 拼接：+
    - 不可变字符串：
        - final class String{} // 保证String无法被继承后劫持value
        - private final char value[]; // private保证无法被外部访问 final保证无法被修改
    - 检测相等：
        - equals，equalsIgnoreCase
        - == 判断是否在相同内存位置，如果==一定equals
        - "abc"是字符串常量 +、sub等产生的字符串不是常量不一定相等
            - s1="abc";       s2="abc";       // s1 == s2
            - s1="abc"+"def"; s2="abc"+"def"; // s1 == s2
            - s1="abc"+"def"; s2="abcdef";    // s1 == s2
            - s3=s1+"def";    s4=s1+"def";    // s3 != s4
            - s3=s1+"def";    s4="abcdef";    // s3 != s4

- 输入输出

- 控制流程
    - 条件语句
        - if (condition) { statement; }
        - if (condition) { statement; } else { statement; }
        - if (condition) { statement; } else if { statement; } else { statement; }
    - 循环语句
        - while (condition) { statement; }
        - do { statement; } while (condition) // 让循环至少执行一次
        - for (int i=1; i<10; i++) { statement; }
            - 第一部分：计数器初始化
            - 第二部分：循环检查条件
            - 第三部分：如何更新计数器
        - for (variable : collection) { statement; }
            - collection：是数组或者实现了Iterable 接口的类对象
            - 增强for：用于处理不关心集合index的遍历
        - switch(choice) {case 1: statement; break; default: statement; break;}
            - choice值：byte、short 、int、char、String(Java SE 7)
            - choice值如果是枚举，case 后可直接跟枚举的值
            - **触发多个case**：如果某个case语句中没有 break; 会触发多个case
            - 编译时加上javac -Xlint:fallthrough Test.java 存在上述情况时编译器会给警告信息
            - 方法上加@SuppressWamings("fallthrough") 存在上述情况时编译器不会给警告信息
        - break：跳出循环
            - break; 跳至最外层循环尾部
            - label: { loopStatement; break label; } 跳至 label 后面跟着的循环尾部
        - continue：跳过档次循环
            - while：跳至当前循环开始
            - for：跳至第三部分更新计数器

- 大数值
    - java.math.BigInteger：任意经度正数计算
        - BigInteger i = BigInteger.valueOf(100);
        - add();
        - subtract();
        - multiply();
        - divide();
        - mod();
        - compareTo(a); 相等返回0 比a大返回1 比a小返回-1
    - java.math.BigDecimal：任意经度浮点数计算

- 数组
    - 声明和创建
        - 创建数形数组：int[] a = new int[10];         创建后，数组中元素的值初始化为0
        - 创建布尔数组：boolean[] a = new boolean[10]; 创建后，数组中元素的值初始化为false
        - 创建对象数组：String[] a = new String[10];   创建后，数组中元素的值初始化为null
        - 一旦创建了数组， **就不能再改变它的大小**。
    - 初始化及匿名初始化
        - int[] a = {1, 2, 3}
    - 数组拷贝
        - int[] new = Arrays.copyOf(old, newLength);
        - 新数组更长：多余的元素赋默认值，0 false null
        - 新数组更短：只拷贝老数组前面的元素
    - 数组排序
        - Arrays.sort(b); // 使用了优化的快速排序算
        - Arrays.toString(b); // 打印 [1, 17, 24, 26, 31, 49]
    - API
        - static String toString(type[] a);
        - static type copyOf(type[] a, int length);
        - static type copyOfRange(type[] a, int start, int end);
        - static void sort(type[] a);
        - static int binarySearch(type[] a, type v);
        - static int binarySearch(type[] a, int start, int end, type v);
        - static void fill(type[] a, type v);
        - static boolean equals(type[] a, type[] b);
        

### 对象与类

- 概述
    - 类
        - 属性
        - 方法
    - 对象
        - 对象的行为：method()
        - 对象的状态：property
        - 对象的标识：identity
    - 类的关系
        - 依赖(uses-b)：类A的方法操作类B
        - 聚合(has-b)： 类A的对象包含类B的对象
        - 继承(is-b):   类A由类B继承而来

- 使用预定义类
    - 构造器
        - 一种特殊的方法，用来构造并初始化对象
        - 构造器与类名相同，无返回值
    - 对象变量：
        - Date a = new Date(); // new操作符返回对象引用，存放在变量a中
        - **局部变量**不会自动初始化，必须new或者null赋值
    - java日期类
        - Date：处理时间点
        - LocalDate：处理日历日期
            - getYear();
            - getMonthValue();
            - getDayOfMonth();
    - 更改器方法和访问器方法
        - 更改器方法：调用方法后，a的值被修改。 ```CregorianCalendar a = new CregorianCalendar(1999, 11, 31); b.add(Calendar.DAY_OF_MONTH, 1000); ```
        - 访问器方法：用方法后，a的值在调保持不变。 ```LocalDate a = LocalDate.of(1999, 11, 31); LocalDate b = a.plusDays(1000); ```

- 用户自定义类
    - 构造器
        - 构造器与类同名
        - 每个类可以有一个以上的构造器
        - 构造器可以有0个、1个或多个参数
        - 构造器没有返回值
        - 构造器总是伴随着 new 操作一起调用
    - final 实例域
        - final 修饰符大都应用于基本(primitive)类型域， 或不可变(immutable)类
        - 如果类中的每个方法都不会改变其对象， 这种类就是不可变的类。

- 静态域与静态方法
    - 静态域
    - 静态常量 static final
        - static 属于类，没有static修饰属性属于实例
        - final 初始化后值不可改变
    - 静态方法：**方法不需要访问对象状态时，使用静态方法**
        - 不能访问实例域A.property (×)，可以访问自身类中的静态域A.staticProperty (√)。
        - 可以使用对象调用如：a.staticProperty; 最好使用A.staticProperty
    - **工厂方法**：
        - 可以自定义**名称**，而不用像构造方法一样与类名相同
        - 可以自定义返回对象**类型**，而构造器只能返回类的实例对象
    - main方法
        - main 方法不对任何对象进行操作。
        - 在启动程序时还没有任何一个对象。静态的 main 方法将执行并创建程序所需要的对象。

- 方法参数
    - 值调用 callByValue
        - 参数是：基础类型+String(因为String被final修饰)
        - 参数值（在方法外）不会被修改
    - 引用调用 callByReference
        - 参数是对象类型
        - 引用中的值可以被修改
        - **不能让对象参数引用一个新的对象**，只是能改变引用对象的值

- **对象构造**
    - 重载：同名不同参数类型或数量的方法
    - 默认域初始化：没有在构造器中给域显示赋值，数值0，布尔false，对象null
    - 无参构造器：没有构造器编译器默认添加，如果**类中提供了至少一个则无参构造不合法**。
    - this()：在构造器使用 this() 为调用其他构造方法
    - 初始化数据
        - 声明时
        - 初始化块中：**在构造器之前执行**
        - 构造器中：创建对象时**最后执行**
    - 静态域初始化
        - 声明时
        - 静态块中：**类第一次加载时执行**
    - finalize()：finalize 方法将在垃圾回收器清除对象之前调用。

- 包
    - javac：操作文件     ```javac com/myconipany/ Payrol1App.java`
    - java:  解释器加载类 ```com.mycompany.PayrollApp```
    - 编译源文件时**不检查目录结构**。java文件与package指定包不在同意路径，可编译，但是无法运行，移动至正确目录可运行。
    - 作用域
        - public：任意位置
        - private：只能类自己使用
        - default：同一个包中的其他类访问
        - JDK1.2开始，禁止加载包名以"java."开头的类
        - 包密封机制：不允许再向这个包中添加类
        - 如果有文件连接，将文件放入 doc-files/ 子目录，使用：<img src=
“ doc-files/uml_png” alt=“ UML diagram” >

- 文档注释
    - 写法
        - /** ... */
        - 标记由@开始，如：@author @param
        - 格式使用html标签
        - 键入等宽代码：{@code ... }
    - 包
        - package-info.java
        - 在一个包语句(package com.example)之后
    - 公有类与接口：
        - 必须放在 import 语句之后，类定义之前
    - 公有的和受保护的构造器及方法
        - @param 变量描述
        - @return 返回描述
        - @throws 异常描述
        - @see com.example.Clazz**#**method(Type param)
        - @see <a href="www.example.com">Example</a>
        - {@link com.example.Clazz**#**method(Type param) ]
        - {@link <a href="www.example.com">Example</a> ]
    - 公有的和受保护的域
        - 只需要对公有域（通常指的是静态常量）建立文档。

- 类设计技巧
    - 保证数据私有性 private
    - 数据要初始化
    - 不要过多使用私有类型，可以多封装几个类 (String code, String number)->Phone phone
    - 不是所有域都需要访问器和更改器 getter、setter
    - 将职责过多的类进行分解
    - 类名和方法名要清晰
    - 优先使用不可变的类：计算数值返回新的值，而不是更改原值

### 继承 **反射**

- 类、超类和子类
    - 定义：class SubClass extends SuperClasss {}
        - 超类(superclass)、基类(base class) 或父类(parent class)
        - 子类（(subclass)、 派生类(derived class) 或孩子类(child class)
    - 覆盖父类方法
        - 在子类中定义与父类重名方法
        - 在子类方法中引用父类属性方法：**super**
        - 方法签名(名称+参数)相同，**返回类型为超类返回类型或子类型**
    - 子类构造器
        - 子类构造器中使用 super(a, b) 为调用父类构造器 SuperClass(a, b)
        - 调用构造器的语句只能作为另一个构造器的**第一条语句**出现。
        - 子类的构造器没有显式地调用超类的构造器，则将自动**调用超类默认(没有参数)的构造器**
        - 超类没有不带参数的构造器，子类没有显示调用其他构造器，**编译报错**。
    - this和super
        - this
            - 隐式参数
            - 调用本类其他构造器
        - super
            - 调用超类方法
            - 调用超类构造器
    - 多态和动态绑定
        - 多态：一个变量可以指示多种类型，即声明的**父类变量**指向**子类对象**
        - 动态绑定：运行时能够自动地选择调用哪个方法
    - 继承层次
        - Manager manager = new Manager(); manager.setBonus(100); √
        - Employee[] staff = manager; staff[0].setBonus(100); ×
    - 方法调用
        - 静态绑定：private 方法、static 方法、final 方法或者构造器
        - 动态绑定：调用的方法**依赖于隐式参数的实际类型**
        - 如果动态绑定，则调用的方法从**隐式参数向超类一路搜索**，调用最近的
        - 每次调用都搜索，开销大，虚拟机预先为每个类创建了一个**方法表(method table)**
    - 强制类型转换
        - 父类引用子类对象，**多态**。// User u = new Student();
        - 子类引用父类对象，**需要将对象强转**。// Student s = (Student) new User();
        - 只能在继承层次内使用强转：**超类转子类**(Sub) super; **子类转超类**(Super) sub;
        - 超类转子类(Sub) super，使用 **super instanceof Sub** 判断后再转
    - 抽象类
        - 包含**1个或多个抽象方法**的类，**必须**声明为抽象类
        - **不含抽象方法**，**也可以**将类声明为抽象类
        - 父类如果为抽象类，子类要么实现全部抽象方法，要么也声明成抽象类
        - **不能实例化**
    - 受保护的访问
        - private: 本类可见
        - public: 所有类可见
        - protected: 本包及子类
        - default: 本包

- Object：所有类的超类
    - equals()
        - 方法特性：(对于任意非空x来说)
            - 自反性：x.equals(x) 返回 true
            - 对称性：x.equals(y) 返回 true，则 y.equals(x) 也返回 true
            - 传递性：x.equals(y) 返回 true，y.equals(z) 返回 true，则 x.equals(z) 也返回 true
            - 一致性：多次调用 x.equals(y) 返回结果一致
            - x.equals(null) 应返回 false
        - 定义：@Override public boolean equals(Object other){} // **参数是Object**
            - 判断入参为null：if (otherObject = null ) return false;
            - 判断是否为同一对象：if (this == otherObject) return true;
            - **比较 this 与 otherObject 是否属于同一个类**
                - (Optional) 如果存在父类，先调用父类equals
                - 子类有自己的equals规则：if (getClass() != otherObject.getCIass()) return false;
                - 子类由超类决定equals规则：if (!(otherObject instanceof ClassName)) return false;
            - 强转类型后比较域是否相同：ClassName other = (ClassName) otherObject
        - Objects.equals(a，b): **ab均为空，返回true**
        - Arrays.equals(type[] a, type[] b); // 长度相同，并且对应位置元素相同
    - hashCode()
        - hash code：是由对象导出的一个**整型值(可以为负)**，Object**默认的hashCode()表示内存地址**。
        - equals 与 hasn code关系
            - A == B：      A与B的 hash code值一定相同
            - A.equals(B)： hash code值一定相同 **《Effective Java》第45页**
            - !A.equals(B)：hash code可能相同 **String类重写了hashCode()，根据内容计算hash code值，"Ma"与"NB"**
        - 重新定义 equals() 方法， 就必须重新定义 hashCode() 方法。**否则可能不满足第二条。**
            - equals() 比较对象ID值
            - hashCode() 散列对象ID值
        - 判断对象是否相同 **hashCode()效率高，equals()效率低**
            - 先看 hashCode 不同，return false
            - 如果 hashCode 相同，再判断 equals
    - toString()
        - 父类：getClaSS().getName() + [name = "wusong"]
        - 子类：super.toString() + [nick = "xingzhe"]
        - Arrays.toString(type[] a)

- 泛型数组列表 ArrayList<Employee> staff = new ArrayList<>();
    - 列表：new ArrayListo(lOO); // 拥有存100个元素的潜力
    - 数组：new Employee[100];   // 只能存放100个元素
    - add/set
        - add(Element e); //添加元素
        - set(index, Element e); // 替换列表中已有数据，空列表时java.lang.IndexOutOfBoundsException
    - get(index);
    - add/remove：需要移动元素，效率低
        - add(index, Element e); // 指定位置插入元素，index之后所有元素向后移动一位，size+1
        - remove(index);         // 指定位置删除元素，index之后所有元素向前移动一位，size-1
        
- 对象包装器与自动装箱
    - 自动装箱**value0f**：list.add(3); <==> list.add(Integer.value0f(3));
    - 自动拆箱**intValue**：list.get(3); <==> list.get(3).intValue();
    - boolean、byte、char(<=127)、short(-128~127)、int(-128~127) 自动装箱，==返回true
        - Integer a=new Integer(3);   Integer b=new Integer(3);   a==b 返回false
        - Integer a=3;                Integer b=3;                a==b 返回true
        - Integer c=3+2;              Integer d=3+2;              a==b 返回true
        - Integer c=a+2;              Integer d=b+2;              a==b 返回true //**拆箱后计算**
        - String a = new String("x"); String b = new String("x"); a==b 返回false
        - String a="x";               String b="x";               a==b 返回true
        - String c="x"+"y";           String d="x"+"y";           a==b 返回true
        - String c=a+"y";             String d=b+"y";             a==b 返回false // **创建了新对象**
    - 装箱和拆箱是编译器认可的**生成字节码时加入方法调用**， 而不是虚拟机。
    - Integer
        - Integer.valueOf(int x);
        - Integer a; a.intValue();
        - Integer.parseInt(String s);

- 参数数量可变的方法
    - public void method(Object... args) {}

- 枚举类
    - enum Gender {MALE, FEMALE} // Gender是一个**类**，MALE, FEMALE是他的**两个实例**
    - 比较两个枚举是否相同，用 **==**
    - 是Enums类的子类
        - Gender a = Gender.MALE; String value = a.toString(); // **toByte()**
        - Gender.valueOf(String value);                        // **Enums.value(byte value)**
        - Gender[] values = Gender.values();
        - Gender a = Gender.MALE; a.ordinal();                 // 返回位置，从0开始

- 反射

- 继承的设计技巧

### 接口、lambda表示式与内部类

- 接口

- lambda表达式

- 内部类

- 代理

### 异常、断言和日志

- 处理错误

- 捕获异常

- 使用异常机制的技巧

- 使用断言

- 记录日期

- 调试技巧

### 泛型

- 定义简单泛型类型

- 泛型方法

- 类型变量的限定

- 泛型代码和虚拟机

- 约束与局限性

- 泛型类型的继承规则

- 通配符类型

- 反射和泛型

### 集合

- Java集合框架

- **具体的集合**
    - 链表
    - 数组
    - 散列集
    - 树
    - 队列与双端队列
    - 优先级队列

- 映射

- 视图与包装器

- **算法**
    - 排序与混排
    - 二分查找
    - 简单算法
    - 批操作
    - 集合与数组的转换
    - 编写自己的算法

- 遗留的集合

### **并发**

- 中断线程

- 线程状态

- 线程属性

- 同步

- 阻塞队列

- 线程安全的集合

- Callable与Future

- 执行器

- 同步器

## Java核心技术II

### JavaSE8 Stream

- 从迭代到流的操作

- 流的创建

- filter、map和flatMap

- 抽取子流和连接流

- 其他流的转换

- 简单约简

- Optional类型

- 收集结果

- 收集到映射表中

- 群组和分区

- 下游收集器

- 约简操作

- 基本流类型

- 并行流

### 输入与输出

- 输入输出流

- 文本输入与输出

- 读写二进制数据

- 对象输入/输出流与序列化

- 操作文件

- 内存映射文件

- 正则表达式

### XML

### 网络

### 数据库

### 日期和时间API

- 时间线

- 本地时间

- 日期调整期

- 本地时间

- 时区时间

- 格式化和解析

- 与遗留代码互操作

## Java并发

### 基础知识

#### 线程安全性

- 原子性

- 加锁机制

- 用锁来保护状态

#### 对象的共享

- 可见性

- 发布与逸出

- 线程封闭

- 不变性

- 安全发布

#### 对象的组合

- 设计线程安全的类

- 实例封闭

- 线程安全性的委托

- 在现有的线程安全类中添加功能

- 将同步策略文档化

#### 基础构建模块

- 同步容器类

- 并发容器类

- 阻塞队列和生产者-消费者模式

- 阻塞方法与中断方法

- 同步工具类
    - 闭锁
    - FutureTask
    - 信号量
    - 栅栏

- 构建高效且可伸缩的结果缓存

### 结构化并发应用程序

#### 任务执行

- 在线程中执行任务

- Executor框架

- 找出可利用的并行性

#### 取消与关闭

- 任务取消

- 停止基于线程的服务

- 处理非正常的线程终止

- JVM关闭

#### 线程池的使用

- 在任务与执行策略之间的隐形耦合

- 设置线程池的大小

- 配置ThreadPoolExecutor

- 扩展ThreadPoolExecutor

- 递归算法的优化

### 活跃性、性能与测试

#### 避免活跃性危险

- 死锁
    - 锁顺序死锁
    - 动态的锁顺序死锁
    - 在协作对象之间发生的死锁
    - 开放调用
    - 资源死锁

- 死锁的避免与诊断

- 其他活跃性危险

#### 性能与可伸缩性

- 对性能的思考

- Amdahl定律

- 线程引入的开销

- 减少锁的竞争

#### 并发程序的测试

- 正确性测试

- 性能测试

- 避免性能测试的陷阱

- 其他的测试方法

### 高级主题

#### 显示锁

- Lock与ReentrantLock

- 性能考虑因素

- 公平性

- 在synchronized和ReentrantLock之间进行选择

- 读-写锁

#### 构建自定义的同步工具

- 状态依赖性的管理

- 使用条件队列

- 显示的Condition对象

- Synchronizer剖析

- AbstractQueuedSynchronizer

- java.util.concurrent同步器类中的AQS

#### 原子变量与非阻塞同步机制

- 所得劣势

- 硬件对并发的支持

- 原子变量类

- 非阻塞算法

#### Java内存模型

- 内存模型

- 发布

- 初始化过程中的安全性

## Java虚拟机

### 自动内存管理机制

#### Java内存区域与内存溢出异常

- 运行时数据区
    - 程序计数器
    - Java虚拟机栈
    - 本地方法栈
    - Java堆
    - 方法区
    - 运行时常量池
    - 直接内存

- HotSpot虚拟机对象探秘

- OutOfMemoryError异常

#### 垃圾收集器与内存分配策略

- 对象已死吗
    - 引用计数算法
    - 可达性分析算法
    - 再谈引用
    - 生存还是死亡
    - 回收方法区

- 垃圾收集算法
    - 标记-清除算法
    - 复制算法
    - 标记-整理算法
    - 分代收集算法

- HotSpot的算法实现

- 垃圾收集器
    - Serial收集器
    - ParNew收集器
    - Paralle Scavenge收集器
    - Serial Old收集器
    - Parallel Old收集器
    - CMS收集器
    - G1收集器
    - 理解GC日志
    - 垃圾收集器参数总结

- 内存分配与回收策略

#### 虚拟机性能监控与故障处理工具

- JDK的命令行工具
    - jps：虚拟机进程状况工具
    - jstat：虚拟机统计信息监视工具
    - jinfo：Java配置信息工具
    - jmap：Java内存映射工具
    - jhat：虚拟机堆转存储快照分析工具
    - jstack：Java堆栈跟踪工具
    - HSDIS：JIT生成代码反汇编

- JDK的可视化工具
    - JConsole：Java监视与管理控制台
    - VisualVM：多合一故障处理工具

#### 调优**案例与实战**

### 虚拟机执行子系统

#### 类文件结构

- Class类文件的结构

- 字节码指令简介

- 公有设计和私有实现

- Class文件结构的发展

#### 虚拟机类加载机制

- 类加载的时机

- 类加载的过程
    - 加载
    - 验证
    - 准备
    - 解析
    - 初始化

- 类加载器
    - 类与类加载器
    - 双亲委派模型
    - 破坏双亲委派模型

#### 虚拟机字节码执行引擎

- 运行时栈帧结构

- 方法调用

基于栈的字节码解释执行引擎

#### 类加载及执行子系统的**案例与实战**

### 程序编译与代码优化

#### 编译器优化

- Javac编译器

- Java语法糖的味道

- 实战：插入式注解处理器

#### 运行期优化

- HotSpot虚拟机内的即时编译器

- 编译优化技术

- Java与C/C++的编译器对比

### 高效并发

#### Java内存模型与线程

- 硬件的效率与一致性

- Java内存模型

- Java与线程

#### 线程安全与锁优化

- 线程安全

- 锁优化
    - 自旋锁与自适应自旋
    - 锁消除
    - 锁粗化
    - 轻量级锁
    - 偏向锁

## MySQL

## Redis

### 数据类型

### 基础操作

### 分布式锁

- [SETNX](http://www.redis.cn/commands/setnx.html)加锁
    - SETNX lock time：返回1，**加锁成功**
    - SETNX lock time：返回0
        - GET lock：返回time未过期，**加锁失败**
        - GET lock：返回time已过期
            - GETSET lock timeNew：返回timeOld未过期，**加锁失败**
            - GETSET lock timeNew：返回timeOld已过期，**加锁成功**

- [SET](http://www.redis.cn/commands/set.html)加锁
    - SET lock token NX EX max-lock-time：返回OK，**加锁成功**
    - SET lock token NX EX max-lock-time：返回null，**加锁失败**
    
- lua脚本解锁：**防止a获取锁后锁到期，b再获取锁**
    ```lua
    String delLuaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";

    redisTemplate.execute( new DefaultRedisScript<>(delLuaScript, Long.class),Arrays.asList(lockKey), uuid);
    ```

- RedLock

## Spring、SpringBoot
