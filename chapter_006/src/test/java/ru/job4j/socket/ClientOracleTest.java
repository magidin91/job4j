package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientOracleTest {

    private final static String LN = System.lineSeparator();

    private void test(String ask, String answer, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(answer.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        System.setIn(new ByteArrayInputStream(ask.getBytes())); //назначаем в "standard" input stream - наш поток
        // байтов из массива (вместо ввода с клавиатуры)
        ByteArrayOutputStream consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut)); // назначаем вместо стандартного потока вывода (вывода на консоль)-
        // вывод в массив байтов
        ClientOracle client = new ClientOracle(socket);
        client.start();
        assertThat(consoleOut.toString(), is(expected));
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void whenClientExitTest() throws IOException {
        test("пока", String.format("%s", LN), "");
    }

    @Test
    public void whenClientHelloTest() throws IOException {
        test(
                Joiner.on(LN).join("Привет, оракул", "пока"),
                String.format("Привет, дорогой друг, я мудрый оракул%s%s%s", LN, LN, LN),
                String.format("Привет, дорогой друг, я мудрый оракул%s", LN));
    }
}