package dev.overlord.camelmicroserviceb.rasteyy;

import dev.overlord.camelmicroserviceb.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSMLReceiver extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:activemq-xml-queue")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
                .to("log:received-xml-file");
    }
}
