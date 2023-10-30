

package com.example;
import com.fazecast.jSerialComm.*;

import javafx.application.Application;

import java.util.ArrayList;

public class NonblockingReading{
        private static String Value;
        // source pour la recuperation des donnees avec le serial : https://github.com/Fazecast/jSerialComm/wiki/Nonblocking-Reading-Usage-Example
        public static String getValue() {
            return Value;
        }

    public static void init() {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort(); 

        try {
            while (true) {
                while (comPort.bytesAvailable() == 0)
                    Thread.sleep(20);

                byte[] readBuffer = new byte[comPort.bytesAvailable()]; 
                int numRead = comPort.readBytes(readBuffer, readBuffer.length); 
                System.out.println("Read " + numRead + " bytes."); 
                Value="";
                for (int i = 0; i < readBuffer.length; ++i){
                    Value+=(char) readBuffer[i];
                }

                // valList.add(Value);
                System.out.println(Value);    
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        comPort.closePort(); // fermeture de port
    }
}


        // source pour la recuperation des donnees avec le serial : https://github.com/Fazecast/jSerialComm/wiki/Nonblocking-Reading-Usage-Example
