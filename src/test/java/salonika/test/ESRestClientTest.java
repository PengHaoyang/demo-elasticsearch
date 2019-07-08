package salonika.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseException;
import org.elasticsearch.client.RestClient;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/7 21:20
 * @Description: ESRestClientTest
 */
public class ESRestClientTest {

    @Test
    public void test01() {

        String queryString = "{\n" +
                "  \"version\": true,\n" +
                "  \"profile\": true,\n" +
                "  \"size\": 3, \n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"DestCountry\": \"AU\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"highlight\": {\n" +
                "    \"fields\": {\n" +
                "      \"DestCountry\":{}\n" +
                "    }\n" +
                "  }\n" +
                "}";

        HttpEntity entity = new NStringEntity(queryString, ContentType.APPLICATION_JSON);

        Request request = new Request("GET", "/kibana_sample_data_flights/_search");
//        request.addParameter("xxx", "");
        request.setEntity(entity);

        try {

            final RestClient restClient = RestClient
                    .builder(new HttpHost("localhost", 9200, "http"))
                    .build();

//            Response response = restClient.performRequest("GET", "/some_important_index*/_search", params, entity);
            Response response = restClient.performRequest(request);

            System.out.println(response.getStatusLine().getStatusCode());
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("******************************************** ");

            JSONObject jsonObject = JSON.parseObject(responseBody);

            System.out.println(jsonObject.get("hits"));
        } catch (ResponseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");

    }

}
