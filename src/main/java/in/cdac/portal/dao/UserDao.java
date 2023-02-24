package in.cdac.portal.dao;

import java.util.HashSet;
import java.util.Map;

public interface UserDao {

	int deptCount();

	int apkCount();

	int totTrnsaction();

	long getDataForChart(String string);

	long getDataForChartMonthly(String string);

	Object deptList();

	Map<String, Integer> getapkAndTransAcToDept(String deptName);

	HashSet<String> getAppListDeptWise(String deptName);

	Object apkWiseCount();

	Object deptWiseCount();

}
