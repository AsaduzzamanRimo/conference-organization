package ac.diu.asad.conference.model;
// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1



/**
 * HallRoom generated by hbm2java
 */
public class HallRoom  implements java.io.Serializable {


     private int hallId;
     private String hallName;
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public HallRoom(int hallId, String hallName) {
		super();
		this.hallId = hallId;
		this.hallName = hallName;
	}
	public HallRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HallRoom [hallId=" + hallId + ", hallName=" + hallName + "]";
	}

    




}


