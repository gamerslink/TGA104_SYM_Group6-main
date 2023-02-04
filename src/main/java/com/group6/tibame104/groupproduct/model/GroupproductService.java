package com.group6.tibame104.groupproduct.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupproductService {
	@Autowired
	private GroupproductDAO_interface dao;

//新增
	public GroupproductVO addGroupproduct(Integer groupBuyProductPrice, byte[] groupBuyProductPicture,
			String groupBuyProductDescrip) {

		GroupproductVO groupproductVO = new GroupproductVO();

		groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
		groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
		groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);

		dao.insert(groupproductVO);

		return groupproductVO;
	}

//修改
	public GroupproductVO updateGroupproduct(Integer groupBuyProductPrice, byte[] groupBuyProductPicture, String groupBuyProductDescrip ,Integer groupBuyProductID ) {

		GroupproductVO groupproductVO = new GroupproductVO();
		
		groupproductVO.setGroupBuyProductPrice(groupBuyProductPrice);
		groupproductVO.setGroupBuyProductPicture(groupBuyProductPicture);
		groupproductVO.setGroupBuyProductDescrip(groupBuyProductDescrip);
		groupproductVO.setGroupBuyProductID(groupBuyProductID);

		dao.update(groupproductVO);
		return groupproductVO;
	}

//單一查詢
	public GroupproductVO getOneGroupproduct(Integer groupBuyProductID) {
		return dao.findByPrimaryKey(groupBuyProductID);
	}

//查詢全部
	public List<GroupproductVO> getAll() {
		return dao.getAll();
	}

	public void deleteGroupproduct(Integer groupBuyProductID) {
		dao.delete(groupBuyProductID);
	}
	
	
	public List<GroupproductVO> getAllBySearch(Map<String, String> queryString){
		
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> it = queryString.entrySet().iterator();
		int i = 0;
		if (it.hasNext()) {
			sb.append(" where ");
		}
		while (it.hasNext()) {
			Entry<String, String> next = it.next();
			if (i > 0) {
				sb.append(" and ");
			}
			if ("groupbuyProductID".equals(next.getKey())) {
				sb.append(next.getKey() + " = " + next.getValue());
			} else if ("groupbuyProductPrice".equals(next.getKey())) {
				sb.append(next.getKey() + " = " + next.getValue());
			} else if ("groupbuyProductDescrip".equals(next.getKey())) {
				sb.append(next.getKey()  + " like " + next.getValue());
			} 
			i++;
		}
//		System.out.println("sb = " + sb);
		
		
		return dao.getAllBySearch(sb.toString());
	}

}
