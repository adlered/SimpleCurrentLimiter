package pers.adlered.simplecurrentlimiter;

import pers.adlered.simplecurrentlimiter.main.SimpleCurrentLimiter;

/**
 * <h3>SimpleCurrentLimiter</h3>
 * <p>测试类</p>
 *
 * @author : https://github.com/AdlerED
 * @date : 2019-10-10 23:55
 **/
public class Test {
    public static void main(String[] args) {
        SimpleCurrentLimiter limiter = new SimpleCurrentLimiter(2, 2);
        try {
            for (int i = 0; i < 20; i++) {
                boolean result = limiter.access("hello");
                System.out.println("Time " + i + ": " + result + "\n");
                Thread.sleep(500);
            }
        } catch (InterruptedException IE) {}
    }
}
