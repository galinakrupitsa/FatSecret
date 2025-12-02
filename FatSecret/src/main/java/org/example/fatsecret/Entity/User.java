package org.example.fatsecret.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private int age;
    private int weight;
    @Column(nullable = true)
    private int height;
    @Column(nullable = true)
    private Double activity;

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;

    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setActivity(double activity) {
        this.activity = activity;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public double getActivity() {
        return activity;
    }


}
