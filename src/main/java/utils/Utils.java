package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.LoginUserModel;
import model.RegisterUserModel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

	public static void waitForSeconds(double seconds) {

		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static List<LoginUserModel> getDataFromJson() {

		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/user.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Gson().fromJson(reader, new TypeToken<List<LoginUserModel>>(){}.getType());
	}

	public static RegisterUserModel gerDataFromJson() {

		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/registeruser.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Gson().fromJson(reader, new TypeToken<RegisterUserModel>(){}.getType());
	}
}
