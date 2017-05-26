package project;

import javax.swing.JFrame;

public class Main extends JFrame  {
	
	public Main(){
		this.setTitle("Connect 4");
		this.setSize(595, 560);
		Gui g=new Gui();
		this.add(g);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// set visible
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[]args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
		
	}
	
	



}
