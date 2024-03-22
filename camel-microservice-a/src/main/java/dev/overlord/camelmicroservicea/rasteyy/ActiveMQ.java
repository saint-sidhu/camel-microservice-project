package dev.overlord.camelmicroservicea.rasteyy;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQ extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //timer
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My message for ActiveMQ")
                .log("${body}")
                .to("activemq:myactive-mq-queue");
        //queue
    }
}
