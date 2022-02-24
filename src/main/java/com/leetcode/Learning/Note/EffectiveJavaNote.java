package com.leetcode.Learning.Note;

public class EffectiveJavaNote {
    /**
     * - 如何设计类结构：
     *     - 1.静态工厂方法（优点：顾名思义的，单例的，返回类型可以根据不同的入参提供不同的子类对象）；
     *     - 2.建造者模式构造对象（优于javabean（setter）和可伸缩构造方法模式（重载构造器））更灵活安全的同时也有性能损失；
     *     - 3.静态工厂方法或枚举实现单例：防止在序列化和反序列化时被修改，所有字段都应该是短暂的（transient）
     *         - ，并且重写readObject()以防止MutablePeriod攻击，私有化构造器并提供一个静态方法获取静态实例；
     *         - （如果在这个类上面增加 implements Serializable 的字样，它就不是一个单例；
     *         - 无论该类使用了默认的序列化形式，还是自定义的序列化形式（详见 87 条），都没有关系；
     *         - 也跟它是否使用了显式的 readObject （详见 88 条）无关。任何一个 readObject 方法，不管是
     *         - 显式的还是默认的，都会返回一个新建的实例，这个新建的实例不同于类初始化时创建的实例。）
     *         - 单一元素枚举类通常是实现单例的最佳方式：注意，如果单例必须继承 Enum 以外的父类（尽管可以声明一个
     *         - Enum 来实现接口），那么就不能使用这种方法；
     *     - 4.关于静态工具类：推荐写一个私有的构造器并添加必要注释，使其无法子类化；
     *     - 5.用静态类来实现经常用且不会变化的对象，例如注入固定的Pattern对象。
     *     - 6.防御性拷贝：在引用类型上加final，只能保证其指针不变，所以要用到防御性拷贝，在给这些引用类型赋值时，
     *     - 拷贝一个冗余的对象，使得外部无法控制这个对象，并且在getter中也返回拷贝过的对象（都是深拷贝）
     *     - 7.消除过期对象引用（stack出栈时应将内部引用置为null），来源一：缓存，来源二：监听器和其他回调
     *     - 8.Finalizer和Cleaner机制
     *     - 9.用try-with-resourse代替try-finally
     *     - 10.重写equals()方法
     *         - 什么时候需要重写：目标类包含逻辑相等概念且有别于对象标识，父类没有重写equals；
     *         - 目标：
     *             - 满足自反；
     *             - 对称；
     *             - 传递(子类->父类->子类)；
     *             - 一致性(持久性：不可变对象之间要么永远相等要么永远不相等)；
     *             - 非空性；
     *         - 最佳实践：
     *             - 使用instanceof 运算符（如果第一个操作数为null，会直接返回false）；
     *             - 入参必须是Object类；（如果不是等于是重载而不是重写）
     *             - 参数转换成正确类型；
     *             - 目标属性相匹配；
     *             - 在比较float时，用Float.compare()，用Float.equals()会自动装箱；
     *             - 在比较Double时，用Double.compare()，用Double.equals()会自动装箱；
     *             - 最有可能不同的放在前面比较；
     *             - 根据目标进行单元测试；
     *             - 重写hashcode()方法（使之能够在HashSet和HashMap中正确运行）；
     *     - 11.重写hashcode()方法
     *         - 如果两个对象是相等的，他们的hashCode也必须相等，反之就必须不相等；
     *         - 目标：
     *             - 为不相等的实例“均匀地”生成不同的哈希码；
     *             - 确保相同的实例的哈希码一定一致；
     *         - 最佳实践：
     *             - 如果是基本类型的属性，使用Type.hashCode(f)；（Type为对应的包装类）
     *             - 推荐使用AutoValue框架进行单元测试
     *             - 如果不可变类的哈希码获取代价很大，可以考虑延迟初始化并缓存哈希码，但需要注意线程安全
     *         // Typical hashCode method
     *          @Override
     *          public int hashCode() {
     *              int result = Short.hashCode(areaCode);
     *              result = 31 * result + Short.hashCode(prefix);
     *              result = 31 * result + Short.hashCode(lineNum);
     *              return result;
     *          }
     *     - 12.始终重写toString()
     *     - 13.重写clone()
     *          - 非严格规范：
     *              - x.clone() != x
     *              - x.clone().getClass() == x.getClass()
     *              - x.clone().equals(x)
     *              - 绝不能调用一个可以被重写的方法
     *              - 写子类时不要实现Closable
     *              - 线程安全的类中的clone也必须是正确同步的
     *          - 最佳实践：
     *              - 返回类型是该类本身
     *              - 先调用super.clone
     *              - 修复所有需要修复属性的深层结构
     *              - 如果类只包含基本类型或对不可变对象的引用，那么很可能是没有属性需要修复的情况。
     *
     *      - 14.考虑实现 Comparable 接口
     *          - 实现类必须确保所有 x 和 y 都满足 sgn(x.compareTo(y)) == -sgn(y. compareTo(x))
     *          - 实现类还必须确保该关系是可传递的： (x. compareTo(y) > 0 && y.compareTo(z) > 0)
     *          - 实现类必须确保 x.compareTo(y) == 0 意味着 sgn(x.compareTo(z)) == sgn(y.compareTo(z))
     *          -
     */
}
