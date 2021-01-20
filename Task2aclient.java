import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class Task2aclient{
public static void main(String args[]) throws IOException,ClassNotFoundException{

Socket c=new Socket("localhost",1000);

BufferedReader reader;
DataOutputStream dos = new DataOutputStream(c.getOutputStream()); 
BufferedReader bis=new BufferedReader(new InputStreamReader(c.getInputStream()));

       try{
               reader = new BufferedReader(new FileReader("fileData.txt"));
	
                String str1;		
                String line =reader.readLine();
                while(line != null){
                        System.out.println(line);

                          // send to the server 
                          dos.writeBytes(line + "\n"); 
  
                       // receive from the server                      
                        System.out.println(bis.readLine());

                        line =reader.readLine();
                }
                 reader.close();
                }catch(IOException e){
                              System.out.println(e.getMessage());
                }

bis.close();
c.close();

}
}