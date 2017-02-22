package service;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import bean.DayBean;
import bean.SystemBean;

public class CreateCsvMethods {

	public void insSystemKanri() {
		String url = /* csvファイル */;
		try (ICsvBeanReader inFile = new CsvBeanReader(new FileReader(url), CsvPreference.EXCEL_PREFERENCE);
				Connection con = DriverManager.getConnection(/* psql */);
				Statement statement = con.createStatement();) {

			SystemBean line = null;
			final String[] header = inFile.getHeader(true);
			int cnt = 0;
			String sql;
			String insert = "INSERT INTO tableA ( system_code, system_name, status, comment, environment, update_user_id, update_date)";
			while ((line = inFile.read(SystemBean.class, header)) != null) {
				cnt++;
				sql = String.format("%s VALUES ('%03d', '%s', '%s', '%s', '%s' , 'user' , now()", insert, cnt,
						line.getSystemName(), line.getSiStatus(), line.getComment(), line.getVmEnvironment());
				System.out.println(sql);
				statement.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insOntime(){

		Map<String, Integer> week = new LinkedHashMap<String, Integer>();
		week.put("日", 1);
		week.put("月", 2);
		week.put("火", 3);
		week.put("水", 4);
		week.put("木", 5);
		week.put("金", 6);
		week.put("土", 7);

		String tableurl = /* csvファイル */;
		try (ICsvBeanReader inFile = new CsvBeanReader(new FileReader(tableurl), CsvPreference.EXCEL_PREFERENCE);
				Connection con = DriverManager.getConnection(/* psql */);
				Statement statement = con.createStatement();) {
			final String[] header = new String[] { "systemCode", "kubunCode", "startWeek", "endWeek", "startTime", "endTime" };
			DayBean day = new DayBean();
			String outputurl;
			String insert = "INSERT INTO tableB (system_code, day_of_week, kubun_id, start_time, end_time, update_user_id, update_date)";
			while ((day = inFile.read(DayBean.class, header)) != null) {

				outputurl = "C:/Users/taniuchi.wataru/Desktop/pleiades/output/" + day.getSystemCode()
						+ day.getKubunCode() + "_" + day.getStartWeek() + "-" + day.getEndWeek() + "_"
						+ day.getStartTime() + ".csv";

				try {

					int end = week.get(day.getEndWeek());
					String sql;
					for (int current = week.get(day.getStartWeek()); current <= end; current++) {
						sql = String.format("%s VALUES ('%s','%s','%s','%s','%s','user',now()) ",insert,day.getSystemCode(),
								current, day.getKubunCode(), day.getStartTime(), day.getEndTime());
						statement.executeUpdate(sql);
						System.out.println(sql);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
