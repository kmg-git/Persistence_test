package com.example.persistence_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EntityAService {
    private final EntityARepository entityARepository;
    private final EntityBRepository entityBRepository;

    @Transactional
    public EntityA create(String text, EntityB B){
        EntityA entityA = new EntityA(text,B);
        entityARepository.save(entityA);
        return entityA;
    }

    @Transactional(readOnly = true)
    public void findAll(){
        entityARepository.findAll();

        for(int i = 1; i < 6; i++){
            find(i);
        }
    }

    @Transactional(readOnly = true)
    public void find(int i){
        EntityA entityA = entityARepository.findById((long) i).orElseThrow(() -> new NoSuchElementException("없음"));
        String textB= entityA.getEntityB().getTextB();

    }


    @Transactional(readOnly = true)
    public void findAllByIds(List<String> list){
        entityARepository.findAllByTextAIn(list);

        for(String string : list){
            findByTextA(string);
        }
    }

    @Transactional(readOnly = true)
    public void findByTextA(String string){
        EntityA entityA = entityARepository.findByTextA(string).orElseThrow(() -> new NoSuchElementException("없음"));
        String textB= entityA.getEntityB().getTextB();

    }

}
