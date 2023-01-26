package com.playground.playground;

import com.playground.playground.repository.jpaElementsRepository;
import com.playground.playground.service.detailService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Transactional
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public detailService memberService() {
        return new detailService(jpaElementsRepository());
    }

    @Bean
    public jpaElementsRepository jpaElementsRepository() {

        return new jpaElementsRepository(em);
    }

}
