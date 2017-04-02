package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public interface TableInsertor {
    /**
     * Requared for table inseryion with constant param
     * @return info about table insertion
     * */
    String insertCompany();

}
