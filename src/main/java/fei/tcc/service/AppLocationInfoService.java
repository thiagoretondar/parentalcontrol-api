package fei.tcc.service;

import fei.tcc.dto.LocationInfoDto;
import fei.tcc.entity.LocationUsedEntity;
import fei.tcc.repository.LocationUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppLocationInfoService {

    private LocationUsedRepository locationUsedRepository;

    private LocalDateTime lastDatetime;

    @Autowired
    public AppLocationInfoService(LocationUsedRepository locationUsedRepository) {
        this.locationUsedRepository = locationUsedRepository;
    }

    public LocalDateTime saveAll(List<LocationInfoDto> locationInfoList, Long userId) {
        lastDatetime = LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0);

        List<LocationUsedEntity> locationUsedEntityList = new ArrayList<>();

        locationInfoList.forEach(locationInfo -> {
            locationUsedEntityList.add(new LocationUsedEntity(
                    locationInfo.getDatetime(),
                    locationInfo.getLatitude(),
                    locationInfo.getLongitude(),
                    userId
            ));

            if (locationInfo.getDatetime().isAfter(lastDatetime)) {
                lastDatetime = locationInfo.getDatetime();
            }

        });

        locationUsedRepository.save(locationUsedEntityList);

        return lastDatetime;
    }

}
