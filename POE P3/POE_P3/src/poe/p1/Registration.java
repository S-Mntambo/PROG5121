/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe.p1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
class Registration {
    
   String registeredUserName;
   String registerdUserPassword;
   String registerdUserNumber;
   ArrayList<String> ignoreMessage = new ArrayList<>();
   ArrayList<String> KeepMessage = new ArrayList<>();
   ArrayList<String> sentMessage = new ArrayList<>();
   ArrayList<String> reciepientPhone = new ArrayList<>();
   ArrayList<String> hashID = new ArrayList<>();
   ArrayList<String> uniqueMessageID = new ArrayList<>();
   Random random = new Random();
   
   //Recommendation for username
    public boolean Username(String Username) {
        if (Username.contains("_") && Username.length() == 5) {
            JOptionPane.showMessageDialog(null, "username successfully captured");
            return true;
        } else {
             JOptionPane.showMessageDialog(null,   "Username must contain the underscore _ and 5 character long", "Username", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    //Password code
     public boolean Password(String Password) {

        if (Password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%&*]).{8,}$")) {
            JOptionPane.showMessageDialog(null, "Password sucessfully captured", "Password", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
             JOptionPane.showMessageDialog(null, "Password incorrectly formatted");
            return false;
        }
     }
   //Cellphone code 
      public boolean CellphoneNumber(String CellphoneNumber) {
        if (CellphoneNumber.matches("^\\+27|0(6|7|8)\\d{8}$")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Cell number not correctly formated or does not contain international code", "CellPhone Number", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
      //Registering a user
    public void RegisterUser() {
        String registeredUserNaame;
        String registeredUserrPassword;
        String registeredUserrNumber;      
//Loop for username
         do{             
         registeredUserNaame = JOptionPane.showInputDialog("Enter your Username");
         if( registeredUserNaame == null){
             return;
         }
            if(!Username(registeredUserNaame)){
                JOptionPane.showMessageDialog(null,"Invalid UserName");
            }      
            }while(!Username(registeredUserNaame));
           registeredUserName = registeredUserNaame;
         
//Loop for password
        do{
         registeredUserrPassword = JOptionPane.showInputDialog("Enter your Password");
              if (registeredUserrPassword == null) {
                  return;   
              }
              if(!Password(registeredUserrPassword)){
                  JOptionPane.showMessageDialog(null,"Weak Password");
              }
        }while (!Password(registeredUserrPassword));
          registerdUserPassword = registeredUserrPassword;
                   
 //Loop for Cell number        
       do{  
         registeredUserrNumber = JOptionPane.showInputDialog("Enter your cell number");
             if(registeredUserrNumber == null){
               return;     
             }
                if(!CellphoneNumber(registeredUserrNumber)){
                    JOptionPane.showMessageDialog(null,"re-enter CellPhoneNumber");
                }
        }while (!CellphoneNumber(registeredUserrNumber));
           registerdUserNumber =  registeredUserrNumber;
         
    if (Username(registeredUserNaame)  &&  Password(registeredUserrPassword) && CellphoneNumber(registeredUserrNumber)){
        registeredUserName = registeredUserNaame;
        registerdUserPassword = registeredUserrPassword;
        registerdUserNumber =  registeredUserrNumber;
        JOptionPane.showMessageDialog(null, "Registration Successful");
    }else{
       JOptionPane.showMessageDialog(null, "Registration Failed"); 
    }
    }
    //Signing in the regsteried user
    public void signin(){
       
        String registerdUserName;
        String registeredUserrPassword;
        
        if (registeredUserName == null &&  registerdUserPassword ==null){
            JOptionPane.showMessageDialog(null,"Username must contain the underscore _ and 5 character long and must be no longer than 5 char");
            return;
        }
        registerdUserName =JOptionPane.showInputDialog("Enter your Username");
        registeredUserrPassword =JOptionPane.showInputDialog("Enter your Password");
        
        
       if(registerdUserName.equals(registeredUserName) && registeredUserrPassword.equals(registerdUserPassword)){
          String [] options = {"Send message", "(coming soon)", "Exit"};
          
           int choices = JOptionPane.showOptionDialog(null, "Welcome To Chatbot!!!", "Options", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]); 
                    switch(choices) {
                        case 0 ->
                            sendMessage();
                        case 1 ->    
                            JOptionPane.showMessageDialog(null, "coming soon");
                        case 2 ->    
                            System.exit(0);
                          }
       } else{
                JOptionPane.showMessageDialog(null, "Your information/credentials are incorrect");        
       }
    }
      
public void sendMessage(){
         String recipientNumber;

            do{
                  recipientNumber = JOptionPane.showInputDialog(null, "Enter your recipient number");
                  if (recipientNumber == null){
                      return;
                    }
                  if (!CellphoneNumber(recipientNumber)){
                      JOptionPane.showMessageDialog(null, "invalid Recipient");
                  }
            }while (!CellphoneNumber(recipientNumber));
            reciepientPhone.add(recipientNumber);
        
       String messageNumber = JOptionPane.showInputDialog("How many messages do you want to sned");
            
            if(messageNumber == null){
                return;
              }
            
            
            try{
               int messageCount = Integer.parseInt(messageNumber);
               for(int count = 0; count < messageCount; count++){
                  String message = JOptionPane.showInputDialog(null, String.format("Enter Your Desired Number of Messages (%d of %d):", count + 1, messageCount));
                  if(message == null){
                      return;
                  }
                   if(message.length() >= 250){
                          JOptionPane.showMessageDialog(null, "It must not be over 250 words.", "Error", JOptionPane.ERROR_MESSAGE);
                      }
                  
                  String[] actions = {"Send", "Store", "Disregard"};
                  int action = JOptionPane.showOptionDialog(null, "What do you want to do with this message?", "Messge action", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, actions, actions [0]);
                  
                  String id = checkMessageID();
                  switch(action){
                      case 0 ->{
                          sentMessage.add(message);
                          uniqueMessageID.add(id);
                         
                          int number = sentMessage.size();
                                  
                          String hash = createMessageHash(id, messageCount, message);
                          hashID.add(hash);
                          JOptionPane.showMessageDialog(null, "Message sent successfully \n Message ID" + id + "\n Hash ID" + hash + "\n Message:" + message.toUpperCase());
                      }
                      case 1 ->{
                          KeepMessage.add(message);
                          JOptionPane.showMessageDialog(null, "Message Stored Successfully");
                      }
                      case 2 ->{
                           ignoreMessage.add(message);
                           JOptionPane.showMessageDialog(null, "Message disregared");
                      }
                      default ->{
                          
                          return;
                      }
                      
                    }
                  
                } 
               
            }catch(NumberFormatException e){ 
             JOptionPane.showMessageDialog(null,"Enter the correct/valid number","Error", JOptionPane.ERROR_MESSAGE);    
            }
            
         // printMessages();
            
          JOptionPane.showMessageDialog(null, "Total of messages sent:" + returnTotalMessages());
          
          
        }//end of method

            public String checkMessageID(){
            String ID;
            
            do{
                int firstNum = 1 + random.nextInt(9);
                int RemainingNum = random.nextInt(1_000_000_000);
                ID = firstNum + String.format("%09d", RemainingNum);
                
               }while(uniqueMessageID.contains(ID));
            
            return ID;
          }
            
      public String createMessageHash(String checkMessageID, int messageNumber, String messageText){
          String[]words = messageText.trim().split("\\s+");
          String firstWord = words[0];
          String lastWord = words.length > 1 ? words[words.length - 1] : words[0];
          
          
          return checkMessageID.substring(0, 2) + ":" + messageNumber + ":" + (firstWord + lastWord);
          
        }
        
      public int returnTotalMessages(){
               return sentMessage.size();
             } 
      
       public void printMessages(){
            if(sentMessage.isEmpty()){
                JOptionPane.showMessageDialog(null, "No message was sent");
                return;  
              }
            
              StringBuilder display = new StringBuilder("\n***SENT MESSAGES***\n");  
              for(int j = 0; j < sentMessage.size(); j++){
                  display.append("Message: ").append(j + 1).append(":\n")
                         .append ("Message HASHID: ").append(hashID.get(j)).append("\n")
                         .append("Message ID: ").append(uniqueMessageID.get(j)).append("\n")
                         .append("Message content: ").append(sentMessage.get(j)).append("\n")
                         .append("Recipient: ").append(reciepientPhone.get(0)).append("\n")
                         .append("----------------------------------\n");
              
              }
              JOptionPane.showMessageDialog(null, display.toString());
            }     
 //Part 3      
       public void messageManagement(){
            
           String[] options = {"Search ID", "Delete by Hash", "Display all sent messages"};
           int action = JOptionPane.showOptionDialog(null, "Message management", "Management",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
       
           switch (action){
               case 0 -> searchByID();
               case 1 -> deleteByHash();
               
                  }
            }//End of Method

    public void searchByID() {
        String uniqueid = JOptionPane.showInputDialog(null, "Enter uniqueID you want to search");
        
            if(uniqueid == null){
                return;
            }
            if(uniqueMessageID.isEmpty()){
                JOptionPane.showMessageDialog(null, "No uniqueID  to search");
            }
            
           int id = uniqueMessageID.indexOf(uniqueid);
           if(id == -1){
                    JOptionPane.showMessageDialog(null, "The position is not define");
                    
                     StringBuilder display = new StringBuilder("\n***MESSAGE DETAILS***\n");  
             
                  display.append("Message: ").append(id).append(":\n")
                         .append ("Message HASHID: ").append(hashID.get(id)).append("\n")
                         .append("Message ID: ").append(uniqueMessageID.get(id)).append("\n")
                         .append("Message content: ").append(sentMessage.get(id)).append("\n")
                         .append("Recipient: ").append(reciepientPhone.get(id)).append("\n")
                         .append("----------------------------------\n");
              
                }
        }//End of Method

    public void deleteByHash() {
            if (hashID.isEmpty()){
                   JOptionPane.showMessageDialog(null, "No hashId to delete message details");
                    }
            String hash = JOptionPane.showInputDialog(null, "Enter hashID to delete a message");
                if (hash == null){
                return;
                 }
                
              int index = hashID.indexOf(hash);
                if (index != -1){
                   ignoreMessage.add(sentMessage.get(index));
                   sentMessage.remove(index);
                   reciepientPhone.remove(index);
                   uniqueMessageID.remove(index);
                   hashID.remove(index);
                   JOptionPane.showMessageDialog(null, "Message successully deleted!", null, JOptionPane.DEFAULT_OPTION);
                   
                }else{  
                        JOptionPane.showMessageDialog(null, "No message exist with this hash!", null, JOptionPane.ERROR_MESSAGE);   
                }
        }    
   
                 } //END OF CLASS
            
                 
            
    
