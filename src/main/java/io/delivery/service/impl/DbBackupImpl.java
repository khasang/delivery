package io.delivery.service.impl;

import io.delivery.service.DbBackup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@PropertySource(value = {"classpath:dbBackup.properties"})
public class DbBackupImpl implements DbBackup {
    @Value("${pg_dump.full_path}")
    private String pgDumpFullPath;
    @Value("${pg_dump.backups_directory}")
    private String backupsDirectory;
    @Value("${pg_dump.db_name}")
    private String dbName;
    @Value("${pg_dump.server_host}")
    private String serverHost;
    @Value("${pg_dump.server_port}")
    private String serverPort;
    @Value("${pg_dump.user_name}")
    private String userName;
    @Value("${pg_dump.backup_format}")
    private String backupFormat;
    @Value("${pg_dump.additional_options}")
    private String additionalOptions;

    public DbBackupImpl() {

    }

    public String makeBackup() {
        int exitCode = -1;
        List<String> command = new ArrayList<String>();

        if (pgDumpFullPath != null)
            command.add(pgDumpFullPath);
        if (backupsDirectory != null)
            command.add("--file=" + backupsDirectory + File.pathSeparator + getDbBackupFileName());
        if (backupFormat != null)
            command.add("--format=" + backupFormat);
        if (dbName != null)
            command.add("--dbname=" + dbName);
        if (serverHost != null)
            command.add("--host=" + serverHost);
        if (serverPort != null)
            command.add("--port=" + serverPort);
        if (userName != null)
            command.add("--user=" + userName);
        if (additionalOptions != null)
            command.add(additionalOptions);
        command.add("--no-password");

        ProcessBuilder processBuilder = new ProcessBuilder(command);
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

    private String getDbBackupFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'_'HHmmss");

        String fileName = "DeliveryDbBackup_" +
                LocalDateTime.now().format(formatter) +
                ".tar";
        return fileName;
    }
}
