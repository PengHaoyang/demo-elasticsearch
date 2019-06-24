package salonika.demo.es.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import salonika.demo.es.bean.City;

import java.util.List;

/**
 * @Author: penghaoyang
 * @Date: 2019/6/25 00:01
 * @Description: CityService
 *  * extends ElasticsearchRepository<City, String>
 *      City as the entity, String as type of _id
 *  * methods defines based on JPA
 *  * no need for @Component, @Service or something
 */
public interface CityService extends ElasticsearchRepository<City, String> {

    List<City> findCityByOfficialName(String officialName);

    Page<City> findCityByCommonName(String commonName, Pageable pageable);
}
