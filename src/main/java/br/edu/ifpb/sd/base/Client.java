/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.base;

import br.edu.ifpb.sd.model.Message;
import br.edu.ifpb.sd.util.ConvertterJson;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class Client {
  
    private final ConvertterJson convertter;
    
    public Client() {
        this.convertter = new ConvertterJson();
    }
    
    public byte[] doOperation(Message message) {
        // instacio o sokect no try
        // pego o endereço e port do remoteRef
        // Construo msg JSON para bytes
        // Crio o pacote
        // send
        try (DatagramSocket socket = new DatagramSocket()) {
            
            byte[] data = convertter.marshal(message).getBytes();
//            System.out.println("DoOperation: " + new String(data));
            
            InetAddress address = InetAddress.getByName(message.getRemoteRef().getHost());
            int port = Integer.parseInt(message.getRemoteRef().getPort());
            
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            socket.send(packet);
        
            // Crio o pacote de novo
            // recieve
            byte[] receiveData = new byte[1024];
            DatagramPacket packetReceive = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(packet);
            
            socket.close();
          
            return packetReceive.getData();
            
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    
}
