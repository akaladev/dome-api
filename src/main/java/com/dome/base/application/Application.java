package com.dome.base.application;

/**
 * Created by akalamichael on 10/20/16.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dome.base.application.exception.ComponentNotFoundException;

public class Application implements ApplicationContextHandler{
    
     private ApplicationContext context;
     private final String resource ="/conf/spring/beans.xml";

    public Application(){
        context =
                new ClassPathXmlApplicationContext(resource);
    }

     public  Object getComponent(String name) throws ComponentNotFoundException{
       return context.getBean(name);
     }
}
