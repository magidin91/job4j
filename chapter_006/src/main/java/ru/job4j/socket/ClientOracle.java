package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientOracle {
    private static final String EXIT = "пока";
    private Socket socket;

    public ClientOracle(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String ask;
        do {
            ask = console.nextLine();
            out.println(ask);
            String str;
            while (!(str = in.readLine()).isEmpty()) {
                System.out.println(str);
            }
        } while (!EXIT.equals(ask));
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 4242)) {
            new ClientOracle(socket).start();
        }
    }
}

