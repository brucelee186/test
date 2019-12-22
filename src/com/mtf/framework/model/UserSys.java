package com.mtf.framework.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.util.JsonDateTimeSerializer;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 人员信息表
 * 作者:    Auto
 * 日期:    2016/11/7
 **********************************************
 */
public class UserSys extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private String id;
	// 员工编号(以前版本)
	private String code;
	// 登录名
	private String loginName;
	// 名
	private String firstName;
	// 姓
	private String lastName;
	// 显示名
	private String displayName;
	// 密码
	private String password;
	// 用户编号(以过时)
	private String userId;
	// 入职时间
	private Date dateTime;
	// 签名
	private String signature;
	// 状态
	private String status;
	// 邮箱地址
	private String email;
	// 国际化语言
	private String language;
	// 中文名
	private String chineseName;
	// 岗位ID
	private String departmentId;
	// 岗位等级
	private Long positionId;
	// 个人照片地址
	private String personalPhoto;
	// 员工卡号
	private String cardNo;
	// 硬件卡号
	private String badgenumber;
	// 客户
	private String workGroup;
	// 客户明细
	private String workGroupDetail;
	// 添加时间
	private Date addDate;
	// 添加人Id
	private String addIp;
	// IP地址
	private String addUser;
	// 修改人员ID
	private Date modifyDate;
	// 修改时间
	private String modifyIp;
	// IP地址
	private String modifyUser;
	
	/**
	 * 数据库字段
	 */
	// ID
	// 时间日期
	private Date				datetime;
	// 0启用、1禁用、2注册、3驳回
	// 新用户 n:new、老用户 o:old
	private String				statusRegist;
	// 入职日期
	private Date				entryDate;
	// 首次工作日期
	private Date				initialDate;

	private String				englishName;
	// 应聘岗位
	private String				targetPosition;
	// 性别
	private String				gender;
	// 出生日期
	private String				birthDate;
	// 民族
	private String				ethnicGroup;
	
	// 民族名称
	private String				ethnicGroupName;
	
	// 国籍
	private String				nationality;
	// 婚姻状况 n:否，y：是
	private String				maritalStatus;
	// 政治身份
	private String				politicalIdentity;
	// 宗教信仰
	private String				religion;
	// 身份证或者护照
	private String				idNo;
	// 户口所在地
	private String				resgisteredResidence;

	// 省
	private String				province;
	// 市
	private String				city;
	// 区
	private String				district;

	// 宅电或者移动电话
	private String				phoneNo;
	
	private String middleNameEn;
	private String rank;
	// 添加人Id
	private Long addUserId;
	// 修改人员ID
	private String modifieduserId;
	// 修改时间
	private Date modifiedDate;
	// IP地址
	private String modifiedIp;
	
	private String stateInit;
	
	private String middleName;


	// 宅电
	private String		telephoneNo;

	// 现住址
	private String		addressAvailable;
	// 社会保险号
	private String		socialSecurity;
	// 是否享受此项福利 n:否，y：是
	private String		socialAccess;
	// 社保缴费状态 d：discontinue断缴，c：continue在缴
	private String		socialPayingStatus;
	// 公积金账号
	private String		houseFunding;
	// 是否享受此项福利 n:否，y：是
	private String		houseAccess;
	// 公积金缴费状态 d：discontinue断缴，c：continue在缴
	private String		housePayingStatus;
	// 紧急联络人姓名1
	private String		emergencyName1;
	// 紧急联络人关系1
	private String		emergencyRelationship1;
	// 紧急联络工作单位和职务1
	private String		emergencyCompanyAndTitle1;
	// 紧急联络联系电话1
	private String		emergencyPhoneNo1;
	// 紧急联络人姓名2
	private String		emergencyName2;
	// 紧急联络人关系2
	private String		emergencyRelationship2;
	// 紧急联络工作单位和职务2
	private String		emergencyCompanyAndTitle2;
	// 紧急联络联系电话2
	private String		emergencyPhoneNo2;
	// 开始学习时间1
	private Date		beginEducationalPeriod1;
	// 结束学习时间1
	private Date		endEducationalPeriod1;
	// 学校名称1
	private String		schoolName1;
	// 专业1
	private String		major1;
	// 学历1
	private String		educationalDegree1;
	// 学历1名称
	private String		educationalDegree1Name;
	// 教育形式1 c:统招compulsory v：volunteer
	private String		educationalStatus1;
	// 开始学习时间2
	private Date		beginEducationalPeriod2;
	// 结束学习时间2
	private Date		endEducationalPeriod12;
	// 学校名称2
	private String		schoolName2;
	// 专业2
	private String		major2;
	// 学历2
	private String		educationalDegree2;
	// 教育形式2 c:统招compulsory v：volunteer
	private String		educationalStatus2;
	// 开始学习时间3
	private Date		beginEducationalPeriod3;
	// 结束学习时间3
	private Date		endEducationalPeriod13;
	// 学校名称3
	private String		schoolName3;
	// 专业3
	private String		major3;
	// 学历3
	private String		educationalDegree3;
	// 教育形式3 c:统招compulsory v：volunteer
	private String		educationalStatus3;
	// 技能名称1
	private String		skills1;
	// 技能证书1
	private String		certificatesOrLicenses1;
	// 资格获得时间1
	private Date		certificatedDate1;
	// 技能名称2
	private String		skills2;
	// 技能证书2
	private String		certificatesOrLicenses2;
	// 资格获得时间2
	private Date		certificatedDate2;
	// 学历证具体要求
	private String		degreeCertificateDetails;
	// 学历证是否符合要求 y:是,n:否
	private String		degreeCertificateValidity;
	// 学位证具体要求
	private String		diplomaCertificateDetails;
	// 学位证是否符合要求 y:是,n:否
	private String		diplomaCertificateValidity;
	// 英语等级证书具体要求
	private String		englishCertificateDetails;
	// 英语等级证书是否符合要求 y:是,n:否
	private String		englishCertificateValidity;
	// 职业资格证书具体要求
	private String		careerLicenseDetails;
	// 职业资格证书是否符合要求 y:是,n:否
	private String		careerLicenseValidity;
	// 身份证具体要求
	private String		IDNODetails;
	// 身份证是否符合要求 y:是,n:否
	private String		IDNOValidity;
	// 解除（终止）劳动合同证明具体要求pet:proof of employment termination
	private String		PETDetails;
	// 解除（终止）劳动合同证明是否符合要求 y:是,n:否 pet:proof of employment termination
	private String		PETValidity;
	// 其他所需具体要求
	private String		othersDetails;
	// 其他所需是否符合要求 y:是,n:否
	private String		othersValidity;
	// 图片路径
	private String		picUri;

	// 英语水平 TEM 4/TEM -8/CET-4/CET-6/其它others
	private String		englishProficiency;
	// 工作经历开始时间
	private String		careerFrom1;
	// 工作经历结束时间
	private String		careerEnd1;
	// 公司名称
	private String		careerCompany1;
	// 职位
	private String		careerPosition1;
	// 离职原因
	private String		careerlr1;
	// 薪水
	private String		careerSalary1;
	// 社保五种
	private String		careerSocial1;
	// 公积金
	private String		careerhouse1;
	// 工作经历开始时间
	private String		careerFrom2;
	// 工作经历结束时间
	private String		careerEnd2;
	// 公司名称
	private String		careerCompany2;
	// 职位
	private String		careerPosition2;
	// 离职原因
	private String		careerlr2;
	// 薪水
	private String		careerSalary2;
	// 社保五种
	private String		careerSocial2;
	// 公积金
	private String		careerhouse2;
	// 工作经历开始时间
	private String		careerFrom3;
	// 工作经历结束时间
	private String		careerEnd3;
	// 公司名称
	private String		careerCompany3;
	// 职位
	private String		careerPosition3;
	// 离职原因
	private String		careerlr3;
	// 薪水
	private String		careerSalary3;
	// 社保五种
	private String		careerSocial3;
	// 公积金
	private String		careerhouse3;
	// other information接受的薪资和福利（税前）
	private String		oiAccept;
	// 是否签订竞业避止条约
	private String		oiAgreement;
	// 是否能够提供与最后的单位的解除/终止劳动合同证明
	private String		oiTermination;

	// 高级管理人id
	private String		approverId;
	// 高级管理人姓名
	private String		approverName;
	// 高级管理人审批时间
	private Date		approverTime;
	// 审批状态 s：提交 a:审批 r:驳回
	private String		approveStatus;
	// 答题状态 y:可答题yes n:不可答题no
	private String		answerStatus;

	// profile
	private UserProfile	userProfile;

	// role
	private List<RoleImpl>	roles;

	private String		divisionId;

	private String		divisionName;

	private Division	divisions;
	
	
	// division
	private List<User2Division> user2Divisions;
		
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getStatusRegist() {
		return statusRegist;
	}

	public void setStatusRegist(String statusRegist) {
		this.statusRegist = statusRegist;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(String targetPosition) {
		this.targetPosition = targetPosition;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEthnicGroup() {
		return ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}

	public String getEthnicGroupName() {
		return ethnicGroupName;
	}

	public void setEthnicGroupName(String ethnicGroupName) {
		this.ethnicGroupName = ethnicGroupName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPoliticalIdentity() {
		return politicalIdentity;
	}

	public void setPoliticalIdentity(String politicalIdentity) {
		this.politicalIdentity = politicalIdentity;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getResgisteredResidence() {
		return resgisteredResidence;
	}

	public void setResgisteredResidence(String resgisteredResidence) {
		this.resgisteredResidence = resgisteredResidence;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMiddleNameEn() {
		return middleNameEn;
	}

	public void setMiddleNameEn(String middleNameEn) {
		this.middleNameEn = middleNameEn;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Long getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(Long addUserId) {
		this.addUserId = addUserId;
	}

	public String getModifieduserId() {
		return modifieduserId;
	}

	public void setModifieduserId(String modifieduserId) {
		this.modifieduserId = modifieduserId;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
	}

	public String getStateInit() {
		return stateInit;
	}

	public void setStateInit(String stateInit) {
		this.stateInit = stateInit;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getAddressAvailable() {
		return addressAvailable;
	}

	public void setAddressAvailable(String addressAvailable) {
		this.addressAvailable = addressAvailable;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public String getSocialAccess() {
		return socialAccess;
	}

	public void setSocialAccess(String socialAccess) {
		this.socialAccess = socialAccess;
	}

	public String getSocialPayingStatus() {
		return socialPayingStatus;
	}

	public void setSocialPayingStatus(String socialPayingStatus) {
		this.socialPayingStatus = socialPayingStatus;
	}

	public String getHouseFunding() {
		return houseFunding;
	}

	public void setHouseFunding(String houseFunding) {
		this.houseFunding = houseFunding;
	}

	public String getHouseAccess() {
		return houseAccess;
	}

	public void setHouseAccess(String houseAccess) {
		this.houseAccess = houseAccess;
	}

	public String getHousePayingStatus() {
		return housePayingStatus;
	}

	public void setHousePayingStatus(String housePayingStatus) {
		this.housePayingStatus = housePayingStatus;
	}

	public String getEmergencyName1() {
		return emergencyName1;
	}

	public void setEmergencyName1(String emergencyName1) {
		this.emergencyName1 = emergencyName1;
	}

	public String getEmergencyRelationship1() {
		return emergencyRelationship1;
	}

	public void setEmergencyRelationship1(String emergencyRelationship1) {
		this.emergencyRelationship1 = emergencyRelationship1;
	}

	public String getEmergencyCompanyAndTitle1() {
		return emergencyCompanyAndTitle1;
	}

	public void setEmergencyCompanyAndTitle1(String emergencyCompanyAndTitle1) {
		this.emergencyCompanyAndTitle1 = emergencyCompanyAndTitle1;
	}

	public String getEmergencyPhoneNo1() {
		return emergencyPhoneNo1;
	}

	public void setEmergencyPhoneNo1(String emergencyPhoneNo1) {
		this.emergencyPhoneNo1 = emergencyPhoneNo1;
	}

	public String getEmergencyName2() {
		return emergencyName2;
	}

	public void setEmergencyName2(String emergencyName2) {
		this.emergencyName2 = emergencyName2;
	}

	public String getEmergencyRelationship2() {
		return emergencyRelationship2;
	}

	public void setEmergencyRelationship2(String emergencyRelationship2) {
		this.emergencyRelationship2 = emergencyRelationship2;
	}

	public String getEmergencyCompanyAndTitle2() {
		return emergencyCompanyAndTitle2;
	}

	public void setEmergencyCompanyAndTitle2(String emergencyCompanyAndTitle2) {
		this.emergencyCompanyAndTitle2 = emergencyCompanyAndTitle2;
	}

	public String getEmergencyPhoneNo2() {
		return emergencyPhoneNo2;
	}

	public void setEmergencyPhoneNo2(String emergencyPhoneNo2) {
		this.emergencyPhoneNo2 = emergencyPhoneNo2;
	}

	public Date getBeginEducationalPeriod1() {
		return beginEducationalPeriod1;
	}

	public void setBeginEducationalPeriod1(Date beginEducationalPeriod1) {
		this.beginEducationalPeriod1 = beginEducationalPeriod1;
	}

	public Date getEndEducationalPeriod1() {
		return endEducationalPeriod1;
	}

	public void setEndEducationalPeriod1(Date endEducationalPeriod1) {
		this.endEducationalPeriod1 = endEducationalPeriod1;
	}

	public String getSchoolName1() {
		return schoolName1;
	}

	public void setSchoolName1(String schoolName1) {
		this.schoolName1 = schoolName1;
	}

	public String getMajor1() {
		return major1;
	}

	public void setMajor1(String major1) {
		this.major1 = major1;
	}

	public String getEducationalDegree1() {
		return educationalDegree1;
	}

	public void setEducationalDegree1(String educationalDegree1) {
		this.educationalDegree1 = educationalDegree1;
	}

	public String getEducationalDegree1Name() {
		return educationalDegree1Name;
	}

	public void setEducationalDegree1Name(String educationalDegree1Name) {
		this.educationalDegree1Name = educationalDegree1Name;
	}

	public String getEducationalStatus1() {
		return educationalStatus1;
	}

	public void setEducationalStatus1(String educationalStatus1) {
		this.educationalStatus1 = educationalStatus1;
	}

	public Date getBeginEducationalPeriod2() {
		return beginEducationalPeriod2;
	}

	public void setBeginEducationalPeriod2(Date beginEducationalPeriod2) {
		this.beginEducationalPeriod2 = beginEducationalPeriod2;
	}

	public Date getEndEducationalPeriod12() {
		return endEducationalPeriod12;
	}

	public void setEndEducationalPeriod12(Date endEducationalPeriod12) {
		this.endEducationalPeriod12 = endEducationalPeriod12;
	}

	public String getSchoolName2() {
		return schoolName2;
	}

	public void setSchoolName2(String schoolName2) {
		this.schoolName2 = schoolName2;
	}

	public String getMajor2() {
		return major2;
	}

	public void setMajor2(String major2) {
		this.major2 = major2;
	}

	public String getEducationalDegree2() {
		return educationalDegree2;
	}

	public void setEducationalDegree2(String educationalDegree2) {
		this.educationalDegree2 = educationalDegree2;
	}

	public String getEducationalStatus2() {
		return educationalStatus2;
	}

	public void setEducationalStatus2(String educationalStatus2) {
		this.educationalStatus2 = educationalStatus2;
	}

	public Date getBeginEducationalPeriod3() {
		return beginEducationalPeriod3;
	}

	public void setBeginEducationalPeriod3(Date beginEducationalPeriod3) {
		this.beginEducationalPeriod3 = beginEducationalPeriod3;
	}

	public Date getEndEducationalPeriod13() {
		return endEducationalPeriod13;
	}

	public void setEndEducationalPeriod13(Date endEducationalPeriod13) {
		this.endEducationalPeriod13 = endEducationalPeriod13;
	}

	public String getSchoolName3() {
		return schoolName3;
	}

	public void setSchoolName3(String schoolName3) {
		this.schoolName3 = schoolName3;
	}

	public String getMajor3() {
		return major3;
	}

	public void setMajor3(String major3) {
		this.major3 = major3;
	}

	public String getEducationalDegree3() {
		return educationalDegree3;
	}

	public void setEducationalDegree3(String educationalDegree3) {
		this.educationalDegree3 = educationalDegree3;
	}

	public String getEducationalStatus3() {
		return educationalStatus3;
	}

	public void setEducationalStatus3(String educationalStatus3) {
		this.educationalStatus3 = educationalStatus3;
	}

	public String getSkills1() {
		return skills1;
	}

	public void setSkills1(String skills1) {
		this.skills1 = skills1;
	}

	public String getCertificatesOrLicenses1() {
		return certificatesOrLicenses1;
	}

	public void setCertificatesOrLicenses1(String certificatesOrLicenses1) {
		this.certificatesOrLicenses1 = certificatesOrLicenses1;
	}

	public Date getCertificatedDate1() {
		return certificatedDate1;
	}

	public void setCertificatedDate1(Date certificatedDate1) {
		this.certificatedDate1 = certificatedDate1;
	}

	public String getSkills2() {
		return skills2;
	}

	public void setSkills2(String skills2) {
		this.skills2 = skills2;
	}

	public String getCertificatesOrLicenses2() {
		return certificatesOrLicenses2;
	}

	public void setCertificatesOrLicenses2(String certificatesOrLicenses2) {
		this.certificatesOrLicenses2 = certificatesOrLicenses2;
	}

	public Date getCertificatedDate2() {
		return certificatedDate2;
	}

	public void setCertificatedDate2(Date certificatedDate2) {
		this.certificatedDate2 = certificatedDate2;
	}

	public String getDegreeCertificateDetails() {
		return degreeCertificateDetails;
	}

	public void setDegreeCertificateDetails(String degreeCertificateDetails) {
		this.degreeCertificateDetails = degreeCertificateDetails;
	}

	public String getDegreeCertificateValidity() {
		return degreeCertificateValidity;
	}

	public void setDegreeCertificateValidity(String degreeCertificateValidity) {
		this.degreeCertificateValidity = degreeCertificateValidity;
	}

	public String getDiplomaCertificateDetails() {
		return diplomaCertificateDetails;
	}

	public void setDiplomaCertificateDetails(String diplomaCertificateDetails) {
		this.diplomaCertificateDetails = diplomaCertificateDetails;
	}

	public String getDiplomaCertificateValidity() {
		return diplomaCertificateValidity;
	}

	public void setDiplomaCertificateValidity(String diplomaCertificateValidity) {
		this.diplomaCertificateValidity = diplomaCertificateValidity;
	}

	public String getEnglishCertificateDetails() {
		return englishCertificateDetails;
	}

	public void setEnglishCertificateDetails(String englishCertificateDetails) {
		this.englishCertificateDetails = englishCertificateDetails;
	}

	public String getEnglishCertificateValidity() {
		return englishCertificateValidity;
	}

	public void setEnglishCertificateValidity(String englishCertificateValidity) {
		this.englishCertificateValidity = englishCertificateValidity;
	}

	public String getCareerLicenseDetails() {
		return careerLicenseDetails;
	}

	public void setCareerLicenseDetails(String careerLicenseDetails) {
		this.careerLicenseDetails = careerLicenseDetails;
	}

	public String getCareerLicenseValidity() {
		return careerLicenseValidity;
	}

	public void setCareerLicenseValidity(String careerLicenseValidity) {
		this.careerLicenseValidity = careerLicenseValidity;
	}

	public String getIDNODetails() {
		return IDNODetails;
	}

	public void setIDNODetails(String iDNODetails) {
		IDNODetails = iDNODetails;
	}

	public String getIDNOValidity() {
		return IDNOValidity;
	}

	public void setIDNOValidity(String iDNOValidity) {
		IDNOValidity = iDNOValidity;
	}

	public String getPETDetails() {
		return PETDetails;
	}

	public void setPETDetails(String pETDetails) {
		PETDetails = pETDetails;
	}

	public String getPETValidity() {
		return PETValidity;
	}

	public void setPETValidity(String pETValidity) {
		PETValidity = pETValidity;
	}

	public String getOthersDetails() {
		return othersDetails;
	}

	public void setOthersDetails(String othersDetails) {
		this.othersDetails = othersDetails;
	}

	public String getOthersValidity() {
		return othersValidity;
	}

	public void setOthersValidity(String othersValidity) {
		this.othersValidity = othersValidity;
	}

	public String getPicUri() {
		return picUri;
	}

	public void setPicUri(String picUri) {
		this.picUri = picUri;
	}

	public String getEnglishProficiency() {
		return englishProficiency;
	}

	public void setEnglishProficiency(String englishProficiency) {
		this.englishProficiency = englishProficiency;
	}

	public String getCareerFrom1() {
		return careerFrom1;
	}

	public void setCareerFrom1(String careerFrom1) {
		this.careerFrom1 = careerFrom1;
	}

	public String getCareerEnd1() {
		return careerEnd1;
	}

	public void setCareerEnd1(String careerEnd1) {
		this.careerEnd1 = careerEnd1;
	}

	public String getCareerCompany1() {
		return careerCompany1;
	}

	public void setCareerCompany1(String careerCompany1) {
		this.careerCompany1 = careerCompany1;
	}

	public String getCareerPosition1() {
		return careerPosition1;
	}

	public void setCareerPosition1(String careerPosition1) {
		this.careerPosition1 = careerPosition1;
	}

	public String getCareerlr1() {
		return careerlr1;
	}

	public void setCareerlr1(String careerlr1) {
		this.careerlr1 = careerlr1;
	}

	public String getCareerSalary1() {
		return careerSalary1;
	}

	public void setCareerSalary1(String careerSalary1) {
		this.careerSalary1 = careerSalary1;
	}

	public String getCareerSocial1() {
		return careerSocial1;
	}

	public void setCareerSocial1(String careerSocial1) {
		this.careerSocial1 = careerSocial1;
	}

	public String getCareerhouse1() {
		return careerhouse1;
	}

	public void setCareerhouse1(String careerhouse1) {
		this.careerhouse1 = careerhouse1;
	}

	public String getCareerFrom2() {
		return careerFrom2;
	}

	public void setCareerFrom2(String careerFrom2) {
		this.careerFrom2 = careerFrom2;
	}

	public String getCareerEnd2() {
		return careerEnd2;
	}

	public void setCareerEnd2(String careerEnd2) {
		this.careerEnd2 = careerEnd2;
	}

	public String getCareerCompany2() {
		return careerCompany2;
	}

	public void setCareerCompany2(String careerCompany2) {
		this.careerCompany2 = careerCompany2;
	}

	public String getCareerPosition2() {
		return careerPosition2;
	}

	public void setCareerPosition2(String careerPosition2) {
		this.careerPosition2 = careerPosition2;
	}

	public String getCareerlr2() {
		return careerlr2;
	}

	public void setCareerlr2(String careerlr2) {
		this.careerlr2 = careerlr2;
	}

	public String getCareerSalary2() {
		return careerSalary2;
	}

	public void setCareerSalary2(String careerSalary2) {
		this.careerSalary2 = careerSalary2;
	}

	public String getCareerSocial2() {
		return careerSocial2;
	}

	public void setCareerSocial2(String careerSocial2) {
		this.careerSocial2 = careerSocial2;
	}

	public String getCareerhouse2() {
		return careerhouse2;
	}

	public void setCareerhouse2(String careerhouse2) {
		this.careerhouse2 = careerhouse2;
	}

	public String getCareerFrom3() {
		return careerFrom3;
	}

	public void setCareerFrom3(String careerFrom3) {
		this.careerFrom3 = careerFrom3;
	}

	public String getCareerEnd3() {
		return careerEnd3;
	}

	public void setCareerEnd3(String careerEnd3) {
		this.careerEnd3 = careerEnd3;
	}

	public String getCareerCompany3() {
		return careerCompany3;
	}

	public void setCareerCompany3(String careerCompany3) {
		this.careerCompany3 = careerCompany3;
	}

	public String getCareerPosition3() {
		return careerPosition3;
	}

	public void setCareerPosition3(String careerPosition3) {
		this.careerPosition3 = careerPosition3;
	}

	public String getCareerlr3() {
		return careerlr3;
	}

	public void setCareerlr3(String careerlr3) {
		this.careerlr3 = careerlr3;
	}

	public String getCareerSalary3() {
		return careerSalary3;
	}

	public void setCareerSalary3(String careerSalary3) {
		this.careerSalary3 = careerSalary3;
	}

	public String getCareerSocial3() {
		return careerSocial3;
	}

	public void setCareerSocial3(String careerSocial3) {
		this.careerSocial3 = careerSocial3;
	}

	public String getCareerhouse3() {
		return careerhouse3;
	}

	public void setCareerhouse3(String careerhouse3) {
		this.careerhouse3 = careerhouse3;
	}

	public String getOiAccept() {
		return oiAccept;
	}

	public void setOiAccept(String oiAccept) {
		this.oiAccept = oiAccept;
	}

	public String getOiAgreement() {
		return oiAgreement;
	}

	public void setOiAgreement(String oiAgreement) {
		this.oiAgreement = oiAgreement;
	}

	public String getOiTermination() {
		return oiTermination;
	}

	public void setOiTermination(String oiTermination) {
		this.oiTermination = oiTermination;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public Date getApproverTime() {
		return approverTime;
	}

	public void setApproverTime(Date approverTime) {
		this.approverTime = approverTime;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<RoleImpl> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleImpl> roles) {
		this.roles = roles;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public Division getDivisions() {
		return divisions;
	}

	public void setDivisions(Division divisions) {
		this.divisions = divisions;
	}

	public List<User2Division> getUser2Divisions() {
		return user2Divisions;
	}

	public void setUser2Divisions(List<User2Division> user2Divisions) {
		this.user2Divisions = user2Divisions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getPersonalPhoto() {
		return personalPhoto;
	}

	public void setPersonalPhoto(String personalPhoto) {
		this.personalPhoto = personalPhoto;
	}
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getBadgenumber() {
		return badgenumber;
	}

	public void setBadgenumber(String badgenumber) {
		this.badgenumber = badgenumber;
	}
	public String getWorkGroup() {
		return workGroup;
	}

	public void setWorkGroup(String workGroup) {
		this.workGroup = workGroup;
	}
	public String getWorkGroupDetail() {
		return workGroupDetail;
	}

	public void setWorkGroupDetail(String workGroupDetail) {
		this.workGroupDetail = workGroupDetail;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyIp() {
		return modifyIp;
	}

	public void setModifyIp(String modifyIp) {
		this.modifyIp = modifyIp;
	}
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
}