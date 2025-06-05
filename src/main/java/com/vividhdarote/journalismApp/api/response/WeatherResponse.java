package com.vividhdarote.journalismApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {

    private Current current;
    private Location location;


    @Data
    public class Current{

        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        private int visibility;
        @JsonProperty("is_day")
        private String isDay;
    }

    @Data
    public class Location{
        private String name;
        private String country;
    }


}


