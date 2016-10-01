package fei.tcc.repository;

import fei.tcc.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thiagoretondar on 10/1/16.
 */
public interface ParentRepository extends JpaRepository<ParentEntity, Integer> {

    ParentEntity findByEmailAndPassword(String email, String password);

}
