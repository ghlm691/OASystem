package com.qf.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.qf.pojo.Student;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelUtils {



	//解析员工
	public static List<Student> parseExcel(InputStream is) {
		List<Student> list = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// 创建单元
		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);

			int l = sheet.getLastRowNum();
			for (int i = 1; i <= l; i++) {
				HSSFRow hr = sheet.getRow(i);
                Student student=new Student();

                student.setSid((int) hr.getCell(0).getNumericCellValue());
                student.setSname(hr.getCell(1).getStringCellValue());
                student.setAge(hr.getCell(2).getNumericCellValue()+"");
                student.setSex(hr.getCell(3).getStringCellValue());
                student.setCname(hr.getCell(4).getStringCellValue());

                /*staff.setNo(hr.getCell(0).getStringCellValue());
				staff.setName(hr.getCell(1).getStringCellValue());
				staff.setDid((int)hr.getCell(2).getNumericCellValue());
				staff.setSex(hr.getCell(3).getStringCellValue());
				staff.setPhone(new Double(hr.getCell(4).getNumericCellValue()).intValue()+"");
				staff.setEmail(hr.getCell(5).getStringCellValue());
				staff.setQq(new Double(hr.getCell(6).getNumericCellValue()).intValue()+"");
				staff.setCreatedate(sdf.parse(hr.getCell(7).getStringCellValue()));*/


				list.add(student);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}

	/**
	 * 信息导出
	 */
	public static void export(OutputStream outputStream, List<Student> students) throws IOException {


		//在内存中建立一个excel
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		//创建工作簿
		HSSFSheet sheet = hssfWorkbook.createSheet("学生信息");
		//创建标题行
		HSSFRow titleRow = sheet.createRow(0);
		//titleRow.createCell(0).setCellValue("sid");
		titleRow.createCell(0).setCellValue("sname");
		titleRow.createCell(1).setCellValue("age");
		titleRow.createCell(2).setCellValue("sex");
		titleRow.createCell(3).setCellValue("cname");


		for (Student student : students) {

			int lastRowNum = sheet.getLastRowNum();
			HSSFRow row = sheet.createRow(lastRowNum + 1);
			//row.createCell(0).setCellValue(student.getSid());
			row.createCell(0).setCellValue(student.getSname());
			row.createCell(1).setCellValue(student.getAge());
			row.createCell(2).setCellValue(student.getSex());
			row.createCell(3).setCellValue(student.getCname());

		}

		//创建文件名
		String fileName = "student.xls";
		//获取mimeType
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		String mimeType = servletContext.getMimeType(fileName);

		HttpServletResponse resp = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();

		resp.setContentType(mimeType);
		resp.setHeader("Content-Disposition","attachment;filename="+fileName);
		hssfWorkbook.write(outputStream);
		hssfWorkbook.close();


	}

	
	//解析学员
	/*public static List<Student> parseExcelS(InputStream is) {
		List<Student> list = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// 创建单元
		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			int l = sheet.getLastRowNum();
			for (int i = 1; i <= l; i++) {
				HSSFRow hr = sheet.getRow(i);
				Student student=new Student();
				student.setNo(hr.getCell(0).getStringCellValue());
				student.setName(hr.getCell(1).getStringCellValue());
				student.setGid((int)hr.getCell(2).getNumericCellValue());
				student.setSex(hr.getCell(3).getStringCellValue());
				student.setPhone(new Double(hr.getCell(4).getNumericCellValue()).intValue()+"");
				student.setQq(new Double(hr.getCell(5).getNumericCellValue()).intValue()+"");
				student.setEmail(hr.getCell(6).getStringCellValue());
				student.setCardno(hr.getCell(7).getStringCellValue());
				student.setSchool(hr.getCell(8).getStringCellValue());
				student.setEducation(hr.getCell(9).getStringCellValue());
				student.setIntrono(hr.getCell(10).getStringCellValue());
				student.setBirthday(sdf.parse(hr.getCell(11).getStringCellValue()));
				student.setCreatedate(sdf.parse(hr.getCell(12).getStringCellValue()));
				list.add(student);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}*/
	
}
