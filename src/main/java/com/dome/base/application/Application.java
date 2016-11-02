package com.dome.base.application;

/**
 * Created by akalamichael on 10/20/16.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dome.base.application.exception.ComponentNotFoundException;

public class Application implements ApplicationContextHandler{
    
     
     private static final String resource ="/conf/spring/beans.xml";
     private static ApplicationContext context =new ClassPathXmlApplicationContext(resource);

     public  String getComponentName(String name) {
       return null;
     }
    
     public static Object getComponent(String name) throws ComponentNotFoundException{
       return context.getBean(name);
     }
}
