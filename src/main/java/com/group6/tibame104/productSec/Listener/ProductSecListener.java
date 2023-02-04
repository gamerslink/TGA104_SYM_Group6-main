package com.group6.tibame104.productSec.Listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.group6.tibame104.productSec.model.ProductSecJDBCDAO;
import com.group6.tibame104.productSec.model.ProductSecVO;

@WebListener
public class ProductSecListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
  
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	List<ProductSecVO> ProductSecAll = new ProductSecJDBCDAO().getAll();
    	sce.getServletContext().setAttribute("ProductSec", ProductSecAll);
//    	System.out.println("ProductSecListener 已經在pageContext載入商品中分類的資料了");
    }
	
}
