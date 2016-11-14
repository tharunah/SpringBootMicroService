package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.inject.Named;

/**
 * Created by tharu on 11/13/2016.
 */
@Configuration
public class CustomerBackendApplicatonConfig {

    @Named
    static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.packages("com.example.rest");
        }
    }
}
