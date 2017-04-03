package io.delivery.service;

public interface DBOperations {
    String createTable();
    String insertToTable();
    String deleteFromTable();
    String updateTable();
    String backUp();
}
