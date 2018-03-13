/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.util;

import br.edu.ifpb.sd.model.Message;
import br.edu.ifpb.sd.model.RemoteRef;
import org.json.JSONObject;

/**
 *
 * @author natan
 */
public class ConvertterJson {
    
    public String marshal(Message message) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("messageType", message.getMessageType());
        jSONObject.put("requestId", message.getRequestId());
        jSONObject.put("host", message.getRemoteRef().getHost());
        jSONObject.put("port", message.getRemoteRef().getPort());
        jSONObject.put("operationId", message.getOperationId());
        jSONObject.put("arguments", new String(message.getArguments()));
       
        return jSONObject.toString();
       
    } 
    
    public Message unmarshal(String json) {
        JSONObject jSONObject = new JSONObject(json);
        
        RemoteRef remoteRef = new RemoteRef(jSONObject.getString("host"), jSONObject.getString("port"));
        
        Message message = new Message(jSONObject.getInt("messageType"), jSONObject.getInt("requestId"), remoteRef, jSONObject.getInt("operationId"), jSONObject.getString("arguments").getBytes());
        
        return message;
    }
    
}
