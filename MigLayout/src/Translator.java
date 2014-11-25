import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class Translator {
	private final String googleTranslate = "https://translate.google.com/#";
	//https://translate.google.com/#en/es/hello%20world
	
	public String Translate( String from, String to, String item ) {

        String translation = googleTranslate + from + '/' + to + '/' + item;
        URL translationURL;
        URLConnection connection;

        try { 
        	translationURL = new URL(translation); 
        	connection = translationURL.openConnection();
        	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        	connection.connect();
        	}
        catch(IOException e) { return e.getMessage(); }

        BufferedReader httpin;
        String fullPage = "";
        System.out.println(translation);
        try {
            httpin = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            String line;
            while((line=httpin.readLine()) != null) { fullPage += line + '\n'; }
            httpin.close();
        } catch(IOException e) { return e.getMessage(); }

        return fullPage.toString();

    }
	
	public Translator(){}
}
