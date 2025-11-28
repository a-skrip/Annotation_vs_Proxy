package ru.skillbox.reflection;

public interface Printer {

    @AccessAllowed
    void on();

    @AccessAllowed
    void print(String document);

    @AccessAllowed(value = false)
    void printSecret(String secretDocument);

    @AccessAllowed(value = false)
    void off();
}
