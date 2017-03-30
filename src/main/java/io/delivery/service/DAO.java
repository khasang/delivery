package io.delivery.service;

public interface DAO {
    /**
     *
     * @return status of creation
     */
    String createTable();

    /**
     *
     * @return number of affected rows
     */
    int insertValues();

    /**
     *
     * @return number of affected rows
     */
    int update();

    /**
     *
     * @return status of operation
     */
    String delete();

    /**
     * make backup
     */
    void backup();
}
