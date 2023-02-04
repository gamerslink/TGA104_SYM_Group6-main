package com.group6.tibame104.order.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group6.tibame104.order.model.OrderService;
import com.group6.tibame104.order.model.OrderVO;
import com.group6.tibame104.orderlist.model.OrderlistService;
import com.group6.tibame104.orderlist.model.OrderlistVO;

@Controller
@RequestMapping("/front-end/order")
public class OrderController {
	@Autowired
	OrderService orderSvc;
	@Autowired
	OrderlistService orderlistSvc;
	
	
//	@PostMapping("/select_by_OrderID")
//    public String selectByOrderID(Model model, @RequestParam("orderID") String str) {
//		Integer orderID = Integer.valueOf(str);
//		
//		
//		OrderVO orderVO_orderID = orderSvc.getOrder(orderID);
//		
//		model.addAttribute("orderVO_orderID", orderVO_orderID); // 資料庫取出的empVO物件,存入req
//		model.addAttribute("orderID", orderID); 
//		return "front-end/order/listOrder_One";
//		
//	}

	
	
	@PostMapping("/select_Order")
	public String selectOrder(Model model, @RequestParam Map<String,String> map) {
		
		List<OrderVO> list_OrderVO  = orderSvc.getAllOrderByComposite(map);
		
		Comparator<OrderVO> keyComparator = new Comparator<OrderVO>() {
            @Override
            public int compare(OrderVO o1, OrderVO o2) {
                // TODO Auto-generated method stub
                return o2.getOrderID().compareTo(o1.getOrderID());
            }
        };
        Map<OrderVO,List<OrderlistVO>> map_list = new TreeMap<OrderVO,List<OrderlistVO>>(keyComparator);
		
		for(OrderVO orderVO : list_OrderVO) {
			List<OrderlistVO> list_OrderlistVO = orderlistSvc.searchOrderlist(orderVO.getOrderID());
			map_list.put(orderVO, list_OrderlistVO);
		}
		if(map.get("orderID") != null) {
			model.addAttribute("orderID", map.get("orderID"));		
		}else {
			model.addAttribute("orderID", null);
		}
		
		if(map.get("status") != null) {
			model.addAttribute("status", map.get("status"));
		} else {
			model.addAttribute("status", null);
		}
		
		if(map.get("fromdate") != null && map.get("todate") != null ) {
			model.addAttribute("fromdate", map.get("fromdate"));
			model.addAttribute("todate", map.get("todate"));
		}else {
			model.addAttribute("fromdate", null);
			model.addAttribute("todate", null);
		}
		
		model.addAttribute("map_list", map_list);
	
				return "front-end/order/listOrder";
		
	}
	
	@PostMapping("/complete")
	public String complete(Model model, @RequestParam("orderID") String orderID) {
		
		orderSvc.updateOrder(Integer.valueOf(orderID), 3);
				
		
		
	
        Map<OrderVO,List<OrderlistVO>> map_list = new HashMap<OrderVO,List<OrderlistVO>>();
		
		
        OrderVO orderVO  = orderSvc.getOrder(Integer.valueOf(orderID));
		List<OrderlistVO> list_OrderlistVO = orderlistSvc.searchOrderlist(orderVO.getOrderID());
		map_list.put(orderVO, list_OrderlistVO);
		
		
		
		model.addAttribute("orderID", orderID);
		
		
		model.addAttribute("map_list", map_list);
	
				return "front-end/order/listOrder";

		
	}
}
