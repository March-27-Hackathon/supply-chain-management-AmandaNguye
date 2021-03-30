/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

/**
 * Manufacturer is a class which implements the manufacturer table
 * from the inventory database
 */

package edu.ucalgary.ensf409;

public class Manufacturer {
    // class fields
    private String manuId;
    private String name;
    private String phone;
    private String province;

    //constructor
    public Manufacturer(String manuId, String name, String phone, String province){
        setManuId(manuId);
        setName(name);
        setPhone(phone);
        setProvince(province);
    }

    // getter methods
    public String getManuId() {
        return manuId;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getProvince() {
        return province;
    }

    // setter methods
    public void setManuId(String manuId) {
        this.manuId = manuId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    //method to return a formatted string
    public String toString(){
        String temp = "Manufacturer Object consists of [";
        temp += "ManuID: " + manuId + ", ";
        temp += "Name: " + name + ", ";
        temp += "Phone: " + phone + ", ";
        temp += "Province: " + province + "]";
        return temp;
    }
}
