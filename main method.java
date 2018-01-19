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