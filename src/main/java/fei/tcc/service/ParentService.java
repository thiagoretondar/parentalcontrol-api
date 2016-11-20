package fei.tcc.service;

import fei.tcc.dto.*;
import fei.tcc.entity.ParentEntity;
import fei.tcc.entity.UserEntity;
import fei.tcc.exception.ParentAlreadyExistsException;
import fei.tcc.repository.ParentRepository;
import fei.tcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * Created by thiagoretondar on 10/1/16.
 */
@Service
public class ParentService {

    private ParentRepository parentRepository;

    private UserRepository userRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository, UserRepository userRepository) {
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates in repository a new parent model
     *
     * @param parentCreationDto DTO for parent creation
     * @return id of new parent created
     */
    public ParentLoginIdResponseDto createParent(ParentCreationDto parentCreationDto) throws ParentAlreadyExistsException {

        if (!existsEmail(parentCreationDto)) {
            ParentEntity parentEntity = new ParentEntity();
            copyProperties(parentCreationDto, parentEntity);

            ParentEntity savedParent = parentRepository.save(parentEntity);

            return new ParentLoginIdResponseDto(true, savedParent.getId());
        }

        return new ParentLoginIdResponseDto(false, -1L);
    }

    /**
     * Verify if exists user and if exists, returns the ID of the parent user
     *
     * @param parentLoginDto DTO for parent loginParent
     * @return id of parent found
     */
    public ParentLoginIdResponseDto loginParent(ParentLoginDto parentLoginDto) {
        ParentEntity parentFound = parentRepository.findByEmailAndPassword(parentLoginDto.getEmail(), parentLoginDto.getPassword());

        if (isNull(parentFound)) {
            return new ParentLoginIdResponseDto(false, -1L);
        }

        return new ParentLoginIdResponseDto(true, parentFound.getId());
    }

    /**
     *  Creates new child user associated to parent
     *
     * @param userChildCreationDto
     * @return
     */
    public UserLoginIdResponseDto createUserChild(UserChildCreationDto userChildCreationDto) {
        UserEntity userByDeviceId = userRepository.findByDeviceId(userChildCreationDto.getDeviceId());

        ParentEntity parentById = parentRepository.findById(userChildCreationDto.getParentId());

        if (isNull(userByDeviceId) && !isNull(parentById)) {
            UserEntity userEntity = new UserEntity();
            copyProperties(userChildCreationDto, userEntity);

            UserEntity savedUser = userRepository.save(userEntity);

            return new UserLoginIdResponseDto(true, savedUser.getId());
        }

        return new UserLoginIdResponseDto(false, -1L);
    }

    private boolean existsEmail(ParentCreationDto parentCreationDto) {

        Integer emailQuantity = parentRepository.countByEmail(parentCreationDto.getEmail());

        if (emailQuantity != 0) {
            return true;
        }

        return false;
    }
}
