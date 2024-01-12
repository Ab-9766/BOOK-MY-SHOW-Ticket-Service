package org.example.bms.Exceptions;

import ch.qos.logback.core.encoder.EchoEncoder;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User was not found");
    }
}
