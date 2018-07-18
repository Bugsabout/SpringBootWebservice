package com.lli.webservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

/**
 * 接口实现
 * 
 * @author leftso
 *
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
    targetNamespace = "http://webservice.lli.com/", // 与接口中的命名空间一致,一般是接口的包名倒
    endpointInterface = "com.lli.webservice.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHello(String name) {

        return "Hello ," + name;
    }

    private Map<String, User> userMap = new HashMap<String, User>();

    public CommonServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getUser(String userId) {
//        System.out.println("userMap是:" + userMap);
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><name>吹比龙</name>";
        return xml;
    }

}