package io.delivery.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementQuery {
    private PreparedStatement preparedStatement;
    public PreparedStatementQuery() {
    }

    public PreparedStatementQuery(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public String createQuety() {
        try {
            preparedStatement.setString(1, "Bingo");
            preparedStatement.setInt(2,2);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "PreparedStatement UPD";
    }
}
