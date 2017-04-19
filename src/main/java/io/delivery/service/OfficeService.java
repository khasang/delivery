package io.delivery.service;

import io.delivery.entity.Office;

import java.util.List;

/**
 * Created by NortT on 16.04.2017.
 */
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
