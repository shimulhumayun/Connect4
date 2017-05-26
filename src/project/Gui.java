package project;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.acl.Group;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Gui extends JPanel implements ActionListener,ItemListener {
	// Buttons of Buttons
	private int[] totalRow;;
	private JButton[][] checkers; // buttons
	private JButton[] drop;
	private Icon red;
	private Icon yellow;
	private String currentPlayer = "Red"; // 0=red
	private JPanel sidePanel;
	private JPanel topPanel;
	private GameLogic findWinner;
	private JButton play;
	private JButton restart;
	private JPanel main; // main gridPanel
	private JPanel panel; // main panel 2nd
	private JPanel dropPanel;
	private JLabel messageLabel;
	private String player = "Player 1";
	private Icon redLabelIcon;
	private Icon yellowLabelIcon;
	private JPanel radioPanel;
	Instructions instructions;

	Gui() {
		this.setLayout(new BorderLayout());
		checkers = new JButton[6][7]; // buttons
		instructions = new Instructions();
		play = new JButton("Lets Play");
		instructions.addButton(play);
		play.addActionListener(this);
		// instructions.addButton(play);
		this.add(headerPanel(), BorderLayout.NORTH);
		this.add(topPanel(), BorderLayout.CENTER);
		this.add(instructions, BorderLayout.CENTER);
		totalRow = new int[7];
		// all the icons
		red = new ImageIcon(this.getClass().getResource("/project/images/red.png"));
		yellow = new ImageIcon(this.getClass().getResource("/project/images/yellow.png"));
		// message label icons
		redLabelIcon = new ImageIcon(this.getClass().getResource("/project/images/redplayer1.png"));
		yellowLabelIcon = new ImageIcon(this.getClass().getResource("/project/images/yellowicon.png"));
		findWinner = new GameLogic(4);
		rowCounter();
	}

	private void rowCounter() { // initialize all the rows to 5
		for (int i = 0; i < totalRow.length; i++) {
			totalRow[i] = 6;
		}

	}

	// update icon and the
	public Icon updatePlayer() {
		if (currentPlayer.equalsIgnoreCase("Red")) {
			currentPlayer = "Yellow";
			return red;
		} else {
			currentPlayer = "Red";
			return yellow;
		}

	}

	public JPanel topPanel() {
		topPanel = new JPanel(new BorderLayout());
		topPanel.add(gridPanel(), BorderLayout.CENTER);
		topPanel.add(sidePanel(), BorderLayout.EAST);
		topPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		return topPanel;
	}

	public JPanel headerPanel() {
		JPanel p = new JPanel();
		JLabel label = new JLabel("<html><center><font color='yellow'>Connect</font></center></html>");
		// JLabel label = new JLabel("CONNECT");
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
		JLabel connect = new JLabel("<html><font color='red'>4</font></html>");
		connect.setFont(new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 100));
		p.setForeground(Color.CYAN);
		p.setBackground(new Color(30, 144, 255));
		p.add(label);
		p.add(connect);
		return p;
	}

	public JPanel colGrid() {
		dropPanel = new JPanel(new GridLayout(1, 7));
		dropPanel.setBackground(new Color(100, 149, 237));
		drop = new JButton[7];
		for (int i = 0; i < drop.length; i++) {
			drop[i] = new JButton("" + (i + 1));
			drop[i].addActionListener(this);
			drop[i].setToolTipText("Drop a checker");
			dropPanel.add(drop[i]);
		}
		return dropPanel;
	}

	public JPanel gridPanel() {
		main = new JPanel(new BorderLayout());
		main.add(colGrid(), BorderLayout.NORTH);
		panel = new JPanel(new GridLayout(6, 7));
		panel.setBackground(new Color(100, 149, 237));
		panel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		for (int row = 0; row < checkers.length; row++) {
			for (int col = 0; col < checkers[row].length; col++) {
				// NOTE: made a change
				checkers[row][col] = new JButton(".");
				checkers[row][col].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 0));
				// checkers[row][col] = new JButton();
				// coding added to check
				checkers[row][col].setIcon(new ImageIcon(this.getClass().getResource("/project/images/white.png")));
				checkers[row][col].setBorder(new BevelBorder(BevelBorder.LOWERED));
				panel.add(checkers[row][col]);
			}
		}
		main.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		main.add(panel, BorderLayout.CENTER);
		// return panel;
		return main;
	}

	public JPanel sidePanel() {
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(255, 255, 255, 255));
		// sidePanel.setBackground(Color.GRAY);
		// sidePanel.setLayout(new FlowLayout());
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		JLabel player1 = new JLabel("Player1: Red ");
		// player1.setIcon(new
		// ImageIcon(this.getClass().getResource("/project/images/redplayer1.png")));
		// redLabelIcon
		player1.setIcon(redLabelIcon);
		player1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		sidePanel.add(player1);
		sidePanel.add(Box.createRigidArea(new Dimension(10, 5)));
		// sidePanel.add(new JLabel(new
		// ImageIcon(this.getClass().getResource("/project/images/redplayer1.png"))));
		JLabel player2 = new JLabel("Player2: Yellow ");
		// player2.setIcon(new
		// ImageIcon(this.getClass().getResource("/project/images/yellowicon.png")));
		player2.setIcon(yellowLabelIcon);
		player2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		// turn.setBorder(BorderFactory.createTitledBorder(""));
		sidePanel.add(player2);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 10)));
		// for testing
		
		restart = new JButton("Start a New Game");
		restart.addActionListener(this);
		// Panel for the Message and winner
		radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
		messageLabel = new JLabel(this.player+"'s turn ");
		messageLabel.setIcon(redLabelIcon);
		messageLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		sidePanel.add(messageLabel);
		// wrapWinner.add(messageLabel);
		radioPanel.setBorder(BorderFactory.createTitledBorder("Connect:"));
		radioPanel.setBackground(Color.WHITE);
		ButtonGroup group=new ButtonGroup();
		JRadioButton two=new JRadioButton("Two \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
		two.addItemListener(this);
		two.setPreferredSize(new Dimension(20,90));
		JRadioButton three=new JRadioButton("Three");
		JRadioButton four=new JRadioButton("Four");
		four.setSelected(true);
		JRadioButton custom=new JRadioButton("ConnectX");
		group.add(two);
		radioPanel.add(two);
		group.add(three);
		radioPanel.add(three);
		group.add(four);
		radioPanel.add(four);
		group.add(custom);
		radioPanel.add(custom);
		
		sidePanel.add(Box.createRigidArea(new Dimension(10, 10)));
		sidePanel.add(radioPanel);
		// sidePanel.add(test);
		sidePanel.add(Box.createRigidArea(new Dimension(10, 50)));
		sidePanel.add(restart);
		return sidePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		str = str.trim();
		if (str.equalsIgnoreCase("Lets Play")) {
			this.add(topPanel(), BorderLayout.CENTER);
			// btn.setVisible(false);
			this.remove(instructions); // remove the instruction panel
			this.validate();

		} else if (str.equalsIgnoreCase("Start a New Game")) {
			// this.currentPlayer="Yellow";
			// remove all the checker buttons
			messageLabel.setText(player+"'s turn");
			removeAllCheckers();
			// reset drop
			removeAlldrop();
			// reset counters
			rowCounter();
			sidePanel.revalidate();
			sidePanel.repaint();

		} else {
			int col = Integer.parseInt(e.getActionCommand()) - 1;
			if (totalRow[col] == 0) {
				drop[col].removeActionListener(this);
			} else {
				setPlayerIcon(col);
			}
		}

	}

	// remove all the drop button and re-add them to panel
	private void removeAlldrop() {
		for (int i = 0; i < drop.length; i++) {
			dropPanel.remove(drop[i]);
			drop[i] = new JButton("" + (i + 1));
			drop[i].addActionListener(this);
			drop[i].setToolTipText("Drop a checker");
			dropPanel.revalidate();
			dropPanel.repaint();
			dropPanel.add(drop[i]);
		}

	}

	private void removeAllCheckers() {
		for (int row = 0; row < checkers.length; row++) {
			for (int col = 0; col < checkers[row].length; col++) {
				// remove the button and then re-add the button the panel
				panel.remove(checkers[row][col]);
				checkers[row][col] = new JButton(".");
				checkers[row][col].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 0));
				checkers[row][col].setIcon(new ImageIcon(this.getClass().getResource("/project/images/white.png")));
				checkers[row][col].setBorder(new BevelBorder(BevelBorder.LOWERED));
				panel.revalidate();
				panel.repaint();
				panel.add(checkers[row][col]);
			}
		}
		//

	}

	// helper method
	private void setPlayerIcon(int column) {
		boolean winner = false; // check if there's a winner
		totalRow[column] -= 1;
		checkers[totalRow[column]][column].setText(this.currentPlayer);

		if (totalRow[column] < 0) {
			drop[column].removeActionListener(this);
		} else {
			checkers[totalRow[column]][column].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 0));

			if (findWinner.diagonalUp(currentPlayer, checkers) || findWinner.diagonalDown(currentPlayer, checkers)
					|| findWinner.vertical(currentPlayer, checkers) || findWinner.horizontal(currentPlayer, checkers)) {
				winner = true;
				removeListener();
				checkers[totalRow[column]][column].setIcon(updatePlayer());
				messageLabel.setText(" " + this.player + " WINS");
				        
				//sidePanel.repaint();
				playAgain();
			} else if (isFull()) {
				messageLabel.setText("It's a draw");

			}
		}

		// if there's n winner then update the message
		if (!winner) {
			checkers[totalRow[column]][column].setIcon(updatePlayer());
			messageUpdate();
			messageLabel.setText(" " + this.player + "'s turn");
			System.out.println("Before col: " + totalRow[column]);
			// totalRow[column] -= 1;
			System.out.println("After col: " + totalRow[column]);

		}

		// totalRow[column] -= 1;
	}

	private void playAgain() {
		// TODO Auto-generated method stub
		int yesNo=JOptionPane.showConfirmDialog(null, this.player + " wins. Do you want to play another game?", "Play Again?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(this.getClass().getResource("/project/images/2.png")));
		if(yesNo==0){
			messageLabel.setText(player+"'s turn");
			removeAllCheckers();
			// reset drop
			removeAlldrop();
			// reset counters
			rowCounter();
			sidePanel.revalidate();
			sidePanel.repaint();
			
		}else{
			JOptionPane.showMessageDialog(null, "Bye!!");
			System.exit(0);
		}
		
	}

	private void messageUpdate() {
		if (this.currentPlayer.equalsIgnoreCase("red")) {
			player = "Player 1";
			messageLabel.setIcon(redLabelIcon);
		} else {
			player = "Player 2";
			messageLabel.setIcon(yellowLabelIcon);
			// messageLabel.setForeground(Color.YELLOW);
		}
	}

	private void removeListener() {
		for (int i = 0; i < drop.length; i++) {
			drop[i].removeActionListener(this);
		}

	}

	// check if the row isFull
	public boolean isFull() {
		for (int i = 0; i < totalRow.length; i++) {
			if (totalRow[i] > 0) {
				return false;
			}

		}
		return true;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			JOptionPane.showMessageDialog(null, "Test");
		}
		
		
	}

}