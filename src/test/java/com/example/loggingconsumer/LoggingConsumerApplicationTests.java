package com.example.loggingconsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

@SpringBootTest(classes = LoggingConsumerApplication.class)
@Import({ TestChannelBinderConfiguration.class })
public class LoggingConsumerApplicationTests {

	@Autowired
	private OutputDestination output;

	@Test
	void supplierTest() {
		Message<byte[]> message = output.receive();
		assertEquals(GenericMessage.class, message.getClass());

	}
}