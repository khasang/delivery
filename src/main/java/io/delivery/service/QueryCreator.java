package io.delivery.service;

public interface QueryCreator {
    /**
     *
     * @return query
     */
    String createQuery(SetQuery setQuery, String query);
}
