package io.delivery.service.impl;

import io.delivery.dao.NewsDao;
import io.delivery.entity.News;
import io.delivery.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> getNewsList() {
        return newsDao.getList();
    }

    @Override
    public List<News> findByName(String name) {
        return newsDao.findByName(name);
    }

    @Override
    public News deleteNews(long id) {
        return newsDao.delete(findById(id));
    }

    @Override
    public News findById(long id) {
        return newsDao.findById(id);
    }

    @Override
    public News updateNews(News news) {
        return newsDao.update(news);
    }

    @Override
    public News create(News news) {
        return newsDao.create(news);
    }
}
