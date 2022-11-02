package cn.c2002.chapter03;

import cn.c2002.chapter03.domain.Article;
import cn.c2002.chapter03.domain.Comment;
import cn.c2002.chapter03.domain.Discuss;
import cn.c2002.chapter03.mapper.ArticleMapper;
import cn.c2002.chapter03.mapper.CommentMapper;
import cn.c2002.chapter03.repository.DiscussRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class Chapter03ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void selectComment() {
        Comment comment = commentMapper.findById(1);
        System.out.println("comment 是=========== " + comment);
    }

    @Test
    public void updateData(){
        Comment comment=new Comment();
        comment.setId(4);
        comment.setContent("更新后的评论");
        comment.setAuthor("某人");
        comment.setaId(2);

        int a=commentMapper.updateComment(comment);
        System.out.println("a = ======" + a);
    }
    @Test
    public void selectAll(){
        List<Comment> commentList=commentMapper.findAll();
        System.out.println(commentList);
    }

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }
    @Test
    public void updateArticle(){
        Article article=new Article();
        article.setId(2);
        article.setContent("更新内容");
        article.setTitle("更标题");
        int ret=articleMapper.updateArticle(article);
        System.out.println("ret="+ret);
    }
    @Test
    public void insertArticle(){
        Article article=new Article();
        article.setContent("插入的第4篇内容");
        article.setTitle("插入的第4篇标题");
        int ret=articleMapper.insertArticle(article);
        System.out.println("ret="+ret);
    }

    @Autowired
    private DiscussRepository repository;
    @Test
    public void selectCommentByKeys() {
        List<Discuss> list = repository.findByContentNotNull();
        System.out.println(list);
    }
    @Test
    public void selectCommentAll() {
        List<Discuss> list = repository.findAll();
        System.out.println(list);
    }
    @Test
    public void selectCommentById() {
        Optional<Discuss> list = repository.findById(1);
        System.out.println(list);
        }

    @Test
    public void selectCommentPaged() {
        Pageable pageable = PageRequest.of(0,3);
        List<Discuss> allPaged = repository.getDiscussPaged(1, pageable);
        System.out.println(allPaged);
    }
    //  4、使用Example封装参数进行数据查询操作
    @Test
    public void selectCommentByExample() {
        Discuss discuss =new Discuss();
        //discuss.setAuthor("张三");
        //discuss.setaId(1);
        discuss.setId(6);
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = repository.findAll(example);
        System.out.println(list);
    }
    @Test
    public void selectCommentByExampleMatcher() {
        Discuss discuss =new Discuss();
        discuss.setAuthor("张");
        //ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",startsWith());
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author",contains());
        Example<Discuss> example = Example.of(discuss, matcher);
        List<Discuss> list = repository.findAll(example);
        System.out.println(list);
    }
    @Test
    public void InsertCommentById(){
        String author="章鱼哥";
        int aid=2;
        String content="暂无";

        int one=repository.insertDiscuss(aid,content,author);
        System.out.println("one = " + one);
    }
}
