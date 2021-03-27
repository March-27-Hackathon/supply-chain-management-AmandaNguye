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
}
