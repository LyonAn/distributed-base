/********************************************
 * 文件名称: ProcessHandler.java
 * 系统名称: xRiskPlus 市场风险管理系统V5.0
 * 模块名称: 
 * 软件版权: 衡泰软件有限公司
 * 功能说明: 
 * 系统版本: 5.0.0.1
 * 开发人员: an.lv
 * 开发时间: 2019/6/25 22:57
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 
 程序版本		修改日期		修改人员		修改单编号		修改说明
 *********************************************/
package com.lyon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * RPC 请求处理类
 * @author an.lv
 */
public class ProcessHandler implements Runnable {

    private Socket socket;

    private Map<String, Object> handlerMap;

    public ProcessHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;

        ObjectOutputStream outputStream = null;

        try {
            inputStream = new ObjectInputStream(socket.getInputStream());

            RpcRequest request = (RpcRequest) inputStream.readObject();

            Object result = invoke(request);

            outputStream = new ObjectOutputStream(socket.getOutputStream());

            outputStream.writeObject(result);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取请求参数：接口，方法，方法入参
        String serviceName = request.getClassName();
        String methodName = request.getMethodName();
        Object[] args = request.getParameters();


        Object service = handlerMap.get(serviceName);
        //检查是否有实现类
        if(service == null){
            throw new RuntimeException("service not found : " + serviceName);
        }


        Method method = null;
        Class clazz = Class.forName(request.getClassName());
        //如果参数不为空，则获取所有参数的类型，匹配带参的方法
        if(args != null) {
            Class<?>[] types = new Class<?>[args.length];
            for (int i = 0 ; i < args.length; i++){
                types[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, types);
        }else{
            method = clazz.getMethod(methodName);
        }

        Object result = method.invoke(service, args);
        return result;
    }
}
