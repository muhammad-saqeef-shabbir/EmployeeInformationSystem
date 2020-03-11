package com.EIS.EmployeeInformationSystem.service;

import com.EIS.EmployeeInformationSystem.model.Employee;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

    @Autowired
    CurrentUser currentUser;

    @Override
    public EbeanServer getObject() throws Exception {
        return createEbeanServer();
    }

    private EbeanServer createEbeanServer() {
        ServerConfig cfg = new ServerConfig();
        cfg.setName("db");
        cfg.setCurrentUserProvider(currentUser);

        Properties properties = new Properties();
        properties.put("ebean.db.ddl.generate", "true");
        properties.put("ebean.db.ddl.run", "true");
        properties.put("datasource.db.databaseUrl","jdbc:postgresql://localhost:5432/postgresspringdb");
        properties.put("datasource.db.databaseDriver", "org.postgresql.Driver");
        properties.put("datasource.db.username", "postgres");
        properties.put("datasource.db.password", "123");

        cfg.loadFromProperties(properties);

        cfg.setDefaultServer(true);

        cfg.addClass(Employee.class);

        EbeanServer server = EbeanServerFactory.create(cfg);
        return server;
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
