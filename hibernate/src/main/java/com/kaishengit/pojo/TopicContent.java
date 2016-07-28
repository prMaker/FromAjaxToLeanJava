package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/27.
 */
@Entity
@Table(name = "t_topic_content")
public class TopicContent implements Serializable {
    private static final long serialVersionUID = -6704621717306724554L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    public TopicContent(String content) {
        this.content = content;
    }

    public TopicContent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TopicContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
