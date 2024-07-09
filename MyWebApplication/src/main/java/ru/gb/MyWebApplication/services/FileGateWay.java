package ru.gb.MyWebApplication.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.logging.FileHandler;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateWay {
    void writeToFile(@Header(FileHeaders.FILENAME)String fileName, String data);
}
