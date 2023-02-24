package in.cdac.portal.service;

import java.util.HashSet;
import java.util.Map;

import in.cdac.portal.pojo.ChartData;

public interface UserService {

	int deptCount();

	int apkCount();

	int totTrnsaction();

	ChartData getDataForChart();

	ChartData getDataForChartMonthly();

	Object deptList();

	Map<String, Integer> getapkAndTransAcToDept(String deptName);

	HashSet<String> getAppListDeptWise(String deptName);

	Object apkWiseCount();

	Object deptWiseCount();


}
