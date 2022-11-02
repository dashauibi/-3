package cn.c2002.chapter03.mapper;

import cn.c2002.chapter03.domain.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public Article selectArticle(Integer id);
    public int updateArticle(Article article);
    public int insertArticle(Article article);

}
