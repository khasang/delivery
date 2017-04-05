package io.delivery.service;


public interface TableDAO {
    /**
     * @return status table creation
     * */
    String createCompany();

    /**
     * @return status table insertion
     * */
    String insertCompany();

    /**
     * @return status table updating
     * */
    String updateCompany();

    /**
     * @return status table deleted
     * */
    String deleteCompany();

    /**
     * @return status user
     * */
    String userCompany();

}
