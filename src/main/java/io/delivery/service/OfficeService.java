package io.delivery.service;

import io.delivery.entity.Office;

import java.util.List;

public interface OfficeService {
    /**
     * Create new office
     * @param office - current office
     * @return created office
     */
    Office create(Office office);

    List<Office> getOfficeList();

    Office delete(Long id);
}
