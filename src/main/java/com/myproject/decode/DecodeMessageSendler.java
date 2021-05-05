/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.decode;

import java.io.IOException;
import javax.jms.JMSException;

/**
 *
 * @author nasretdinova.u.k
 */
public class DecodeMessageSendler {
    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        final String pathConfigConsumer = "com/myproject/decode/consumer.properties";
        final String pathConfigProducer = "com/myproject/decode/producer.properties";
        
        MessageProcessorImpl processor = new MessageProcessorImpl();
        processor.init(pathConfigConsumer, pathConfigProducer);
        processor.start();


        try {
            processor.start();            
        } catch (JMSException e) {
            System.err.println("Exception occurred: " + e.toString());
        }
        finally {
            processor.stop();
        }
    }
}
