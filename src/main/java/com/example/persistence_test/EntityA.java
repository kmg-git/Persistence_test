package com.example.persistence_test;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "entity_a")
@Entity
@Getter
public class EntityA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_a")
    private String textA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_id")
    private EntityB entityB;

    protected EntityA(){
    }

    public EntityA(String text, EntityB B){
        this.textA=text;
        this.entityB =B;
    }
}
