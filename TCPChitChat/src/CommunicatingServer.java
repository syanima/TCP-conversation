import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CommunicatingServer {
    public static void main(String[] args) throws Exception {
        String receiveMessage, sendMessage;
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server  ready for chatting");
        Socket socket = serverSocket.accept();
        // reading from keyboard (inFromServer object)
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        OutputStream out = socket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(out, true);
        // receiving from server ( inFromClient  object)
        InputStream in = socket.getInputStream();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(in));
        while (true) {
            if ((receiveMessage = inFromClient.readLine()) != null) {
                System.out.println(receiveMessage);
            }
            sendMessage = inFromServer.readLine();
            pwrite.println(sendMessage);
            pwrite.flush();
        }
    }
}
