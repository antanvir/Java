package client;

import java.io.*;
import java.net.*;
public class ClientWithIP
{
    PrintStream streamToServer;
    BufferedReader streamFromServer;
    Socket toServer;
    public ClientWithIP()
    {
    	System.out.println("Welcome to Client");
        connectToServer();
    }
    private void connectToServer()
    {
        try{
            String name,reading;
            toServer = new Socket("192.168.1.102",12005);
            streamFromServer = new BufferedReader(new InputStreamReader((toServer.getInputStream())));
            streamToServer = new PrintStream(toServer.getOutputStream());
            //System.out.println("Enter Connection Name");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            //System.out.println("TYPE 'Q' OR 'q'(without quotation) To QUIT.\n");
           
            while(true){
                
                 String str = streamFromServer.readLine();
                 
                 System.out.println("The SERVER says::\n"+str+"\n");  
                 if(str.equals("Q")|| str.equals("q")){
                     
                    //streamToServer.println(reading);
                    //toServer.close();
                    break;
                 }
                 
                 reading = reader.readLine();   
                 if(reading.equals("Q")|| reading.equals("q")){
                     
                    streamToServer.println(reading);
                    toServer.close();
                    break;
                 }
                 
                 streamToServer.println(reading);
                 
                   
            }
            
        }
        catch(Exception e)
        {
                System.out.println("Exception "+e);
        }       
    }
    public static void main(String args[])
    {
        new ClientWithIP();
    }
}