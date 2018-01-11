import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
class PicturePassword extends Frame implements ActionListener, MouseListener
{
	static int click_count;
	String file_name;
	Image password_image,img2,img3,img4=null;
	Graphics g=null;
	Button browse_button,use_picture=null;
	boolean password_set;
	//Label l1,l2=null;
	FileDialog filedialog=null;
	Color background_color=null,button_color=null;
	private int x;
	private int y;
	Point points[];
	private boolean picselected;
	static Frame f;
	//Button use_picture;
	static Runtime run;
	//Panel picture;
	//Panel steps;
//	public static void main(String args[]) 
//	{
//		f = new PicturePassword();
//		//System.out.println(filedialog.getFileName());
//	}
	public PicturePassword()
	{
		//picture=new Panel();
		//steps=new Panel();
		//picture.add();
		points=new Point[3];
		setSize(1400,1000);
		setAlwaysOnTop(true);
		setUndecorated(true);//no title bar
		setVisible(true);
		run=Runtime.getRuntime();
		setResizable(false);//cannot change size of window
		/*addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we) 
			{
			System.exit(0);
			}
		});*/
		
		background_color=new Color(53,0,106);
		setBackground(background_color);
		setLayout(null);
		addMouseListener(this);
		
		
		Button opt=new Button("options");
		opt.setBounds(1120, 50, 150, 50);
		add(opt);
		opt.addActionListener(this);
		
		File f=new File("abc.txt");//create reference of file
		password_set=f.exists();
		if(password_set)
		{
			Label l=new Label("Enter password sequence : ");
			l.setBounds(1120, 100, 250, 50);
			Font f0=new Font("Courier",Font.BOLD+Font.ITALIC,12);
			l.setFont(f0);
			add(l);
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("abc.txt"))));
				String file_name=br.readLine();
				password_image=ImageIO.read(new File(file_name));
				g=getGraphics();
				g.drawImage(password_image,0,0,1000,1000,this);
				picselected=true;
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			browse_button=new Button();
			//g=getGraphics();
			//browse_button=new Button();
			browse_button.addActionListener(this);
			browse_button.setLabel("Browse");
			button_color=new Color(149,0,74);
			browse_button.setBackground(button_color);
			browse_button.setBounds(1100,100,150,50);
			
			add(browse_button);
			use_picture=new Button("Use this picture");
			use_picture.addActionListener(this);
			
			//repaint();
		}
}
public void actionPerformed(ActionEvent e)
{
	String s1=e.getActionCommand();
	if(e.getSource() instanceof Button)
	{
		if("Browse".equals(s1))
		{
			filedialog = new FileDialog(this, "File Dialog",FileDialog.LOAD);
			filedialog.setAlwaysOnTop(true);
			setAlwaysOnTop(false);
			filedialog.setVisible(true);
			file_name=filedialog.getDirectory()+filedialog.getFile();
			setAlwaysOnTop(true);
			try
				{
					password_image=ImageIO.read(new File(file_name));
				}
			catch(Exception ee)
				{}
			
			g=getGraphics();
			g.drawImage(password_image,0,0,1000,1000,null);
			remove(browse_button);
			
			use_picture.setBounds(1030,100,150,50);
			use_picture.setBackground(button_color);
			browse_button.setBounds(1185,100,150,50);
			add(use_picture);
			add(browse_button);
			picselected=false;
		}
		
		if("Use this picture".equals(s1))
		{
			remove(browse_button);
			remove(use_picture);
			
			Label l=new Label("Click on the Image");
			l.setBounds(1120, 100, 250, 50);
			Font f=new Font("Courier",Font.BOLD+Font.ITALIC,12);
			l.setFont(f);
			Image img5 = null;
			try {
				img5 = ImageIO.read(new File("0.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			g.drawImage(img5,1145,200,75,75,null);
			l.setForeground(Color.orange);
			add(l);
			picselected=true;
			click_count=0;
		}
		if("Finish".equals(s1))
		{
			try {
				PrintWriter pw=new PrintWriter(new FileOutputStream(new File("abc.txt")));
				pw.print(file_name+"\n");
				for(int i=0;i<3;i++)
				{
					pw.print(points[i].x+" "+points[i].y+"\n");
					
				}
				pw.close();
				System.exit(0);
			} catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();	
			}
		}
		if("options".equals(s1))
		{
			dispose();
			new WindowsSecurity();
		}
	}
}
@Override
public void mouseClicked(MouseEvent arg0) 
{
	
	// TODO Auto-generated method stub
	x = arg0.getX();
	y = arg0.getY();
	Point p=new Point(x,y);
	Rectangle r=new Rectangle(0,0,1000,1000);
	if(r.contains(p)&&click_count<3&&picselected)
	{
		Image img = null;
		points[click_count]=p;
		if(!password_set)
		{
			 
			try {
				img = ImageIO.read(new File((click_count+1)+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			g.drawImage(password_image,0,0,1000,1000,null);
		}
		g.setColor(Color.orange);
		g.drawRect(x-15, y-15, 30, 30);
		
		try {
				Thread.sleep(100);
			} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(password_image,0,0,1000,1000,null);
		g.drawImage(img,1145,200,75,75,null);
		click_count++;
	}
	if(click_count==3)
	{
		if(!password_set)
		{
			Button b=new Button("Finish");
			b.setBounds(1145, 650, 100, 50);
			b.addActionListener(this);
			add(b);
			try{
			PrintWriter pw=new PrintWriter(new File("recent.txt"));
			pw.print("picture");
			pw.close();
			}
			catch (Exception e){}
		}
		else
		{
			try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("abc.txt"))));
			br.readLine();
			StringTokenizer st;
			int cx,cy;
			Rectangle check1,check2,check0;
			
				st=new StringTokenizer(br.readLine());
				cx=Integer.parseInt(st.nextToken());
				cy=Integer.parseInt(st.nextToken());
				check0=new Rectangle(cx-15,cy-15,30,30);
				
				st=new StringTokenizer(br.readLine());
				cx=Integer.parseInt(st.nextToken());
				cy=Integer.parseInt(st.nextToken());
				check1=new Rectangle(cx-15,cy-15,30,30);
				
				st=new StringTokenizer(br.readLine());
				cx=Integer.parseInt(st.nextToken());
				cy=Integer.parseInt(st.nextToken());
				check2=new Rectangle(cx-15,cy-15,30,30);
			
				if(check0.contains(points[0])&&check1.contains(points[1])&&check2.contains(points[2]))
				{
					//JOptionPane.showMessageDialog(null,"Password correct.");
					run.exec("cmd.exe /C start undo.exe");
					PrintWriter pw=new PrintWriter(new File("recent.txt"));
					pw.print("picture");
					pw.close();
					//run.exec("reg.exe ADD HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System  /v  DisableTaskMgr  /t REG_DWORD  /d 0 /f");
					System.exit(0);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Password INcorrect.");
					click_count=0;
					PrintWriter pw=new PrintWriter(new File("recent.txt"));
					pw.print("picture");
					pw.close();
				//	f.dispose();
					//main(null);
				}
				
			}catch(Exception e){}
		}
	}
}
@Override
public void mouseEntered(MouseEvent arg0) 
{
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) 
{
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) 
{
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) 
{
	// TODO Auto-generated method stub
	
}
}