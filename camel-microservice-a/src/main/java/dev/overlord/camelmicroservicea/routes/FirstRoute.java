package dev.overlord.camelmicroservicea.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//@Component
public class FirstRoute extends RouteBuilder {
    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;
    @Override
    public void configure() throws Exception {
        from("timer:first-timer")
                .log("${body}")
                .transform().constant("First Constant")
                .log("${body}")
                .bean(getCurrentTimeBean)
                .log("${body}")
                .process(new SimpleLoggingProcessor())
                .log("${body}")
                .to("log:first-log");
    }
}
@Component
class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "Time now is" + LocalDateTime.now();
    }
}

class SimpleLoggingProcessor implements Processor{
    private final Logger logger= LoggerFactory.getLogger(SimpleLoggingProcessor.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("SimpleLoggingProcessor {}", exchange.getMessage().getBody());
    }
}
