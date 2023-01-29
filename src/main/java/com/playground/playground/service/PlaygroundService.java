package com.playground.playground.service;

import com.playground.playground.domain.playground_Elements;
import com.playground.playground.repository.jpaElementsRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class PlaygroundService {

        private final jpaElementsRepository jpaelementsrepository;

        public PlaygroundService(jpaElementsRepository jpaelementsrepository) {
            this.jpaelementsrepository = jpaelementsrepository;
        }


        /**
         * 전체 요소 조회
         */
        public List<playground_Elements> findMembers() {
            return jpaelementsrepository.findAll();
        }

        public Optional<playground_Elements> findOne(Long id) {
            return jpaelementsrepository.findById(id);
        }
    }


