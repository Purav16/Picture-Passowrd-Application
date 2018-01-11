

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
class PatternPassword extends Frame implements ActionListener {
	Image img1, img2 = null;
	Graphics g = null;
	// String rs=properties.getProperty("replaceAll.String");
	Color color1, color2, color3 = null;
	boolean change=false;
	Button b1 = null;
	Button b2, b3;// b4 = null;
	JButton jb, jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8 = null;
	StringBuffer sb = new StringBuffer();
	// StringBuffer sb1=new StringBuffer(null);
	String st = "";
	String line = null;
	// fil f;

	File f, f1, f3, f5 = null;
	FileWriter fw = null;
	PrintWriter pw, pw1, pw3, pw5 = null;
	BufferedReader br1, br2, br3, br4, br5 = null;
	Label l1, l2, l3, l4, l5 = null;
	int flag = 0;
	static int count = 0;
	String a, b = null;
	FileReader fr1, fr2, fr3, fr4, fr = null;
	Font font2 = null;
	Runtime run;
	// Thread thread=null;

//	public static void main(String s[]) {
//		new PatternPassword();
//
//	}

	public PatternPassword() {
		setSize(1366, 768);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		run=Runtime.getRuntime();
		sb.append(st);
		// sb1.append(st1);
		font2 = new Font("Arial", Font.BOLD + Font.ITALIC, 20);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		// g=getGraphics();
		color1 = new Color(53, 0, 106);
		setBackground(color1);
		setLayout(null);
		b1 = new Button("SUBMIT");
		b2 = new Button("CHNAGE PASSWORD");
		b3 = new Button("NEXT");
		color2 = new Color(149, 0, 74);
		b1.setBackground(color2);
		b2.setBackground(color2);
		b3.setBackground(color2);
		b3.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		// b4 = new Button("SUBMITT");
		color2 = new Color(149, 0, 74);
		// b4.setBackground(color2);
		// b4.setBounds(500, 570, 150, 50);
		b1.setBounds(620, 570, 150, 50);
		b2.setBounds(620, 650, 150, 50);
		b3.setBounds(800, 570, 150, 50);
		// thread=new Thread();
		l1 = new Label();
		l1.setBounds(1, 1, 600, 70);
		l2 = new Label();
		//l2.setBounds(900, 630, 600, 70);

		l3 = new Label();
		l3.setBounds(1, 630, 600, 70);
		l4 = new Label();
		l4.setBounds(1050, 1, 400, 70);
		add(l4);
		l5 = new Label();
		l5.setBounds(800, 1, 500, 70);
		add(l5);
		add(l3);
		add(b1);
		//add(b2);
		add(l1);
		//add(b3);
		add(l2);
		// add(b4);
		// b4.setVisible(false);
		File fn=new File("pro.txt");
		if(fn.exists())
		{
			add(b2);
			//add(b3);
		}
		if(change)
		{
			remove(b2);
			add(b3);
		}
	

		try {
			img1 = ImageIO.read(new File("4.jpg"));

			jb = new JButton();
			jb.setIcon(new ImageIcon(img1));
			jb.setBounds(450, 150, 50, 50);
			jb.addActionListener(this);
			add(jb);

			jb1 = new JButton();
			jb1.setIcon(new ImageIcon(img1));
			jb1.setBounds(650, 150, 50, 50);
			jb1.addActionListener(this);
			add(jb1);

			jb2 = new JButton();
			jb2.setIcon(new ImageIcon(img1));
			jb2.setBounds(850, 150, 50, 50);
			jb2.addActionListener(this);
			add(jb2);

			jb3 = new JButton();
			jb3.setIcon(new ImageIcon(img1));
			jb3.setBounds(450, 300, 50, 50);
			jb3.addActionListener(this);
			add(jb3);

			jb4 = new JButton();
			jb4.setIcon(new ImageIcon(img1));
			jb4.setBounds(650, 300, 50, 50);
			jb4.addActionListener(this);
			add(jb4);

			jb5 = new JButton();
			jb5.setIcon(new ImageIcon(img1));
			jb5.setBounds(850, 300, 50, 50);
			jb5.addActionListener(this);
			add(jb5);

			jb6 = new JButton();
			jb6.setIcon(new ImageIcon(img1));
			jb6.setBounds(450, 450, 50, 50);
			jb6.addActionListener(this);
			add(jb6);

			jb7 = new JButton();
			jb7.setIcon(new ImageIcon(img1));
			jb7.setBounds(650, 450, 50, 50);
			jb7.addActionListener(this);
			add(jb7);

			jb8 = new JButton();
			jb8.setIcon(new ImageIcon(img1));
			jb8.setBounds(850, 450, 50, 50);
			jb8.addActionListener(this);
			add(jb8);
			
			Button opt=new Button("options");
			opt.setBounds(800, 650, 150, 50);
			opt.setBackground(color2);
			add(opt);
			opt.addActionListener(this);

		} catch (Exception e) {
		}

		f = new File("pro.txt");
		if (f.exists()) {

			l4.setText("Please enter password sequance:");
			l4.setFont(font2);
			l4.setBackground(color2);

		}

	}

