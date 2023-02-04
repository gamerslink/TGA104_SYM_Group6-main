package com.group6.tibame104.member.com.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group6.tibame104.member.model.MemberDAO_interface;

@SpringBootTest
public class MemberHibernateDaoTests {

	@Autowired
	private MemberDAO_interface dao;

	@Test
	public void testSelect() {
		Integer bean = dao.selectLastMemberID();
		System.out.println("bean=" + bean);
	}

}
