package org.launchcode.codingevents.models;

import jdk.jfr.Description;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;
    @NotBlank(message="Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @Size(max = 500, message = "Description too long!")
    private String description;
    @NotBlank(message="Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank.")
    private String location;

    @AssertTrue(message="You must register to attend.")
    private Boolean attendeeRegistered = true;

    @Positive(message = "The number of attendees must be one or more.")
    private int numberOfAttendees;

    @NotBlank(message = "Please answer true of false if you need valet parking.")
    private boolean needParkingValet;

    public Event(String name, String description, String contactEmail,
                 String location, Boolean attendeeRegistered, int numberOfAttendees, boolean needParkingValet) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.attendeeRegistered = attendeeRegistered;
        this.numberOfAttendees = numberOfAttendees;
        this.needParkingValet = needParkingValet;
        this.id = nextId;
        nextId++;
    }

    public Event(){

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAttendeeRegistered() {
        return attendeeRegistered;
    }

    public void setAttendeeRegistered(Boolean attendeeRegistered) {
        this.attendeeRegistered = attendeeRegistered;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public boolean isNeedParkingValet() {
        return needParkingValet;
    }

    public void setNeedParkingValet(boolean needParkingValet) {
        this.needParkingValet = needParkingValet;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
//        returning the boolean value of comparison,
//        compares object we're inside vs object we are passing in. hashcode just hashes the id field value
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
