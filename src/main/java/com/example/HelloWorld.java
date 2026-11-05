package com.example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class HelloWorld {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8081), 0
        );

        server.createContext("/", exchange -> {
            String response = "Hello World! Java Maven CI/CD Successful!";

            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("Server started at http://localhost:8081");
    }
}
