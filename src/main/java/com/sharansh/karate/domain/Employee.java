package com.sharansh.karate.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id()
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
}
