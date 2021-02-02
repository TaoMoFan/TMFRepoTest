package Others;

/**
 * @Author taomofan
 * @Date 2021/2/1 1:18 下午
 * @Version 1.0
 */
public class RoundTset {
public static void main(String[] args) {
    int n = 10;
    int count = 0;
    for (int i = 0;i < n;i++){
        if (i % 2 == 0){
            count = count + 1;
            System.out.println(i);
        }
    }
    System.out.println("一共有" + count + "个偶数");
}
}
