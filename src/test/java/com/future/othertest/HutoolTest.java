package com.future.othertest;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.Date;
import java.util.List;

public class HutoolTest {
    Log log = LogFactory.get();


    @Test
    public void testIdCard() {
        String ids = "131081198208153415";
        boolean b = IdcardUtil.isValidCard(ids);

        if(b) {
            log.info("{} is valid ", ids);
        } else {
            log.info("{} is invalid ", ids);
        }

        log.info("He's birthday is {}", IdcardUtil.getBirthByIdCard(ids));

    }
    @Test
    public void testRuntimeUtil() {
        log.info(RuntimeUtil.execForStr("ping www.baidu.com"));

    }


    @Test
    public void testWatchMonitor() {
        File file = FileUtil.file("com/future/test.txt");

        //这里只监听文件或目录的修改事件
        WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);

        watchMonitor.setWatcher(new Watcher() {
            @Override
            public void onCreate(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("创建：{}-> {}", currentPath, obj);
            }

            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("修改：{}-> {}", currentPath, obj);
            }

            @Override
            public void onDelete(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("删除：{}-> {}", currentPath, obj);
            }

            @Override
            public void onOverflow(WatchEvent<?> event, Path currentPath) {
                Object obj = event.context();
                Console.log("Overflow：{}-> {}", currentPath, obj);
            }
        });

        //设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
        watchMonitor.setMaxDepth(3);
        //启动监听
        watchMonitor.start();
    }

    @Test
    public void testTimeInterval() {
        final TimeInterval timeInterval = new TimeInterval();

        timeInterval.start("1");
        ThreadUtil.sleep(1000 * 1);

        timeInterval.start("2");
        ThreadUtil.sleep(1000 * 2);


        log.info("it takes {} ms!", timeInterval.intervalMs("1"));
        log.info("it takes {} ms!", timeInterval.intervalMs("2"));
    }


    @Test
    public void testList() {
        String[] ss = new String[]{"abc", "cde", "fgh"};
        List list = Convert.toList(ss);

        list.stream().forEach(System.out::println);

        String money = "234234342";
        String convert = Convert.digitToChinese(Convert.toBigDecimal(money));
        log.info("money is {}", convert);
    }

    @Test
    public void testDate() {
        String s = "20220809";
        Date d = DateUtil.date();
        DateUtil.format(DateUtil.date(), "yyyy-MM-dd hh:mm:ss");
        log.info("date is :  {}", d);
    }

    @Test
    public void testStrUtil() {
        log.info("name is {}, age is {}", "abc", "44");

        String s = "av bc";
        if (StrUtil.hasBlank(s, "")) {
            log.info("{} has blank!", s);
        }

        if (StrUtil.hasEmpty(s, "")) {
            log.info("{} has empty!", s);
        }

        String ss = null;
        if (StrUtil.isNullOrUndefined(ss)) {
            log.info("{} is null or empty!", ss);
        }
    }

    @Test
    public void t1() {
        Date date1 = Convert.toDate("2021/01/02");
        System.out.println(date1);//运行结果：Sat Jan 02 00:00:00 CST 2021

        Date date2 = Convert.toDate("20210102182025");
        System.out.println(date2);//运行结果：Sat Jan 02 18:20:25 CST 2021

        Date date3 = Convert.toDate("2021-01-02 18:20:25");
        System.out.println(date3);//运行结果：Sat Jan 02 18:20:25 CST 2021

        Date date4 = Convert.toDate("2021-13-02 18:20:25");
        System.out.println(date4);//运行结果：Sun Jan 02 18:20:25 CST 2022

        Date date5 = Convert.toDate("2021,01,02");
        System.out.println(date5);//运行结果：null

        Date date6 = Convert.toDate("2021,01,02", new Date());
        System.out.println(date6);//

    }
}
