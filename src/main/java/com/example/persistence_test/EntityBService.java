package com.example.persistence_test;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EntityBService {
    private final EntityARepository entityARepository;
    private final EntityBRepository entityBRepository;

    @Transactional
    public EntityB create(String text){
        EntityB entityB = new EntityB(text);
        entityBRepository.save(entityB);
        return entityB;
    }
}
