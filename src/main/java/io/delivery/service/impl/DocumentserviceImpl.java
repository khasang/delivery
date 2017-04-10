package io.delivery.service.impl;

import io.delivery.dao.Basicdao;
import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("documentService")
public class DocumentserviceImpl implements DocumentService{
    @Autowired
    DocumentDao documentDao;

    @Override
    public List<Document> getDocumentList() {
        return documentDao.getList();
    }

    @Override
    public List<Document> findByName(String name) {
        return documentDao.findByName(name);
    }
}
