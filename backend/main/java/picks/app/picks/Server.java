package backend.main.java.picks.app.picks;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public void connect() throws IOException {
        // Server

        ServerSocket serversocket = new ServerSocket(8080);
        Socket connectionSocket = serversocket.accept();

        InputStreamReader in = new InputStreamReader(connectionSocket.getInputStream());

        BufferedReader bf = new BufferedReader(in);

        PrintWriter pr = new PrintWriter(connectionSocket.getOutputStream());
        pr.println("Yes");
        pr.flush();

        int str;

        while ((str = bf.read()) != 1) {
            if (str > 0) {
                char c = (char) str;
                System.out.print(c);
            }

        }

        System.out.println("client: " + str);

        System.out.print("You made it to the end");

        serversocket.close();

    }

}
