package in.cdac.portal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class ReadIgniteService {

	@Autowired
	Environment env;
	
	private final static Logger logger = Logger.getLogger(ReadIgniteService.class);

	@SuppressWarnings("unchecked")
	public int getDataForChartMonthly(String Month) {		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	 
			logger.info(e.getMessage());
		}	  
	    
//		String line = "";
		int count = 0;
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[3].toString().isEmpty() && CscData[3].toString() != ""
						&& !CscData[3].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					if (Month.equals(LocalDate.parse(CscData[3]).getMonth().toString())
							&& LocalDate.parse(CscData[3]).getMonth().toString() != ""
							&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
							&& !CscData[7].replaceAll("^\"|\"$", "").isEmpty()) {
						count = count + Integer.parseInt(CscData[7]);
					}
				}
			}
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return 0;
	}

	public int getDataForChart(String date) {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		    
	    
	    
//		String line = "";
		int count = 0;
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[3].toString().isEmpty()) {
					if (date.contentEquals((CscData[3])) && CscData[3] != ""
							&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
							&& !CscData[7].replaceAll("^\"|\"$", "").isEmpty()) {
						count = count + Integer.parseInt(CscData[7]);
					}
				}
			}
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return 0;

	}

	public int apkCount() {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		      
		
		
		
	    
//		String line = "";
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");

				if (!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					apkList.add(CscData[1].replace("\"", ""));

					if (CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
						tranCount.add(0);
						apkAndCount.put(CscData[1].replace("\"", ""), 0);
					}
					deptList.add(CscData[0].replace("\"", ""));
					deptAndCount.put(CscData[0].replace("\"", ""), 0);
					
//					if (!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
//							&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
//							&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {					
//						apkList.add(CscData[1].replace("\"", ""));
//						tranCount.add(Integer.valueOf(CscData[7].replace("\"", "")));
//						apkAndCount.put(CscData[1].replace("\"", ""), Integer.valueOf(CscData[7].replace("\"", "")));
//
//						deptList.add(CscData[0].replace("\"", ""));
//						deptAndCount.put(CscData[0].replace("\"", ""), 0);
//					}
				}

				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return (apkList.size());
	}

	public int deptCount() {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
			return 0;
		}		    
	    
	    
