package com.zxh.algorithms.experiment.fourth;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/22
 */
public class UDPServerThread extends Thread {
    private DatagramSocket socket;
    private String data;
    private int length;
    private InetAddress address;
    private int port;

    public UDPServerThread(DatagramSocket socket,String data, long length, InetAddress address, int port){
        socket = socket;
        data = data;
        length = length;
        address = address;
        port = port;
    }
    @Override
    public void run() {
        DatagramPacket reply = new DatagramPacket(data.getBytes(),length,address,port);
        try {
            socket.send(reply);
        } catch (IOException e) {
            System.out.println("Io: "+e.getMessage());
        }
    }
}
