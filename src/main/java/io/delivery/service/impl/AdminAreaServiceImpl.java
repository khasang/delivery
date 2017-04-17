package io.delivery.service.impl;

import io.delivery.dao.AdminAreaDao;
import io.delivery.dao.DocumentDao;
import io.delivery.entity.AdminArea;
import io.delivery.entity.Document;
import io.delivery.service.AdminAreaService;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminAreaService")
public class AdminAreaServiceImpl implements AdminAreaService {

    @Autowired
    AdminAreaDao adminAreaDao;

    @Override
    public List<AdminArea> getAdminAreaList() {
        return adminAreaDao.getList();
    }

    @Override
    public List<AdminArea> findByName(String name) {
        return adminAreaDao.findByName(name);
    }

    @Override
    public AdminArea create(AdminArea adminArea) {
        return adminAreaDao.create(adminArea);
    }

    @Override
    public AdminArea updateAdminArea(AdminArea adminArea) {
        return adminAreaDao.update(adminArea);
    }

    @Override
    public AdminArea deleteAdminArea(long id) {
        return adminAreaDao.delete(findById(id));
    }

    @Override
    public AdminArea findById(long id) {
        return adminAreaDao.findById(id);
    }
}
