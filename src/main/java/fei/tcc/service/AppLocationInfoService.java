package fei.tcc.service;

import fei.tcc.dto.LocationInfoDto;
import fei.tcc.entity.LocationUsedEntity;
import fei.tcc.repository.LocationUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppLocationInfoService {

    private LocationUsedRepository locationUsedRepository;

    @Autowired
    public AppLocationInfoService(LocationUsedRepository locationUsedRepository) {
        this.locationUsedRepository = locationUsedRepository;
    }

    public void saveAll(List<LocationInfoDto> locationInfoList, Long userId) {
        List<LocationUsedEntity> locationUsedEntityList = new ArrayList<>();

        locationInfoList.forEach(locationInfo -> {
            locationUsedEntityList.add(new LocationUsedEntity(
                    locationInfo.getDatetime(),
                    locationInfo.getLatitude(),
                    locationInfo.getLongitude(),
                    userId
            ));
        });

        locationUsedRepository.save(locationUsedEntityList);
    }

}
