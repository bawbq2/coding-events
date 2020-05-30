package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        HashMap<String,String> events = new HashMap<>();
//        List<String> events = new ArrayList<>();
        events.put("Code With Pride", "help underrepresented groups succeed in the tech industry");
        events.put("Strange Loop", "Strange Loop is a multi-disciplinary conference that brings together the developers and thinkers building tomorrow's technology in fields such as emerging languages, alternative databases, concurrency, distributed systems, security, and the web.");
        events.put("SpringOne Platform", "cloud native conference");
        model.addAttribute("events", events);
        return "events/index";

    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }


}
