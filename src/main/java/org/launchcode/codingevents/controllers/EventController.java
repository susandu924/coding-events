package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

//    autopopulate, Spring will manage this class for us. dependency injection, inversion control. i need an eventrepository object, do you have one?
//
    @Autowired
    private EventRepository eventRepository;
//    findAll, save, findById part of base class CrudRepository

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
//        calls static method off object
        return "events/index";
    }

    //    lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories", eventCategoryRepository.findAll());
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
            eventRepository.save(newEvent);
        return "redirect:";
//        redirects to the displayAllEvents
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable int eventId) {
//        Event event = eventRepository.findById(eventId);
//        String title = "Edit Event " + event.getName() + " (id=" + event.getId() + ")";
//        model.addAttribute("event", event);
//        model.addAttribute("title", title);
//        return "events/edit";
//    }
//    @PostMapping("edit")
//    public String processEditForm(int eventId, String name, String description) {
//        Optional<Event> myEvent = eventRepository.findById(eventId);
//        myEvent.setName(name);
//        myEvent.setDescription(description);
//        // controller code will go here
//        return "redirect:/events";
//    }

}