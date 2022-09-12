package com.example.schedule.utils;

import com.example.schedule.dto.EngineerDto;

import java.util.List;
import java.util.Random;

public class RandomEngineerPicker {

    public static EngineerDto pickUp(List<EngineerDto> engineerPool) {

        Random random = new Random();
        return engineerPool.get(random.nextInt(engineerPool.size()));
    }
}
