package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todos {

    List<String> taskList = new ArrayList<>();

    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(taskList);
        StringBuilder sb = new StringBuilder();
        for (String task : taskList) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }
}
