package com.future.service.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.testng.collections.Sets;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Set;

public class JedisTest {

    @Test
    public void testJedis() {
        Set<String> sentinelSet = Sets.newHashSet();
        sentinelSet.add("127.0.0.1:26379");
        sentinelSet.add("127.0.0.1:26380");
        sentinelSet.add("127.0.0.1:26381");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(
                "mymaster",
                sentinelSet,
                new GenericObjectPoolConfig());
        System.out.println(jedisSentinelPool.getResource().get("hello111"));
    }

    public static void main(String[] args) {
        //1.生成一个jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("127.0.0.1", 8000);
        //带密码需要执行认证方法
        //jedis.auth("123456");
        //2.jedis执行set操作
        jedis.set("hello", "world");
        jedis.set("hello111", "world111");
        //3.jedis执行get操作，value="world"
        String value = jedis.get("hello");
        String value111 = jedis.get("hello111");

        System.out.println("value=" + value111);

    }

}
