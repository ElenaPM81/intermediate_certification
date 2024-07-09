package ru.gb.MyWebApplication.services;

public class SingletonService { //  класс  реализует паттерн Singleton
    private static SingletonService instance;
    private SingletonService() {}
    public static SingletonService getInstance() {
        if (instance == null) {
            instance = new SingletonService();
        }
        return instance;
    }
}
