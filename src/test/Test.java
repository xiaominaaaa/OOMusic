;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        Users user1 = new Users();
        user1.setId(1);
        user1.setUsername("susu");
        user1.setPassword("123");

        Users user2 = new Users();
        user2.setId(2);
        user2.setUsername("tutu");
        user2.setPassword("456");

        List<Users> list = new ArrayList<Users>();
        list.add(user1);
        list.add(user2);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(list);

        System.out.println(result);

        List<Users> us = mapper.readValue(result,List.class);
        System.out.println(us);
        for (Users users:list){
            System.out.println(users);
        }

    }
}
