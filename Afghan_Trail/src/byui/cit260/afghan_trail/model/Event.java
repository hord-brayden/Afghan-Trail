/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author jonsi
 */
public class Event implements Serializable {
    private String eventDescription;

    public Event() {
        setEventDescription("Event Description"); 
    }
    
    public Event(String description) {
        setEventDescription(description); 
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.eventDescription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.eventDescription, other.eventDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "eventDescription=" + eventDescription + '}';
    }
    
    
    
    
}
