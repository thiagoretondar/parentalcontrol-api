package fei.tcc.repository;

import fei.tcc.entity.AppUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thiagoretondar on 10/11/16.
 */
public interface AppUsageRepository extends JpaRepository<AppUsageEntity, Integer> {
}
