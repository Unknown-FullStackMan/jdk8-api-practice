package com.simple.jdk8apipractice.javalang.throwable.exception;

/**
 * @Author Simple
 * @Create 2021/10/14 13:28
 */
public class MyException extends Exception {
    private static final long serialVersionUID = 2156153215231L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
