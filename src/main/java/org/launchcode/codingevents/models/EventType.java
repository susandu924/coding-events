package org.launchcode.codingevents.models;

public enum EventType {

    CONFERENCE("Conference"),
    MEETUP("Meetup"),
    WORKSHOP("Meetup"),
    SOCIAL("Social");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}
