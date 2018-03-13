/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.model;

import java.io.Serializable;

/**
 *
 * @author natan
 */
//@XmlRootElement
public class Message implements Serializable {
    
    // 0 = Request, 1 = Reply
    private int messageType;
    private int requestId;
    private RemoteRef remoteRef;
    private int operationId;
    private byte[] arguments;
    
    public Message() {
        
    }

    public Message(int messageType, int requestId, RemoteRef remoteRef, int operationId, byte[] arguments) {
        this.messageType = messageType;
        this.requestId = requestId;
        this.remoteRef = remoteRef;
        this.operationId = operationId;
        this.arguments = arguments;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public RemoteRef getRemoteRef() {
        return remoteRef;
    }

    public void setRemoteRef(RemoteRef remoteRef) {
        this.remoteRef = remoteRef;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public byte[] getArguments() {
        return arguments;
    }

    public void setArguments(byte[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "Message{" + "messageType=" + messageType + ", requestId=" + requestId + ", remoteRef=" + remoteRef + ", operationId=" + operationId + ", arguments=" + arguments + '}';
    }
    
    
}
