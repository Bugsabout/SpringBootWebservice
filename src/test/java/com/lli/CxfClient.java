package com.lli;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.XmlUtil;
import com.lli.webservice.CommonService;
import com.lli.webservice.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Arrays;

public class CxfClient {
    public static void main(String[] args) throws Exception {
        String param = Base64.encode(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<request>" +
                "<AHDM>" + Base64.encode("1234") + "</AHDM>" +
                "</request>");
        System.out.println(param);
        cl1(param);
    }

    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static void cl1(String param) {
        try {
            // 接口地址
            String address = "http://localhost:9999/services/CommonService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            // 创建一个代理接口实现
            CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
            // 数据准备
//            String userName = "Leftso";
            // 调用代理接口的方法调用并返回结果
            String result = cs.sayHello(param);
            String decodeStr = Base64.decodeStr(result);
            System.out.println("返回结果:\n" +decodeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用方式
     *
     * @throws Exception
     */
    public static void cl2() throws Exception {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf
                .createClient("http://localhost:9999/services/CommonService?wsdl");
        // getUser 为接口中定义的方法名称 张三为传递的参数 返回一个Object数组
        Object[] objects = client.invoke("getUser", "411001");
        for (Object object : objects) {
            User ss = (User) object;
            System.err.println(ss);
        }

        // 输出调用结果
        System.out.println(((User) objects[0]).getAge());
        System.out.println(objects[0].toString());
    }
}