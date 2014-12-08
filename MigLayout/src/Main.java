import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.memetix.mst.language.Language;
import net.miginfocom.swing.MigLayout;

public class Main {

	public static void main(String[] args) {
		
		try
		 {
			 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		 }catch(Exception e){}
		System.out.println("Testing git");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 200);
		
		JButton button = new JButton("Translate");
		JLabel label1 = new JLabel("Input your text here");
		JLabel label2 = new JLabel("Languagues to translate through");
		JLabel label3 = new JLabel("Your text translated through your selected languages back into English");
		final JTextArea input = new JTextArea(20,60);
		final JTextArea output = new JTextArea(10,60);
		
		final JRadioButton Spanishbutton = new JRadioButton("Spanish");
		final JRadioButton Swedishbutton = new JRadioButton("Swedish");
		final JRadioButton Finnishbutton = new JRadioButton("Finnish");
		final JRadioButton Germanbutton = new JRadioButton("German");
		final JRadioButton Chinesebutton = new JRadioButton("Chinese");
		final JRadioButton Hindubutton = new JRadioButton("Hindu");
		final JRadioButton Italianbutton = new JRadioButton("Italian");
		final JRadioButton Frenchbutton = new JRadioButton("French");
		JCheckBox checkbox = new JCheckBox("Random order of translation");
		JPanel parentContainer = new JPanel();
		JPanel panel = new JPanel(new MigLayout());
		JPanel panel2 = new JPanel(new MigLayout());
		frame.add(parentContainer);
		parentContainer.setLayout(new MigLayout("debug","[] []"," [] [] []"));
		
		panel.add(Spanishbutton);
		panel.add(Swedishbutton);
		panel.add(Finnishbutton ,"wrap");
		panel.add(Germanbutton);
		panel.add(Chinesebutton);
		panel.add(Hindubutton,"wrap");
		panel.add(Italianbutton);
		panel.add(Frenchbutton,"wrap");
		panel.add(checkbox,"wrap");
		button.setSize(30, 30);
		panel.add(button,"span ,push,grow,wrap");
		
		parentContainer.add(label1,"left");
		parentContainer.add(label2,"wrap");
		parentContainer.add(input);
		parentContainer.add(panel,"span,center,wrap");
		
		parentContainer.add(label3,"wrap");
		parentContainer.add(output,"span2 , grow, wrap");
	
		frame.add(parentContainer,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Translator translator = new Translator();
				if(Spanishbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.SPANISH.toString(), input.getText());
					output.setText(result);
				}else if(Swedishbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.SWEDISH.toString(), input.getText());
					output.setText(result);
				}else if(Finnishbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.FINNISH.toString(), input.getText());
					output.setText(result);
				}else if(Germanbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.GERMAN.toString(), input.getText());
					output.setText(result);
				}else if(Chinesebutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.CHINESE_SIMPLIFIED.toString(), input.getText());
					output.setText(result);
				}else if(Hindubutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.HINDI.toString(), input.getText());
					output.setText(result);
				}else if(Italianbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.ITALIAN.toString(), input.getText());
					output.setText(result);
				}else if(Frenchbutton.isSelected()){
					String result = translator.Translate(Language.ENGLISH.toString(), Language.FRENCH.toString(), input.getText());
					output.setText(result);
				}
			}
		});
		
		//TODO LANGUAGES SPANISH AND FRENCH WORK. LANGUAGE CODES FOR OTHERS DONT WORK
		//Jazus lads ye did great work there. I must get my finger out...
	}

}
