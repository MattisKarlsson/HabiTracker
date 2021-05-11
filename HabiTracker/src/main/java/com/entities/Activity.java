package com.entities;
import lombok.Data;

@Data
public class Activity {

	
	  private Long id;
        private String name;
        
        @ApiModelProperty(notes = "Time spent on each tracked habit/task.")
	private int duration;
    
    @ApiModelProperty(notes = "Description of the habit/task.")
	private String description;

}
