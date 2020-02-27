package com.zxh.algorithms.experiment.fourth;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2020/2/22
 */
public class EchoServerTask implements Runnable {
    private Socket socket;
    public EchoServerTask(Socket socket){
        socket = socket;
    }
    @Override
    public void run() {
        System.out.println(socket+"------Accepted connection from client");

        InputStream instream = null;
        try {
            instream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(instream));
            PrintWriter out = new PrintWriter(outputStream);

            String line = null;
            while ((line=in.readLine()) != null){
                System.out.println("Message from client: "+line);
                out.println(line);
                out.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
