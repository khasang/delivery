package io.delivery.config;

import io.delivery.config.application.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
<<<<<<< Updated upstream
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;
=======

import javax.servlet.*;
>>>>>>> Stashed changes


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter =
                new CharacterEncodingFilter("utf-8", true);
        Filter[] filter = new Filter[]{characterEncodingFilter};
        return filter;
    }

}
