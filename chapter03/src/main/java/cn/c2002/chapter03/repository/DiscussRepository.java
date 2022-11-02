package cn.c2002.chapter03.repository;

import cn.c2002.chapter03.domain.Discuss;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
    public List<Discuss> findByAuthorNotNull();
    public List<Discuss> findByContentNotNull();
    @Query(value = "SELECT c FROM t_comment c WHERE c.aId = ?1")
    public List<Discuss> getDiscussPaged(Integer aid,Pageable pageable);

    @Query(value = "SELECT * FROM t_comment WHERE aId = ?1",nativeQuery = true)
    public List<Discuss> getDiscussPaged2(Integer aid,Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_comment c SET c.author = ?1 WHERE c.id = ?2")
    public int updateDiscuss(String author,Integer id);
    @Transactional
    @Modifying
    @Query(value = "DELETE from t_comment c WHERE c.id = ?1")
    public int deleteDiscuss(Integer id);
    @Transactional
    @Modifying
    @Query(value = "INSERT into t_comment(aId,content,author) values(?1,?2,?3)",nativeQuery = true)
    public int insertDiscuss(int aid, String content,  String author);
}
