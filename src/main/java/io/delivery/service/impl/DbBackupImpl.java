package io.delivery.service.impl;

import io.delivery.service.DbBackup;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbBackupImpl implements DbBackup {
    private static final Logger LOG = Logger.getLogger(DbBackup.class);

    public DbBackupImpl() {
    }

    public String makeBackup() {
        int exitCode = -1;
        Resource resource = new ClassPathResource("dbBackup.properties");

        List<String> command = new ArrayList<String>();
        try {
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            command.add(props.getProperty("pg_dump.full_path", "pg_dump"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'_'HHmmss");
            String fileName = "DbBackup_" +
                    props.getProperty("pg_dump.db_name", "delivery") +
                    "_" +
                    LocalDateTime.now().format(formatter);
            switch (props.getProperty("pg_dump.backup_format", "tar")) {
                case "tar" :
                    fileName += ".tar";
                    break;
                case "plain" :
                    fileName += ".sql";
                    break;
                case "custom" :
                    fileName += ".dump";
                    break;
                case "directory" :
                    break;
                default:
                    fileName += ".tar";
                    break;
            }

            command.add("--file=" + props.getProperty("pg_dump.backups_directory", ".") + File.separator + fileName);
            command.add("--format=" + props.getProperty("pg_dump.backup_format", "tar"));
            command.add("--dbname=" + props.getProperty("pg_dump.db_name", "delivery"));
            command.add("--host=" + props.getProperty("pg_dump.server_host", "localhost"));
            command.add("--port=" + props.getProperty("pg_dump.server_port", "5432"));
            command.add("--user=" + props.getProperty("pg_dump.user_name", "root"));
            command.add(props.getProperty("pg_dump.additional_options", "--no-password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            exitCode = process.waitFor();
            if (exitCode != 0) {
                String line = reader.readLine();
                while (line != null) {
                    LOG.error(line);
                    line = reader.readLine();
                }
                reader.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (exitCode == 0) {
            return "Backup complete";
        }
        else {
            return "Backup failed";
        }
    }
}
