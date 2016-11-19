package fei.tcc.service;

import fei.tcc.dto.ParentCreationDto;
import fei.tcc.dto.ParentLoginDto;
import fei.tcc.dto.UserLoginIdResponseDto;
import fei.tcc.entity.ParentEntity;
import fei.tcc.exception.ParentAlreadyExistsException;
import fei.tcc.repository.ParentRepository;
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

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    /**
     * Creates in repository a new parent model
     *
     * @param parentCreationDto DTO for parent creation
     * @return id of new parent created
     */
    public UserLoginIdResponseDto create(ParentCreationDto parentCreationDto) throws ParentAlreadyExistsException {

        if (!existsEmail(parentCreationDto)) {
            ParentEntity parentEntity = new ParentEntity();
            copyProperties(parentCreationDto, parentEntity);

            ParentEntity savedParent = parentRepository.save(parentEntity);

            return new UserLoginIdResponseDto(true, savedParent.getId());
        }

        throw new ParentAlreadyExistsException("Email already exists");
    }

    /**
     * Verify if exists user and if exists, returns the ID of the parent user
     *
     * @param parentLoginDto DTO for parent login
     * @return id of parent found
     */
    public UserLoginIdResponseDto login(ParentLoginDto parentLoginDto) {
        ParentEntity parentFound = parentRepository.findByEmailAndPassword(parentLoginDto.getEmail(), parentLoginDto.getPassword());

        if (isNull(parentFound)) {
            return new UserLoginIdResponseDto(false, -1);
        }

        return new UserLoginIdResponseDto(true, parentFound.getId());
    }

    private boolean existsEmail(ParentCreationDto parentCreationDto) {

        Integer emailQuantity = parentRepository.countByEmail(parentCreationDto.getEmail());

        if (emailQuantity != 0) {
            return true;
        }

        return false;
    }
}
