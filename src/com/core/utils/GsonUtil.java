package com.core.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.core.TestDataController;
import com.google.gson.Gson;
import com.model.TestModel;

public class GsonUtil {

	public static String path = "e:\\file.json";

	public static void saveGsonTestToFile() {

		Gson gson = new Gson();

		String json = gson.toJson(TestDataController.getInstance().getTest());

		try {
			FileWriter writer = new FileWriter(path);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void retrieveTestModelFromJson() {

		Gson gson = new Gson();

		try {
			BufferedReader br = new BufferedReader(new FileReader("e:\\file.json"));

			TestModel obj = gson.fromJson(br, TestModel.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
