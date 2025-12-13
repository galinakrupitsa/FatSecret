package org.example.fatsecret.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Integer age;
    private Integer weight;
    @Column(nullable = true)
    private Double height;
    @Column(nullable = true)
    private Double activity;

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;

    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public void setActivity(Double activity) {
        this.activity = activity;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getWeight() {
        return weight;
    }
    public Double getHeight() {
        return height;
    }
    public Double getActivity() {
        return activity;
    }


}
