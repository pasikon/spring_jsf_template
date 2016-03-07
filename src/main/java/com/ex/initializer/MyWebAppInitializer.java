package com.ex.initializer;

import com.ex.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addListener(new RequestContextListener());

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);

//        ServletRegistration.Dynamic dispatcherS = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
//        dispatcherS.setLoadOnStartup(1);
//        dispatcherS.addMapping("/");

//        ServletRegistration.Dynamic facesS = servletContext.addServlet("FacesServlet", new FacesServlet());
//        facesS.setLoadOnStartup(1);
//        facesS.addMapping("/faces/*");
//        facesS.addMapping("*.jsf");

        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherContext =
//                new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(DispatcherConfig.class);

        // Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher =
//                servletContext.addServlet("facesServlet", new DispatcherServlet(dispatcherContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
    }

}