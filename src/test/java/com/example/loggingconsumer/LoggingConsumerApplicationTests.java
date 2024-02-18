package com.example.loggingconsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;

@SpringBootTest(classes = LoggingConsumerApplication.class)
@Import({ TestChannelBinderConfiguration.class })
public class LoggingConsumerApplicationTests {

	@Autowired
	private InputDestination input;

	@Test
	void consumerTest() {
		input.send(new GenericMessage<byte[]>("{\"name\":\"Sam Spade\"}".getBytes()));

//		Redirect System.out to ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		PrintStream originalOut = System.out;
		System.setOut(printStream);

		input.send(new GenericMessage<byte[]>("{\"name\":\"Sam Spade\"}".getBytes()));

		String capturedOutput = outputStream.toString();

		System.setOut(originalOut);

		assertTrue(capturedOutput.length() > 19);

		String next19Characters = capturedOutput.substring(0, 19);
		assertEquals("Received: Sam Spade", next19Characters);

	}
}