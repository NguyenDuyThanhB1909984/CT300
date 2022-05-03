package Buoi3;

import java.util.Scanner;

public class SDSinhVien {

	public static int them1sv(int n,SinhVien ds[]){
		
			ds[n] = new SinhVien();

			System.out.println("Nhap thong tin sinh vien:");
			ds[n].nhap();

		n+=1;
		return n;


	}
	

	
	

	public static int inDssv(int n,SinhVien ds[]){

			 System.out.println("");
		 System.out.println("Danh sach Sinh vien:");
		 for(int i=0; i<n;i++){
		 	System.out.println("-Sinh vien thu "+(i+1)+":");
		 	ds[i].in();
			 ds[i].inHP();
		 	System.out.println("+DTB: "+ds[i].diemtb());
		 }

		 return 1;
	}

	public static int nhapDiemHP(int n,SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		String mssv = new String();
		System.out.println("Nhap diem cho sinh vien co ma so:");
		mssv=sc.nextLine();
		
		// sc.nextLine();
		
		int chiso=1;
		for(int i=0; i<n;i++){
		if(ds[i].getmssv().equalsIgnoreCase(mssv)){
			chiso=i;
			break;		
		}
		
		}
		System.out.println(chiso);
		ds[chiso].nhapdiem();
		return 1;
	}
	public static int xoaSv(int n, SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		String mssv = new String();
		System.out.println("Xoa sinh vien co ma so:");
		mssv=sc.nextLine();
		int i;
		for( i =0;i<n;i++){
			if(ds[i].getmssv().equalsIgnoreCase(mssv)){
				break;
			}
			
		}
		for(int j=i;j<n-1;j++){
			ds[j].makeCoppy(ds[j+1]);
		}
		n=n-1;
		return n;
	}
	public static int timSV(int n, SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		String mssv = new String();
		System.out.println("Tim sinh vien co ma so:");
		mssv=sc.nextLine();
		int i;
		for( i =0;i<n;i++){
			if(ds[i].getmssv().equalsIgnoreCase(mssv)){
				ds[i].in();
				break;
			}
			
		}


		return 1;


	}

	public static int xemDiem(int n, SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		String mssv = new String();
		System.out.println("Nhap ma so sinh vien:");
		mssv=sc.nextLine();
		int i;
		for( i =0;i<n;i++){
			if(ds[i].getmssv().equalsIgnoreCase(mssv)){
				ds[i].in();
				System.out.println("Diem tb:"+ds[i].diemtb());
				break;
			}
			
		}


		return 1;


	}
	public static void menu(int n,SinhVien ds[]){
		Scanner sc= new Scanner(System.in);
			int x;	
		System.out.println("1. admin");
			System.out.println("2. Sinh vien");
			System.out.println("3. Thoat");
			System.out.println("Moi chon:");
				x=sc.nextInt();
				if(x==1){
					menuAdmin(n, ds);
				}
				else if(x==2){
					menuSV(n,ds);
				}
				else if(x==3){
					return;
				}
				else {
					System.out.print("Sai cu phap, Vui long nhap lai!");
					 menu(n, ds);
				}
				

	}
	public static void menuSV(int n,SinhVien ds[]){
		Scanner sc= new Scanner(System.in);
		int x;	
	System.out.println("1. Them hoc phan");
		System.out.println("2. Xoa hoc phan");
		System.out.println("3. Xem diem hoc phan");
		System.out.println("4. Thoat");
		System.out.println("Moi chon");
			x=sc.nextInt();
			if(x==1){
				SDSinhVien.dkhp(n, ds);
				menuSV(n, ds);
			}
			else if(x==2){
				
				SDSinhVien.xoahp(n, ds);
				menuSV(n, ds);
			}
			else if(x==3){
				SDSinhVien.xemDiem(n, ds);
				sc.nextLine();
				sc.nextLine();
				menuSV(n, ds);
			}
			else if(x==4) {
			 menu(n, ds);
			}
			else{
				System.out.print("Sai cu phap, Vui long nhap lai!");
					 menuSV(n, ds);
			}
			


	}
	public static void menuAdmin(int n,SinhVien ds[]){
		Scanner sc= new Scanner(System.in);
		int x;	
	System.out.println("1. Nhap vao 1 sinh vien ");
		System.out.println("2. Nhap diem hoc phan");
		System.out.println("3. Xem danh sach canh cao hoc vu");
		System.out.println("4. Tim sinh vien");
		System.out.println("5. Xoa sinh vien");
		System.out.println("6. hien thi danh sach sinh vien");
		System.out.println("7. Thoat");

		System.out.println("Moi chon");
			x=sc.nextInt();
		
			if(x==1){
			n=SDSinhVien.them1sv(n, ds);
			menuAdmin(n, ds);
			}
			else if(x==2){
				System.out.print("N la :" +n);
				SDSinhVien.nhapDiemHP(n, ds);
				menuAdmin(n, ds);
			}
			else if(x==3){
				SDSinhVien.dscanhcaohocvu(n, ds);
				sc.nextLine();
				sc.nextLine();
				menuAdmin(n, ds);
			}
			else if(x==4) {
			 SDSinhVien.timSV(n, ds);
			 sc.nextLine();
			sc.nextLine();
			 menuAdmin(n, ds);

			}else if(x==5){
				System.out.print("N la :" +n);
				n=SDSinhVien.xoaSv(n, ds);
				menuAdmin(n, ds);
			}else if(x==6) {

				inDssv(n, ds);
				sc.nextLine();
				sc.nextLine();
			
					menuAdmin(n, ds);
				
			
			}
			else if(x==7) {
				menu(n, ds);
			}
			else{
				System.out.print("Sai cu phap, Vui long nhap lai!");
					 menuAdmin(n, ds);
			}
			


	}

