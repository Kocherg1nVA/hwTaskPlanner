package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldFindSimpleTask(){
        SimpleTask simpleTask = new SimpleTask(12, "Выполнить дз по теме: Наследование и расширяемость систем");
        boolean expected = true;
        boolean actual = simpleTask.matches("Наследование");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindSimpleTask(){
        SimpleTask simpleTask = new SimpleTask(12, "Выполнить дз по теме: Наследование и расширяемость систем");
        boolean expected = false;
        boolean actual = simpleTask.matches("тз");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpic(){
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpic(){
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Мясо");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByTopic(){
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingByProject(){
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("НетоБанк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting(){
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("МетаБанк");
        Assertions.assertEquals(expected, actual);
    }

}
