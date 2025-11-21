 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe.p1;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class POEP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Registration obj = new Registration();

        obj.RegisterUser();
        obj.signin();
        obj.printMessages();
        obj.messageManagement();
        obj.searchByID();
        obj.deleteByHash();
        obj.checkMessageID();
    }

}
