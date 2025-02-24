package ru.skillbox.reflection;

public interface Printer {
    void on();

    void print(String document);

    void printSecret(String secretDocument);

    void off();
}
