package com.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Size(min = 3, message = "Description has to be min 3 char!")
    private String Description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    protected Post() {}
    public Post(Integer id, String description) {
        Id = id;
        Description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", Description='" + Description + '\'' +
                '}';
    }
}
