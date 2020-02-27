package com.zxh.algorithms.experiment.fourth;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/22
 */
public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        int serverPort = 6789;
        try{
            socket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[1000];
            while (true){
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                socket.receive(request);
                UDPServerThread serverThread = new UDPServerThread(socket, request.toString(),request.getLength(),request.getAddress(),request.getPort());
                serverThread.start();
                System.out.println(serverThread);
            }
        } catch (SocketException e) {
            System.out.println("Socket: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        } finally {
            if(socket != null)
                socket.close();
        }
    }
}
