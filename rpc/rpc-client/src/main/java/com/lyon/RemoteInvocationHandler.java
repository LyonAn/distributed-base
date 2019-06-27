/********************************************
 * 文件名称: RemoteInvocationHandler.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/25 23:35
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author an.lv
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setMethodName(method.getName());
        request.setClassName(method.getDeclaringClass().getName());
        request.setParameters(args);

        RpcNetTransport transport = new RpcNetTransport(host, port);
        Object result = transport.send(request);
        return result;
    }
}
