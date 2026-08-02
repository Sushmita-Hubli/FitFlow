package com.fitness.activityservice.service;


import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
  private final UserValidationService userValidationService;

    public ActivityResponse trackActivity(ActivityRequest request) {

        boolean isValidUser= userValidationService.validateUser(request.getUserId());

        if(!isValidUser){
           throw new RuntimeException("Invalid user id"+ request.getUserId());
        }
        Activity activity=new Activity();
        activity.setUserId(request.getUserId());
        activity.setDuration(request.getDuration());
        activity.setType(request.getType());
        activity.setAdditionalMetrics(request.getAdditionalMetrics());
        activity.setCaloriesBurned(request.getCaloriesBurned());
        activity.setStartTime(request.getStartTime());

        Activity savedactivity=activityRepository.save(activity);
        //ActivityResponse activityResponse=new ActivityResponse();

//        activityResponse.setId(savedactivity.getId());
//        activityResponse.setAdditionalMetrics(savedactivity.getAdditionalMetrics());
//        activityResponse.setDuration(savedactivity.getDuration());
//        activityResponse.setType(savedactivity.getType());
//        activityResponse.setStartTime(savedactivity.getStartTime());
//        activityResponse.setCaloriesBurned(savedactivity.getCaloriesBurned());
//        activityResponse.setCreatedAt(activity.getCreatedAt());
//        activityResponse.setUpdatedAt(activity.getUpdatedAt());
//        activityResponse.setUserId(activity.getUserId());
//
//        return activityResponse;
        return mapToResponse(savedactivity);



    }

    private ActivityResponse mapToResponse(Activity savedactivity) {

        ActivityResponse activityResponse=new ActivityResponse();

        activityResponse.setId(savedactivity.getId());
        activityResponse.setAdditionalMetrics(savedactivity.getAdditionalMetrics());
        activityResponse.setDuration(savedactivity.getDuration());
        activityResponse.setType(savedactivity.getType());
        activityResponse.setStartTime(savedactivity.getStartTime());
        activityResponse.setCaloriesBurned(savedactivity.getCaloriesBurned());
        activityResponse.setCreatedAt(savedactivity.getCreatedAt());
        activityResponse.setUpdatedAt(savedactivity.getUpdatedAt());
        activityResponse.setUserId(savedactivity.getUserId());

        return activityResponse;
    }
}
