package Buoi3;

import java.util.Scanner;

import Buoi2.Date;

public class SinhVien {
	private String mssv;
	private String htsv;
	private Date nssv;
	private int sl;
	private String tenhp[];
	private String diemhp[];

	public SinhVien(){
		mssv =new String();
		htsv =new String();
		nssv =new Date();
		sl=0;
		tenhp= new String[80];
		diemhp= new String[80];
	}

	public SinhVien(String ms, String ht,int d,int m,int y){
		mssv =new String(ms);
		htsv =new String(ht);
		nssv =new Date(d,m,y);
		sl=0;
		tenhp= new String[80];
		diemhp= new String[80];
	}
	public SinhVien(SinhVien a){
		mssv = new String(a.mssv);
		htsv = new String(a.htsv);
		nssv = new Date(a.nssv);
		sl=a.sl;
		tenhp= new String [80];
		diemhp= new String [80];
		for(int i=0;i<sl;i++){
			tenhp[i]=new String(a.tenhp[i]);
			diemhp[i]=new String(a.diemhp[i]);
		}
	}
	public void nhap(){
		Scanner sc =new Scanner(System.in);
		System.out.println("+Nhap mssv:");
		mssv=sc.nextLine();
		System.out.println("+Nhap htsv:");
		htsv=sc.nextLine();
		System.out.println("+Nhap nssv:");
		nssv.readDate();
	}
	public void in(){
		System.out.println("-"+mssv+", "+htsv+", "+ nssv+":");
		for(int i=0;i<sl;i++){
			System.out.println("-"+tenhp[i]+": " + diemhp[i]);
		}
	}
	public String toString(){
		String s= new String("+"+mssv+", "+htsv+", "+ nssv+":\n");
		for(int i=0;i<sl;i++){
			s+="+"+tenhp[i]+": " + diemhp[i]+"\n";
		}
		return s;
	}
	public void themhp(String ten){
		if (sl<tenhp.length){
			tenhp[sl]= new String(ten);
			diemhp[sl]=new String("G");
			sl++;
		}
		else System.out.println("K the them");
	}
	
	public void xoahp(String ten){
		int i=0;
		for(i=0;i<sl;i++){
			if(tenhp[i].equals(ten)) break;
		}
		if(i!=sl) {
			for(int j=i;j<sl-1;j++){
				tenhp[i]=new String(tenhp[i+1]);
				diemhp[i]=new String(diemhp[i+1]);
			}
			sl--;
		}
	}
	public void inHP(){
		System.out.println("Danh sach hoc phan:");
		for(int i=0;i<sl;i++){
			System.out.println("Hoc phan thu: "+(i+1));
			System.out.println(tenhp[i]);

		}
	}
	public void makeCoppy(SinhVien a){
		this.htsv =a.htsv;
		this.mssv=a.mssv;
		this.sl=a.sl;
		nssv.makeCoppy(a.nssv);

		for(int i=0;i<this.sl;i++){

			this.tenhp[i]=a.tenhp[i];
			this.diemhp[i]=a.diemhp[i];

		}


	}
	public float diemtb(){
		float f=0.0f;
		int d=0;
		for(int i=0;i<sl;i++){
			if(diemhp[i].equals("A")) {
				f+=4;
				d++;
			}
			if(diemhp[i].equals("B+")) {
				f+=3.5;
				d++;
			}
			if(diemhp[i].equals("B")) {
				f+=3;
				d++;
			}
			if(diemhp[i].equals("C+")) {
				f+=2.5;
				d++;
			}
			if(diemhp[i].equals("C")) {
				f+=2;
				d++;
			}
			if(diemhp[i].equals("D+")) {
				f+=1.5;
				d++;
			}
			if(diemhp[i].equals("D")) {
				f+=1;
				d++;
			}
			if(diemhp[i].equals("F")) {
				f+=0;
				d++;
			}
			if(diemhp[i].equals("G")) {
				f+=-1;
				d++;
			}
		}
		return f/d;
	}
	public void nhapdiem(){
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<sl;i++){
			
			System.out.println("+Nhap diem cua mon "+tenhp[i]+":");
			diemhp[i]= sc.nextLine();
		}
	}
	public int diemf(){
		for(int i=0;i<sl;i++){
			if(diemhp[i].equals("F")) return 1;
		}
		return 0;
	}
	public String getname(){
		String h=htsv.trim();
		return h.substring(h.lastIndexOf(" ")+1);
	}
	public String getmssv(){
		// String h=mssv.trim();
		// return h.substring(h.lastIndexOf(" ")+1);
		return mssv;
	}
	public String getEmail(){
		return "";
	}
	public int getSl(){
		return sl;
	}
}
