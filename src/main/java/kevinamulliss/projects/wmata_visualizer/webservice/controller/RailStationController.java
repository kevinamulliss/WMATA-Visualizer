package kevinamulliss.projects.wmata_visualizer.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RailStationController {
    private static final String BASE_PATH = "/railstation/";

    @GetMapping(BASE_PATH + "lines/")
    public List<String> getLines() {
        List<String> tempList = new ArrayList<String>();
        
        tempList.add("one");
        tempList.add("two");

        return tempList;
    }
}
