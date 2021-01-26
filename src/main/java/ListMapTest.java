import java.util.*;

/**
 * @Author taomofan
 * @Date 2021/1/26 10:39 下午
 * @Version 1.0
 */
public class ListMapTest {
    public static List<Map<String, Object>> getListMap(){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name","张三");
        map1.put("code",001);
        map1.put("time",2020-01-01);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","李四");
        map2.put("code",002);
        map2.put("time",2020-01-02);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name","王五");
        map3.put("code",003);
        map3.put("time",2020-01-03);
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        return mapList;
    }
}
