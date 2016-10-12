package fei.tcc.repository;

import fei.tcc.entity.LocationUsedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thiagoretondar on 10/11/16.
 */
public interface LocationUsedRepository extends JpaRepository<LocationUsedEntity, Integer> {
}
