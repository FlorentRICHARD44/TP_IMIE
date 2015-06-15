package fr.imie.formation.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
/**
 * 
 */
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import fr.imie.formation.jdbc.data.Usager;

/**
 * @author imie
 *
 */
public class Launcher {

    /**
     * 
     */
    public Launcher() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /* Code Serveur */
        //try (Socket socket = new Socket("10.0.11.56", 1234)) {
        
        try (ServerSocket hostServer = new ServerSocket(1234)) {
              SocketReader soReader = new SocketReader();
            Thread listenThread = new Thread(soReader);
            SocketReaderClient soReaderClient = new SocketReaderClient();
          Thread listenThreadClient = new Thread(soReaderClient);
            try (Scanner scan = new Scanner(System.in)){
                listenThreadClient.start();
                listenThread.start();
                Socket socket = hostServer.accept();
                System.out.println("Client connecté: " + socket.getInetAddress());
                try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
                    String s = "";
                    while (!s.equals("\\stop")) {
                        s = scan.nextLine();
                        out.writeObject(s);
                        out.flush();
                    }
                    soReader.stop();
                    listenThread.interrupt();
                    listenThread.join();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error during connection");
            e.printStackTrace();
        }
    }
}