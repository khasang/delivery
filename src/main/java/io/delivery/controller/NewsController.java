package io.delivery.controller;

import io.delivery.entity.News;
import io.delivery.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    final private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<News> getNewsList(){
        return newsService.getNewsList();
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<News> getNewsByName(@PathVariable(value = "name") String name){
        return newsService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public News addNews(@RequestBody News news){
        newsService.create(news);
        return news;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public News updateNews(@RequestBody News news){
        newsService.updateNews(news);
        return news;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public News deleteNews(@PathVariable(value = "id") String inputId){
        return newsService.deleteNews(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public News getNewsById(@PathVariable(value = "id") String id){
        return newsService.findById(Long.parseLong(id));
    }
}
