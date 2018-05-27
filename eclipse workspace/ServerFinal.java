//package serverfinal;


import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServerFinal implements Runnable
{
    ServerSocket serverSocket;
    PrintStream streamToClient;
    BufferedReader streamFromClient;
    Socket fromClient;
    static int count = 0;
    Thread thread;
    public ServerFinal()
    {
    	System.out.println("Welcome to Server");
        try{
            serverSocket = new ServerSocket(55000);
        }
        catch(Exception e)
        {
            System.out.println("Socket could not be created"+e);
        }
        thread = new Thread(this);
        thread.start();
    }
    
    public void run()
    {
        try{
            again :
          
            while(true)
            {
                fromClient = serverSocket.accept();
                count++;    
                System.out.println("Client connection number "+count);
                streamFromClient = new BufferedReader(new InputStreamReader((fromClient.getInputStream())));
                streamToClient = new PrintStream(fromClient.getOutputStream());
                String str = streamFromClient.readLine();
                
               
                
                    String []user1=str.split(",") ;
                    
                    String []users =new String[1000]  ;
                    int i;
                    if(user1[0].equals("login")){
                            String name = null,pass = null;
                            File file = new File("usr.txt") ;
                            Scanner sc = new Scanner(file) ;
                            try {
                                int flag = 0 ;
                                i=0;
                              
                                while(sc.hasNext()){
                                    
                                    String str1 = sc.nextLine() ;
                                    
                                    users[i] = str1 ;
                                    i++;
                                    //System.out.println("stupid");
                                    String [] user=str1.split(",") ;
                                    name=user[0] ;
                                    pass=user[1] ;
                                    
                                    if(name.equals(user1[1]) && pass.equals(user1[2])){
                                        streamToClient.println("yes");
                                        flag = 1 ;
                                        
                                    }                                   
                                }
                                if(flag==0) {
                                    streamToClient.println("no");
                                    serverSocket.close();
                                    continue again;
                                }
                                
                            } catch (FileNotFoundException ex) {

                            }
                            
                            ////////
                            
                            str = streamFromClient.readLine();
                            user1 = str.split(",") ;
                            System.out.println(str);
                            if(user1[0].equals("deposit"))
                            {
                                System.out.println("here");
                                String news=user1[1]+","+user1[2] ;

                                int amount = Integer.parseInt(user1[3]) ;

                                File inputFile = new File("usr.txt");
                               // File tempFile = new File("myTempFile.txt");

                                BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
                               // BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                String lineToRemove =  news ;
                                String currentLine;
                                i=0;
                                while((currentLine =users[i++]) != null) {
                                    
                                    String trimmedLine = currentLine.trim();
                                    if(trimmedLine.contains(lineToRemove)){
                                        String []temp = trimmedLine.split(",") ;
                                        int damount = Integer.parseInt(temp[2]) ;
                                        damount+=amount ;
                                        streamToClient.println(damount);
                                        String xxx = temp[0]+","+temp[1]+","+Integer.toString(damount);
                                        writer.write(xxx + System.getProperty("line.separator"));
                                    }
                                    else
                                        writer.write(currentLine + System.getProperty("line.separator"));
                                }

                                writer.close(); 
                                //reader.close(); 
                               // tempFile.renameTo(inputFile) ; 
                                //boolean successful = tempFile.renameTo(inputFile);

                            }


                           if(user1[0].equals("withdraw"))
                            {
                                String news=user1[1]+","+user1[2] ;

                                int amount = Integer.parseInt(user1[3]) ;

                               File inputFile = new File("usr.txt");
                               // File tempFile = new File("myTempFile.txt");

                                BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
                               // BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                String lineToRemove =  news ;
                                String currentLine;
                                i=0;
                                while((currentLine =users[i++]) != null) {
                                    
                                    String trimmedLine = currentLine.trim();
                                    if(trimmedLine.contains(lineToRemove)){
                                        String []temp = trimmedLine.split(",") ;
                                        int damount = Integer.parseInt(temp[2]) ;
                                        damount-=amount ;
                                        streamToClient.println(damount);
                                        String xxx = temp[0]+","+temp[1]+","+Integer.toString(damount);
                                        writer.write(xxx + System.getProperty("line.separator"));
                                    }
                                    else
                                        writer.write(currentLine + System.getProperty("line.separator"));
                                }

                                writer.close(); 

                            }
                            
                            ////////
                    }
                   
                    
                    
                   
                }                
            }
        
        catch(Exception e){
            System.out.println("Exception "+e);         
        }
        finally{
            try{
                fromClient.close();
            }
            catch(Exception e)
            {
                System.out.println("could not close connection "+e);
            }
        }
         
    }
public static void main(String args[])  
{
    new ServerFinal();
}
}