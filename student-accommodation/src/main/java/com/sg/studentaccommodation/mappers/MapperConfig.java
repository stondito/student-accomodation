package com.sg.studentaccommodation.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public final class MapperConfig {

    @Bean
    public ModelMapper mapper() {
      return new ModelMapper();
    }
}
