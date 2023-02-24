package in.cdac.portal.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.portal.dao.UserDao;
import in.cdac.portal.pojo.ChartData;

@Service
public class UserServiceImpl implements UserService {
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

//	@Autowired
//	UserDao userDao;
	
	@Autowired
	Read userDao;

	@Override
	public int deptCount() {
		// TODO Auto-generated method stub
		return userDao.deptCount();
	}

	@Override
	public int apkCount() {
		// TODO Auto-generated method stub
		return userDao.apkCount();
	}

	@Override
	public int totTrnsaction() {
		// TODO Auto-generated method stub
		return userDao.totTrnsaction();
	}

	@Override
	public ChartData getDataForChart() {
		// TODO Auto-generated method stub
		long[] chartData = new long[7];
		ChartData chartD = new ChartData();
		String label[] = { "Total Department", "Total Services", "Total Transaction", "Jan", "dec", "Jan", "Jan" };
		try {

			LocalDate localdate = LocalDate.now();
			String date = localdate.toString();
			label[6] = date.toString();
			chartData[6] = userDao.getDataForChart(date.toString());

			String dateforchart = findPrevDay(1);
			label[5] = dateforchart;
			chartData[5] = userDao.getDataForChart(dateforchart);

			dateforchart = findPrevDay(2);
			label[4] = dateforchart;
			chartData[4] = userDao.getDataForChart(dateforchart);

			dateforchart = findPrevDay(3);
			label[3] = dateforchart;
			chartData[3] = userDao.getDataForChart(dateforchart);

			dateforchart = findPrevDay(4);
			label[2] = dateforchart;
			chartData[2] = userDao.getDataForChart(dateforchart);

			dateforchart = findPrevDay(5);
			label[1] = dateforchart;
			chartData[1] = userDao.getDataForChart(dateforchart);

			dateforchart = findPrevDay(6);
			label[0] = dateforchart;
			chartData[0] = userDao.getDataForChart(dateforchart);
			chartD.setData(chartData);
			chartD.setLabels(label);
			return chartD;
		} catch (Exception e) {
			logger.info(e.getMessage());
			chartD.setData(chartData);
			chartD.setLabels(label);
			String demolabel[] = { LocalDate.now().toString(), findPrevDay(1), findPrevDay(2), findPrevDay(3),
					findPrevDay(4), findPrevDay(5), findPrevDay(6) };
			long demodata[] = { 10, 20, 30, 40, 50, 60, 70 };
			chartD.setData(demodata);
			chartD.setLabels(demolabel);
			return chartD;
		}
	}

	private String findPrevDay(int days) {
		LocalDate localdate = LocalDate.now();
		return localdate.minusDays(days).toString();
	}

	@Override
	public ChartData getDataForChartMonthly() {
		String monthnames[] = { "Jan", "dec", "Jan"};
		long[] monthwisecount = new long[3];
		LocalDate now = LocalDate.now();
		ChartData chartData = new ChartData();
		try {
			LocalDate earlier = now.minusMonths(0);
			monthnames[2] = earlier.getMonth().toString();
			monthwisecount[2] = userDao.getDataForChartMonthly(earlier.getMonth().toString());

			earlier = now.minusMonths(1);
			monthnames[1] = earlier.getMonth().toString();
			monthwisecount[1] = userDao.getDataForChartMonthly(earlier.getMonth().toString());

			earlier = now.minusMonths(2);
			monthnames[0] = earlier.getMonth().toString();
			monthwisecount[0] = userDao.getDataForChartMonthly(earlier.getMonth().toString());
		

			chartData.setData(monthwisecount);
			chartData.setLabels(monthnames);
			return chartData;
		} catch (Exception e) {
			logger.info(e.getMessage());
			long monthslist[] = { 10, 20, 30 };
			String monthslabels[] = { now.minusMonths(0).getMonth().toString(), now.minusMonths(1).getMonth().toString(),
					now.minusMonths(2).getMonth().toString()  };
			chartData.setData(monthslist);
			chartData.setLabels(monthslabels);
			return chartData;
		}
	
	}

	@Override
	public Object deptList() {
		// TODO Auto-generated method stub
		return userDao.deptList();
	}

	@Override
	public Map<String, Integer> getapkAndTransAcToDept(String deptName) {
		// TODO Auto-generated method stub
		return userDao.getapkAndTransAcToDept(deptName);
	}

	@Override
	public HashSet<String> getAppListDeptWise(String deptName) {
		// TODO Auto-generated method stub
		return userDao.getAppListDeptWise(deptName);
	}

	@Override
	public Object apkWiseCount() {
		// TODO Auto-generated method stub
		return userDao.apkWiseCount();
	}

	@Override
	public Object deptWiseCount() {
		// TODO Auto-generated method stub
		return userDao.deptWiseCount();
	}

}
