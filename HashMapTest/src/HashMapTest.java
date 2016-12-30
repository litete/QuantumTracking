import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/30.
 */
public class HashMapTest {
    public static void testt() throws JsonProcessingException {
        HashMap<String, String> hashmap=new HashMap<String,String>();
        hashmap.put("sss","111");
        hashmap.put("aaa","222");
        HashMap<String,String>hash=new HashMap<String,String>();
        hash.put("111","111");
        Map<String,HashMap>map=new IdentityHashMap<String, HashMap>();
        map.put("data",hashmap);
        map.put("data1",hash);
        HashMap<String,Map> map2=new HashMap<String, Map>();
        map2.put("data2", map);
        ObjectMapper obj=new ObjectMapper();
        String json1=obj.writeValueAsString(map2);
        System.out.println(json1);
    }
   public static void main(String[] args) throws JsonProcessingException {
       testt();
   }
}
