package me.ruslanys.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Data
@AllArgsConstructor
public class Event {

    private Long taskId;
    private Type type;
    private Status status;
    public Event(Long taskId,Type type,Status status){
    	this.taskId= taskId;
    	this.type=type;
    	this.status=status;
    }
    public enum Status {
        STARTED, SUCCESSFUL, FAILED
    }

}
