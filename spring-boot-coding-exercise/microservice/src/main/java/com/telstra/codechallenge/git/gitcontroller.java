package com.telstra.codechallenge.git;


import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;


@RestController

public class gitcontroller {
    private gitservice gitservice;

    public gitcontroller(gitservice gitservice) {
        this.gitservice = gitservice;
    }

    Logger logger = LoggerFactory.getLogger(gitcontroller.class);


    @RequestMapping(path = "/new", method = RequestMethod.GET)

    public model git() throws JSONException {
        //return List.of("kjdck","asc");

     model getresponsedata = gitservice.getresponsedata();

        logger.info("controller");
        logger.debug(String.valueOf(getresponsedata));
        logger.info(String.valueOf(getresponsedata));
        return getresponsedata;
    }


}
