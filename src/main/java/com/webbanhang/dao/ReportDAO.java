/*
*
* Fresher Academy 2019
* @author Kay
* @date Dec 7, 2019
* @version 1.8
* 
*/
package com.webbanhang.dao;

import java.util.List;

public interface ReportDAO {
	List<Object[]> inventoryByCategory();
	List<Object[]> revenueByCategory();
	List<Object[]> revenueByCustomer();
	List<Object[]> revenueByMonth();
	List<Object[]> quantityByNCC();
	Double revenueByMonthNow();
	Double revenueByYearNow();
	int userByData();
	int adminByData();
}
