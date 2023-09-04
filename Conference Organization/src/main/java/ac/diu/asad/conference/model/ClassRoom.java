package ac.diu.asad.conference.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1



/**
 * ClassRoom generated by hbm2java
 */
@Entity
public class ClassRoom  implements java.io.Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     private int classRoomId;
     private String cooling;
     private String soundSystem;
     private int seats;

    public ClassRoom() {
    }

    public ClassRoom(int classRoomId, String cooling, String soundSystem, int seats) {
       this.classRoomId = classRoomId;
       this.cooling = cooling;
       this.soundSystem = soundSystem;
       this.seats = seats;
    }
   
    public int getClassRoomId() {
        return this.classRoomId;
    }
    
    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }
    public String getCooling() {
        return this.cooling;
    }
    
    public void setCooling(String cooling) {
        this.cooling = cooling;
    }
    public String getSoundSystem() {
        return this.soundSystem;
    }
    
    public void setSoundSystem(String soundSystem) {
        this.soundSystem = soundSystem;
    }
    public int getSeats() {
        return this.seats;
    }
    
    public void setSeats(int seats) {
        this.seats = seats;
    }




}


