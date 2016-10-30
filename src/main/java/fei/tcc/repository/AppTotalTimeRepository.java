package fei.tcc.repository;

import fei.tcc.entity.AppTotalTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by thiagoretondar on 10/11/16.
 */
public interface AppTotalTimeRepository extends JpaRepository<AppTotalTimeEntity, Integer> {

    Optional<AppTotalTimeEntity> findByAppName(String name);
}
