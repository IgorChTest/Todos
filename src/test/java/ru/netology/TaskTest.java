package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldReturnTrueWhenAnswerInTitle() {
        SimpleTask task = new SimpleTask(1, "Проверить ДЗ");
        String query = "ДЗ";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseWhenAnswerNotInSubtasks() {
        String[] subtasks = new String[]{"Задание 1", "Задание 2", "Задание 3"};
        Epic epic = new Epic(2, subtasks);
        String query = "Решение 4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueWhenAnswerInSubtasks() {
        String[] subtasks = new String[]{"Задание 1", "Задание 2", "Задание 3"};
        Epic epic = new Epic(1, subtasks);
        String query = "Задание 3";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueWhenAnswerInTopic() {
        Meeting meeting = new Meeting(
                1,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Выкатка";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueWhenAnswerInProject() {
        Meeting meeting = new Meeting(
                1,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "НетоБанк";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseWhenAnswerNotInTopicAndInProject(){
        Meeting meeting = new Meeting(
                1,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Регрессивный";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}
