package dev.overlord.camelmicroservicea.rasteyy;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQXMLSender extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //I am going to take xml file from this directory and send it to a queue
        from("file:files/xml")
                .log("${body}")
                .to("activemq:activemq-xml-queue");
    }
}
