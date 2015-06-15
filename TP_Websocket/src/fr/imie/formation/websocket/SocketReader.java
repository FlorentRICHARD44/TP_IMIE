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

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try (ServerSocket hostServer = new ServerSocket(1234)) {
            hostServer.setSoTimeout(60000);  // Timeout 1 minute
            try (Socket socketServer = hostServer.accept()) {
                System.out.println("Client connecté: " + socketServer.getInetAddress());
                try (BufferedReader in = new BufferedReader(new
                        InputStreamReader(socketServer.getInputStream()))) {
                    while (true) {
                       String s = in.readLine();
                       if (s == null) {
                           break;
                       } else {
                           System.out.println(s);
                       }
                    }
                } catch (IOException e) {
                    System.out.println("Error during listening");
                    e.printStackTrace();
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
    
    /**
    * @param socket
    */
   public void listen(final Socket socket) {
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
   public void send(final Socket socket, final String message) {
       try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
           out.println(message);
           out.flush();
       }  catch (Exception e) {
           System.out.println("Error during sending");
           e.printStackTrace();
       }
   }

}
