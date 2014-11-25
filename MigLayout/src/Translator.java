import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Translator {
	private final String googleTranslate = "http://translate.google.com/#";
	//https://translate.google.com/#en/es/hello%20world
	
	public String Translate( String from, String to, String item ) {

        String translation = googleTranslate + from + '|' + to + '|' + item;
        URL translationURL;

        try { 
        	translationURL = new URL(translation); 
        	URLConnection conn = translationURL.openConnection();
        	// fake request coming from browser
        	conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
        	}
        catch(IOException e) { return e.getMessage(); }

        BufferedReader httpin;
        String fullPage = "";
        System.out.println(translation);
        try {
            httpin = new BufferedReader(
                    new InputStreamReader(translationURL.openStream()));
            String line;
            while((line=httpin.readLine()) != null) { fullPage += line + '\n'; }
            httpin.close();
        } catch(IOException e) { return e.getMessage(); }

        int begin = fullPage.indexOf("<span class=\"\">");
        int end = fullPage.indexOf("</span>");

        return fullPage.substring(begin + 15, end);

    }
	
	public Translator(){}
}
