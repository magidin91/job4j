package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Сервер должен отвечать на простые вопросы. Если Ораклу сказали пока. То приложение выключается.
 * Важно. что Оракл может отправлять большие сообщения. Что бы понять когда конец сообщение он отправляет пустую строку.
 */
public class ServerOracle {
    private static final String EXIT = "пока";
    private Socket socket;

    public ServerOracle(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Привет, оракул".equals(ask)) {
                out.println("Привет, дорогой друг, я мудрый оракул");
                out.println();
            } else if (EXIT.equals(ask)) {
                out.println();
                return;
            } else {
                String answer = "Это очень сложный вопрос, я даже не знаю";
                out.println(answer);
                out.println();
            }
        } while (true);
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(4242).accept()) {
            new ServerOracle(socket).start();
        }
    }
}
