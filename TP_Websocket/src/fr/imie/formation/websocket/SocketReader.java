/**
 * 
 */
package fr.imie.formation.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author imie
 *
 */
public class SocketReader implements Runnable {
    private boolean stop;
    /**
     * 
     */
    public SocketReader() {
        stop = false;
    }

    @SuppressWarnings("javadoc")
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try (Socket socket = new Socket("10.0.10.75", 1234)) {
        
        //try (ServerSocket hostServer = new ServerSocket(1234);
        //     Socket socket = hostServer.accept()) {
            try (BufferedReader in = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()))) {
                while (!stop) {
                   String s = in.readLine();
                   if (s == null) {
                       stop = true;
                   } else {
                       System.out.format("%s: %s\n", socket.getInetAddress(), s);
                   }
                }
            }
        } catch (Exception e) {
            System.out.println("Error during connection");
            e.printStackTrace();
        }
    }
    
    public synchronized void stop()
    {
        stop = true;
    }
}
