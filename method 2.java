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