import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class Task2aserver{
public static void main(String args[]) throws Exception{

ServerSocket s=new ServerSocket(1000);

System.out.println("Waiting for Client connection");

Socket c=s.accept();
System.out.println("Connection established");
System.out.println("-----------------------------------------------------------");

PrintStream ps1 = new PrintStream(c.getOutputStream());	
BufferedReader bis1=new BufferedReader(new InputStreamReader(c.getInputStream()));
String msg = "Recieved the above line\n";

while (true) { 
  
            String str; 
  
            // repeat as long as the client 
            // does not send a null string 
  
            // read from client 
            while ((str = bis1.readLine()) != null) { 
                System.out.println(str); 
  
                // send to client 
                ps1.println(msg + msg); 
            } 

ps1.close();
bis1.close();
c.close();
}

}
}

