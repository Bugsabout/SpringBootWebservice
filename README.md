# SpringBootWebservice

1、通过git或者svn下载本项目。  

2、通过eclipse或者idea打开本项目，下载相关的mvn依赖，配置字符集utf-8。  

3、运行项目，打开浏览器输入地址：http://localhost:9999/services，可以看到暴露出来的webservice服务。  

4、点击其中的链接，进入wsdl文件，可以看到其中的方法协议。  

5、打开项目的test目录，找到com.lli中的CxfClient测试类。我们可以看到其中有两个调用方法，cl1()和cl2()，
是静态调用方式调用webservice接口，cl2()是动态调用。一般我们使用cl1()方法调用即可。  

@WebService、@WebParam


private Bus bus;

CommonService commonService;

@Bean
public Endpoint endpoint2() {
    EndpointImpl endpoint = new EndpointImpl(bus, commonService);
    endpoint.publish("/CommonService");
    return endpoint;
}