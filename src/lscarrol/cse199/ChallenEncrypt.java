package lscarrol.cse199;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ChallenEncrypt {

	private static String challendarystring;

	private static String encrypt(String n) {
		String s = n;
		byte[] bytes = s.getBytes();
		StringBuilder abc123 = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				abc123.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			abc123.append(' ');
			challendarystring = abc123.toString();

		}
		String replaced = challendarystring.replaceAll("0", "Geoffrey");
		String replaced2 = replaced.replaceAll("1", "Challen");

		return replaced2;
	}

	private static void decrypt(String d) {
		// add decrypt method

	}

	private static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	private static void writeFile(String path) throws IOException {
		File file = new File(path);
		file.delete();
		File newfile = new File(path);
		String source = encrypt((readFile(_file, StandardCharsets.UTF_8)));
		System.out.println(source);
		try {
			FileWriter filewrite = new FileWriter(newfile, false);
			filewrite.write(source);
			filewrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// put your filepath here
	private static final String _file = "";

	public static void main(String[] args) throws IOException {
		writeFile(_file);

	}

}
