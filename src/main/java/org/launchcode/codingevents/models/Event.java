package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;
//    private static int nextId = 1;

    @NotBlank(message = "name is required")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @NotBlank(message = "You must enter a description")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "must enter an email")
    @Email(message = "Invalid Email. Try Again.")
    private String contactEmail;

    @NotBlank(message = "you must enter a date")
    private String date;

    @NotBlank(message = "you must enter a location")
    private String location;

    @NotBlank(message = "you must enter a price")
    private String price;


    private EventType type;

    public Event(String name, String description, String date, String location, String price, String contactEmail, EventType type) {
//        this();
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
        this.price = price;
//        this.contactEmail = contactEmail;
        this.type = type;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
