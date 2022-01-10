package com.star.app.screen.utils;

import java.io.*;

public class ProcessingResult {
    public static void serialize(Result result){
        try(FileOutputStream fileOutputStream = new FileOutputStream("result.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Result deserialize(){

        try(FileInputStream fileInputStream = new FileInputStream("result.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Result) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Result(-1,-1);
    }
}
