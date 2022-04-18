package ru.netology.javacore;

import com.google.gson.Gson;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Objects;

public class TodoServer {
    private static int port;
    private static Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        ServerSocket serverSocket = new ServerSocket(port);

        Gson gson = new Gson();

        while (true) {
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String json = in.readLine();
                Map map = gson.fromJson(json, Map.class);

                switch (map.get("type").toString()) {
                    case ("ADD"):
                        todos.addTask(map.get("task").toString());
                        break;
                    case ("REMOVE"):
                        todos.removeTask(map.get("task").toString());
                        break;
                }
                out.println(todos.getAllTasks());
            } catch (IIOException e) {
                e.printStackTrace();
            }
        }
    }
}
