import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 400);
		
		JButton button = new JButton("Translate");
		JLabel label1 = new JLabel("Input your text here");
		JLabel label2 = new JLabel("Languagues to translate through");
		JLabel label3 = new JLabel("Your text translated through your selected languages back into English");
		JTextArea input = new JTextArea(20,60);
		JTextArea output = new JTextArea(10,60);
		
		JRadioButton Russianbutton = new JRadioButton("Russian");
		JRadioButton Swedishbutton = new JRadioButton("Swedish");
		JRadioButton Finnishbutton = new JRadioButton("Finnish");
		JRadioButton Germanbutton = new JRadioButton("German");
		JRadioButton Chinesebutton = new JRadioButton("Chinese");
		JRadioButton Hindubutton = new JRadioButton("Hindu");
		JRadioButton Irishbutton = new JRadioButton("Irish");
		JRadioButton Frenchbutton = new JRadioButton("French");
		JCheckBox checkbox = new JCheckBox("Random order of translation");
		JPanel parentContainer = new JPanel();
		JPanel panel = new JPanel(new MigLayout());
		JPanel panel2 = new JPanel(new MigLayout());
		frame.add(parentContainer);
		parentContainer.setLayout(new MigLayout("debug","[] []"," [] [] []"));
		
		panel.add(Russianbutton);
		panel.add(Swedishbutton);
		panel.add(Finnishbutton ,"wrap");
		panel.add(Germanbutton);
		panel.add(Chinesebutton);
		panel.add(Hindubutton,"wrap");
		panel.add(Irishbutton);
		panel.add(Frenchbutton,"wrap");
		panel.add(checkbox,"wrap");
		button.setSize(30, 30);
		panel.add(button,"span ,push,grow,wrap");
		
		
		
		
		
		
		parentContainer.add(label1,"left");
		parentContainer.add(label2,"wrap");
		parentContainer.add(input);
		parentContainer.add(panel,"span,center,wrap");
		//parentContainer.add(button,;
		
		parentContainer.add(label3,"wrap");
		//output.setBorder(BorderFactory.createEtchedBorder());
		parentContainer.add(output,"span2 , grow, wrap");
	
		
	
		
		//parentContainer.setVisible(true);
		frame.add(parentContainer,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		Translator translator = new Translator();
		String result = translator.Translate("en", "es", "Hello World");
		System.out.println(result);
	}

}
