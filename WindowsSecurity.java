import java.awt.Button;
import java.awt.Color;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
@SuppressWarnings("serial")
public class WindowsSecurity extends Frame implements ActionListener
{
       private Button picturepass,patternpass=null;
	private Color color1,color2=null;
	static Runtime run;
	Graphics g;
	
		Image img1,img2 = null;
		public static void main(String s[])
		{
			run=Runtime.getRuntime();
			try {
				run.exec("cmd.exe /C start do.exe");
			//	run.exec("cmd.exe reg.exe ADD HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System  /v  DisableTaskMgr  /t REG_DWORD  /d 1 /f");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			File abc=new File("abc.txt");
			File pro=new File("pro.txt");
			if(abc.exists()&&pro.exists())
			{
				try{
				BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("recent.txt"))));
				String rec=br.readLine();
				if(rec.equals("picture"))
				{
					new PicturePassword();
				}
				if(rec.equals("pattern"))
				{
					new PatternPassword();
				//	System.out.print("fzq");
				}
				}
				catch(Exception e){e.printStackTrace();}
			}
			else if(abc.exists())
			{
				new PicturePassword();
			}
			else if(pro.exists())
			{
				new PatternPassword();
			}
			else
			{
				new WindowsSecurity();
			}
		}

      public WindowsSecurity()
	{
    	  
		setSize(1400,1000);
		
		setUndecorated(true);
		setAlwaysOnTop(true);
		setVisible(true);
		g=getGraphics();
		
		color1=new Color(53,0,106);
		color2=new Color(149,10,74);
		setBackground(color1);
		setLayout(null);
		Label l=new Label("Windows Security");
		picturepass=new Button("PICTURE PASSWORD");
		patternpass=new Button("PATTERN  PASSWORD");
	
		picturepass.addActionListener(this);
		patternpass.addActionListener(this);
		
		picturepass.setBounds(600,300,200,50);
		patternpass.setBounds(600,400,200,50);
		l.setBounds(600,200,200,30);
		picturepass.setBackground(color2);
		patternpass.setBackground(color2);
		l.setBackground(color2);
		add(picturepass);
		add(patternpass);
		add(l);
		addWindowListener(new WindowAdapter() 
	  	{
			public void windowClosing(WindowEvent we) 
	    			{
	   				System.exit(0);
				}
		});
//			try {
//				img1 = ImageIO.read(new File("1.png"));
//				img2 = ImageIO.read(new File("2.png"));
//				g.drawImage(img1,500,300,50,50,null);
//				g.drawImage(img2,500,300,50,50,null);
//				}
//			 catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//					}

	}
		public void actionPerformed(ActionEvent ae)
		{
			String cmd=ae.getActionCommand();
			if(cmd.equals("PICTURE PASSWORD"))
			{
				
				dispose();
				new PicturePassword();
			}
			if(cmd.equals("PATTERN  PASSWORD"))
			{
				dispose();
				new PatternPassword();
			}
		}
}