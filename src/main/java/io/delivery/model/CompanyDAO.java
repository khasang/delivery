package io.delivery.model;

public interface CompanyDAO {
    /**
     * Requared for table creation with constant param
     *
     * @return info about table creation
     */
    String createDbTable();

    String createCompany(String name);

    String deleteCompany(String name);

    String updateCompany(String name, String newName);
}