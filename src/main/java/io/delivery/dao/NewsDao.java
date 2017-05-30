package io.delivery.dao;

import io.delivery.entity.News;

import java.util.List;

public interface NewsDao extends BasicDao<News>{
    /**
     * Find news by name at database
     *
     * @param name - value name of news
     * @return news
     */
    List<News> findByName(String name);
}
