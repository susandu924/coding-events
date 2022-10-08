package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @GetMapping
    public String displayAllEvents(Model model) {
        /*List<String>events = new ArrayList<>();
        events.add("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");

        model.addAttribute("events", events);*/
        HashMap<String, String> events = new HashMap<>();
        events.put("Hour of Code", "Getting young minds interested in coding.");
        events.put("Strange Loop", "Coding conference of professionals sharing ideas.");
        events.put("CES", "Annual trade show showing awesome new tech.");
        model.addAttribute("events", events);
        return "events/index";
    }

//    lives at /events/create
//    @GetMapping("create")
//    public String renderCreateEventsForm(){
//        return "events/create";
//    }
//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName){
//        events.add(eventName);
//        return "redirect:";
////        redirects to the displayAllEvents
//    }
}
