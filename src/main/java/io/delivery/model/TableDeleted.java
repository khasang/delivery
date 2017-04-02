package io.delivery.model;

import org.springframework.jdbc.core.JdbcTemplate;

public interface TableDeleted {
    /**
     * Requared for table deleted with constant param
     * @return info about table deleted
     * */
    String deleteCompany();
}
