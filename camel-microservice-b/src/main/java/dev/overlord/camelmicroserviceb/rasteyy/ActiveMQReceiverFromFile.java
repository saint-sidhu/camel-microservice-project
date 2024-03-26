package dev.overlord.camelmicroserviceb.rasteyy;

import dev.overlord.camelmicroserviceb.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class ActiveMQReceiverFromFile extends RouteBuilder {



    @Autowired
    private MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;
    @Override
    public void configure() throws Exception {
        from("activemq:activemq-file-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(myCurrencyExchangeProcessor)
                .to("log:received-message-from-file-queue");
    }
}
class MyCurrencyExchangeProcessor{
    private final Logger logger = LoggerFactory.getLogger(ActiveMQReceiverFromFile.class);
    public void processMessage(CurrencyExchange currencyExchange){

        logger.info("Do some processing with currencyExchnage",currencyExchange.getConversionMultiple());
    }
}

