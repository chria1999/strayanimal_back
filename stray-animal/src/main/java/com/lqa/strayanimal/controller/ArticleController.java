package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.ArticleEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10411
 */
@RestController
@Api(tags = "文章内容管理")
@RequestMapping("/article/info")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    @ApiOperation(value = "分页查询")
    public RespPageBean getArticleByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, ArticleEntity articleEntity) {
        return articleService.getArticleByPage(page, size, articleEntity);
    }

    @PostMapping("/")
    @ApiOperation(value = "发布文章")
    public RespBean addArticle(@RequestBody ArticleEntity articleEntity) {
        if (articleService.addArticle(articleEntity) == 1) {
            return RespBean.ok("发布成功");
        }
        return RespBean.error("发布失败");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看详细内容")
    public ArticleEntity getArticleById(@PathVariable("id") Integer id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/")
    @ApiOperation(value = "更新文章内容")
    public RespBean updateArticle(@RequestBody ArticleEntity articleEntity) {
        if (articleService.updateArticle(articleEntity) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除一篇文章")
    public RespBean deleteArticleById(@PathVariable("id") Integer id) {
        if (articleService.deleteArticleById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
