package com.example.persistence_test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class testController {
    private final EntityBService entityBService;
    private final EntityAService entityAService;

    @GetMapping("/create")
    public ResponseEntity<Void> create50(){
        for(int i=1; i<6; i++){
            EntityB B = entityBService.create(i+"B");
            EntityA A = entityAService.create(i+"A",B);

        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test1")
    public ResponseEntity<Void> findtest(){
        entityAService.findAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test2")
    public ResponseEntity<Void> findtest2(){
        List<String> list = List.of("1A","2A","3A","4A","5A");
        entityAService.findAllByIds(list);
        return ResponseEntity.noContent().build();
    }


}
