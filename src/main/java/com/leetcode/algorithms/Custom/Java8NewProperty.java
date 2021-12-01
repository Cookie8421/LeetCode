package com.leetcode.algorithms.Custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author JoeyYoung
 * @ClassName:
 * @Date 2021/11/19 9:32
 * @Description:
 */
public class Java8NewProperty {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("codeIng");
        list.add("coding");
        list.add("Joey1");
        list.add("JoeyYoung");

        String result = list.stream()// 首先将列表转化为Stream流

                .filter( i -> !isNum(i) )// 首先筛选出字母型字符串

                .filter( i -> i.length() >= 5 )// 其次筛选出长度>=5的字符串

                .map( i -> i.toLowerCase() )// 字符串统一转小写

                .distinct()                 // 去重操作来一下

                .sorted( Comparator.naturalOrder() ) // 字符串排序来一下

                .collect( Collectors.joining("❤") ); // 连词成句来一下，完美！


        System.out.println(result);


        //Lambda
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        Java8NewProperty tester = new Java8NewProperty();
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));

        //lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有final 的语义）
        int num = 1;//等同于加上final
        Converter<Integer, String> s = (param) -> System.out.println(param + num);
        s.convert(2);

        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        Car car  = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        Car car3 = new Car();
        List<Car> cars = Arrays.asList(car,car1,car2,car3);
        System.out.println("===================构造器引用========================");
        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);
        System.out.println("===================静态方法引用========================");
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);
        System.out.println("==============特定类的任意对象的方法引用================");
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
        System.out.println("===================特定对象的方法引用===================");

    }

    private static boolean isNum(String i) {
        char[] charArray = i.toCharArray();
        for(int j = 0; j < charArray.length; j++){
            if(charArray[j] < 65 || (charArray[j] > 90 && charArray[j] < 97) || charArray[j] > 122){
                return true;
            }
        }
        return false;
    }


    /**
     * 解决套娃判空，用Optional
     */
    /*public Integer getScore( Student student ) {

        return Optional.ofNullable(student)

                .map( Student::getSubject )

                .map( Subject::getScore )

                .orElse(null);

    }*/
    /*public String getStreetName( Province province ) {
        return Optional.ofNullable( province )
                .map( i -> i.getCity() )
                .map( i -> i.getDistrict() )
                .map( i -> i.getStreet() )
                .map( i -> i.getName() )
                .orElse( "未找到该道路名" );
    }*/


    interface MathOperation {
        int operation(int a, int b);
    }
    interface GreetingService {
        void sayMessage(String message);
    }
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }


}
class Car{

    public static Car create(final Java8NewProperty.Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
