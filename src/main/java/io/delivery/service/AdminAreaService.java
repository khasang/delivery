package io.delivery.service;

import io.delivery.entity.AdminArea;

import java.util.List;

public interface AdminAreaService {
    /**
     * Receive all adminArea from db
     *
     * @return adminArea list
     */
    List<AdminArea> getAdminAreaList();

    /**
     * Find adminArea by name at database
     *
     * @param name - value name of adminArea
     * @return adminArea
     */
    List<AdminArea> findByName(String name);

    /**
     * Create adminArea at database
     *
     * @param adminArea - current adminArea for creation
     * @return created adminArea
     */
    AdminArea create(AdminArea adminArea);

    /**
     * @param adminArea - adminArea for update
     * @return adminArea
     */
    AdminArea updateAdminArea(AdminArea adminArea);

    /**
     * @param id = adminArea id
     * @return deleted adminArea
     */
    AdminArea deleteAdminArea (long id);

    AdminArea findById(long id);
}
