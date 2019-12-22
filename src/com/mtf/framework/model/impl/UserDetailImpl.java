package com.mtf.framework.model.impl;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fr.third.org.apache.poi.hssf.record.formula.functions.Date;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.UserDetail;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 人员信息表
 * 作者:    Auto
 * 日期:    2015/2/28
 **********************************************
 */
/**
 * @author admin
 *
 */
/**
 * @author admin
 *
 */
public class UserDetailImpl extends UserDetail {
	private static final long serialVersionUID = 1L;

	// 文件存放路径
	private String savePathFile;
	
	// 附件列表
	private List<CommonsMultipartFile> listFile;
	
	// 需要赋值的字段
	private String attachFiled;
	
	// 附件类型
	private String typeAttach;
	
	// 附件ID
	private Long attachmentId;
	
	// 照片路径
	private String attachPersonalPhotoPath;
	
	// 证件附件名
	private String attachIdNoFileName;
	
	// 附件名称
	private String attachFileName;
	
	// 附件下标
	private Integer attachIndex;
	
	// 个人资料
	private UserDetailImpl userDetail1;
	
	// 教育情况
	private UserDetailImpl userDetail2;
	
	// 工作经验
	private UserDetailImpl userDetail3;
	
	// 其他技能
	private UserDetailImpl userDetail4;
	
	// 紧急联络人
	private UserDetailImpl userDetail5;
	
	// 工作资料
	private UserDetailImpl userDetail6;
	
	// 学历附件
	private String attachEducationalDegreeFileName1;
	
	private String attachEducationalDegreeFileName2;
	
	private String attachEducationalDegreeFileName3;
	
	// 学位附件
	private String attachDegreeFileName1;
	
	private String attachDegreeFileName2;
	
	private String attachDegreeFileName3;
	
	// 技能证书附件
	private String certificatesOrLicensesFileName1;
	
	private String certificatesOrLicensesFileName2;
	
	private String certificatesOrLicensesFileName3;
	
	private String loginName;
	
	
	private String displayName;
	private String language;
	private String status;
	private String roleId;
	private String roleName;
	private String divisionName;
	private String divisionId;
	
	private String divisionIdMain;
	
	private List<RoleImpl> listRole;
	
	private List<Division> listDivision;
	
	private String ethnicGroupName;
	
	private String educationalDegree1Name;
	
	// 用户注册状态,新注册用户填写信息用 1. 
	private String statusInit;
	
	// 权限编码
	private String code;
	
	// 司龄展示
	private String seniorityShow;
	
	// 年龄
	private String age;
	
	// 合同截止日
	private String terminationDateEnd;
	
	private String searchRank;
	
	private String[] listSearchRank;
	
	private String[] arraySearchStatus;
	
	private String[] arraySearchMajor;
	
	private String[] arraySearchEducation;
	
	private String[] arraySearchPosition;
	
	private String[] arraySearchDivision;
	
	private String[] arraySearchEnglishEfficien;
	
	private String[] arraySearchRole;
	
	private String searchStatus;
	
	private String searchMajor;
	
	private String searchEducation;
	
	private String searchPosition;
	
	private String searchDivision;
	
	private String searchEnglishEfficien;

	private String searchLoginName;
	
	private String searchDisplayName;
	
	private String searchImmediateSuperior;
	
	private String searchRole;
	
	private String divisionNameEng;
	
	private String depTitle;
	
	private String nameImmediateSuperior;
	
	private Date onBoardDate;
	
	private String nameEmployer;
	
	private String nameSocialSecurityPermission;
	
	private String nameHouseFundingPermission;
	
	private String statusMain;
	
	private String loginNameMain;
	
	private String languageMain;
	
	// 部门等级
	private Integer divisionLevel;
	
	// 搜索用部门编号
	private String searchDivisionId;

	// 主部门标记
	private Integer mainIndex;
	
	private Long idAttenVacateManage;
	
	private String checked;
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Long getIdAttenVacateManage() {
		return idAttenVacateManage;
	}

	public void setIdAttenVacateManage(Long idAttenVacateManage) {
		this.idAttenVacateManage = idAttenVacateManage;
	}

