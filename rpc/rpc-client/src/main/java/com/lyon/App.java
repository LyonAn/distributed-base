package com.lyon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        RpcProxyClient client = (RpcProxyClient) context.getBean("rpcProxyClient");

        IHelloService service = client.clientProxy(IHelloService.class, "localhost", 8080);

        String result = service.sayHello("你好啊");

        System.out.println(result);
    }
}
