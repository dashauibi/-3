package cn.c2002.chapter03.domain;


import lombok.Data;

import javax.persistence.*;


@Entity(name = "t_comment")
public class Discuss {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "aId")
    private Integer aId;
    private String content;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", aId=" + aId +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
