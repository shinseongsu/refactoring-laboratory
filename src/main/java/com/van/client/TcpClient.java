package com.van.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClient {

    public static void main(String[] args) {
        try( Socket socket = new Socket() ) {
            System.out.println("[ Request .....]");
            socket.connect(new InetSocketAddress("127.0.0.1", 8080));
            System.out.println("[ Success .....]");

            socketReadAndWrite(socket);

            System.out.println("[ Socket close ]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void socketReadAndWrite(Socket socket) {
        try(OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream(); ) {


            byte[] bytes = null;
            String message = null;
            message = "00000243@@ae-6y@@                        IF0000001  127.0.0.1                                          D1SS202010201016210551101621000202010201016210551UC                           AA00000058123                     234                 345           @@";
            bytes = message.getBytes(StandardCharsets.UTF_8);

            os.write(bytes);
            os.flush();
            System.out.println("[ Data Send Success ] " + message);

            bytes = new byte[500];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount, StandardCharsets.UTF_8);
            System.out.println("[ Data Recevied ] " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
