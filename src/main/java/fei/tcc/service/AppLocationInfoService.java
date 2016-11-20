package fei.tcc.service;

import fei.tcc.dto.LocationInfoDto;
import fei.tcc.entity.LocationUsedEntity;
import fei.tcc.repository.LocationUsedRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static java.time.Instant.ofEpochMilli;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppLocationInfoService {

    private LocationUsedRepository locationUsedRepository;

    private Long lastDatetime;

    private final static Logger LOGGER = Logger.getLogger(AppLocationInfoService.class);

    @Autowired
    public AppLocationInfoService(LocationUsedRepository locationUsedRepository) {
        this.locationUsedRepository = locationUsedRepository;
    }

    public Long saveAll(List<LocationInfoDto> locationInfoList, Long userId) {
        LOGGER.info("Received an amount of " + locationInfoList.size() + " locations for user id " + userId);
        lastDatetime = 0L;

        List<LocationUsedEntity> locationUsedEntityList = new ArrayList<>();

        locationInfoList.forEach(locationInfo -> {
            LocalDateTime dateTimeConverted = ofEpochMilli(locationInfo.getDatetime()).atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
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

        LOGGER.info("Saving " + locationUsedEntityList.size() + " locations for user id " + userId);
        locationUsedRepository.save(locationUsedEntityList);

        LOGGER.info("Returning biggest date in milliseconds: " + lastDatetime + " for user id " + userId);
        return lastDatetime;
    }

}
