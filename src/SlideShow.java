import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = "";
		switch (i) {
			case 1:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/yoga_retreat.jpg") + "'</body></html>";
				break;
			case 2:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/wellness_resort.jpg") + "'</body></html>";
				break;
			case 3:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/nature_scene.jpg") + "'</body></html>";
				break;
			case 4:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/meditation_space.jpg") + "'</body></html>";
				break;
			case 5:
				image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/hiking_trail.jpg") + "'</body></html>";
				break;
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = "";
		switch (i) {
			case 1:
				text = "<html><body><font size='5'>Serene Yoga Retreat.</font> <br>Find peace and balance in nature.</body></html>";
				break;
			case 2:
				text = "<html><body><font size='5'>Luxury Wellness Resort.</font> <br>Experience ultimate relaxation and rejuvenation.</body></html>";
				break;
			case 3:
				text = "<html><body><font size='5'>Nature Scene.</font> <br>Embrace the tranquility of the great outdoors.</body></html>";
				break;
			case 4:
				text = "<html><body><font size='5'>Meditation in Forest.</font> <br>Connect with nature in a serene forest setting.</body></html>";
				break;
			case 5:
				text = "<html><body><font size='5'>Hiking Adventure.</font> <br>Explore and rejuvenate on scenic trails.</body></html>";
				break;
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}