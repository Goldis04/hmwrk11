import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Epic;
import ru.netology.javaqa.Meeting;
import ru.netology.javaqa.SimpleTask;
import ru.netology.javaqa.Task;

public class TasksTest {

    @Test
    public void shouldFindSimpleTask() {
        SimpleTask task = new SimpleTask(22, "Купить колбасы");
        boolean actual = task.matches("Купить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotSimpleTask() {
        SimpleTask task = new SimpleTask(22, "Захватить еду");
        boolean actual = task.matches("заглянуть в рюкзак");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindEpic() {
        Epic task = new Epic(666, new String[]{"Молоко", "Яйца", "Хлеб", "Булка"});
        boolean actual = task.matches("Булка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindEpic() {
        Epic task = new Epic(999, new String[]{"Молоко", "Яйца", "Хлеб", "Вода"});
        boolean actual = task.matches("Чипсы");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindMeeting() {
        Meeting task = new Meeting(33, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = task.matches("Выкатка 3й версии приложения");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindMeeting2() {
        Meeting task = new Meeting(66, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = task.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindMeeting() {
        Meeting task = new Meeting(99, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = task.matches("Абоба");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testConstructorAndGetId() {
        Task task = new Task(5);
        int expected = 5;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatches() {
        Task task = new Task(5);
        int expected = 5;
        boolean actual = task.matches("query");
        Assertions.assertFalse(actual);

        boolean actual2 = task.matches("");
        Assertions.assertFalse(actual2);

        boolean actual3 = task.matches(null);
        Assertions.assertFalse(actual3);
    }

    @Test
    public void testEqualsTask() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);
        Task task4 = null;
        String notATask = "not Task";

        boolean actual = task1.equals(task2);
        Assertions.assertTrue(actual);

        boolean actual2 = task1.equals(task3);
        Assertions.assertFalse(actual2);

        boolean actual3 = task1.equals(null);
        Assertions.assertFalse(actual3);

        boolean actual4 = task1.equals(task1);
        Assertions.assertTrue(actual4);

        boolean actual5 = task1.equals(task4);
        Assertions.assertFalse(actual5);

        boolean actual6 = task1.equals(notATask);
        Assertions.assertFalse(actual6);
    }

    @Test
    public void testHashCode() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        Task task3 = new Task(2);

        int expected = task2.hashCode();
        int actual = task1.hashCode();
        Assertions.assertEquals(expected, actual);

        int expected2 = task2.hashCode();
        int actual2 = task3.hashCode();
        Assertions.assertNotEquals(expected2, actual2);
    }
}