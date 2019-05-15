package com.yuanyuan.smp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuanyuan.smp.entity.User;
import com.yuanyuan.smp.service.IUserService;
import com.yuanyuan.smp.utils.FileUtil;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAll();
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建表
        HSSFSheet sheet = workbook.createSheet("用户信息");
        // 创建行
        HSSFRow row = sheet.createRow(0);
        // 创建单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        // 表头
        String[] head = {"姓名", "年龄"};
        HSSFCell cell;
        // 设置表头
        for(int iHead=0; iHead<head.length; iHead++) {
            cell = row.createCell(iHead);
            cell.setCellValue(head[iHead]);
            cell.setCellStyle(cellStyle);
        }
        // 设置表格内容
        for(int iBody=0; iBody<userList.size(); iBody++) {
            row = sheet.createRow(iBody+1);
            User u = userList.get(iBody);
            String[] userArray = new String[2];
            userArray[0]=u.getName();
            userArray[1]=u.getAge() + "";
            for(int iArray=0; iArray<userArray.length; iArray++) {
                row.createCell(iArray).setCellValue(userArray[iArray]);
            }
        }
        // 生成Excel文件
        FileUtil.createFile(response, workbook);
    }

}
