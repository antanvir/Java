package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
//import java.util.Scanner;
public class ServerWithIP implements Runnable
{
    ServerSocket serverSocket;
    PrintStream streamToClient;
    BufferedReader streamFromClient;
    Socket fromClient;
    static int count = 0;
    Thread thread;
    String welcome = "WELCOME TO BANKING SYSTEM. " +"What Type Of Service Do You Want?(A/B) " +
            "A. Open An Account   B. Transaction Of Money.";
    
    String AcOpen = "To Open An Account You Have To Deposit At least 5000/- BDT. " +
            "'Y/y' To Continue.";
    
    String transactionType = "What Type of Transaction ?(A/B) " +"A. Deposit   B. Withdraw";
    
    String depositQuantity = "Enter Deposit Amount.";
    String WithdrawQuantity = "Enter The Amount You Want To Withdraw.";
    public ServerWithIP()
    {
    	System.out.println("Welcome to Server");
        try{
            serverSocket = new ServerSocket(12005);
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
            while(true)
            {
                String reading="";
                fromClient = serverSocket.accept();
                count++;
                System.out.println("Client connection number: "+count);
                
                streamFromClient = new BufferedReader(new InputStreamReader((fromClient.getInputStream())));
                streamToClient = new PrintStream(fromClient.getOutputStream());
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                //Scanner reader = new Scanner(System.in);
                
                if(true){
                    
                //===>
                
                    //streamToClient.println(reading);
                    String userName, fullName, userPass, userData, user;
                    String str;
                    
                    streamToClient.println(welcome);
                    str = streamFromClient.readLine();
                    System.out.println("\nThe CLIENT says::\n"+str);
                    
                    /*if(str.equals("Q")|| str.equals("q")){
                        System.out.println("Client has Quit.\n");
                        //fromClient.close();
                        //break;
                        continue;
                    }*/
                    
                    //streamToClient.println("Welcome "+str);
                    if(str.equals("A")|| str.equals("a")){
                        
                        streamToClient.println(AcOpen);
                        str = streamFromClient.readLine();
                        
                        /*if(str.equals("Q")|| str.equals("q")){
                            System.out.println("Client has Quit.\n");
                            continue;
                        }*/
                        
                        if(str.equals("Y")|| str.equals("y")){
                            
                            
                            streamToClient.println("Enter Username & Password.(separated by space)");
                            userData = streamFromClient.readLine();
                            System.out.println("\nThe CLIENT says::\n"+userData);
                            
                            String []data = userData.split(" ");
                            userName = data[0];
                            userPass = data[1];
                            
                           
                            int depAmount;
                            
                            streamToClient.println(depositQuantity +"(at least 5000 BDT)");
                            str = streamFromClient.readLine();
                            System.out.println("\nThe CLIENT says::\n"+ str);
                            
                            depAmount = Integer.parseInt(str);
                            String msg = userName+" has currently made a deposit of BDT "+ depAmount +"\n";
                            System.out.println(msg);
                            try{
                                String filename= "userData.txt";
                                String userInfo = userName+","+userPass+","+depAmount+"\n";
                                FileWriter fw = new FileWriter(filename,true);
                                fw.write(userInfo);
                                fw.close();
                            }
                            catch(IOException ioe){
                                System.err.println("IOException: " + ioe.getMessage());
                            }       
                        }
                    }
                    
                    
                    else if(str.equals("B")|| str.equals("b")){
                        
                        streamToClient.println("Enter Username & Password.(separated by space)");
                        userData = streamFromClient.readLine();
                        System.out.println("\nThe CLIENT says::\n"+userData);
                            
                        String []data = userData.split(" ");
                        userName = data[0];
                        userPass = data[1];
                        
                        int depAmount;
                        Scanner in;
                        in= new Scanner(new File("userData.txt"));
                        boolean found=false;
                        while(in.hasNextLine()){
                            String line = in.nextLine();
                            
                            String arr[]=line.split(",");
                            if(userName.equals(arr[0]) && userPass.equals(arr[1])){
                                found=true;
                                break;
                            }
                        }
                        
                        if(found==true){
                            streamToClient.println(transactionType);
                            str = streamFromClient.readLine();
                            
                            int TotalUser=0;
                            String[] line = new String[1000] ;
                            
                            if(str.equals("A")|| str.equals("a")){
                                
                                streamToClient.println(depositQuantity);
                                str = streamFromClient.readLine();
                                
                                depAmount = Integer.parseInt(str);
                                String msg = userName+" has currently made a deposit of BDT "+ depAmount +"\n";
                                System.out.println(msg);
                                
                                in = new Scanner(new File("userData.txt"));
                                //String[] line = null ;
                                int i=0;
                                int amount=0;
                                while(in.hasNextLine()){
                                    
                                    line[i] = in.nextLine();
                                    System.out.println(line[i]);
                                    
                            
                                    String arr[]=line[i].split(",");
                                    
                                    if(userName.equals(arr[0]) && userPass.equals(arr[1])){
                                       
                                        amount = Integer.parseInt(arr[2]);
                                        amount+=depAmount;
                                        line[i]=userName+","+userPass+","+amount+"\n";
                                        
                                    }
                                    else{
                                        line[i]=line[i]+"\n";
                                    }
                                  
                                    i++;
                                }
                                TotalUser=i;
                                
                            }
                            else if(str.equals("B")|| str.equals("b")){
                                
                                streamToClient.println(WithdrawQuantity);
                                str = streamFromClient.readLine();
                                
                                depAmount = Integer.parseInt(str);
                                String msg = userName+" has currently withdrawn BDT "+ depAmount +"\n";
                                System.out.println(msg);
                                
                                
                                in = new Scanner(new File("userData.txt"));
                                //String[] line = null ;
                                int i=0;
                                int amount=0;
                                while(in.hasNextLine()){
                                    
                                    line[i] = in.nextLine();
                            
                                    String arr[]=line[i].split(",");
                                    if(userName.equals(arr[0]) && userPass.equals(arr[1])){
                                        
                                        amount = Integer.parseInt(arr[2]);
                                        amount-=depAmount;
                                        line[i]=userName+","+userPass+","+amount+"\n";
                                       
                                    }
                                    else{
                                        line[i]=line[i]+"\n";
                                    }
                                    
                                    i++;
                                }
                                TotalUser=i;
                            }
                            
                            try{
                                
                                String filename= "userData.txt";
                               
                                FileWriter fw = new FileWriter(filename);
                                
                                for(int i=0; i<TotalUser; i++){
                                   
                                    System.out.println("Writing after modification : "+line[i]);
                                    fw.write(line[i]);
                                }
                                fw.close();
                            }
                            catch(IOException ioe){
                                System.err.println("IOException: " + ioe.getMessage());
                            }    
                            
                            
                        }
                        else{
                            streamToClient.println("You don't have an account in our bank. "
                                    + " Type anything to continue.");
                            
                            str = streamFromClient.readLine();
                            /*if(str.equals("Q")|| str.equals("q")){
                                
                                System.out.println("Client has Quit.\n");
                            }
                            else{
                                System.out.println("Client wants to continue.\n");
                            }*/
                            
                            System.out.println("Client wants to continue.\n"); 
                        }
                        
                        
                        
                        
                    }
                    
                    
                }
               
            }
        }
        catch(Exception e){
            System.out.println("Exception "+e);
        }
        
    }
public static void main(String args[])
{
    new ServerWithIP();
}
}
