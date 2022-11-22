//package org.launchcode.codingevents.controllers;
//
//import org.launchcode.codingevents.data.EventCategoryRepository;
//import org.launchcode.codingevents.data.EventRepository;
//import org.launchcode.codingevents.data.TagRepository;
//import org.launchcode.codingevents.models.Event;
//import org.launchcode.codingevents.models.EventCategory;
//import org.launchcode.codingevents.models.Tag;
//import org.launchcode.codingevents.models.dto.EventTagDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("events")
//public class EventController {
//
////    autopopulate, Spring will manage this class for us. dependency injection, inversion control. i need an eventrepository object, do you have one?
////
//    @Autowired
//    private EventRepository eventRepository;
////    findAll, save, findById part of base class CrudRepository
//
//    @Autowired
//    private EventCategoryRepository eventCategoryRepository;
//
//    @Autowired
//    private TagRepository tagRepository;
//
//    @GetMapping
//    public String displayEvents(@RequestParam(required=false) Integer categoryId, Model model) {
//        if (categoryId == null) {
//            model.addAttribute("title", "All Events");
//            model.addAttribute("events", eventRepository.findAll());
//        } else {
//            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
//            if(result.isEmpty()){
//                model.addAttribute("title", "Invalid Category ID: " + categoryId);
//            } else {
//                EventCategory category = result.get();
//                model.addAttribute("title", "Events in category: " + category.getName());
//            model.addAttribute("events", category.getEvents());
//            }
//        }
////        calls static method off object
//        return "events/index";
//    }
//
//    //    lives at /events/create
//    @GetMapping("create")
//    public String displayCreateEventForm(Model model) {
//        model.addAttribute("title", "Create Event");
//        model.addAttribute(new Event());
//        model.addAttribute("categories", eventCategoryRepository.findAll());
////        returns an array of the 4 different values that exist for the enum EventType
////        then can use template to render a dropdown
//        return "events/create";
//    }
//
//    @PostMapping("create")
//        public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
//                Errors errors, Model model) {
//            if(errors.hasErrors()) {
//                model.addAttribute("title", "Create Event");
//                return "events/create";
//            }
//            eventRepository.save(newEvent);
//        return "redirect:";
////        redirects to the displayAllEvents
//    }
//
//    @GetMapping("delete")
//    public String displayDeleteEventForm(Model model) {
//        model.addAttribute("title", "Delete Events");
//        model.addAttribute("events", eventRepository.findAll());
//        return "events/delete";
//    }
//
//    @PostMapping("delete")
//    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
//        if (eventIds != null) {
//            for (int id : eventIds) {
//                eventRepository.deleteById(id);
//            }
//        }
//        return "redirect:";
//    }
//
//        @GetMapping("detail")
//        public String displayEventDetails(@RequestParam Integer eventId, Model model) {
//
//            Optional<Event> result = eventRepository.findById(eventId);
//
//            if (result.isEmpty()) {
//                model.addAttribute("title", "Invalid Event ID: " + eventId);
//            } else {
//                Event event = result.get();
//                model.addAttribute("title", event.getName() + " Details");
//                model.addAttribute("event", event);
//                model.addAttribute("tags", event.getTags());
//            }
//
//            return "events/detail";
//        }
//
//        // responds to /events/add-tag?eventId=13 this is the type of request that will result in this handler
//        // being called. id will be pulled out of the request, and will fetch the event from the database with that id,
//        // will pass the event to the form. then were putting that
//        @GetMapping("add-tag")
//        public String displayAddTagForm(@RequestParam Integer eventId, Model model){
//            Optional<Event> result = eventRepository.findById(eventId);
//            Event event = result.get();
////passing into view vvvvv passing in a title for out page, the title specific to this event is, Add Tag to: link to the events name
//            model.addAttribute("title", "Add Tag to: " + event.getName());
////            V drop down for all the tags to chose from, passes a list of tags from our repository into our template
//            model.addAttribute("tags", tagRepository.findAll());
////            event object we just fetched from the data base on line 117. the event im adding a tag to.
//            EventTagDTO eventTag = new EventTagDTO();
////            use model binding with EventTag object. instead of passing in and event and a tag, this makes a single object of both
//            eventTag.setEvent(event);
//            model.addAttribute("eventTag", eventTag);
//            return "events/add-tag.html";
//        }
//
////        if you use model binding, thats when you use model attribute of type eventtagdto. EventTagDTO is a simple object
////    just checks as valid, both event and tag fields should be populated. when you do a form submission, you should always do a redirect.
//        @PostMapping("add-tag")
//        public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag,
//                Errors errors,
//                Model model){
//
//            if (!errors.hasErrors()) {
//                Event event = eventTag.getEvent();
//                Tag tag = eventTag.getTag();
////                if my tags like from the event is not already populated with that tag, then we want to add it
//
//                if (!event.getTags().contains(tag)){
//                    event.addTag(tag);
//                    eventRepository.save(event);
//                }
////                return to the details view/handler, pass back to the details view to the event
//                return "redirect:detail?eventId=" + event.getId();
//            }
//
//            return "redirect:add-tag";
//        }
//    }
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

package org.launchcode.codingevents.controllers;

        import org.launchcode.codingevents.data.EventCategoryRepository;
        import org.launchcode.codingevents.data.EventRepository;
        import org.launchcode.codingevents.data.TagRepository;
        import org.launchcode.codingevents.models.Event;
        import org.launchcode.codingevents.models.EventCategory;
        import org.launchcode.codingevents.models.Tag;
        import org.launchcode.codingevents.models.dto.EventTagDTO;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.Optional;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        } else {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: " + category.getName());
                model.addAttribute("events", category.getEvents());
            }
        }

        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories", eventCategoryRepository.findAll());
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

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model) {

        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }

        return "events/detail";
    }

    // responds to /events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);
        Event event = result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO eventTag = new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag", eventTag);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Event event = eventTag.getEvent();
            Tag tag = eventTag.getTag();
            if (!event.getTags().contains(tag)){
                event.addTag(tag);
                eventRepository.save(event);
            }
            return "redirect:detail?eventId=" + event.getId();
        }

        return "redirect:add-tag";
    }

}
