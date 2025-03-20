package ru.netology.javaqa;

public class Epic extends Task {
    protected String[] subtasks;
    protected int id;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.equals(query)) {
                return true;
            }
        }
        return false;
    }
}

