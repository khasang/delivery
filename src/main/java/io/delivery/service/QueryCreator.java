package io.delivery.service;

public interface QueryCreator {
    /**
     * @return query's status
     * @return query
     */
    String createQuery(SetQuery setQuery, String query);

    /**
     * @return query's status
     */
    String updateQuery(String status);

    /**
     * @return query's status
     */
    String pgDump();
}
