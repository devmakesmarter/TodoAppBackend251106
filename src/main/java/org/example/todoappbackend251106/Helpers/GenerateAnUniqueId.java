package org.example.todoappbackend251106.Helpers;

import java.util.UUID;

public class GenerateAnUniqueId {



    public static String uniqueId(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }
}
