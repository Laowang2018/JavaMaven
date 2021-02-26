package com.lw.java.jmh;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//这样的性能对比测试是不准确的。
public class JmhTest {

    private final static String DATA = "DUMMY DATA";
    private final static int MAX_CAPACITY = 1000000;
    private final static int MAX_ITERATIONS = 10;
    private static void test(List<String> list) {
        for (int i=0; i<MAX_CAPACITY; i++) {
            list.add(DATA);
        }
    }

    private static void arrayListPerfTest (int iterations) {
        for (int i=0; i<iterations; i++) {
            final List<String> list = new ArrayList<>();
            final Stopwatch stopWatch = new Stopwatch().start();
            test(list);
            System.out.println(stopWatch.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    private static void linkedListPerfTest (int interations) {
        for (int i=0; i<interations; i++) {
            final List<String> list = new LinkedList<>();
            final Stopwatch stopwatch = new Stopwatch().start();
            test(list);
            System.out.println(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        }
    }

    public static void main(String[] args) {
        arrayListPerfTest(MAX_ITERATIONS);
        System.out.println(Strings.repeat("#", 100));
        linkedListPerfTest(MAX_ITERATIONS);
    }
}
