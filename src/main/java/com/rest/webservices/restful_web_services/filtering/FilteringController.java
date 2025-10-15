package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        FilteringBean filteringBean = new FilteringBean("field-1", "field-2", "field-3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("FilteringBeanJsonFilter", filter);

        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<FilteringBean> filteringBeanList = Arrays.asList(
                new FilteringBean("field-1", "field-2", "field-3"),
                new FilteringBean("field-4", "field-5", "field-6"),
                new FilteringBean("field-7", "field-8", "field-9")
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBeanList);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field2", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("FilteringBeanJsonFilter", filter);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
