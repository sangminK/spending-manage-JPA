package me.smkim.spending.repository;

import me.smkim.spending.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getId();    // 커멘드와 쿼리의 분리
    }

    public User find(Long id) {
        return em.find(User.class, id);
    }
}
