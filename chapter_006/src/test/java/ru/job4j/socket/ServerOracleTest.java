package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerOracleTest {
    private static final String LN = System.lineSeparator();

    /**
     * mock:
     * mock(Socket.class) - создаём заглушку.
     * when(socket.getInputStream()).thenReturn(in); - реализуем конкретный мсетод.
     * Это позволяет создавать только необходимую логику для проверки в тесте
     */
    private void testServerOracle(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        ServerOracle oracle = new ServerOracle(socket);

        oracle.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void exit() throws IOException {
        this.testServerOracle("пока", LN);
    }

    @Test
    public void hello() throws IOException {
        this.testServerOracle(
                Joiner.on(LN).join(
                        "Привет, оракул",
                        "пока"),
                String.format("Привет, дорогой друг, я мудрый оракул%s%s%s", LN, LN, LN)
        );
    }

    @Test
    public void another() throws IOException {
        this.testServerOracle(
                Joiner.on(LN).join(
                        "unsupported ask",
                        "пока"
                ),
                String.format("Это очень сложный вопрос, я даже не знаю%s%s%s", LN, LN, LN)
        );
    }
}