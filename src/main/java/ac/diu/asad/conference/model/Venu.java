package ac.diu.asad.conference.model;
// Generated Feb 19, 2020 12:53:09 PM by Hibernate Tools 4.3.1




public class Venu  implements java.io.Serializable {


     private int venuId;
     private String venuName;
     private int locationId;

    public Venu() {
    }

    public Venu(int venuId, String venuName, int locationId) {
       this.venuId = venuId;
       this.venuName = venuName;
       this.locationId = locationId;
    }
   
    public int getVenuId() {
        return this.venuId;
    }
    
    public void setVenuId(int venuId) {
        this.venuId = venuId;
    }
    public String getVenuName() {
        return this.venuName;
    }
    
    public void setVenuName(String venuName) {
        this.venuName = venuName;
    }
    public int getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }




}


