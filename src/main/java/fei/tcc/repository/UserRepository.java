package fei.tcc.repository;

import fei.tcc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thiagoretondar on 10/11/16.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByDeviceId(String deviceId);
}
