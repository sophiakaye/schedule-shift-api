package com.example.schedule.processor;

import com.example.schedule.dto.EngineerDto;
import com.example.schedule.utils.WheelConstants;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EngineerPoolPreparator {

    public List<EngineerDto> createEngineerPool() {

        return seedEngineer()
                .stream()
                .limit(WheelConstants.MAX_ENGINEER_PER_PERIOD)
                .collect(Collectors.toList());
    }

    private List<EngineerDto> seedEngineer() {

        return new ArrayList<>() {{
            add(new EngineerDto(1L, "Bob"));
            add(new EngineerDto(2L, "Alice"));
            add(new EngineerDto(3L, "Antoine"));
            add(new EngineerDto(4L, "Amelie"));
            add(new EngineerDto(5L, "Marc"));
            add(new EngineerDto(6L, "Giselle"));
            add(new EngineerDto(7L, "Jean"));
            add(new EngineerDto(8L, "Sebastian"));
            add(new EngineerDto(9L, "Kate"));
            add(new EngineerDto(10L, "Luc"));
        }};
    }
}
