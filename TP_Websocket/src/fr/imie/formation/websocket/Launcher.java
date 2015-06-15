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
        SocketReader soReader = new SocketReader();
        Thread listenThread = new Thread(soReader);
        try {
            listenThread.start();
            listenThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* Code Client */
        //        try (Socket socketCustomer = new Socket("10.0.10.98", 1234)){
        //            System.out.println("Socket créé avec " + socketCustomer.getInetAddress());
        //            send(socketCustomer, "Hello Eric");
        //        } catch (Exception e) {
        //            System.out.println("Error during connection");
        //            e.printStackTrace();
        //        }
    }
    
    /**
     * @param socket
     */
    public static void listen(final Socket socket) {
        try (BufferedReader in = new BufferedReader(new
                InputStreamReader(socket.getInputStream()))) {
            String s = in.readLine();
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Error during listening");
            e.printStackTrace();
        }
    }
    
    /**
     * @param socket
     * @param message
     */
    public static void send(final Socket socket, final String message) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println(message);
            out.flush();
        }  catch (Exception e) {
            System.out.println("Error during sending");
            e.printStackTrace();
        }
    }
}