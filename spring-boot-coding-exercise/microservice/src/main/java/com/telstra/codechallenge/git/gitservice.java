package com.telstra.codechallenge.git;


import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class gitservice {
    @Value("${git.base.url}")
    private String gitbaseurl;
    public static String reponse;
    public  List list;
    private static Logger logger = LoggerFactory.getLogger(gitservice.class);

    private RestTemplate restTemplate;
    private JSONObject jobj;

    public gitservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public model getresponsedata() throws JSONException {

        logger.info(String.valueOf(restTemplate.getForEntity(gitbaseurl + "/search/repositories?q=id", model.class)));
        logger.info("Started with response parse as per requirements");

       String mod= restTemplate.getForObject(gitbaseurl + "/search/repositories?q=id", String.class);
        logger.info(String.valueOf(mod));
        JSONObject jsonObject= new JSONObject(String.valueOf(mod));
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        model mode =new model();

        for (int i =0;i<jsonArray.length();i++)
        {

            logger.info("Started with response parse as per requirements" + jsonArray.getJSONObject(i).getString("name"));
            mode.setHtml_url(jsonArray.getJSONObject(i).getString("html_url"));
            mode.setDescription(jsonArray.getJSONObject(i).getString("description"));
            mode.setName(jsonArray.getJSONObject(i).getString("name"));
            mode.setWatchers_count(jsonArray.getJSONObject(i).getLong("watchers_count"));
            mode.setLanguage(jsonArray.getJSONObject(i).getString("language"));
        }

        return mode;

    }
}
