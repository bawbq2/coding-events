package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

//import org.launchcode.codingevents.data.EventRepository;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer categoryId, Model model) {
        if (categoryId == null) {
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

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("event", new Event());
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "events/create";
    }

    //lives at /events/create. OK To have both at same path because they handle different types of events
    @PostMapping("create")
    public String createEvent(Model model, @ModelAttribute @Valid Event newEvent, Errors errors){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            model.addAttribute("types", eventCategoryRepository.findAll());
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("events/{id}")
    public String show(Model model, @PathVariable int id) {
        model.addAttribute("event", eventRepository.findById(id));
        return "events/show";
}

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds !=null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable int eventId) {
//        model.addAttribute("title", "Edit Event " + eventRepository.findById(eventId) + " (id = " +eventId + ")");
//        model.addAttribute("event", eventRepository.findById(eventId));
//        return "events/edit";
//    }

//    @PostMapping("edit")
//    public String processEditForm(int eventId, String name, String description) {
//        EventData.getById(eventId).setName(name);
//        EventData.getById(eventId).setDescription(description);
//        return "redirect:";
//
//    }


}
