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
//@XmlType
public class RemoteRef implements Serializable {
    private String host;
    private String port;
    
    public RemoteRef() {
        
    }
    
    public RemoteRef(String host, String port) {
        this.host = host;
        this.port = port;
    }

    public RemoteRef(double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "RemoteRef{" + "host=" + host + ", port=" + port + '}';
    }
}
