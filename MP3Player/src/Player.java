import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import jaco.mp3.player.MP3Player;
import jaco.mp3.player.plaf.MP3PlayerUICompact;

public class Player {

	private JFrame frame;
	private JLabel lb;
	private File parentDir;
	int i;
	private MP3Player player;
	static File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player window = new Player();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Player() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("MP3 PLAYER");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		lb = new JLabel("MP3 PLAYER");
		lb.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(299, 0, 146, 43);
		JLabel icon = new JLabel();
		icon.setIcon(new ImageIcon("C:\\Users\\AMIR\\Downloads\\music.png"));
		icon.setBounds(48, 11, 65, 43);


		parentDir = new File("C:\\workspace-eclipse\\TestFile\\Music");
		String[] fileNames = parentDir.list();


		frame.getContentPane().add(lb);
		frame.getContentPane().add(icon);
		frame.setSize(783, 463);
		frame.getContentPane().setLayout(null);

		JButton Play = new JButton("");
		Play.setBackground(SystemColor.activeCaption);
		Play.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\play.png"));
		Play.setBounds(355, 356, 56, 58);
		frame.getContentPane().add(Play);

		JButton Pause = new JButton("");
		Pause.setBackground(SystemColor.activeCaption);
		Pause.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\pause.png"));
		Pause.setBounds(289, 379, 42, 35);
		frame.getContentPane().add(Pause);

		JButton Next = new JButton("");
		Next.setBackground(SystemColor.activeCaption);
		Next.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\next 1.png"));
		Next.setBounds(501, 379, 42, 35);
		frame.getContentPane().add(Next);

		JButton Previous = new JButton("");
		Previous.setBackground(SystemColor.activeCaption);
		Previous.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\prev 1.png"));
		Previous.setBounds(218, 379, 42, 35);
		frame.getContentPane().add(Previous);

		JLabel lblFileName = new JLabel();
		lblFileName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileName.setFont(new Font("Simplified Arabic", Font.BOLD, 16));
		lblFileName.setText(fileNames[0]);
		lblFileName.setBounds(242, 38, 263, 43);
		frame.getContentPane().add(lblFileName);
		
		JButton Stop = new JButton("");
		Stop.setBackground(SystemColor.activeCaption);
		Stop.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\stop.png"));
		Stop.setBounds(434, 379, 42, 35);
		frame.getContentPane().add(Stop);
		
		JLabel gif = new JLabel("");
		gif.setIcon(new ImageIcon("C:\\Users\\AMIR\\Pictures\\download.gif"));
		gif.setBounds(56, 91, 660, 243);
		frame.getContentPane().add(gif);
		frame.setVisible(true);

		List<String> names = new ArrayList<String>();
		for(String s : fileNames) {
			names.add(s);
		}
		
		System.out.println("text : " + lblFileName.getText());

		Play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				file = new File(parentDir, lblFileName.getText());
				
				player = new MP3Player(file);
				player.play();
				
			}
		});
		
		Pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				file = new File(parentDir, lblFileName.getText());
				
				if(!player.isPaused()) {
					
					player.pause();
					
				}
				
			}
		});

		Stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				file = new File(parentDir, lblFileName.getText());
				
				if(!player.isStopped()) {
					
					player.stop();
					
				}
				
			}
		});
		
		Next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = names.indexOf(lblFileName.getText());
				
				if(!player.isPaused()) {
					
					player.pause();
					
				}

				System.out.println(names.get(index++));
				lblFileName.setText(names.get(index++));
			}
		});

		Previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = names.indexOf(lblFileName.getText());

				if(!player.isPaused()) {

					player.pause();

				}
				
				System.out.println(names.get(index--));
				lblFileName.setText(names.get(index--));
			}
		});


	}
}























