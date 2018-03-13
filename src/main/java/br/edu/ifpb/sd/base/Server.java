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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class Server {
    
    public void getRequest() {
        // instanciar o datagram
        // criar o pacote
        // receber a msg
        byte[] receiveData = new byte[1024];
        
        try(DatagramSocket socket = new DatagramSocket(1234)) {
            
            DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(packet);
            
            // chamar o send
            sendReply(receiveData, packet.getAddress(), packet.getPort());
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void sendReply(byte[] response, InetAddress clientHost, int clietPort) {
        
        // instanciar o datagram
        // pegar a requsiçao
        // montar o pacote
        try(DatagramSocket socket = new DatagramSocket()) {
            // dar o send
            DatagramPacket packet = new DatagramPacket(response, response.length, clientHost, clietPort);
            socket.send(packet);
            
            socket.close();
            
            String receiveData = new String(response, 0, response.length);
            // System.out.println("SendReply: " + receiveData);
            Message message = new ConvertterJson().unmarshal(receiveData);
            
            System.out.println(message.toString());
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
}
