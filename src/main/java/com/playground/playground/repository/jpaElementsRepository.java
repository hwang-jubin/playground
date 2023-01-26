package com.playground.playground.repository;

import com.playground.playground.domain.playground_Elements;
import jakarta.persistence.EntityManager;
import net.minidev.json.JSONUtil;

import java.util.List;
import java.util.Optional;

public class jpaElementsRepository {

    private final EntityManager em;


    public jpaElementsRepository(EntityManager em) {
        this.em = em;
    }


    public playground_Elements save(playground_Elements playground_elements) {
        em.persist(playground_elements); //em을 영구적으로 저장(persist)
        return playground_elements;
    }
//이렇게 하면 insert쿼리 넣어서 다 집어넣고 member에 setId까지 해줌


    public Optional<playground_Elements> findById(Long id) {
        playground_Elements elements = em.find(playground_Elements.class, id);//조회하기
        return Optional.ofNullable(elements);//없을 수도 있으니까 이렇게 감싸주기
    }



    public List<playground_Elements> findAll() {
        return em.createQuery("select m from playground_Elements m", playground_Elements.class)//Member as m
                .getResultList(); //Member 객체 자체(entity)를 상대로 query 를 날림. 객체 자체를 select
    }


}