	public Integer getMainIndex() {
		return mainIndex;
	}

	public void setMainIndex(Integer mainIndex) {
		this.mainIndex = mainIndex;
	}

	public String[] getArraySearchRole() {
		return arraySearchRole;
	}

	public void setArraySearchRole(String[] arraySearchRole) {
		this.arraySearchRole = arraySearchRole;
	}

	public String getSearchRole() {
		return searchRole;
	}

	public void setSearchRole(String searchRole) {
		this.searchRole = searchRole;
	}

	public String getSearchDivisionId() {
		return searchDivisionId;
	}

	public void setSearchDivisionId(String searchDivisionId) {
		this.searchDivisionId = searchDivisionId;
	}

	public Integer getDivisionLevel() {
		return divisionLevel;
	}

	public void setDivisionLevel(Integer divisionLevel) {
		this.divisionLevel = divisionLevel;
	}

	public String getDivisionIdMain() {
		return divisionIdMain;
	}

	public void setDivisionIdMain(String divisionIdMain) {
		this.divisionIdMain = divisionIdMain;
	}

	public String getSearchStatus() {
		return searchStatus;
	}

	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}

	public String getSearchMajor() {
		return searchMajor;
	}

	public void setSearchMajor(String searchMajor) {
		this.searchMajor = searchMajor;
	}

	public String getSearchEducation() {
		return searchEducation;
	}

	public void setSearchEducation(String searchEducation) {
		this.searchEducation = searchEducation;
	}

	public String getSearchPosition() {
		return searchPosition;
	}

	public void setSearchPosition(String searchPosition) {
		this.searchPosition = searchPosition;
	}

	public String getSearchDivision() {
		return searchDivision;
	}

	public void setSearchDivision(String searchDivision) {
		this.searchDivision = searchDivision;
	}

	public String getSearchEnglishEfficien() {
		return searchEnglishEfficien;
	}

	public void setSearchEnglishEfficien(String searchEnglishEfficien) {
		this.searchEnglishEfficien = searchEnglishEfficien;
	}

	public String[] getArraySearchStatus() {
		return arraySearchStatus;
	}

	public void setArraySearchStatus(String[] arraySearchStatus) {
		this.arraySearchStatus = arraySearchStatus;
	}

	public String[] getArraySearchMajor() {
		return arraySearchMajor;
	}

	public void setArraySearchMajor(String[] arraySearchMajor) {
		this.arraySearchMajor = arraySearchMajor;
	}

	public String[] getArraySearchEducation() {
		return arraySearchEducation;
	}

	public void setArraySearchEducation(String[] arraySearchEducation) {
		this.arraySearchEducation = arraySearchEducation;
	}

	public String[] getArraySearchPosition() {
		return arraySearchPosition;
	}

	public void setArraySearchPosition(String[] arraySearchPosition) {
		this.arraySearchPosition = arraySearchPosition;
	}

	public String[] getArraySearchDivision() {
		return arraySearchDivision;
	}

	public void setArraySearchDivision(String[] arraySearchDivision) {
		this.arraySearchDivision = arraySearchDivision;
	}

	public String[] getArraySearchEnglishEfficien() {
		return arraySearchEnglishEfficien;
	}

	public void setArraySearchEnglishEfficien(String[] arraySearchEnglishEfficien) {
		this.arraySearchEnglishEfficien = arraySearchEnglishEfficien;
	}

	public String getLanguageMain() {
		return languageMain;
	}

	public void setLanguageMain(String languageMain) {
		this.languageMain = languageMain;
	}

	public String getLoginNameMain() {
		return loginNameMain;
	}

	public void setLoginNameMain(String loginNameMain) {
		this.loginNameMain = loginNameMain;
	}

	public String getStatusMain() {
		return statusMain;
	}

	public void setStatusMain(String statusMain) {
		this.statusMain = statusMain;
	}

	public String getNameSocialSecurityPermission() {
		return nameSocialSecurityPermission;
	}

	public void setNameSocialSecurityPermission(String nameSocialSecurityPermission) {
		this.nameSocialSecurityPermission = nameSocialSecurityPermission;
	}

	public String getNameHouseFundingPermission() {
		return nameHouseFundingPermission;
	}

	public void setNameHouseFundingPermission(String nameHouseFundingPermission) {
		this.nameHouseFundingPermission = nameHouseFundingPermission;
	}

	public String getNameEmployer() {
		return nameEmployer;
	}

	public void setNameEmployer(String nameEmployer) {
		this.nameEmployer = nameEmployer;
	}

	public Date getOnBoardDate() {
		return onBoardDate;
	}

	public void setOnBoardDate(Date onBoardDate) {
		this.onBoardDate = onBoardDate;
	}

	public String getNameImmediateSuperior() {
		return nameImmediateSuperior;
	}

	public void setNameImmediateSuperior(String nameImmediateSuperior) {
		this.nameImmediateSuperior = nameImmediateSuperior;
	}

	public String getDivisionNameEng() {
		return divisionNameEng;
	}

	public void setDivisionNameEng(String divisionNameEng) {
		this.divisionNameEng = divisionNameEng;
	}

	public String getDepTitle() {
		return depTitle;
	}

	public void setDepTitle(String depTitle) {
		this.depTitle = depTitle;
	}

	public String getSearchLoginName() {
		return searchLoginName;
	}

	public void setSearchLoginName(String searchLoginName) {
		this.searchLoginName = searchLoginName;
	}

	public String getSearchDisplayName() {
		return searchDisplayName;
	}

	public void setSearchDisplayName(String searchDisplayName) {
		this.searchDisplayName = searchDisplayName;
	}

	public String getSearchImmediateSuperior() {
		return searchImmediateSuperior;
	}

	public void setSearchImmediateSuperior(String searchImmediateSuperior) {
		this.searchImmediateSuperior = searchImmediateSuperior;
	}

	public String[] getListSearchRank() {
		return listSearchRank;
	}

	public void setListSearchRank(String[] listSearchRank) {
		this.listSearchRank = listSearchRank;
	}

	public String getSearchRank() {
		return searchRank;
	}

	public void setSearchRank(String searchRank) {
		this.searchRank = searchRank;
	}

	public String getTerminationDateEnd() {
		return terminationDateEnd;
	}

	public void setTerminationDateEnd(String terminationDateEnd) {
		this.terminationDateEnd = terminationDateEnd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSeniorityShow() {
		return seniorityShow;
	}

	public void setSeniorityShow(String seniorityShow) {
		this.seniorityShow = seniorityShow;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatusInit() {
		return statusInit;
	}

	public void setStatusInit(String statusInit) {
		this.statusInit = statusInit;
	}

	public List<Division> getListDivision() {
		return listDivision;
	}

	public void setListDivision(List<Division> listDivision) {
		this.listDivision = listDivision;
	}

	public String getEducationalDegree1Name() {
		return educationalDegree1Name;
	}

	public void setEducationalDegree1Name(String educationalDegree1Name) {
		this.educationalDegree1Name = educationalDegree1Name;
	}

	public String getEthnicGroupName() {
		return ethnicGroupName;
	}

	public void setEthnicGroupName(String ethnicGroupName) {
		this.ethnicGroupName = ethnicGroupName;
	}

	public List<RoleImpl> getListRole() {
		return listRole;
	}

	public void setListRole(List<RoleImpl> listRole) {
		this.listRole = listRole;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getCertificatesOrLicensesFileName1() {
		return certificatesOrLicensesFileName1;
	}

	public void setCertificatesOrLicensesFileName1(
			String certificatesOrLicensesFileName1) {
		this.certificatesOrLicensesFileName1 = certificatesOrLicensesFileName1;
	}

	public String getCertificatesOrLicensesFileName2() {
		return certificatesOrLicensesFileName2;
	}

	public void setCertificatesOrLicensesFileName2(
			String certificatesOrLicensesFileName2) {
		this.certificatesOrLicensesFileName2 = certificatesOrLicensesFileName2;
	}

	public String getCertificatesOrLicensesFileName3() {
		return certificatesOrLicensesFileName3;
	}

	public void setCertificatesOrLicensesFileName3(
			String certificatesOrLicensesFileName3) {
		this.certificatesOrLicensesFileName3 = certificatesOrLicensesFileName3;
	}

	public String getAttachEducationalDegreeFileName1() {
		return attachEducationalDegreeFileName1;
	}

	public void setAttachEducationalDegreeFileName1(
			String attachEducationalDegreeFileName1) {
		this.attachEducationalDegreeFileName1 = attachEducationalDegreeFileName1;
	}

	public String getAttachEducationalDegreeFileName2() {
		return attachEducationalDegreeFileName2;
	}

	public void setAttachEducationalDegreeFileName2(
			String attachEducationalDegreeFileName2) {
		this.attachEducationalDegreeFileName2 = attachEducationalDegreeFileName2;
	}

	public String getAttachEducationalDegreeFileName3() {
		return attachEducationalDegreeFileName3;
	}

	public void setAttachEducationalDegreeFileName3(
			String attachEducationalDegreeFileName3) {
		this.attachEducationalDegreeFileName3 = attachEducationalDegreeFileName3;
	}

	public String getAttachDegreeFileName1() {
		return attachDegreeFileName1;
	}

	public void setAttachDegreeFileName1(String attachDegreeFileName1) {
		this.attachDegreeFileName1 = attachDegreeFileName1;
	}

	public String getAttachDegreeFileName2() {
		return attachDegreeFileName2;
	}

	public void setAttachDegreeFileName2(String attachDegreeFileName2) {
		this.attachDegreeFileName2 = attachDegreeFileName2;
	}

	public String getAttachDegreeFileName3() {
		return attachDegreeFileName3;
	}

	public void setAttachDegreeFileName3(String attachDegreeFileName3) {
		this.attachDegreeFileName3 = attachDegreeFileName3;
	}

	public Integer getAttachIndex() {
		return attachIndex;
	}

	public void setAttachIndex(Integer attachIndex) {
		this.attachIndex = attachIndex;
	}

	public UserDetailImpl getUserDetail2() {
		return userDetail2;
	}

	public void setUserDetail2(UserDetailImpl userDetail2) {
		this.userDetail2 = userDetail2;
	}

	public UserDetailImpl getUserDetail3() {
		return userDetail3;
	}

	public void setUserDetail3(UserDetailImpl userDetail3) {
		this.userDetail3 = userDetail3;
	}

	public UserDetailImpl getUserDetail4() {
		return userDetail4;
	}

	public void setUserDetail4(UserDetailImpl userDetail4) {
		this.userDetail4 = userDetail4;
	}

	public UserDetailImpl getUserDetail5() {
		return userDetail5;
	}

	public void setUserDetail5(UserDetailImpl userDetail5) {
		this.userDetail5 = userDetail5;
	}

	public UserDetailImpl getUserDetail6() {
		return userDetail6;
	}

	public void setUserDetail6(UserDetailImpl userDetail6) {
		this.userDetail6 = userDetail6;
	}

	public UserDetailImpl getUserDetail1() {
		return userDetail1;
	}

	public void setUserDetail1(UserDetailImpl userDetail1) {
		this.userDetail1 = userDetail1;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

	public String getAttachIdNoFileName() {
		return attachIdNoFileName;
	}

	public void setAttachIdNoFileName(String attachIdNoFileName) {
		this.attachIdNoFileName = attachIdNoFileName;
	}

	public String getAttachPersonalPhotoPath() {
		return attachPersonalPhotoPath;
	}

	public void setAttachPersonalPhotoPath(String attachPersonalPhotoPath) {
		this.attachPersonalPhotoPath = attachPersonalPhotoPath;
	}

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getTypeAttach() {
		return typeAttach;
	}

	public void setTypeAttach(String typeAttach) {
		this.typeAttach = typeAttach;
	}

	public String getAttachFiled() {
		return attachFiled;
	}

	public void setAttachFiled(String attachFiled) {
		this.attachFiled = attachFiled;
	}

	public String getSavePathFile() {
		return savePathFile;
	}

	public void setSavePathFile(String savePathFile) {
		this.savePathFile = savePathFile;
	}

	public List<CommonsMultipartFile> getListFile() {
		return listFile;
	}

	public void setListFile(List<CommonsMultipartFile> listFile) {
		this.listFile = listFile;
	}

}