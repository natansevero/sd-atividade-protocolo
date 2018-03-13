/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.util;

import br.edu.ifpb.sd.model.Message;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXB;

/**
 *
 * @author natan
 */
public class ConvertterXml {
    
    public String marshal(Message message) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JAXB.marshal(message, outputStream);
        
        return new String(outputStream.toByteArray());
    }
    
    public Message unmarshal(String xml) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        Message message = JAXB.unmarshal(inputStream, Message.class);
        
        return message;
    }
}
