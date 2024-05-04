package com.milktea.myspring.boot;

import edu.pnu.myspring.annotations.MySpringApplication;
import edu.pnu.myspring.core.MyApplicationContext;
import edu.pnu.myspring.utils.InputProvider;
import edu.pnu.myspring.web.dispatcher.RequestDispatcher;

public class MySpringApplicationRunner {

    public static MyApplicationContext run(Class<?> clazz, String... args) {

        if (!clazz.isAnnotationPresent(MySpringApplication.class)) {

            throw new RuntimeException("The class must be annotated with @MySpringApplication");

        }



        //displayBanner();

        String basePackage = clazz.getPackageName();

        MyApplicationContext context = new MyApplicationContext(basePackage);

        RequestDispatcher dispatcher = new RequestDispatcher(context, new InputProvider());

        dispatcher.startListening();



        return context;

    }

}