package com.example.learning.lock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.nio.channels.NonWritableChannelException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLockExample {

	public static void main(String[] args) {
		Path path = null;

		try {
			path = Files.createTempFile("foo", "txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (FileOutputStream fis = new FileOutputStream(path.toFile())) {
			FileLock lock = fis.getChannel().lock(0, Long.MAX_VALUE, true);

		} catch (NonWritableChannelException | IOException e) {
			// TODO: handle exception
		}
	}

}
