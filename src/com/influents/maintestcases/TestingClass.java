package com.influents.maintestcases;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TestingClass {
	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath(".").toAbsolutePath();
		System.out.println(path);
	}
}
