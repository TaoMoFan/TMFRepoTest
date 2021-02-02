package ThreadTest;

/**
 * @Author taomofan
 * @Date 2021/2/1 2:11 下午
 * @Version 1.0
 */
public class ThreadMain {
public static void main(String[] args) {
    Thread t1 = new ThreadTest("t1");
    Thread t2 = new ThreadTest("t2");
    t1.start();
    t2.start();
}
}
