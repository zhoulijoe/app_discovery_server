package com.zhou.appdiscovery;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory servletContainerFactory = new TomcatEmbeddedServletContainerFactory();

        servletContainerFactory.addAdditionalTomcatConnectors(createAJPConnector());

        return servletContainerFactory;
    }

    /**
     * Create a AJP connector on port 8009 for Apache HTTP server to connect to
     *
     * @return APJ connector
     */
    private Connector createAJPConnector() {
        Connector connector = new Connector("AJP/1.3");

        connector.setPort(8009);

        return connector;
    }
}
