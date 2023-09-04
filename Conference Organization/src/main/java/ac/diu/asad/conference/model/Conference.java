package ac.diu.asad.conference.model;
// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Conference generated by hbm2java
 */
@Entity
public class Conference  implements java.io.Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
     private int conferenceId;
     private Date startDate;
     private Date endDate;
     private int universityId;
     private int venuId;

    public Conference() {
    }

    public Conference(int conferenceId, Date startDate, Date endDate, int universityId, int venuId) {
       this.conferenceId = conferenceId;
       this.startDate = startDate;
       this.endDate = endDate;
       this.universityId = universityId;
       this.venuId = venuId;
    }
   
    public int getConferenceId() {
        return this.conferenceId;
    }
    
    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getUniversityId() {
        return this.universityId;
    }
    
    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }
    public int getVenuId() {
        return this.venuId;
    }
    
    public void setVenuId(int venuId) {
        this.venuId = venuId;
    }




}


