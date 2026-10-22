package com.example.persistence_test;

import jakarta.persistence.*;
import lombok.Getter;


@Table(name = "entity_b")
@Entity
@Getter
public class EntityB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_b")
    private String textB;

    protected EntityB(){
    }

    public EntityB(String text){
        this.textB=text;
    }
}