//		String line = "";
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (
						!CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[2].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					
					apkList.add(CscData[2].replace("\"", ""));
//					tranCount.add(Integer.valueOf(CscData[7].replace("\"", "")));
//					apkAndCount.put(CscData[2].replace("\"", ""), Integer.valueOf(CscData[7].replace("\"", "")));
					deptList.add(CscData[0].replace("\"", ""));
//					deptAndCount.put(CscData[0].replace("\"", ""), 0);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return deptList.size();
	}

	public Map<String, Map<String, Integer>> deptList() {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		     
	    
	    
//		String line = "";
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[2].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						) {
					apkList.add(CscData[1].replace("\"", ""));
//					tranCount.add(Integer.valueOf(CscData[7].replace("\"", "")));
//					apkAndCount.put(CscData[1].replace("\"", ""), Integer.valueOf(CscData[7].replace("\"", "")));
					deptList.add(CscData[0].replace("\"", ""));
//					deptAndCount.put(CscData[0].replace("\"", ""), 0);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		Map<String, Map<String , Integer>> deptcounts1 = new HashMap<>();
		for (String string : deptList) {
			deptcounts1.put(string, getapkAndTransAcToDept(string));
		}
		return deptcounts1;
	}

	public Map<String, Integer> apkWiseCount() {	
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		     
	    
	    
	    
	    
	    
//		String line = "";	
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[1].replace("\"", "").isEmpty()
//						&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[1].replaceAll("^\"|\"$", "").isEmpty()) {
					apkList.add(CscData[1].replace("\"", ""));
					if(CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
					{
						tranCount.add(0);
					}else
					{
						tranCount.add(Integer.parseInt(CscData[7].replace("\"", "")));
					}
					

					if (apkAndCount.get(CscData[1].replace("\"", "").toString()) != null
							&& !CscData[1].replace("\"", "").isEmpty()) {
						apkAndCount.put(CscData[1].replace("\"", ""),
								apkAndCount.get(CscData[1].replace("\"", "").toString())
										+ Integer.parseInt(CscData[7].replace("\"", "")));
					} else {
						if (!CscData[1].replace("\"", "").isEmpty()
								&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
								&& !CscData[1].replaceAll("^\"|\"$", "").isEmpty())
							if(CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
							{
								apkAndCount.put(CscData[1].replace("\"", ""),
										0);
							}else
							{
								apkAndCount.put(CscData[1].replace("\"", ""),
										Integer.parseInt(CscData[7].replace("\"", "")));
							}
							

					}
					if (!CscData[0].replace("\"", "").isEmpty()
							&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
							&& !CscData[0].replaceAll("^\"|\"$", "").isEmpty()) {
						deptList.add(CscData[0].replace("\"", ""));
						deptAndCount.put(CscData[0].replace("\"", ""), 0);
					}
				}
			}
			loop = 0;
//			while ((line = br.readLine()) != null) {
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				for (Map.Entry<String, Integer> entry : deptAndCount.entrySet()) {
					if (!CscData[1].replace("\"", "").isEmpty()
							&& CscData[2].replace("\"", "").contentEquals(entry.getKey())) {
						entry.setValue(entry.getValue() + Integer.valueOf(CscData[1].replace("\"", "")));
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return apkAndCount;
	}

	public Map<String, Integer> deptWiseCount() {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		     
	    
	    
	    
	    
	    
//		String line = "";
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (
//						!CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						 !CscData[2].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					apkList.add(CscData[2].replace("\"", ""));
//					tranCount.add(Integer.valueOf(CscData[7].replace("\"", "")));
//					apkAndCount.put(CscData[2].replace("\"", ""), Integer.valueOf(CscData[7].replace("\"", "")));
					deptList.add(CscData[0].replace("\"", ""));
					deptAndCount.put(CscData[0].replace("\"", ""), 0);
				}
			}
//			br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (
//						!CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
				
					for (Map.Entry<String, Integer> entry : deptAndCount.entrySet()) {
						if (CscData[0].replace("\"", "").contentEquals(entry.getKey())) {
							if(CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
							{
								entry.setValue(entry.getValue() + 0);
							}
							else
							{
								entry.setValue(entry.getValue() + Integer.valueOf(CscData[7].replace("\"", "")));
							}
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return deptAndCount;
	}

	public int totTrnsaction() {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		     
	    
	    
	    
//		String line = "";
		Set<String> apkList = new HashSet<String>();
		List<Integer> tranCount = new ArrayList<Integer>();
		Set<String> deptList = new HashSet<String>();
		Map<String, Integer> apkAndCount = new HashMap<String, Integer>();
		Map<String, Integer> deptAndCount = new HashMap<String, Integer>();
		// TODO Auto-generated method stub
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[2].replace("\"", "").isEmpty() && !CscData[0].replace("\"", "").isEmpty()
						&& !CscData[2].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					apkList.add(CscData[2].replace("\"", ""));
					tranCount.add(Integer.valueOf(CscData[7].replace("\"", "")));
					apkAndCount.put(CscData[2].replace("\"", ""), Integer.valueOf(CscData[7].replace("\"", "")));
					deptList.add(CscData[0].replace("\"", ""));
					deptAndCount.put(CscData[0].replace("\"", ""), 0);
				}
			}
//			br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
						&& !CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					for (Map.Entry<String, Integer> entry : deptAndCount.entrySet()) {
						if (!CscData[0].replace("\"", "").isEmpty()
								&& CscData[0].replace("\"", "").contentEquals(entry.getKey())) {
							entry.setValue(entry.getValue() + Integer.valueOf(CscData[7].replace("\"", "")));
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}

		int totTrasactionCount = 0;
		for (Map.Entry<String, Integer> entry : deptAndCount.entrySet()) {
			totTrasactionCount = entry.getValue() + totTrasactionCount;
		}
		return totTrasactionCount;
	}

	public HashSet<String> getAppListDeptWise(String dept) {
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}		       
	    
	    
	    
		ArrayList<String> list = new ArrayList<String>();
//		String line = "";
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					if (dept.contains((CscData[0]).replaceAll("^\"|\"$", ""))
							&& !CscData[0].replaceAll("^\"|\"$", "").isEmpty()) {
						if (!CscData[1].replaceAll("^\"|\"$", "").isEmpty()
								&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
							list.add(CscData[1].replaceAll("^\"|\"$", ""));
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		HashSet<String> ret = new HashSet<String>();
		ret.addAll(list);
		return ret;
	}

	public Map<String, Integer> getapkAndTransAcToDept(String dept) {
		
		List<String> lines = new ArrayList<>(); 		
		ArrayList<String> resAl= new ArrayList<String>();
	    try {
//	    	String url = "http://localhost:8080/ignite/portalData";
	    	String url= env.getProperty("apiurl");
			RestTemplate rt = new RestTemplate();
			byte [] b=rt.getForObject(url, byte[].class);

			
			resAl= (ArrayList<String>)SerializationUtils.deserialize(b);				   
	    } catch (Exception e) {	    	
			logger.info(e.getMessage());
		}	    
	    
	    
		Map<String, Integer> map = new HashMap<String, Integer>();
//		String line = "";
		try {
//			BufferedReader br = new BufferedReader(new FileReader(env.getProperty("locationforchart")));
			int loop = 0;
			 for (String line : resAl) {
				loop++;
				String[] CscData = line.split(",");
				if (!CscData[0].replaceAll("^\"|\"$", "").isEmpty()
						&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
					if (dept.contains((CscData[0]).replaceAll("^\"|\"$", ""))
							&& !CscData[0].replaceAll("^\"|\"$", "").isEmpty()
							&& !CscData[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
						if (map.get((CscData[1]).replaceAll("^\"|\"$", "")) != null
								&& !CscData[1].replaceAll("^\"|\"$", "").isEmpty()
								&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")
								) {
							if( CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
							{
								map.put((CscData[1]).replaceAll("^\"|\"$", ""),
										map.get((CscData[1]).replaceAll("^\"|\"$", ""))
												+ 0);
							}
							else {
								map.put((CscData[1]).replaceAll("^\"|\"$", ""),
										map.get((CscData[1]).replaceAll("^\"|\"$", ""))
												+ Integer.parseInt((CscData[7]).replaceAll("^\"|\"$", "")));
							}
							
						} else {
							if (!CscData[1].replaceAll("^\"|\"$", "").isEmpty()									
									&& !CscData[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("null")) {
								if(CscData[7].replaceAll("^\"|\"$", "").equalsIgnoreCase("null"))
								{
									map.put((CscData[1]).replaceAll("^\"|\"$", ""),
											0);
								}else {
									
									map.put((CscData[1]).replaceAll("^\"|\"$", ""),
											Integer.parseInt((CscData[7]).replaceAll("^\"|\"$", "")));
								}
								
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return map;
	}
}
