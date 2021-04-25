# portfolio-page-v1

Contains a basic portfolio page created for a simple tutorial to jumpstart on creating a full stack app using reactJS, springboot and MySQL.

You can checkout the portfolio page here: https://porfolio-page-v1.herokuapp.com/

As Heroku does not support MySQL, so I used PostgreSQL to host it there. 
To do the same, you need to make the following changes:

application.properties:
```
server.port=${PORT:5000}

db.driverClassName=org.postgresql.Driver
db.url=jdbc:postgresql://ec2-34-233-0-64.compute-1.amazonaws.com:5432/d2dnsfi46di1ja?sslmode=require
db.username=sjkzachplpceua
db.password=a460bdade718bf25b0be797cacbd7d369c2d6897f97a5199251bbefb30f52e56
```

And in "infra", add a folder "configuration".
In /infra/configuration, add a file "Datasource.java"

```
package com.example.demo.infra.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class Datasource {
    @Value("${db.driverClassName}")
    private String driverClass;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;
    @Bean
    public DriverManagerDataSource dataSource(){
        System.out.println(driverClass+" "+ url+" "+username+" "+password);
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driverClass);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);
        return source;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource());
        return namedParameterJdbcTemplate;
    }
}

```

