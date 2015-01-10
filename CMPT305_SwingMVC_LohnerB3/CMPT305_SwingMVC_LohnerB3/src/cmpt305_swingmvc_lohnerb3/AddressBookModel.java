/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpt305_swingmvc_lohnerb3;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AddressBookModel {
    List<Contact> contacts;
    private DefaultTableModel tableModel;
    
    public AddressBookModel(DefaultTableModel tm) {
        contacts = new ArrayList<Contact>();
        this.tableModel = tm;
    }
    
    public void addContact(Contact contact) {
        String name, email;
        name = contact.getFName() + " " + contact.getLName();
        email = contact.getEmail();
        
        tableModel.addRow(new Object[]{name, email});
        contacts.add(contact);
    }
    
    public void deleteContact(int index) {
        tableModel.removeRow(index);
        contacts.remove(index);
    }
    
    public List<Contact> getContacts(){
        return contacts;
    }
    
    public Contact getContactAt(int index){
        return contacts.get(index);
    }

}
