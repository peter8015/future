package com.future.algorithm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 题目：判断一个ip地址是否在一个地址段中
 * 例如："192.168.0.111" 是否在地址段 "192.168.0.0~192.168.0.255"
 * 分析：需要转换成long，判断给定的ip是否在地址范围内
 */
public class IpRange {

    @Test
    public void t1() {
        String ip = "192.168.0.111";
        String ipRange = "192.168.0.0~192.168.0.255";

        assertTrue(ipInRange(ip, ipRange));
    }

    public boolean ipInRange(String ip, String ipRange) {
        long ipx = ipToLong(ip);
        int pos = ipRange.indexOf("~");

        long s = ipToLong(ipRange.substring(0, pos));
        long e = ipToLong(ipRange.substring(pos + 1));

        return ipx >= s && ipx <= e;
    }

    public long ipToLong(String ip) {
        long r = 0L;
        String[] ips = ip.split("\\.");

        for(int i = 0; i < ips.length; i++) {
            r = r << 8 | Integer.parseInt(ips[i]);
        }

        return r;
    }




}
