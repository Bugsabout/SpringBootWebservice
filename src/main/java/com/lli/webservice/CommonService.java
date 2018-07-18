package com.lli.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 接口
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://webservice.lli.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {
    @WebMethod
    String sayHello(@WebParam(name = "userName") String name);

    @WebMethod
    String getUser(@WebParam(name = "xml") String xml);
}