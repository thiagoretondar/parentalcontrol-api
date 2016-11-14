package fei.tcc.service;

import fei.tcc.dto.LocationInfoDto;
import fei.tcc.entity.LocationUsedEntity;
import fei.tcc.repository.LocationUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.Instant.ofEpochMilli;
import static java.time.ZoneId.systemDefault;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppLocationInfoService {

    private LocationUsedRepository locationUsedRepository;

    private Long lastDatetime;

    @Autowired
    public AppLocationInfoService(LocationUsedRepository locationUsedRepository) {
        this.locationUsedRepository = locationUsedRepository;
    }

    public Long saveAll(List<LocationInfoDto> locationInfoList, Long userId) {
        lastDatetime = 0L;

        List<LocationUsedEntity> locationUsedEntityList = new ArrayList<>();

        locationInfoList.forEach(locationInfo -> {
            LocalDateTime dateTimeConverted = ofEpochMilli(locationInfo.getDatetime()).atZone(systemDefault()).toLocalDateTime();
            locationUsedEntityList.add(new LocationUsedEntity(
                    dateTimeConverted,
                    locationInfo.getLatitude(),
                    locationInfo.getLongitude(),
                    userId
            ));

            if (locationInfo.getDatetime().longValue() > lastDatetime) {
                lastDatetime = locationInfo.getDatetime();
            }

        });

        locationUsedRepository.save(locationUsedEntityList);

        return lastDatetime;
    }

}
