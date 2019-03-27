package com.framework.ssm.consumer;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PigHandler implements MessageListener {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public void onMessage(Message msg) {
        try {
            //msg就是rabbitmq传来的消息，需要的同学自己打印看一眼
            // 使用jackson解析
            JsonNode jsonData = MAPPER.readTree(msg.getBody());
            System.out.println("我是可爱的小猪,我的id是" + jsonData.get("id").asText()
                    + ",我的名字是" + jsonData.get("name").asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
