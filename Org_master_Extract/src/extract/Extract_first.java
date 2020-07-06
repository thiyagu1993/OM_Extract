package extract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Extract_first {

	public static void main(String[] args) throws IOException{
		
	
		FileInputStream f = new FileInputStream(new File("C:\\Author_test\\test.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet = wb.getSheetAt(0);		
		
		String[] Indicators = {"University","Hospital","Infirmary","Foundation","Academy","College","Faculty","Center","School","Institute","Council","Department","Service","Division","Clinic","Polyclinic","Unit","Section"};
		
		//University Hospital - ordered 2 indicators comes first.
		
		
		for(int j=0;j<sheet.getLastRowNum()+1;j++){
		
			LinkedHashSet<String> s = new LinkedHashSet<String>();
			ArrayList<String> ar = new ArrayList<String>();
			ArrayList<String> s2 = new ArrayList<String>();
			Row r = sheet.getRow(j);	
			Cell ce = r.getCell(0);
			
			
			String[] raw_split = ce.toString().split(", ");
							
			for(int i=0;i<Indicators.length;i++){
			
				for(int j1=0;j1<raw_split.length;j1++){
				
			if(raw_split[j1].contains(Indicators[i])){
				
				s.add(raw_split[j1]);
				
			}
			}
		}
			
//		System.out.println(s);
			Object[] myarr = s.toArray();
				
			for(String n: raw_split){
				
				ar.add(n);	
			}	
				
		
			for(int n1=0;n1<s.size();n1++){
				ar.remove(myarr[n1]);
			}
		
			System.out.println(s+""+ar);
	
		record_find(s,ar);
	
		}
		
		wb.close();
	}


private static void record_find(LinkedHashSet<String> s, ArrayList<String> ar) throws IOException{
	

	FileInputStream ff = new FileInputStream(new File("C:\\Author_test\\out_test.xlsx"));
	XSSFWorkbook wbb = new XSSFWorkbook(ff);
	XSSFSheet sheets = wbb.getSheetAt(0);		
	Object[] arr={};
	
	if(s.size()==0){
		arr=ar.toArray();
	}else{
		arr = s.toArray();	
	}
	
	
	String mainorg_record=arr[0].toString();
	String suborg1_record="";
	String suborg2_record="";
	String suborg3_record="";
	
	
	if(arr.length<3){
		try{
			suborg1_record=arr[1].toString();
		}catch(ArrayIndexOutOfBoundsException are){
		}
		try{
			suborg2_record=arr[2].toString();
		}catch(ArrayIndexOutOfBoundsException are){
		}

		try{
			suborg3_record=arr[3].toString();
		}catch(ArrayIndexOutOfBoundsException are){
		}

	}

	int temp=0;
	
	String geo_city="";
	String geo_street="";
	String geo_state="";
	String geo_country="";
	String geo_zipcode="";
	
	for(int j=0;j<sheets.getLastRowNum()+1;j++){
		int count=0;
		Row r1 = sheets.getRow(j);	
		Cell ce1 = r1.getCell(0);
		Cell ce2 = r1.getCell(1);
		Cell ce3 = r1.getCell(2);
		Cell ce4 = r1.getCell(3);
		Cell ce5 = r1.getCell(4);
		Cell ce6 = r1.getCell(5);
		Cell ce7 = r1.getCell(6);
		Cell ce8 = r1.getCell(7);
		
		String state=  "";
		String street="";
		String mainorg="";
		String suborg1="";
		String suborg2="";
		String suborg3="";
		String city="";
		String country="";
		String zipcode="";
			
		
		try{
			city=ce4.toString();
		}catch(NullPointerException n){
			
		}
		
		try{
			street = ce5.toString();
		}catch(NullPointerException n){
			
		}
		
		try{
			state = ce6.toString();
		}catch(NullPointerException n){
			
		}
		
		try{
			country = ce7.toString();
		}catch(NullPointerException n){
			
		}
		
		try{
			zipcode = ce8.toString();
		}catch(NullPointerException n){
			
		}
				
		try{
			mainorg = ce2.toString().replace("\"", "").replace("{", "").replace("}", "");
		}catch(NullPointerException ne){
			mainorg ="";
		}
		String[] all_suborg={};
		
		try{
		 all_suborg=ce3.toString().replace("{", "").replace("}","").replace("\"", "").split(",");
		}catch(NullPointerException nne){
			
		}
				
				try{
					suborg1=all_suborg[0];
				
				}catch(ArrayIndexOutOfBoundsException af){
					
				}
				
				try{
					suborg2=all_suborg[1];
				
				}catch(ArrayIndexOutOfBoundsException af){
					
				}
				try{
					suborg3=all_suborg[2];
				
				}catch(ArrayIndexOutOfBoundsException af){
					
				}
				

			if(mainorg_record.equals(mainorg)&&mainorg_record!=""){
				count++;
				temp=j;
				System.out.println(temp);
				geo_city=city;
				geo_street=street;
				geo_state=state;
				geo_country=country;
				geo_zipcode=zipcode;
					
				if(suborg1_record.equals(suborg1)&&suborg1_record!=""){
					temp=j;
					count++;
					geo_city=city;
					geo_street=street;
					geo_state=state;
					geo_country=country;
					geo_zipcode=zipcode;
					
					if(suborg2_record.equals(suborg2)&&suborg2_record!=""){
						count++;
						temp=j;
						geo_city=city;
						geo_street = street;
						geo_state=state;
						geo_country=country;
						geo_zipcode=zipcode;
						
						if(suborg3_record.equals(suborg3)&&suborg3_record!=""){
							count++;
							temp=j;
							geo_city=city;
							geo_street=street;
							geo_state=state;
							geo_country=country;
							geo_zipcode=zipcode;
						}
					}
				}
			}	
	
	
					
			
	}

	
	
	wbb.close();
	ff.close();
}

}
