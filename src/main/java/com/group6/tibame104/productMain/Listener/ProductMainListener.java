package com.group6.tibame104.productMain.Listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.group6.tibame104.productMain.model.ProductMainJDBCDAO;
import com.group6.tibame104.productMain.model.ProductMainVO;

@WebListener
public class ProductMainListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
  
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	List<ProductMainVO> ProductMainAll = new ProductMainJDBCDAO().getAll();
    	sce.getServletContext().setAttribute("ProductMain", ProductMainAll);
//    	System.out.println("ProductMainListener 已經在pageContext載入商品大分類的資料了");
    }
	
}
