/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.main;

import br.edu.ifpb.sd.model.Message;
import br.edu.ifpb.sd.model.RemoteRef;
import br.edu.ifpb.sd.util.ConvertterXml;
import java.io.IOException;

/**
 *
 * @author natan
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        byte[] lala = "csfsdfsdfsd".getBytes();
        Message message = new Message(0, 0, new RemoteRef("127.0.0.1", "1234"), 0, lala);
    
        ConvertterXml c = new ConvertterXml();
        
        String xml = c.marshal(message);
        System.out.println(xml);
        
        Message unmarshal = c.unmarshal(xml);
        System.out.println(unmarshal.toString()); 
     
   }
}
