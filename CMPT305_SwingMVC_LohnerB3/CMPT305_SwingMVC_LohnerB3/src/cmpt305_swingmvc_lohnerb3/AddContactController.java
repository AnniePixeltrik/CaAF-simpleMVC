/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpt305_swingmvc_lohnerb3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class AddContactController {

    private AddContactGUI view;
    private AddressBookModel model;
    
    public AddContactController(AddContactGUI view, AddressBookModel model) {
        this.view = view;
        this.model = model;
        view.addOkButtonListener(new OkButtonListener());
        view.addCancelButtonListener(new CancelButtonListener());
    }
    
    public void showGUI() {
        view.setVisible(true);
    }
    
    private class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ((view.getFName().equals("")) || (view.getLName().equals("")) || (view.getEmail().equals(""))) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ErrorMessage error = new ErrorMessage();
                        error.setVisible(true);
                    }
                 });
            } else {
                String fname, lname, email, wphone, hphone;
                fname = view.getFName();
                lname = view.getLName();
                email = view.getEmail();
                wphone = view.getWPhone();
                hphone = view.getHPhone();
            
                if (wphone.equals("")) {
                    wphone = " ";
                } else if (hphone.equals("")) {
                    hphone = " ";
                }
                System.out.println(fname + lname + email + wphone + hphone + "");
                model.addContact(new Contact(fname, lname, email, wphone, hphone)); //note: model updates the view
                view.dispose();
            }
        }// end override
    }//end class okbuttonlistener
    
        private class CancelButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
    }
    

}
