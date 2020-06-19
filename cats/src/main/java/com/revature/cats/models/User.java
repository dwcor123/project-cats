package com.revature.cats.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(schema = "cat", name = "users")
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
  @Column(name = "username")
  private String username;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.MERGE)
  @JsonIgnoreProperties({"owner"})
  private List<Cat> cats;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<Cat> getCats() {
    return cats;
  }

  public void setCats(List<Cat> cats) {
    this.cats = cats;
    for(Cat c : cats) {
      c.setOwner(this);
    }
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", username=" + username + "]";
  }

}
