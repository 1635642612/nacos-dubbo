import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Test {


    public static void main(String args[]){

        List<User> list1  = Lists.newArrayList();
        User u1 = new User();u1.setName("zx");u1.setAge(18);u1.setDay("2010-12-15 15:30:23");
        User u0 = new User();u0.setName("www");u0.setAge(12);u0.setDay("2002-11-05 13:30:23");
        list1.add(u1);list1.add(u0);

        List<User2> list2  = Lists.newArrayList();
        Date birth =new Date(System.currentTimeMillis()-1000*60*60*24);

        Date birth2 =new Date(System.currentTimeMillis()-(1000*60*60*24)*2);

        User2 u2 = new User2();u2.setName("dhp");u2.setAge(20);u2.setBirth("2000-12-15 12:30:23");
        User2 u3 = new User2();u3.setName("kenan");u3.setAge(10);u3.setBirth("2020-08-11 10:26:32");
        User2 u4 = new User2();u4.setName("xxx");u4.setAge(20);u4.setBirth("2009-11-15 11:30:23");
        list2.add(u2); list2.add(u3); list2.add(u4);

        List result = Stream.of(list1,list2)
                .flatMap(Collection::stream).distinct().collect(Collectors.toList());


        ComparatorTime comparator=new ComparatorTime();
        Collections.sort(result, comparator);
        System.out.println("正序："+new Gson().toJson(result));


        Collections.reverse(result);
        System.out.println("逆序："+new Gson().toJson(result));

        /*Collections.sort(result, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2).compareTo(Integer.valueOf(o1));
            }
        });*/
       /* List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();

        result.forEach(item->{
            Map<String, Object> map = JSON.parseObject(JSON.toJSONString(item), new TypeReference<Map<String, Object>>() {
            });
            maps.add(map);
            System.out.println(map);
        });

        for(int i=0;i<maps.size();i++){
            for(int j=0;j<maps.size()-i-1;j++){
                if(result.get(j).g("distance")>list.get(j+1).getInteger("distance")){
                    JSONObject r=list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, r);
                }
            }
        }*/



    }

}
