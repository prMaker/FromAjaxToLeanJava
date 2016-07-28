package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/27.
 */
@Entity
@Table(name = "t_topic")
public class Topic implements Serializable {
    private static final long serialVersionUID = -6477196937995290142L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contentid",unique = true)
    private TopicContent topicContent;

    public Topic() {}

    public Topic(String title) {
        this.title = title;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TopicContent getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(TopicContent topicContent) {
        this.topicContent = topicContent;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topicContent=" + topicContent +
                '}';
    }
}
