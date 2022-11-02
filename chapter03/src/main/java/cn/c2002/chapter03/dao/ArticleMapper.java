package cn.c2002.chapter03.dao;

import cdnu.webapp.chapter03_01.pojo.Article;
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}


//这是我在github测试的完整的项目。
