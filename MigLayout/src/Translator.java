import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;


public class Translator {

	
	public String Translate( String from, String to, String item ) {

	    Translate.setClientId("Miglayoutprojectid");
	    Translate.setClientSecret("8nwAAraqI80QpHuk6MRW1z6XDX89ES7HuPkamZgNKxY=");
	    
	    Language translateFrom = getLanguage(from);
	    Language translateTo = getLanguage(to);
	    
	    
	    
	    String translatedText = "";
		try {
			translatedText = Translate.execute(item, translateFrom, translateTo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return translatedText;

    }
	
	public Language getLanguage(String lang) {
		//TODO add other languages
		switch(lang){
		case "en":
			return Language.ENGLISH;
		case "fr":
			return Language.FRENCH;
		case "es":
			return Language.SPANISH;
		case "ru":
			return Language.RUSSIAN;
		case "sw":
			return Language.SWEDISH;
		case "fn":
			return Language.FINNISH;
		case "gr":
			return Language.GERMAN;
		case "ch":
			return Language.CHINESE;
		case "hi":
			return Language.HINDI;
		case "is":
			return Language.IRISH;
			
		}
		return Language.AUTO_DETECT;
	}
	public Translator(){}
}
