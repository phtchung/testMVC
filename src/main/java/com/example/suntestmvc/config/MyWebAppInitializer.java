package com.example.suntestmvc.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        ServletRegistration.Dynamic registration = container.addServlet("SunTestMVC",new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/**");
    }
}
