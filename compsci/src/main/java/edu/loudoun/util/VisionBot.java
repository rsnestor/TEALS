package edu.loudoun.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class VisionBot {

	public static void main(String[] args) {

		if (args.length < 2)
			throw new IllegalArgumentException("VisionBot <userid> <password>");

		try {

			URL visUrl = new URL("https://loudounvision.net/login/index.php");
			HttpURLConnection conn = (HttpURLConnection) visUrl.openConnection();
			// Map<String, List<String>> map = conn.getHeaderFields();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Nestor)");
			conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			conn.setRequestProperty( "charset", "utf-8");

			String urlParameters = "username=" + args[0] + "&password=" + args[1];

			// Send post request
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			InputStream response = conn.getInputStream();
			
			String contentType = conn.getHeaderField("Content-Type");
			String charset = null;

			for (String param : contentType.replace(" ", "").split(";")) {
			    if (param.startsWith("charset=")) {
			        charset = param.split("=", 2)[1];
			        break;
			    }
			}

			if (charset != null) {
			    try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset))) {
			        for (String line; (line = reader.readLine()) != null;) {
			            System.out.println(line);
			        }
			    }
			}
			/*
			System.out.println("Printing All Response Header for URL: " + visUrl.toString() + "\n");

			Map<String, List<String>> map = conn.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}

			System.out.println("\nGet Response Header By Key ...\n");
			List<String> contentLength = map.get("Content-Length");

			if (contentLength == null) {
				System.out.println("'Content-Length' doesn't present in Header!");
			} else {
				for (String header : contentLength) {
					System.out.println("Content-Lenght: " + header);
				}
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
