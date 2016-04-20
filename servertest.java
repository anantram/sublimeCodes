import java.net.*;
import java.io.*;

public class TCPServer_1{
    public static void main(String[] args) throws IOException{
        int portNumber = 5500;
        try (
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        )
        {
            String inputLine;
            
            while ((inputLine = in.readLine()) != null){
            	String str="";
            	if(inputLine.equals("quit")){
            		clientSocket.close();
            	}
            	else{
            		for(int i=0;i<inputLine.length();i++){
            			char ch=inputLine.charAt(i);
            			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            				switch(ch){
            					case 'a':str=str+'A';
            					   		break;
            					case 'e':str=str+'E';
         					   			break;
            					case 'i':str=str+'I';
         					   			break;
            					case 'o':str=str+'O';
            							break;
            					case 'u':str=str+'U';
         					   			break;   
            				}
            			}
            			else{
            				str=str+ch;
            			}
               		}
            	}
                out.println(str);
            }
        } 
        catch (IOException e){
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}