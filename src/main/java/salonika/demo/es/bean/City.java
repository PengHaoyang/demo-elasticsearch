package salonika.demo.es.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: penghaoyang
 * @Date: 2019/6/24 23:56
 * @Description: City
 * * use @Document to tell the index and type (if there is)
 * * if no java field with @Field, all treat as with @Field
 */
@Document(indexName = "city", type = "usa")
public class City {

    /**
     * _id
     */
    @Id
    private String idd;

    private String officialName;

//    @Field(searchAnalyzer = "ik_max_word",analyzer = "ik_smart")
    private String commonName;

    private String friendlyName;

    private Integer age;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