	public static int dscanhcaohocvu(int n,SinhVien ds[]){
			
			System.out.println("Cac sinh vien bi canh cao hoc vu:");
		for(int i=0;i<n;i++){
			if(ds[i].diemtb()<1) {
			ds[i].in();
			System.out.println("Diem tb:"+	ds[i].diemtb());
		
			}
		}
	
		return 1;
	}
	public static int xoahp(int n,SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		String mssv = new String();
		String hp = new String();
		System.out.println("Nhap ma so sinh vien:");

		mssv=sc.nextLine();
		System.out.println("Nhap hoc phan can xoa:");
		hp=sc.nextLine();
		int i;
		for( i =0;i<n;i++){
			if(ds[i].getmssv().equalsIgnoreCase(mssv)){
				break;
			}
			
		}
		ds[i].xoahp(hp);
		

		return 1;
	}


	///////////////////////////////////////////////
	public static void dkhp(int n,SinhVien ds[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma so sinh vien");
		String mssv = new String();
			 mssv=sc.nextLine();
			// sc.nextLine();
		System.out.println("Dang ki hoc phan cho sinh vien:");
		for (int i = 0; i< n; i++){
			System.out.println(ds[i].getmssv());

		
			if(ds[i].getmssv().equalsIgnoreCase(mssv)){
				System.out.println("-Nhap so mon can dang ki cua ma so "+mssv);
				 int x=sc.nextInt();
				sc.nextLine();
				for(int j=0;j<x;j++){
					System.out.println("+Nhap ten mon hoc thu "+(j+1)+" cua ma so "+mssv+":");
					String ten= sc.nextLine();
					ds[i].themhp(ten);
				}
			}
		
		}
	}



	public static void main(String[] args) {
		
		

		SinhVien ds[];

		ds = new SinhVien[30];
		ds[0] = new SinhVien("b1909973","Nguyen Van Phuong",12,12,2001);
		ds[1] = new SinhVien("b1909951","Ha Chanh Nam",12,12,2001);
		ds[2] =  new SinhVien("b1909901","Thai Dai Nhan",12,12,2001);
		ds[3] =  new SinhVien("b1909911","Nguyen Duy Thanh",12,12,2001);

		 SDSinhVien.menu(4, ds);


		
	}
}
