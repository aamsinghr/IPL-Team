package files.interaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class designed to support interaction (Read/Add/Delete/Update) with JSON
 * Files
 */
public class ReadJSON {

	private ReadJSON() {
		throw new IllegalStateException("Utility class");
	}

	private static final String USER_DIR_CONSTANT = "user.dir";
	private static final String USER_DIR_PATH = File.separator + "src" + File.separator + "test" + File.separator
			+ "resources" + File.separator;

	/**
	 * Given a file name within the .src/test/resources folder, it will read the file and return
	 * the contents as a string.
	 *
	 * @param
	 * @return Contents of the file as a String
	 */
	public static String parse(String fileName) {
		try {
			String path = System.getProperty(USER_DIR_CONSTANT) + USER_DIR_PATH;

			return readFileAsString(path + fileName);
		} catch (IOException ex) {
			throw new UnsupportedOperationException(ex);
		}
	}

	/**
	 * Gets the JSONArray from a JSONObject / Node
	 *
	 * @param jsonobj The JSONObject to use
	 * @param node Index/node of where the JSONObject is
	 * @return The JSONObject at the given index
	 */
	public static JSONArray getArray(JSONObject jsonobj, String node) {
		JSONArray obj = null;

		try {
			obj = jsonobj.getJSONArray(node);
		} catch (JSONException e) {

		}
		return obj;
	}

	/**
	 * Gets the JSONObject from a JSONObject / Node
	 *
	 * @param jsonobj The JSONObject to use
	 * @param node Index/node of where the JSONObject is
	 * @return The JSONObject at the given index
	 */
	public static JSONObject getObject(JSONObject jsonobj, String node) {
		JSONObject obj = null;

		try {
			obj = jsonobj.getJSONObject(node);
		} catch (JSONException e) {

		}
		return obj;
	}

	/**
	 * Reads file and converts to String.
	 *
	 * @param filePath
	 * @throws IOException
	 */
	static String readFileAsString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);

		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		char[] buf = new char[1024];
		int numRead = 0;
		try {
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
		} catch (IOException e) {
		} finally {
			reader.close();
		}

		return fileData.toString();
	}

}
