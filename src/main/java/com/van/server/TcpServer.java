package com.van.server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 8080));

            while (true) {
                System.out.println("\n[ Waiting ... ] \n");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("\n[ Accept ... ] \n" + isa.getHostName() + ":" + isa.getPort());

                byte[] bytes = null;
                String header = null;
                String message = null;

                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                byte[] header_bytes = new byte[8];
                int readHeader = dis.read(header_bytes);
                header = new String(header_bytes, 0, readHeader, "UTF-8");
                System.out.println("\n[ Data Length ] \n" + header);

                int length = Integer.parseInt(header);
                bytes = new byte[length];
                int readMessage = is.read(bytes);

                // Get Interface ID
                byte[] if_id_byte = new byte[9];
                System.arraycopy(bytes, 33, if_id_byte, 0, if_id_byte.length);
                String if_id_str = new String(if_id_byte, "UTF-8");
                System.out.println("\n[ Interface ID ] \n" + if_id_str);

                message = new String(bytes, 0, readMessage, "UTF-8");
                System.out.println("\n[ Data Received ] \n" + message);

                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                message = header + message;
                bytes = message.getBytes("UTF-8");

                dos.write(bytes);
                dos.flush();

                System.out.println("\n[ Data Send Success ] \n" + message);

                dos.close();
                os.close();
                dis.close();
                is.close();

                socket.close();
                System.out.println("\n[ Socket closed ]\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
                System.out.println("\n[ Socket closed ]\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
