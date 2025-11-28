package ru.skillbox.reflection;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        OfficePrinter officePrinter = new OfficePrinter();
        //Создаем прокси и ней вызываем методы
        Printer proxyPrinter = (Printer) Proxy.newProxyInstance(
                officePrinter.getClass().getClassLoader(),
                officePrinter.getClass().getInterfaces(),
                new PrinterInvocationHandler(officePrinter)
        );
        proxyPrinter.on();
        proxyPrinter.print("simple document");
        proxyPrinter.printSecret("41b5e1ef-08ce-40dc-9149-614e3032afa0");
        proxyPrinter.off();
    }
}
