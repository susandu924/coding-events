package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
//        calls static method off object
        return "events/index";
    }

    //    lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
//        returns an array of the 4 different values that exist for the enum EventType
//        then can use template to render a dropdown
        return "events/create";
    }

    @PostMapping("create")
        public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                Errors errors, Model model) {
            if(errors.hasErrors()) {
                model.addAttribute("title", "Create Event");
                return "events/create";
            }
            EventData.add(newEvent);
        return "redirect:";
//        redirects to the displayAllEvents
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event event = EventData.getById(eventId);
        String title = "Edit Event " + event.getName() + " (id=" + event.getId() + ")";
        model.addAttribute("event", event);
        model.addAttribute("title", title);
        return "events/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Event myEvent = EventData.getById(eventId);
        myEvent.setName(name);
        myEvent.setDescription(description);
        // controller code will go here
        return "redirect:/events";
    }

}