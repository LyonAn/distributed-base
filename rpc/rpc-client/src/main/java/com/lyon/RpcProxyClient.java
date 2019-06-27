/********************************************
 * 文件名称: RpcProxyClient.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/25 23:31
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author an.lv
 */
@Component
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls, String host, int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},
                new RemoteInvocationHandler(host, port));
    }
}
