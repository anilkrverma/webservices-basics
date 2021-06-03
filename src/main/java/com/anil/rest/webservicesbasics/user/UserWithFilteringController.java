package com.anil.rest.webservicesbasics.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class UserWithFilteringController {

    @GetMapping(value = "/users-filter")
    public List<UserWithFiltering> getAllUsers() {
        return Arrays.asList(new UserWithFiltering(11, "Anil - 1", new Date()), new UserWithFiltering(21, "Anil - 2", new Date()));
    }


    @GetMapping(value = "/users-filter-dynamic")
    public MappingJacksonValue getAllUsersWithDynamicFilter() {
        List<UserWithFiltering> users = Arrays.asList(new UserWithFiltering(11, "Anil - 1", new Date()), new UserWithFiltering(21, "Anil - 2", new Date()));

        SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("My Filter", beanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filterProvider);

        return mapping;
    }

    @GetMapping(value = "/users-filter-dynamic-2")
    public MappingJacksonValue getAllUsersWithDynamicFilter2() {
        List<UserWithFiltering> users = Arrays.asList(new UserWithFiltering(11, "Anil - 1", new Date()), new UserWithFiltering(21, "Anil - 2", new Date()));

        SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("My Filter", beanPropertyFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filterProvider);

        return mapping;
    }

}
