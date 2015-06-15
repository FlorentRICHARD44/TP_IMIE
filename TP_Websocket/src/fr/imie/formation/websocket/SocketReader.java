/**
 * 
 */
package fr.imie.formation.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

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
        try (Socket socket = new Socket("10.0.10.75", 1234);
             Socket socket2 = new Socket("10.0.10.75", 4321)) {
        
        //try (ServerSocket hostServer = new ServerSocket(1234);
        //     Socket socket = hostServer.accept()) {
            try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(socket2.getOutputStream());
                 ServiceData servData = new ServiceData();) {
                while (!stop) {
                   Object o = in.readObject();
                   if (o == null) {
                       stop = true;
                   } else {
                       if (o instanceof String) {
                           System.out.format("%s: %s\n", socket.getInetAddress(), o);
                           switch((String) o) {
                           case "usagers": ArrayList<Usager> listU = (ArrayList<Usager>) servData.selectAllUsagers();
                                           out.writeObject(listU);
                                           out.flush();
                                           break;
                           default: break;
                           }
                       } else if (o instanceof ArrayList) {
                           for (Usager u: (ArrayList<Usager>) o) {
                               System.out.println(u.getFirstName() + " " + u.getName());
                           }
                       } else {
                           System.out.println("other");
                       }
                       
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
