package fr.imie.formation.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
/**
 * 
 */
import java.net.Socket;
import java.util.Scanner;

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
            try (Scanner scan = new Scanner(System.in)){
                listenThread.start();
                Socket socket = hostServer.accept();
                System.out.println("Client connecté: " + socket.getInetAddress());
                try (PrintWriter out = new PrintWriter(socket.getOutputStream(), false)) {
                    String s = "";
                    while (!s.equals("\\stop")) {
                        s = scan.nextLine();
                        out.println(s);
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