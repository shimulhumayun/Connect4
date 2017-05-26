package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3793459710562532465L;
	private JPanel wrap;
	public Instructions(){
		//gui=new Gui();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setBackground(new Color(255,0,0,20));
		wrap=new JPanel(new FlowLayout());
		wrap.setAlignmentX(CENTER_ALIGNMENT);
		wrap.setBorder(BorderFactory.createTitledBorder(""));
		wrap.setOpaque(false);
		titleLabels();
		rules();
	
		addImage();
		this.add(wrap);
	}
	public void titleLabels(){
		JLabel emptyLabel=new JLabel(" ");
		this.add(emptyLabel);
		JLabel title=new JLabel("How to play connect 4");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		//title.setBorder(BorderFactory.createEtchedBorder());
		title.setAlignmentX(CENTER_ALIGNMENT);
		this.add(title);
		JLabel underline=new JLabel("_____________________________________");
		underline.setForeground(Color.GREEN);
		underline.setAlignmentX(CENTER_ALIGNMENT);
		this.add(underline);
		JLabel emptyLabel2=new JLabel(" ");
		this.add(emptyLabel2);
		
		
	}
	public void rules(){
		JLabel redLabel=new JLabel("1. It's Player 1(Red Checker");
		JLabel redImageLabel=new JLabel(new ImageIcon(this.getClass().getResource("/project/images/redLabel.png")));
		JLabel label2=new JLabel(") VS Player 2 ( Yellow Checker");
		wrap.add(redLabel);
		wrap.add(redImageLabel);
		wrap.add(label2);
		JLabel yellowImageLabel=new JLabel(new ImageIcon(this.getClass().getResource("/project/images/yellowLabel.png")));
		wrap.add(yellowImageLabel);
		wrap.add(new JLabel(")"));
		JLabel label3=new JLabel("2. Players take turn to drop checkers.Click top buttons to drop \t \t \t \t ");
		JLabel label4=new JLabel("<html> &nbsp;&nbsp;&nbsp;&nbsp;3.The play alternates until one of the players gets"
				+ " four checkers of his <br> &nbsp;&nbsp;&nbsp;&nbsp;color in a row.The four in a row can be horizontal,"
				+ " vertical, or diagonal.</html>");
		JLabel label5=new JLabel("<html> &nbsp;&nbsp;&nbsp;&nbsp;4. The first player to get four in a row wins.If the board"
				+ " is filled with &nbsp; &nbsp;&nbsp;<br> &nbsp;&nbsp;&nbsp;&nbsp;pieces and neither player has 4 in a row, "
				+ "then the game is a draw.</html>");
		wrap.add(label3);
		wrap.add(label4);
		wrap.add(label5);
	}
	public void addImage(){
		wrap.setAlignmentX(CENTER_ALIGNMENT);
		JLabel img1=new JLabel(new ImageIcon(this.getClass().getResource("/project/images/img1.png")));
		img1.setBorder(BorderFactory.createTitledBorder("Verticle"));
		JLabel img2=new JLabel(new ImageIcon(this.getClass().getResource("/project/images/img2.png")));
		img2.setBorder(BorderFactory.createTitledBorder("Diagonal"));
		JLabel img3=new JLabel(new ImageIcon(this.getClass().getResource("/project/images//img3.png")));
		img3.setBorder(BorderFactory.createTitledBorder("Horizontal"));
		wrap.add(img1);
		wrap.add(img2);
		wrap.add(img3);
		wrap.add(new JLabel("<html>&nbsp;&nbsp;</html>"));
		wrap.add(new JLabel("\t"));
		
	}
  public void addButton(JButton btn){
	  btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
	  btn.setForeground(Color.RED);
	  //btn.setBackground(Color.GREEN);
	  //btn.setBorder(new BevelBorder(BevelBorder.RAISED));
	// btn.setBorder(BorderFactory.createLoweredBevelBorder());
	 wrap.add(btn);
	  
  }
}
