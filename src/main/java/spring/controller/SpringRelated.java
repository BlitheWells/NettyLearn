package spring.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.service.SpringRelatedService;

import java.util.Date;

@RestController
@RequestMapping("/spring")
public class SpringRelated {

    // BeanFactory 与 FactoryBean
    FactoryBean factoryBean;

    @Autowired
    private SpringRelatedService springRelatedService;

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test(@Param("test") String test) {
        return springRelatedService.formatDate(new Date()) + " controller level : " + test;
    }

}
