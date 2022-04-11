package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.ArticleEntity;
import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.mapper.ArticleMapper;
import com.lqa.strayanimal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10411
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * todo 搜索
     * @param page
     * @param size
     * @param articleEntity
     * @return
     */
    @Override
    public RespPageBean getArticleByPage(Integer page, Integer size, ArticleEntity articleEntity) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        LambdaQueryWrapper<ArticleEntity> lambdaQueryWrapper = new LambdaQueryWrapper<ArticleEntity>();
        if (page != null && size != null) {
            lambdaQueryWrapper.last("limit #{page}, #{size}");
        }
        List<ArticleEntity> articleEntityList = articleMapper.selectList(lambdaQueryWrapper);
        Long total = articleMapper.selectCount(new LambdaQueryWrapper<>());
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(articleEntityList);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Override
    public Integer addArticle(ArticleEntity articleEntity) {
        return articleMapper.insert(articleEntity);
    }

    @Override
    public ArticleEntity getArticleById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public Integer updateArticle(ArticleEntity articleEntity) {
        return articleMapper.updateById(articleEntity);
    }

    @Override
    public Integer deleteArticleById(Integer id) {
        return articleMapper.deleteById(id);
    }
}
