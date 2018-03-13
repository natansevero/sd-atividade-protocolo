/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sd.main;

import br.edu.ifpb.sd.base.Server;

/**
 *
 * @author natan
 */
public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        
        server.getRequest();
    }
}
