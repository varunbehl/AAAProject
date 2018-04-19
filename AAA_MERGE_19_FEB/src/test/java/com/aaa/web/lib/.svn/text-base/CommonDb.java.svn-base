package com.aaa.web.lib;

import java.awt.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import com.aaa.commonutilities.DBMethods;
import com.aaa.commonutilities.DBUtils;

public class CommonDb extends DBMethods {

	/**
	 *  common method to retrieve member data 
	 *
	 * @param siteName      is the site_name of the DB
	 * @param queryFileName is the file_name of the Query
	
	 * @return 
	 */
	public static void retrieveMemberData(String siteName, String queryFileName) {
		String sqlFilePath = CR_SQL_ROOT + SEPARATOR + queryFileName;
		String sql = fileToString(sqlFilePath);
		try {
			//DBUtils.executeSqlStmt(getDb(siteName), sql);
			ArrayList<LinkedHashMap<String, Object>> membvalue = DBUtils.selectValuesFromDB(getDb(siteName), sql);
			
			System.out.println("Member value : "+membvalue );
		} catch (Exception ex) {
			LOG.debug(ex.getMessage());
		}
		
	}
	/**
	 *  common method to retrieve unique member data 
	 *
	 * @param siteName      is the site_name of the DB
	 * @param queryFileName is the file_name of the Query
	
	 * @return 
	 */
	public static String selectRandomMemberFromDB(String siteName, String queryFileName, String columnName, int rownum) {
		String sqlFilePath = CR_SQL_ROOT + SEPARATOR + queryFileName;
        String sql = fileToString(sqlFilePath);
        final String[] t_memberNumber = new String[rownum];
        DBUtils.select(getDb(siteName), sql, (ResultSet rs, long cnt) -> t_memberNumber[0] = rs.getString(columnName));
        return t_memberNumber[0];
    }
	/**
	 *  common method to retrieve unique member data 
	 *
	 * @param siteName      is the site_name of the DB
	 * @param queryFileName is the file_name of the Query
	
	 * @return 
	 */
	public static String selectRandomVehicleFromDB(String siteName, String queryFileName, String columnName, int rownum) {
		String sqlFilePath = CR_SQL_ROOT + SEPARATOR + queryFileName;
        String sql = fileToString(sqlFilePath);
        final String[] t_vehicleDetails = new String[rownum];
        DBUtils.select(getDb(siteName), sql, (ResultSet rs, long cnt) -> t_vehicleDetails[0] = rs.getString(columnName));
        return t_vehicleDetails[0];
    }
}