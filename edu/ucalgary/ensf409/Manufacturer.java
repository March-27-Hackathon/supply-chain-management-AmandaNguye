/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

package edu.ucalgary.ensf409;

/**
 * Manufacturer is a class which implements the manufacturer table from the
 * inventory database
 */
public class Manufacturer {
    // CLASS FIELDS
    private String manuId;
    private String name;
    private String phone;
    private String province;

    /**
     * Manufacturer's constructor, takes in their ID, name, phone number, and
     * province.
     * 
     * @param manuId
     * @param name
     * @param phone
     * @param province
     */
    public Manufacturer(String manuId, String name, String phone, String province) {
        setManuId(manuId);
        setName(name);
        setPhone(phone);
        setProvince(province);
    }

    // GETTER METHODS
    /**
     * Method that returns the Manufacturer's ID.
     * 
     * @return String of ID
     */
    public String getManuId() {
        return manuId;
    }

    /**
     * Method that returns the Manufacturer's name.
     * 
     * @return String of name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the Manufacturer's phone number.
     * 
     * @return String of phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method that returns the Manufacturer's province.
     * 
     * @return String of province
     */
    public String getProvince() {
        return province;
    }

    // SETTER METHODS
    /**
     * Method that sets the ID of the Manufacturer.
     * 
     * @param manuId String of Manufacturer's ID
     */
    public void setManuId(String manuId) {
        this.manuId = manuId;
    }

    /**
     * Method that sets the name of the Manufacturer.
     * 
     * @param name String of Manufacturer's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that sets the phone of the Manufacturer.
     * 
     * @param phone String of Manufacturer's phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method that sets the province of the Manufacturer.
     * 
     * @param province String of Manufacturer's province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Method that returns a Manufacturer Object and its variables and information
     * to a formatted String.
     * 
     * @return String of formatted Manufacturer output
     */
    public String toString() {
        String temp = "Manufacturer Object consists of [";
        temp += "ManuID: " + manuId + ", ";
        temp += "Name: " + name + ", ";
        temp += "Phone: " + phone + ", ";
        temp += "Province: " + province + "]";
        return temp;
    }
}
