package ThreadTest;

/**
 * @Author taomofan
 * @Date 2021/1/30 1:07 上午
 * @Version 1.0
 */
public class ThreadTest extends Thread{
    private String name = null;
    ThreadTest(String name){
        this.name = name;
    }
@Override
public void run() {
    int n = 10;
    int count = 0;
    for (int i = 0;i < n;i++){
        if (i % 2 == 0){
            count = count + 1;
            System.out.println(name +"/" + i);
        }
    }
}
}
