package com.van.server;

import com.van.server.domain.FixedData;
import com.van.server.domain.ReceivedLinkedData;
import com.van.server.domain.ReceivedMapDataGlobal;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static com.van.server.util.CalculatorUtils.sumUpArray;
import static com.van.server.util.DataUtils.buildData;
import static com.van.server.util.StringUtils.appendData;

public class TcpServer2 extends FixedData {

    private static final int TCP_SERVER_PORT = 8080;

    public static void main(String[] args) {
        TcpServer2 server2 = new TcpServer2();
        server2.tcpServerStart();
    }

    public void tcpServerStart() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(TCP_SERVER_PORT));
            System.out.println("Starting tcp Server: " + TCP_SERVER_PORT);
            System.out.println("\n[ Waiting ]\n");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected " + socket.getLocalPort());
                Server tcpServer = new Server(socket);
                tcpServer.start();
            }
        } catch (IOException io) {
            io.getStackTrace();
        }
    }


    public class Server extends Thread {
        private Socket socket;

        public Server(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                OutputStream os = this.socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);

                InputStream is = this.socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);

                int recieveLength = dis.readInt();

                byte receiveByte[] = new byte[recieveLength];
                dis.readFully(receiveByte, 0, recieveLength);

                ReceivedLinkedData receivedLinkedData = new ReceivedLinkedData();
                String receiveMessage = readAndSetData(receiveByte, receivedLinkedData);

                // set response data
                String dataAll = buildData();
                String sendMessage = receiveMessage + dataAll;

                // send bytes
                byte[] sendBytes = sendMessage.getBytes("UTF-8");
                int sendLength = sendBytes.length;
                dos.writeInt(sendLength);
                dos.write(sendBytes, 0, sendLength);
                dos.flush();

                System.out.println("\n[ Data Send Success ]");
                System.out.println("[ Length ] " + sendLength);
                System.out.println("[ Message ] " + sendMessage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String readAndSetData(byte[] receiveByte, ReceivedLinkedData receivedLinkedData) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        if (ReceivedMapDataGlobal.receivedMapDataGlobal == null || ReceivedMapDataGlobal.receivedMapDataGlobal.size() == 0) {
            ReceivedMapDataGlobal.receivedMapDataGlobal = new HashMap<String, ReceivedLinkedData>();
        }

        for (int i = 0; i < arrayId.length - 1; i++) {
            System.arraycopy(receiveByte, sumUpArray(arrayId, i), arrayByte[i + 1], 0, arrayId[i + 1]);
            String newStr = new String(arrayByte[i + 1], "UTF-8");
            System.out.println("\n[ " + arrayStr[i + 1] + " ] " + "\'" + newStr + "\'");
            sb.append(newStr);
            linkedHashMap.put(arrayKey[i + 1], newStr.trim());
        }
        String sendMessage = sb.toString();
        receivedLinkedData.setReceivedLinkedHashMap(linkedHashMap);

        System.arraycopy(receiveByte, sumUpArray(arrayId, 2), arrayByte[3], 0, arrayId[3]);
        String newStr = new String(arrayByte[3], "UTF-8");
        if (ReceivedMapDataGlobal.receivedMapDataGlobal.containsKey(newStr)) {
            ReceivedMapDataGlobal.receivedMapDataGlobal.get(newStr);
        } else {
            ReceivedMapDataGlobal.receivedMapDataGlobal.put(newStr, receivedLinkedData);
        }

        return sendMessage;
    }

}
