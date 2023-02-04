package com.group6.tibame104.administrator.model;
import java.util.List;

public class AdministratorService {

	private AdministratorDAO_interface dao;

	public AdministratorService() {
		dao = new AdministratorJDBCDAO();
	}
	
	public AdministratorVO addAdmin(String administratorName, String administratorAccount, String administratorPassword) {
		AdministratorVO administratorVO = new AdministratorVO();
		administratorVO.setAdministratorName(administratorName);
		administratorVO.setAdministratorAccount(administratorAccount);
		administratorVO.setAdministratorPassword(administratorPassword);
		
		dao.insert(administratorVO);
		
		return administratorVO;
	}

	public AdministratorVO updateAdmin(String administratorName, String administratorAccount, String administratorPassword) {

		AdministratorVO administratorVO = new AdministratorVO();
		administratorVO.setAdministratorName(administratorName);
		administratorVO.setAdministratorAccount(administratorAccount);
		administratorVO.setAdministratorPassword(administratorPassword);
		dao.update(administratorVO);

		return administratorVO;
	}
	
	public AdministratorVO getOneAdmin(Integer administratorID) {
		return dao.findOneAdmin(administratorID);
	}
	

	public List<AdministratorVO> getAll() {
		return dao.getAll();
	}
	
	public void delete(Integer administratorID) {
		dao.delete(administratorID);
	}
}
