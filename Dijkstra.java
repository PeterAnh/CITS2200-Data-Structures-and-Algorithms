import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Dijkstra
{
	private int n;
	private int[][] mat; // Graph
	private int firstVer, lastVer; //Dinh dau va dinh cuoi
	private int[] label;
	private int[] length;
	private int[] prev;
	public Dijkstra() {}
	//Phuong thuc khoi tao doc du lieu tu file
	public Dijkstra(String file) throws IOException{
		//sinh vien viet ma tai day
		FileReader fr= new FileReader(file);
		BufferedReader br= new BufferedReader(fr);
		n = Integer.parseInt(br.readLine());
		//Lay dinh dau va dinh cuoi
		String[] res = br.readLine().split(" ");;
		firstVer = Integer.parseInt (res[0]);
		lastVer = Integer.parseInt(res[1]);
		//Cap phat 
		label = new int[n];
		length = new int[n];
		prev = new int[n];
		mat = new int [n][n];
		//Khoi tao
		construct(br);
	}  
	
	public Dijkstra(String file, int first, int last) throws IOException{
		//sinh vien viet ma tai day
		FileReader fr= new FileReader(file);
		BufferedReader br= new BufferedReader(fr);
		n = Integer.parseInt(br.readLine());
		//Lay dinh dau va dinh cuoi
		String[] res = br.readLine().split(" ");;
		firstVer = first;
		lastVer = last;
		//Cap phat 
		label = new int[n];
		length = new int[n];
		prev = new int[n];
		mat = new int [n][n];
		//Khoi tao
		construct(br);
	}  
	//Khoi tao
	public void construct(BufferedReader br) throws IOException
	{
		for (int i = 0; i < n; i++)
		{
			label[i] = 1;//danh dau dinh chua duoc xet
			length[i] = -1; //Chieu dai la vo cung
			prev[i] = -1;//Chua co dinh truoc
		}
		length[firstVer] = 0;
		String[] res;
		String line;
		int k = 0;
		line = br.readLine();
		while (line != null){
			res = line.split(" ");
			for (int i = 0; i<res.length; ++i)
				mat[k][i] = Integer.parseInt (res[i]);
			++k;
			line = br.readLine();
		}
	}
	
	//In ma tran
	public void printMat()
	{
		for (int i = 0; i<mat.length; ++i)
		{	
			for (int j = 0; j<mat[i].length; ++j)
				System.out.print (mat[i][j] + "  ");
			System.out.println();
		}
	}
	//Tim duong di ngan nhat
	public boolean createPath()
	{
		// Chung nào dinh lastVer van chua duoc danh dau thì ta còn xét
		while (label[lastVer] == 1)
		{
			int min = -1;
			int vertex = -1;
	 
			// Tìm min length
			for (int i = 0; i < n; i++)
			{
				if (label[i] == 1 && length[i] != -1 && (length[i] < min || min == -1))
				{
					min = length[i];
					vertex = i;
				}
			}
	 
			// Neu ta không tim duoc min nao, co nghia là không có duong di tu firstVer -> lastVer
			if (min == -1)
			{
				return false;
			}
	 
			// Ðánh dau dinh vertex da duoc xet
			//length[vertex] = min;
			label[vertex] = 0;
	 
			for (int i = 0; i < n; i++)
			{
				// Neu dinh chua duoc danh dau, và co duong di tu vertex -> i
				if (label[i] == 1 && mat[vertex][i] != 0)
				{
					// Neu duong di tu vertex -> i ngan hon duong di da luu trong mang length
					if (length[i] == -1 || length[i] > length[vertex] + mat[vertex][i])
					{
						length[i] = length[vertex] + mat[vertex][i];
						// Tao dinh dung truoc
						prev[i] = vertex;
					}
				}
			}
		}
		return true;
	}
	
	//In duong di ngan nhatv   
	public void print()
	{
		boolean pathExists = createPath();
		if (!pathExists) 
			System.out.println("Khong ton tai duong di ngan nhat");
		else
		{
			String s = "";
			System.out.println("Duong di ngan nhat tu dinh " + lastVer + " den dinh " + firstVer + " la: ");
			// Do nguoc tu dinh cuoi ve dinh dau
			int k = lastVer;
			while (true)
			{
				s = "--->" + k + s; ;
				if (k == firstVer)
					break;
				k = prev[k];
				
			}
			System.out.println(s.substring(4));
			try
			{
				PrintWriter printWriter = new PrintWriter ("file.txt");
				printWriter.println("Duong di ngan nhat tu dinh " + lastVer + " den dinh " + firstVer + " la: ");
				printWriter.println (s.substring(4));
				printWriter.close ();       
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public void BFS()
	{
		int[] queue = new int[3*n];
		int pos = 0, a =0;
		int[] out =new int[n];
		int[] check = new int[n];
		for(int j=0; j<n;j++)
			check[j]=0;
		int i=0;
		queue[a++]=0;
		while(i!=n)
		{
			if(check[queue[pos]]==0){
				check[queue[pos]]=1;
				out[i++]=queue[pos++];
				for(int j=0;j<n;j++)
				{
					if(mat[out[i-1]][j]!=0)
					{
							queue[a++]=j;
					}		
				}
			}
			else
			{
				if(pos<a)
					pos++;
			}
		}
		System.out.println("BFS:");
		for(int j=0;j<n;j++){
			System.out.print(out[j]+" ");
		}
		System.out.println(" ");
	}
}