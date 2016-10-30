package fei.tcc.service;

import fei.tcc.dto.MostUsedAppsDto;
import fei.tcc.entity.AppTotalTimeEntity;
import fei.tcc.repository.AppTotalTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppMostUsedService {

    private AppTotalTimeRepository appTotalTimeRepository;

    @Autowired
    public AppMostUsedService(AppTotalTimeRepository appTotalTimeRepository) {
        this.appTotalTimeRepository = appTotalTimeRepository;
    }

    public void saveAll(List<MostUsedAppsDto> mostUsedAppsList, Long userId) {
        mostUsedAppsList.forEach(app -> {
            AppTotalTimeEntity appTotalTimeEntity = appTotalTimeRepository
                    .findByAppName(app.getName())
                    .orElse(new AppTotalTimeEntity(app.getName(), userId));

            Integer hours = Integer.valueOf(app.getTime().split(":")[0]);
            Integer minutes = Integer.valueOf(app.getTime().split(":")[1]);

            appTotalTimeEntity.setHours(hours);
            appTotalTimeEntity.setMinutes(minutes);

            appTotalTimeRepository.save(appTotalTimeEntity);
        });
    }

}
