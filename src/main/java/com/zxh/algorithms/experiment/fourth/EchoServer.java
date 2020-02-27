package com.zxh.algorithms.experiment.fourth;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/22
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        Socket cilentSocket = null;
        ServerSocket listenSocket = new ServerSocket(8189);
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println("Server listening at 8189");
        while (true) {
            cilentSocket = listenSocket.accept();
            service.execute(new EchoServerTask(cilentSocket));
        }
    }
}
