package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodosTests {

    // ваши тесты для класса Todos
    Todos todos = new Todos();
    final List<String> taskList = new ArrayList<>();
    final String task = "Побегать";

    public static int i = 1;

    @BeforeAll
    public static void started() {
        System.out.println("Testing started");
    }

    @BeforeEach
    public void startMsg() {
        System.out.println("Test " + i + " started");
    }

    @AfterEach
    public void endMsg() {
        System.out.println("Test " + i + " ended");
        i++;
    }

    @AfterAll
    public static void ended() {
        System.out.println("Testing ended");
    }

    @Test
    public void testAddTask() {
        //arrange
        taskList.add(task);

        //act
        todos.addTask(task); //можно было положить в BeforeEach, но для наглядности добавил в каждый тест

        //assert
        assertEquals(taskList.toString(), todos.taskList.toString());
    }

    @Test
    public void testRemoveTask() {
        //act
        todos.addTask(task);
        todos.removeTask(task);

        //assert
        assertTrue(todos.taskList.isEmpty()); //проверка на то, что лист с заданиями пустой после удаления
    }

    @Test
    public void testGetAllTasks() {
        //arrange
        String expected = "Английский Кино Побегать Футбол ";

        //act
        todos.addTask(task);
        todos.addTask("Кино");
        todos.addTask("Футбол");
        todos.addTask("Английский");

        //assert
        assertEquals(todos.getAllTasks(), expected);

    }
}
