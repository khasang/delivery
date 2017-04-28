package io.delivery.service;

import io.delivery.entity.News;

import java.util.List;

public interface NewsService {
    /**
     * Receive all news from db
     *
     * @return news list
     */
    List<News> getNewsList();

    /**
     * Find news by name at database
     *
     * @param name - value name of news
     * @return news
     */
    List<News> findByName(String name);

    /**
     * Create news at database
     *
     * @param news - current news for creation
     * @return created news
     */
    News create(News news);

    /**
     * @param news - news for updateProduct
     * @return news
     */
    News updateNews(News news);

    /**
     * @param id = news id
     * @return deleted news
     */
    News deleteNews(long id);

    News findById(long id);
}
