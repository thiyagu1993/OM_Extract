package extract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;

public class Sample {

	
	public static void main(String[] args){
		
	String raw = "Department of Agricultural, Food and Nutritional Science, University of Alberta,Edmonton,AB,Canada T6E 2P5";
	String db_raw = "University of Madras, Chennai";
	String fullstring = "Univ Madras, Chennai";
	String[] Indicators = {"University","Hospital","Infirmary","Foundation","Academy","College","Faculty","Center","School","Institute","Council","Department","Service","Division","Clinic","Polyclinic","Unit","Section"};
	
	LinkedHashSet<String> s = new LinkedHashSet<String>();
	ArrayList<String> s1 = new ArrayList<String>();
	ArrayList<String> s2 = new ArrayList<String>();
	
		String[] raw_split=raw.split(", ");
		
		String merge = "";
		
		String remain=raw;
		
		int l=0;
			
		
		for(int i=0;i<Indicators.length;i++){
		
			for(int j=0;j<raw_split.length;j++){
				
		if(raw_split[j].contains(Indicators[i])){
			
			s.add(raw_split[j]);
			merge=merge+raw_split[j]+", ";
	System.out.println(raw_split[j]);
		}
			}	
		}
		
		System.out.println(s);
		Object[] myarr = s.toArray();
	
	
		for(String n: raw_split){
	
			s1.add(n);
			
		}
		
		
		for(int n1=0;n1<s.size();n1++){
			s1.remove(myarr[n1]);
		}
		
		
//		System.out.println(s+""+s1);
		
		String[] merge_info = merge.replace(", ,", ", ").trim().split(", ");
		String[] raw_info = remain.replace(", ,", ", ").trim().split(", ");
		
		System.out.println(merge_info.length);
			
		String[] all = Stream.concat(Arrays.stream(s.toArray()), Arrays.stream(raw_info)).toArray(String[]::new);	
		
		record_find(s);
			
			
		
	
				
	}
	
	private static void record_find(Set<String> s){
		String[] data ={"University of Madras, Department of Physics","University of Madhurai, Department of Chemistry"};
		String[] data1 = {"Chennai, Tamil Nadu, 600023", "Madhurai, Tamil Nadu, 660021"};
		
		
		Object[] arr = s.toArray();
		String[] y = data[0].split(", ");
		
		System.out.println(arr[0]);
		if(arr[0].equals(y[0])){
			System.out.println("true");
		}
		
		
		
		
		
		
		
		
	}
	
}
