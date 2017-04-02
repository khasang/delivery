package io.delivery.service.impl;

import io.delivery.service.DumpDB;
import java.io.IOException;

public class DumpDbImpl implements DumpDB {

    public DumpDbImpl(){}

    @Override
    public String execute() {
        String postgre = System.getenv("POSTGRESQL");
        System.out.println(postgre);
        String command = "cmd.exe /C \""+postgre+"\\pg_dump.exe\" -f D:\\dump.sql -F p -U root delivery";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Dumped";
    }
}
