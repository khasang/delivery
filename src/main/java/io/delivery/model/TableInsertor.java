package io.delivery.model;


import org.springframework.jdbc.core.JdbcTemplate;

public class TableInsertor {
    private JdbcTemplate jdbcTemplate;

    public TableInsertor(){}

    public TableInsertor(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertNewDataIntoTable(){
        jdbcTemplate.execute("insert into companies (code, title, did) values(11111, 'Title_1', 10)");
        return "Data inserted";
    }
}
