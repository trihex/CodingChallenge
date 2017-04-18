package com.example;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Configuration
public class WebConfiguration
{
   @Bean
   ServletRegistrationBean h2ServeltRegistration()
   {
      ServletRegistrationBean regBean = new ServletRegistrationBean(new WebServlet());
      regBean.addUrlMappings("/console/*");
      return regBean;
   }
}
