package java_study;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pcsCompare {
	public static void main(String args[]) {
		Map tmp1 = new HashMap();
		
		
		List mfcsSelectList = new ArrayList();
		List pcsSelectList = new ArrayList();
		
		List msnCompareList = new ArrayList();
		List mblCompareList = new ArrayList();
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST001");
		tmp1.put("MSN", "0001");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST002");
		tmp1.put("MSN", "0002");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST003");
		tmp1.put("MSN", "0003");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST004");
		tmp1.put("MSN", "0004");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST006");
		tmp1.put("MSN", "0006");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST088");
		tmp1.put("MSN", "0008");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST010");
		tmp1.put("MSN", "0010");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST011");
		tmp1.put("MSN", "0011");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST012");
		tmp1.put("MSN", "1012");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST013");
		tmp1.put("MSN", "0013");
		mfcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST020");
		tmp1.put("MSN", "0020");
		mfcsSelectList.add(tmp1);
		
		
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST001");
		tmp1.put("MSN", "0001");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST002");
		tmp1.put("MSN", "1002");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST003");
		tmp1.put("MSN", "0003");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST044");
		tmp1.put("MSN", "0004");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST005");
		tmp1.put("MSN", "0005");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST008");
		tmp1.put("MSN", "0008");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST012");
		tmp1.put("MSN", "0012");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST113");
		tmp1.put("MSN", "0013");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST015");
		tmp1.put("MSN", "0015");
		pcsSelectList.add(tmp1);
		
		tmp1 = new HashMap();
		tmp1.put("MBL_NO", "TEST020");
		tmp1.put("MSN", "1020");
		pcsSelectList.add(tmp1);
		
		Collections.sort(mfcsSelectList, orderMsnSort);
		Collections.sort(pcsSelectList, orderMsnSort);
		
		int mfcsMsn = 0;
		String mfcsMbl = "";
		int pcsMsn = 0;
		String pcsMbl = "";
		int jIdx = 0;
		int loopCnt = 0;
		
		for(int i=0; i<mfcsSelectList.size(); i++){
			Map tmp2 = (Map) mfcsSelectList.get(i);
			
			mfcsMsn = Integer.parseInt((String)tmp2.get("MSN"));
			mfcsMbl = (String)tmp2.get("MBL_NO");
			
			if(mfcsMsn >= pcsMsn) {
				
				for(int j=jIdx; j<pcsSelectList.size(); j++){
					Map tmp3 = (Map) pcsSelectList.get(j);
					
					pcsMsn = Integer.parseInt((String)tmp3.get("MSN"));
					pcsMbl = (String)tmp3.get("MBL_NO");
					
					++loopCnt;
					
					if(mfcsMsn < pcsMsn) {
						jIdx = j;
						
						break;
					}else if(mfcsMsn == pcsMsn && mfcsMbl.equals(pcsMbl)){
						mfcsSelectList.remove(i);
						i--;
						
						pcsSelectList.remove(j);
						j--;
						
						break;
					}else if(mfcsMsn == pcsMsn){
						tmp2.put("PCS_MBL_NO", tmp3.get("MBL_NO"));
						msnCompareList.add(tmp2);
						
						mfcsSelectList.remove(i);
						i--;
						
						pcsSelectList.remove(j);
						j--;
						
						break;
					}
				}
			}
		}
		
		
		Collections.sort(mfcsSelectList, orderMblSort);
		Collections.sort(pcsSelectList, orderMblSort);
		
		mfcsMbl = "";
		pcsMbl = "";
		jIdx = 0;
		
		for(int i=0; i<mfcsSelectList.size(); i++){
			Map tmp2 = (Map) mfcsSelectList.get(i);
			
			mfcsMbl = (String)tmp2.get("MBL_NO");
			
			if(mfcsMbl.compareTo(pcsMbl) >= 0) {
				
				for(int j=jIdx; j<pcsSelectList.size(); j++){
					Map tmp3 = (Map) pcsSelectList.get(j);
					
					pcsMbl = (String)tmp3.get("MBL_NO");
					
					if(mfcsMbl.compareTo(pcsMbl) < 0) {
						jIdx = j;
						
						break;
					}else if(mfcsMbl.equals(pcsMbl)){
						tmp2.put("PCS_MSN", tmp3.get("MSN"));
						mblCompareList.add(tmp2);
						
						mfcsSelectList.remove(i);
						i--;
						
						pcsSelectList.remove(j);
						j--;
						
						break;
					}
				}
			}
		}
		
		
		for(int i=0; i<mfcsSelectList.size(); i++){
			Map tmp2 = (Map) mfcsSelectList.get(i);
			println("MFCS에만 존재 : " + tmp2.get("MSN") + ", " + tmp2.get("MBL_NO"));
		}
		
		for(int i=0; i<pcsSelectList.size(); i++){
			Map tmp2 = (Map) pcsSelectList.get(i);
			println("PCS에만 존재 : " + tmp2.get("MSN") + ", " + tmp2.get("MBL_NO"));
		}
		
		for(int i=0; i<msnCompareList.size(); i++){
			Map tmp2 = (Map) msnCompareList.get(i);
			println("MSN은 같으나 MBL_NO가 다름 : " + tmp2.get("MSN") + ", " + tmp2.get("MBL_NO") + ", " + tmp2.get("PCS_MBL_NO"));
		}
		
		for(int i=0; i<mblCompareList.size(); i++){
			Map tmp2 = (Map) mblCompareList.get(i);
			println("MBL_NO은 같으나 MSN이 다름 : " + tmp2.get("MBL_NO") + ", " + tmp2.get("MSN") + ", " + tmp2.get("PCS_MSN"));
		}
	}
	
	private final static Comparator<Map<String,String>> orderMsnSort = new Comparator<Map<String,String>>() {
		private final Collator collator = Collator.getInstance();
		public int compare(Map<String, String> lhs, Map<String, String> rhs) {
			//TODO Auto-generated method stub
			return collator.compare(lhs.get("MSN"),  rhs.get("MSN"));
		}
	};
	
	private final static Comparator<Map<String,String>> orderMblSort = new Comparator<Map<String,String>>() {
		private final Collator collator = Collator.getInstance();
		public int compare(Map<String, String> lhs, Map<String, String> rhs) {
			//TODO Auto-generated method stub
			return collator.compare(lhs.get("MBL_NO"),  rhs.get("MBL_NO"));
		}
	};
	
	public static void println(String msg) {
		System.out.println(msg);
	}
}
