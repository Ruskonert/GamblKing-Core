package com.ruskonert.GamblKing.program;

import com.ruskonert.GamblKing.MessageType;
import com.ruskonert.GamblKing.entity.MessageDispatcher;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public interface ConsoleSender extends MessageDispatcher
{
    TextField getCommandField();

    TextArea getConsoleScreen();

    StringProperty getMessageProperty();

    void sendRawMessage(String message);

    void sendMessage(String message, MessageType type);

    void log(String message);

    void clearScreen();

    void clearCommandField();

    void dispatch(String command);

    void sendAll(String message);
}
