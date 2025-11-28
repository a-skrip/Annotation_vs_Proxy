package ru.skillbox.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PrinterInvocationHandler implements InvocationHandler {
    private final Printer orignalPrinter;

    public PrinterInvocationHandler(Printer orignalPrinter) {
        this.orignalPrinter = orignalPrinter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //если метод не аннотирован, то вызываем оригинальный метод интерфейса
        if (!method.isAnnotationPresent(AccessAllowed.class)) {
            return method.invoke(orignalPrinter, args);
        }
        //получаем значение аннотации
        AccessAllowed accessAllowed = method.getAnnotation(AccessAllowed.class);

        if (accessAllowed.value()) {
            return method.invoke(orignalPrinter, args);
        } else {
            System.out.println("ACCESS DENIED!");
        }
        return null;
    }
}
