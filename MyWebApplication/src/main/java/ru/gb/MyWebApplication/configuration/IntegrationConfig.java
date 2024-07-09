package ru.gb.MyWebApplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {
    @Bean  // для создания канала
    public MessageChannel textInputChanel(){
        return new DirectChannel();
    }

    @Bean  // для создания канала
    public MessageChannel fileWriterChanel(){
        return new DirectChannel();
    }
    //
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer <String, String> myTransformer(){
        return text -> text.toLowerCase().trim();
        }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler(){
       FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("output.txt"));
       handler.setExpectReply(false);
       handler.setFileExistsMode(FileExistsMode.APPEND);
       handler.setAppendNewLine(true);
       return handler;
    }
}
