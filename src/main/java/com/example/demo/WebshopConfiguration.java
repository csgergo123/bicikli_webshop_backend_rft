package com.example.demo;

import com.example.demo.entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class WebshopConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Bicikli.class);
        config.exposeIdsFor(Kepek.class);
        config.exposeIdsFor(Rendeles.class);
        config.exposeIdsFor(RendelesTetel.class);
    }
}