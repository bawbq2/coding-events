package org.launchcode.codingevents.models;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message = "name is required")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters.")
    private String name;

//    @NotBlank(message = "You must enter a description")
//    @Size(max = 500, message = "Description too long!")
//    private String description;
//
//    @NotBlank(message = "must enter an email")
//    @Email(message = "Invalid Email. Try Again.")
//    private String contactEmail;
//
//    @NotBlank(message = "you must enter a date")
//    private String date;
//
//    @NotBlank(message = "you must enter a location")
//    private String location;
//
//    @NotBlank(message = "you must enter a price")
//    private String price;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Event(String name, EventCategory eventCategory) {
//        this();
        this.name = name;
//        this.description = description;
//        this.date = date;
//        this.location = location;
//        this.price = price;
//        this.contactEmail = contactEmail;
        this.eventCategory = eventCategory;

//        this.id = nextId;
//        nextId++;
    }

    public Event(){
//        this.id = nextId;
//        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
    @Override
    public String toString() {
        return name;
    }

}
