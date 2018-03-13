/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.main;

import br.edu.ifpb.sd.base.Client;
import br.edu.ifpb.sd.model.Message;
import br.edu.ifpb.sd.model.RemoteRef;

/**
 *
 * @author natan
 */
public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();

        byte[] arguments = "Send message".getBytes();
        RemoteRef remoteRef = new RemoteRef("localhost", "1234");
        Message message = new Message(0, 1, remoteRef, 0, arguments);
        
        byte[] data = client.doOperation(message);
    }
}
