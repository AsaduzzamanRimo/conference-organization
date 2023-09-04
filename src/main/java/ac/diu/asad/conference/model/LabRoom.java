package ac.diu.asad.conference.model;
// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * LabRoom generated by hbm2java
 */
@Entity
public class LabRoom  implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     private int labId;
     private String labSubject;

    public LabRoom() {
    }

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getLabSubject() {
		return labSubject;
	}

	public void setLabSubject(String labSubject) {
		this.labSubject = labSubject;
	}

	public LabRoom(int labId, String labSubject) {
		super();
		this.labId = labId;
		this.labSubject = labSubject;
	}

	@Override
	public String toString() {
		return "LabRoom [labId=" + labId + ", labSubject=" + labSubject + "]";
	}

    



}


