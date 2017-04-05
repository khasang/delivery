package io.delivery.model.impl;

import io.delivery.model.CompanyDAO;
import io.delivery.service.DbDumpFileNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletContext;
import java.io.*;
import java.sql.Connection;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private ServletContext context;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DbDumpFileNameGenerator dbDumpFileNameGenerator;

    @Autowired
    private String db
    public String createCompanyTable() {
        Resource companiesCreateTableScript = new ClassPathResource("Companies_CreateTable.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(companiesCreateTableScript);

        databasePopulator.execute(jdbcTemplate.getDataSource());
        return "table created";
    }

    public String createCompany(String name) {
        return "created";
    }

    public String dumpDb() {
        int exitCode = -1;
        ProcessBuilder processBuilder = new ProcessBuilder(
                "/Library/PostgreSQL/9.6/bin/pg_dump",
                "--file=" + context.getRealPath(dbDumpFileNameGenerator.getDbDumpFileName()),
                "--no-password",
                "--format=tar",
                "--user=root",
                "delivery");
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            exitCode = process.waitFor();
            String line = reader.readLine();
            while (line != null) {
                System.err.println(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            exitCode = -1;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            exitCode = -1;
        }

        if (exitCode == 0) {
            return "Backup complete";
        }
        else {
            return "Backup failed";
        }
    }
}
