package fei.tcc.service;

import fei.tcc.dto.MostUsedAppsDto;
import fei.tcc.entity.AppTotalTimeEntity;
import fei.tcc.repository.AppTotalTimeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppMostUsedService {

    private AppTotalTimeRepository appTotalTimeRepository;

    private final static Logger LOGGER = Logger.getLogger(AppMostUsedService.class);

    @Autowired
    public AppMostUsedService(AppTotalTimeRepository appTotalTimeRepository) {
        this.appTotalTimeRepository = appTotalTimeRepository;
    }

    public void saveAll(List<MostUsedAppsDto> mostUsedAppsList, Long userId) {
        LOGGER.info("Received an amount of " + mostUsedAppsList.size() + " most used apps for user id " + userId);

        mostUsedAppsList.forEach(app -> {
            LOGGER.info("Stating to save or update app: " + app.getName());
            AppTotalTimeEntity appTotalTimeEntity = appTotalTimeRepository
                    .findByAppName(app.getName())
                    .orElse(new AppTotalTimeEntity(app.getName(), userId));

            Integer hours = app.getHours();
            Integer minutes = app.getMinutes();

            if (!hours.equals(appTotalTimeEntity.getHours()) || !minutes.equals(appTotalTimeEntity.getMinutes())) {
                LOGGER.info("Hours of app " + app.getName() + " BEFORE saving: " + appTotalTimeEntity.getHours());
                appTotalTimeEntity.setHours(hours);

                LOGGER.info("Minutes of app " + app.getName() + " BEFORE saving: " + appTotalTimeEntity.getMinutes());
                appTotalTimeEntity.setMinutes(minutes);

                appTotalTimeRepository.save(appTotalTimeEntity);
                LOGGER.info("Hours of app " + app.getName() + " AFTER saving: " + appTotalTimeEntity.getHours());
                LOGGER.info("Minutes of app " + app.getName() + " AFTER saving: " + appTotalTimeEntity.getMinutes());
            }
        });

        LOGGER.info("Finished saving most used apps");
    }

}
