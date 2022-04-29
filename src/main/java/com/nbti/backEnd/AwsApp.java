package com.nbti.backEnd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwsApp {
	
	private static ApplicationContext springApplicationContext;
    
    private static ApplicationContext getApplicationContext() {
         if(springApplicationContext == null) {
              synchronized (ApplicationContext.class) {
                   if(springApplicationContext == null) {
                        springApplicationContext = new AnnotationConfigApplicationContext();
                   }
              }
         }
         return springApplicationContext;
    }
    
    public static<T> T getBean(Class<T> clazz) {
         ApplicationContext context = getApplicationContext();
         AnnotationConfigApplicationContext webContext = null;
         if(context instanceof AnnotationConfigApplicationContext)
              webContext = (AnnotationConfigApplicationContext) context;
         webContext.register(LambdaConfig.class);
         webContext.refresh();
         return webContext.getBean(clazz);
    }

}
