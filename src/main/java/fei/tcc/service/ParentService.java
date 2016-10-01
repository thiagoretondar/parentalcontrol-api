package fei.tcc.service;

import fei.tcc.dto.ParentCreationDto;
import fei.tcc.dto.ParentLoginDto;
import fei.tcc.entity.ParentEntity;
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
    public Integer create(ParentCreationDto parentCreationDto) {
        ParentEntity parentEntity = new ParentEntity();
        copyProperties(parentCreationDto, parentEntity);

        // TODO validate if there isn't this parent registered already

        ParentEntity savedParent = parentRepository.save(parentEntity);

        return savedParent.getId();
    }

    /**
     * Verify if exists user and if exists, returns the ID of the parent user
     *
     * @param parentLoginDto DTO for parent login
     * @return id of parent found
     */
    public Integer login(ParentLoginDto parentLoginDto) {
        ParentEntity parentFound = parentRepository.findByEmailAndPassword(parentLoginDto.getEmail(), parentLoginDto.getPassword());

        if (isNull(parentFound)) {
            return 0;
        }

        return parentFound.getId();
    }
}
