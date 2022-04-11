package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.ArticleEntity;
import com.lqa.strayanimal.entity.RespPageBean;

/**
 * @author 10411
 */
public interface ArticleService extends IService<ArticleEntity> {

    /**
     * 分页查询
     * @param page
     * @param size
     * @param articleEntity
     * @return
     */
    RespPageBean getArticleByPage(Integer page, Integer size, ArticleEntity articleEntity);

    /**
     * 发布文章
     * @param articleEntity
     * @return
     */
    public Integer addArticle(ArticleEntity articleEntity);

    /**
     * 查看详细内容
     * @param id
     * @return
     */
    public ArticleEntity getArticleById(Integer id);

    /**
     * 更新文章内容
     * @param articleEntity
     * @return
     */
    public Integer updateArticle(ArticleEntity articleEntity);

    /**
     * 删除一篇文章
     * @param id
     * @return
     */
    public Integer deleteArticleById(Integer id);

}
