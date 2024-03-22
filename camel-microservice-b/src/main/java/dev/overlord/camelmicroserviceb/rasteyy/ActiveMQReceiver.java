package dev.overlord.camelmicroserviceb.rasteyy;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiver extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:myactive-mq-queue")
                .to("log:received-messsages-from-activemq-queue");
    }
}
