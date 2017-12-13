package io.delivery.service;

import org.springframework.jdbc.core.JdbcTemplate;

public interface PreparedSQL {
    String execute();
}
