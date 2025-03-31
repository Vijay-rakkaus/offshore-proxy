package com.cruise.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TCPServer {

    @PostConstruct
    public void ServerConfig() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9090)) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println("Processed: " + inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
