package com.leetcode.Learning.Note;

import com.leetcode.algorithms.Custom.A;
import com.leetcode.algorithms.EasyMode.*;
import com.leetcode.algorithms.HardcoreMode.*;
import com.leetcode.algorithms.MediumMode.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import reactor.core.publisher.Flux;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        /*ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5} , -2));*/

        /*PathWithMaximumProbability p = new PathWithMaximumProbability();
        System.out.println(p.maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));*/

        /*ShortestPalindrome s = new ShortestPalindrome();
        System.out.println(s.shortestPalindrome("aacecaaa"));*/

        /*TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{3,3,3,3,3}, 3));*/

        /*DayoftheWeek d = new DayoftheWeek();
        System.out.println(d.dayOfTheWeek(15,8,2019));*/


        /*FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(-1);
        System.out.println(f.findMedian());
        f.addNum(-2);
        System.out.println(f.findMedian());
        f.addNum(-3);
        System.out.println(f.findMedian());
        f.addNum(-4);
        System.out.println(f.findMedian());
        f.addNum(-5);
        System.out.println(f.findMedian());*/


        /*ErectTheFence e = new ErectTheFence();
        System.out.println(e.outerTrees(new int[][]{{1,1},{2,0},{2,4},{4,2},{4,1}}));*/

        /*NumberOfNodesInTheSubTreeWithTheSameLabel n = new NumberOfNodesInTheSubTreeWithTheSameLabel();
        System.out.println(n.countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd"));*/


        /*PossibleBipartition p = new PossibleBipartition();
        System.out.println(p.possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));*/


        /*//just()：创建Flux序列，并声明数据流，
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);//整形
        //subscribe()：订阅Flux序列，只有进行订阅后才回触发数据流，不订阅就什么都不会发生
        integerFlux.subscribe(System.out::println);

        Flux<String> stringFlux = Flux.just("hello", "world");//字符串
        stringFlux.subscribe(System.out::println);

        //fromArray(),fromIterable()和fromStream()：可以从一个数组、Iterable 对象或Stream 对象中创建Flux序列
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array).subscribe(System.out::println);

        List<Integer> integers = Arrays.asList(array);
        Flux.fromIterable(integers).subscribe(System.out::println);

        Stream<Integer> stream = integers.stream();
        Flux.fromStream(stream).subscribe(System.out::println);*/

        /*BasicCalculatorII b = new BasicCalculatorII();
        System.out.println(b.calculate(" a b c"));*/

        //System.out.println(String.format("%05d", 103));

        /*String a = "15:05";
        String b = "15:30";
        System.out.println(StringUtils.compare(a, b));*/

    }



}
