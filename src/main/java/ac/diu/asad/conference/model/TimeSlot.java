package ac.diu.asad.conference.model;
// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * TimeSlot generated by hbm2java
 */
@Entity
public class TimeSlot  implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private Date timeSlot;
     private int timeSlotId;
     private Room roomNumber;

    public int getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(int timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public Room getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Room roomNumber) {
		this.roomNumber = roomNumber;
	}

	public TimeSlot() {
    }

    public TimeSlot(Date timeSlot) {
       this.timeSlot = timeSlot;
    }
   
    public Date getTimeSlot() {
        return this.timeSlot;
    }
    
    public void setTimeSlot(Date timeSlot) {
        this.timeSlot = timeSlot;
    }

	@Override
	public String toString() {
		return "TimeSlot [timeSlot=" + timeSlot + "]";
	}





}


