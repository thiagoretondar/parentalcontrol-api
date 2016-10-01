package fei.tcc.service;

import fei.tcc.dto.ParentCreationDto;
import fei.tcc.entity.ParentEntity;
import fei.tcc.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * Created by thiagoretondar on 10/1/16.
 */
@Service
public class ParentCreationService {

    private ParentRepository parentRepository;

    @Autowired
    public ParentCreationService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    /**
     * Creates in repository a new parent model
     *
     * @param parentCreationDto
     * @return id of new parent created
     */
    public Integer create(ParentCreationDto parentCreationDto) {
        ParentEntity parentEntity = new ParentEntity();
        copyProperties(parentCreationDto, parentEntity);

        // TODO validate if there isn't this parent registered already

        ParentEntity savedParent = parentRepository.save(parentEntity);

        return savedParent.getId();
    }

}
