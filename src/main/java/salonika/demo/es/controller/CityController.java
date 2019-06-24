package salonika.demo.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import salonika.demo.es.bean.City;
import salonika.demo.es.service.CityService;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: penghaoyang
 * @Date: 2019/6/25 00:09
 * @Description: CityController
 */
@RestController
@RequestMapping("/es/demo")
public class CityController {

    /**
     * just inject Elasticsearch service
     */
    @Autowired
    CityService cityService;

    @RequestMapping("/r1")
    public Object findCityByOfficialName(@RequestParam(value = "n")String officialName){
        Object result = cityService.findCityByOfficialName(officialName);
        return result;
    }

    @RequestMapping("/s1")
    public Object save1(@RequestParam(value = "n") String name){
        City city = new City();
        city.setIdd(UUID.randomUUID().toString().replace("-", ""));
        city.setOfficialName(name);
        city.setCommonName(name);
        city.setFriendlyName(name);
        city.setAge(new Random().nextInt());
        Object result = cityService.save(city);
        return result;
    }

}
