/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpt305_swingmvc_lohnerb3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MainController {
    private MainGUI view;
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private AddressBookModel model;
    
    public MainController(MainGUI view) {
        this.view = view;
        this.contactTable = view.getContactTable();
        view.addNewContactButtonListener(new NewContactButtonListener());
        view.addDeleteButtonListener(new DeleteButtonListener());
        
        initTableModel();
        initTableColumns();
        initListSelectionModel();
        
        this.model = new AddressBookModel(tableModel);
    }

    private void initTableModel() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        contactTable.setModel(tableModel);
    }

    private void initTableColumns() {
        contactTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        contactTable.getColumnModel().getColumn(1).setPreferredWidth(300);
    }

    private void initListSelectionModel() {
        ListSelectionModel lsm = contactTable.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsm.addListSelectionListener(new ContactTableListener());        
    }
    
    public void showGUI() {
        view.setVisible(true);
    }
    
    private class ContactTableListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (!e.getValueIsAdjusting()) {
                view.setEnabledDeleteButton(!lsm.isSelectionEmpty());
                
                view.clearInfoDisplay();
                int selectedindex = lsm.getMinSelectionIndex();
                Contact contactToDisplay;
                contactToDisplay = model.getContactAt(selectedindex);
                
                String textToDisplay;
                textToDisplay = "First Name: " + contactToDisplay.getFName() + "\n";
                textToDisplay += "Last Name: " + contactToDisplay.getLName() + "\n";
                textToDisplay += "Email: " + contactToDisplay.getEmail() + "\n";
                textToDisplay += "Work Phone: " + contactToDisplay.getWorkPhone() + "\n";
                textToDisplay += "Home Phone: " + contactToDisplay.getHomePhone() + "\n";
                
                view.setInfoDisplay(textToDisplay);
            }
        }
    }
    
    private class NewContactButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //create addcontactgui
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddContactGUI addContactGui = new AddContactGUI(model);
                AddContactController addContactController = new AddContactController(addContactGui, model);
                addContactController.showGUI();
            }
        });
        }
    }
    
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ListSelectionModel lsm = contactTable.getSelectionModel();
            if (!lsm.isSelectionEmpty()) {
                int selectedIndex = lsm.getMinSelectionIndex();
                tableModel.removeRow(selectedIndex);
                //model.deleteContact(selectedIndex); //???
            }
        }
    }
}
