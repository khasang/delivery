package io.delivery.model.impl;


import io.delivery.model.TableDeleted;
import org.springframework.jdbc.core.JdbcTemplate;

public class TableDeletedImpl implements TableDeleted {
    private JdbcTemplate jdbcTemplate;

    public TableDeletedImpl() {
    }

    public TableDeletedImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteCompany(){
        String query = ("DELETE FROM companies WHERE did = 2");
//   insert into companies (////) values ()
//        String query = ("INSERT INTO companies (\n" +
//                "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
//                "    title       varchar(40) NOT NULL,\n" +
//                "    did         integer NOT NULL,\n" +
//                "    date_prod   date,\n" +
//                "    kind        varchar(10),\n" +
//                "    len         interval hour to minute\n" +
//                ");");
//        jdbcTemplate.execute(preQuery);
        jdbcTemplate.execute(query);

        return "table deleted";
    }

}
