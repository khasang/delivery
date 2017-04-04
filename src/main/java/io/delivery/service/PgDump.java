package io.delivery.service;

public interface PgDump {
    /**
     * Make dump of database
     * @return status result of operation
     */
    String dump();
}