	public void actionPerformed(ActionEvent e) {

		// String sa = e.getActionCommand();

		if("options".equals(e.getActionCommand()))
		{
			dispose();
			new WindowsSecurity();
		}
		
		if (e.getSource() == jb) {
			String s1 = "H";
			sb.append(s1);
		}
		if (e.getSource() == jb1) {
			String s2 = "E";
			sb.append(s2);
		}
		if (e.getSource() == jb2) {
			String s3 = "L";
			sb.append(s3);
		}
		if (e.getSource() == jb3) {
			String s4 = "O";
			sb.append(s4);
		}
		if (e.getSource() == jb4) {
			String s5 = "W";
			sb.append(s5);
		}
		if (e.getSource() == jb5) {
			String s6 = "R";
			sb.append(s6);
		}
		if (e.getSource() == jb6) {
			String s7 = "P";
			sb.append(s7);
		}
		if (e.getSource() == jb7) {
			String s8 = "A";
			sb.append(s8);
		}
		if (e.getSource() == jb8) {
			String s9 = "B";
			sb.append(s9);
		}

		// if (e.getSource() == b4) {
		//
		// try {
		// f5 = new File("F:\\Apexa_Project\\pro5.txt");
		// if (f5.exists()) {
		// System.out.println("File already exixt");
		// }
		// pw3 = new PrintWriter(f5);
		// pw3.print(sb);
		// pw3.close();
		// JOptionPane.showMessageDialog(null, "Password is set.");
		// System.exit(0);
		//
		// } catch (FileNotFoundException e10) {
		// System.out.println("EXCEPTION:" + e10);
		// }
		// }
		// submit
		if (e.getSource() == b1) {
			System.out.println("Submit Button Clicked...");
			try {
				

				if (!f.exists()) {
					System.out.println("Here");
					pw = new PrintWriter(f);
					pw.print(sb);
					pw.close();
					sb.append(st);
					PrintWriter pw=new PrintWriter(new File("recent.txt"));
					pw.print("pattern");
					pw.close();
					System.exit(0);

				} else {
					f3 = new File("pro3.txt");
					if (f3.exists()) {
						System.out.println("File already exixt submit");
					}
					pw3 = new PrintWriter(f3);
					pw3.print(sb);
					pw3.close();
					// sb=sb1;

					print1();
					sb.delete(0, sb.length());

					// System.exit(0);

				}

			}

			catch (FileNotFoundException e1) {
				System.out.println("EXCEPTION:" + e1);
			}
		}
		// change password
		if (e.getSource() == b2) {

			l4.setVisible(false);

			String sp = "Please enter the old password and than save the password:";
			l1.setText(sp);
			
			change=true;
			add(b3);
			l1.setFont(font2);
			l1.setBackground(color2);
			b1.setVisible(false);
			// l2.setVisible(false);
		}
		// save password
		if (e.getSource() == b3) {

			try {
				f1 = new File("pro1.txt");
				if (f1.exists()) {
					System.out.println("File already exixt save pass");
				}
				pw1 = new PrintWriter(f1);
				pw1.print(sb);
				pw1.close();
				print();
				sb.delete(0, sb.length());
				PrintWriter pw=new PrintWriter(new File("recent.txt"));
				pw.print("pattern");
				pw.close();

			} catch (FileNotFoundException e2) {
				System.out.println("EXCEPTION:" + e2);
			}

		}

	}

