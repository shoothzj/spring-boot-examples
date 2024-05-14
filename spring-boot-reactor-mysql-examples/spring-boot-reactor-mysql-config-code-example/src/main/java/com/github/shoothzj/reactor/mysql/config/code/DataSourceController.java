package com.github.shoothzj.reactor.mysql.config.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {
    @Autowired(required = false)
    @Qualifier("secondaryDatabaseClient")
    private DatabaseClient databaseClient;
}
