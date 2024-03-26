package dev.overlord.camelmicroservicea.rasteyy;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderFromFile extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //I am going to read from a directory and push it to queue.
        from("file:files/json")
                .log("${body}")
                .to("activemq:activemq-file-queue");
    }
}