	public void print() {
		try {
			FileReader fr1 = new FileReader(new File(
					"pro.txt"));
			FileReader fr2 = new FileReader(new File(
					"pro1.txt"));
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br2 = new BufferedReader(fr2);

			a = (String) br1.readLine();
			b = (String) br2.readLine();
			if (a.equals(b)) {

				l2.setVisible(false);
				l1.setVisible(false);
				l4.setVisible(false);
				// b1.setVisible(false);
				// b4.setVisible(true);
				b1.setVisible(true);
				b3.setVisible(false);
				//JOptionPane.showMessageDialog(null,
					//	"Password correct you can set password.");
				fr1.close();
				deleteFile("pro.txt");

				//
				// pw5.print(st);

			}

			// f.delete();

			else {
				l1.setVisible(false);

				String sp3 = "Please try again your old password is wrong:";
				l2.setText(sp3);
				l2.setFont(font2);
				l1.setVisible(false);
				l2.setBackground(color2);
				sb.append(st);
				// flag=0;
			}

		} catch (IOException e5) {
			return;
		}

	}

	public void print1() {
		try {
			FileReader fr4 = new FileReader(new File(
					"pro.txt"));
			FileReader fr3 = new FileReader(new File(
					"pro3.txt"));
			BufferedReader br4 = new BufferedReader(fr4);
			BufferedReader br3 = new BufferedReader(fr3);

			a = (String) br4.readLine();
			b = (String) br3.readLine();
			if (a.equals(b)) {
				l5.setVisible(false);
				l4.setVisible(false);
				try {
					//JOptionPane.showMessageDialog(null, "Password correct.");

					fr = new FileReader(new File("pro.txt"));
					fw = new FileWriter(new File("pro4.txt"));
					br5 = new BufferedReader(fr);
					pw5 = new PrintWriter(fw);

					while ((line = br5.readLine()) != null) {
						fw.write(line);
						// br5.reset();
					}
					br5.close();
					pw5.close();

					System.out.print(f.exists());
					fr4.close();
					fr3.close();
					fr.close();
					fw.close();
					run.exec("cmd.exe /C start undo.exe");
					PrintWriter pw=new PrintWriter(new File("recent.txt"));
					pw.print("pattern");
					pw.close();
					System.exit(0);
					// String s="F:\\Apexa_Project\\pro.txt";
					
//					if (f.delete()) {
//						System.out.println("FILE IS DELETED");
//
//					} else {
//						System.out.println("FILE IS not DELETED");
//					}
				}

				catch (Exception e6) {
					e6.printStackTrace();
				}
				
				Thread.sleep(1000);
				System.exit(0);

			} else {
				l5.setText("Please try again you have entererd wrong password:");

				l5.setFont(font2);
				l4.setVisible(false);
				l5.setBackground(color2);
				sb.append(st);
				PrintWriter pw=new PrintWriter(new File("recent.txt"));
				pw.print("pattern");
				pw.close();
				// flag=0;
			}

		} catch (IOException e5) {
			return;
		}

		catch (Exception e6) {
			e6.printStackTrace();
		}

	}
	public void deleteFile(String path)
	{
//		Path p = FileSystems.getDefault().getPath(
//				path, "");
//
//		 try {
//			Files.delete(p);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		File f=new File(path);
		f.delete();
	}
}