import java.io.*;
import java.net.Socket;

public class CommunicatingClient {
    public static void main(String[] args) throws Exception {
        String receiveMessage, sendMessage;
        Socket socket = new Socket("localhost", 6789);
        // reading from keyboard (inFromClient object)
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        OutputStream out = socket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(out, true);
        // receiving from server ( inFromServer  object)
        InputStream in = socket.getInputStream();
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(in));
        System.out.println("Start the chitchat, type and press Enter key");
        while (true) {
            sendMessage = inFromClient.readLine();  // keyboard reading
            pwrite.println(sendMessage);       // sending to server
            pwrite.flush();                    // flush the data
            //receive from server
            if ((receiveMessage = inFromServer.readLine()) != null) {
                System.out.println(receiveMessage); // displaying at DOS prompt
            }
        }
    }
}
