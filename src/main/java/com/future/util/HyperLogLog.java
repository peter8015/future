package com.future.util;


import java.util.concurrent.ThreadLocalRandom;

public class HyperLogLog {

    static class BitKeeper {
        private int maxBits;

        public void random() {
            // 这里的随机数可以当成一个对象的hashCode。long value = new Object().hashCode() ^ (2 << 32);
            long value = ThreadLocalRandom.current().nextLong(2L << 32);
            int bits = lowZeros(value);
            if (bits > this.maxBits) {
                this.maxBits = bits;
            }
        }

        /**
         * 低位有多少个连续0
         * 思路上 ≈ 倒数第一个1的位置
         *
         * @param value
         * @return
         */
        private int lowZeros(long value) {
            int i = 1;
            for (; i < 32; i++) {
                if (value >> i << i != value) {
                    break;
                }
            }
            return i - 1;
        }
    }

    static class Experiment {
        private int n;
        private BitKeeper keeper;

        public Experiment(int n) {
            this.n = n;
            this.keeper = new BitKeeper();
        }

        public void work() {
            for (int i = 0; i < n; i++) {
                this.keeper.random();
            }
        }

        public void debug() {
            double v = Math.log(this.n) / Math.log(2);
            System.out.printf("%d %.2f %d\n", this.n, v, this.keeper.maxBits);
        }
    }

    public static void main(String[] args) {
        for (int i = 10000; i < 1000000; i += 10000) {
            Experiment exp = new Experiment(i);
            exp.work();
            exp.debug();
        }
    }
}
