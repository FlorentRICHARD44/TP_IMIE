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
        try (ServerSocket hostServer = new ServerSocket(1234)) {
            hostServer.setSoTimeout(60000);  // Timeout 1 minute
            try (Socket socketServer = hostServer.accept()) {
                System.out.println("Client connecté: " + socketServer.getInetAddress());
                listen(socketServer);
            }
        } catch (Exception e) {
            System.out.println("Error during connection");
        }

        /* Code Client */
        try (Socket socketCustomer = new Socket("10.0.10.98", 1234)){
            System.out.println("Socket créé avec " + socketCustomer.getInetAddress());
            send(socketCustomer, "Hello Eric");
        } catch (Exception e) {
            System.out.println("Error during connection");
            e.printStackTrace();
        }
    }
    
    /**
     * @param socket
     */
    public static void listen(final Socket socket) {
        try (BufferedReader in = new BufferedReader(new
                InputStreamReader(socket.getInputStream()))) {
            while (!in.ready());
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