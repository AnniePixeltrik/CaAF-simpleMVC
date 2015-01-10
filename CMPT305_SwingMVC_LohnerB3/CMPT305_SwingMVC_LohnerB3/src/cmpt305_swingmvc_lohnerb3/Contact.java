/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpt305_swingmvc_lohnerb3;

/**
 *
 * @author User
 */
public class Contact {
    private String firstName, lastName, eMail, workPhone, homePhone;
    
    public Contact(String fname, String lname, String email, String wphone, String hphone) {
        firstName = fname;
        lastName = lname;
        eMail = email;
        workPhone = wphone;
        homePhone = hphone;
    }
    
    public String getFName() {
        return firstName;
    }
    
    public String getLName() {
        return lastName;
    }
    
    public String getEmail() {
        return eMail;
    }
    
    public String getWorkPhone() {
        return workPhone;
    }
    
    public String getHomePhone() {
        return homePhone;
    }
        
}
