package com.mtf.framework.model;

import java.util.Date;
import com.mtf.framework.model.common.CommonModel;

import com.mtf.framework.util.JsonDateSerializer;

import com.mtf.framework.util.JsonDateTimeSerializer;

import com.mtf.framework.util.JsonYearSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 基础资料 -> 人员信息表
 * 作者:    Auto
 * 日期:    2018/3/22
 **********************************************
 */
public class UserDetail extends CommonModel {
private static final long serialVersionUID = 1L;
	/**
	 * 数据库字段
	 */
	// ID
	private Long id;
	// 用户编号
	private String userId;
	// 员工编号
	private String staffCode;
	// 车牌号
	private String vehiclePlateNo;
	// 中文名
	private String firstName;
	// 中文姓
	private String lastName;
	// 英文名
	private String firstNameEn;
	// 英文中间名
	private String middleNameEn;
	// 英文姓
	private String lastNameEn;
	// 登录名
	private String loginName;
	// 密码
	private String password;
	// 用户名
	private String displayName;
	// 唯一系统用户名
	private String uniqueName;
	// 客户名称
	private String workGroupName;
	// 客户明细名称
	private String workGroupDetailName;
	// 客户编号
	private String workGroupId;
	// 客户明细编号
	private String workGroupDetailId;
	// 个人照片
	private String attachPersonalPhoto;
	// 修改时间
	private Date dateTime;
	// 状态(0 在职, 1 离职, 2 注册, 3 驳回, 4 试用, 5 外部人员,   6 外部人员禁用)
	private String status;
	// 个人邮箱地址
	private String emailPersonal;
	// 国际化语言
	private String language;
	// 英语水平 TEM 4/TEM -8/CET-4/CET-6/其它others
	private String englishProficiency;
	// 中文名
	private String chineseName;
	// 英文名
	private String englishName;
	// 明细部门编号(三级部门）
	private String departmentId;
	// 应聘职位
	private String targetPosition;
	// 直属主管
	private String immediateSuperiorName;
	// 直属主管编号
	private String immediateSuperiorId;
	// 一级部门
	private String primaryDepartment;
	// 二级部门
	private String secondaryDepartment;
	// 三级部门
	private String tertiaryDepartment;
	// 客户
	private String employer;
	// 岗位ID
	private String positionId;
	// 岗位等级
	private String rank;
	// 性别　男:male m，女:famle f
	private String gender;
	// 出生日期
	private Date birthDate;
	// 年龄
	private String age;
	// 民族
	private String ethnicGroup;
	// 民族或者国籍
	private String nationality;
	// 婚姻状况       n:否，y：是 o:其它
	private String maritalStatus;
	// 政治身份
	private String politicalIdentity;
	// 宗教信仰
	private String religion;
	// 身份证或者护照
	private String idNo;
	// 身份证或者护照类型
	private String idNoType;
	// 是否提供证明  n:否，y：是
	private String idNoAccess;
	// 证件附件
	private String attachIdNo;
	// 办公电话
	private String officialTelNo;
	// 内部电话
	private String VNetNo;
	// 办公邮件
	private String email;
	// 入职日期
	private Date entryDate;
	// 离职时间
	private Date departedDate;
	// 转正日期
	private Date positiveDate;
	// 司龄
	private String seniority;
	// 缴费单位
	private String contractor;
	// 合同编号
	private String contractNo;
	// 合同期限
	private String contractPeriod;
	// 合同开始日期
	private Date contractCommenceDate;
	// 合同结束日期
	private Date contracTerminationDate;
	// 续签次数
	private String turns;
	// 首次工作日期
	private Date initialDate;
	// 户口所在地
	private String resgisteredResidence;
	// 移动电话
	private String phoneNo;
	// 宅电
	private String telephoneNo;
	// 现住址
	private String addressAvailable;
	// 社会保险号
	private String socialSecurityNo;
	// 是否享受此项福利   n:否，y：是
	private String socialSecurityPermission;
	// 社保缴费状态     d：discontinue断缴，c：continue在缴
	private String socialSecurityPayingStatus;
	// 社保开始日期
	private Date socialSecurityCommenceDate;
	// 社保结束日期
	private Date socialSecurityTerminationDate;
	// 保险基数
	private Double socialSecurityRange;
	// 公积金账号
	private String houseFundingNo;
	// 是否享受此项福利   n:否，y：是
	private String houseFundingPermission;
	// 公积金缴费状态    d：discontinue断缴，c：continue在缴
	private String houseFundingPayingStatus;
	// 公积金开始日期
	private Date houseFundingCommenceDate;
	// 公积金结束日期
	private Date houseFundingTerminationDate;
	// 公积金基数
	private Double houseFundinRange;
	// 开户行
	private String bankName;
	// 银行卡号
	private String bankCard;
	// 紧急联络人姓名1
	private String emergencyName1;
	// 紧急联络人关系1
	private String emergencyRelationship1;
	// 紧急联络工作单位和职务1
	private String emergencyCompanyAndTitle1;
	// 紧急联络联系电话1
	private String emergencyPhoneNo1;
	// 紧急联络人姓名2
	private String emergencyName2;
	// 紧急联络人关系2
	private String emergencyRelationship2;
	// 紧急联络工作单位和职务2
	private String emergencyCompanyAndTitle2;
	// 紧急联络联系电话2
	private String emergencyPhoneNo2;
	// 紧急联络人姓名3
	private String emergencyName3;
	// 紧急联络人关系3
	private String emergencyRelationship3;
	// 紧急联络工作单位和职务3
	private String emergencyCompanyAndTitle3;
	// 紧急联络联系电话3
	private String emergencyPhoneNo3;
	// 紧急联络人下标(1~3)
	private String indexEmergency;
	// 开始学习时间1
	private Date beginEducationalPeriod1;
	// 结束学习时间1
	private Date endEducationalPeriod1;
	// 学校名称1
	private String schoolName1;
	// 专业1
	private String major1;
	// 学历1
	private String educationalDegree1;
	// 教育形式1 c:统招compulsory  v：volunteer
	private String educationalStatus1;
	// 学历1附件
	private String attachEducationalDegree1;
	// 学位1附件
	private String attachDegree1;
	// 是否提供学历证明1
	private String proveEducationalDegree1;
	// 是否提供学位证明1
	private String proveDegree1;
	// 开始学习时间2
	private Date beginEducationalPeriod2;
	// 结束学习时间2
	private Date endEducationalPeriod2;
	// 学校名称2
	private String schoolName2;
	// 专业2
	private String major2;
	// 学历2
	private String educationalDegree2;
	// 教育形式2 c:统招compulsory  v：volunteer
	private String educationalStatus2;
	// 学历2附件
	private String attachEducationalDegree2;
	// 学位2附件
	private String attachDegree2;
	// 是否提供学历证明2
	private String proveEducationalDegree2;
	// 是否提供学位证明2
	private String proveDegree2;
	// 开始学习时间3
	private Date beginEducationalPeriod3;
	// 结束学习时间3
	private Date endEducationalPeriod3;
	// 学校名称3
	private String schoolName3;
	// 专业3
	private String major3;
	// 学历3
	private String educationalDegree3;
	// 教育形式3 c:统招compulsory  v：volunteer
	private String educationalStatus3;
	// 学历3附件
	private String attachEducationalDegree3;
	// 学位3附件
	private String attachDegree3;
	// 是否提供学历证明3
	private String proveEducationalDegree3;
	// 是否提供学位证明3
	private String proveDegree3;
	// 教育情况下标(1~3)
	private String indexEducation;
	// 技能名称1
	private String skills1;
	// 技能证书1
	private String certificatesOrLicenses1;
	// 是否提供证明  n:否，y：是
	private String skillsProve1;
	// 资格获得时间1
	private Date certificatedDate1;
	// 技能名称2
	private String skills2;
	// 技能证书2
	private String certificatesOrLicenses2;
	// 是否提供证明  n:否，y：是
	private String skillsProve2;
	// 资格获得时间2
	private Date certificatedDate2;
	// 技能名称3
	private String skills3;
	// 技能证书3
	private String certificatesOrLicenses3;
	// 是否提供证明  n:否，y：是
	private String skillsProve3;
	// 资格获得时间3
	private Date certificatedDate3;
	// 技能下标(1~3)
	private String indexSkill;
	// 学历证具体要求
	private String degreeCertificateDetails;
	// 学历证是否符合要求  y:是,n:否
	private String degreeCertificateValidity;
	// 学位证具体要求
	private String diplomaCertificateDetails;
	// 学位证是否符合要求  y:是,n:否
	private String diplomaCertificateValidity;
	// 英语等级证书具体要求
	private String englishCertificateDetails;
	// 英语等级证书是否符合要求  y:是,n:否
	private String englishCertificateValidity;
	// 职业资格证书具体要求
	private String careerLicenseDetails;
	// 职业资格证书是否符合要求  y:是,n:否
	private String careerLicenseValidity;
	// 身份证具体要求
	private String IDNODetails;
	// 身份证是否符合要求  y:是,n:否
	private String IDNOValidity;
	// 解除（终止）劳动合同证明具体要求pet:proof of employment termination
	private String PETDetails;
	// 解除（终止）劳动合同证明是否符合要求  y:是,n:否  pet:proof of employment termination
	private String PETValidity;
	// 其他所需具体要求
	private String othersDetails;
	// 其他所需是否符合要求  y:是,n:否
	private String othersValidity;
	// 图片路径
	private String picUri;
	// 高级管理人id
	private String approverId;
	// 高级管理人姓名
	private String approverName;
	// 高级管理人审批时间
	private Date approverTime;
	// 审批状态    s：提交 a:审批  r:驳回
	private String approveStatus;
	// 答题状态  y:可答题yes n:不可答题no
	private String answerStatus;
	// 创建时间
	private Date addDate;
	// 创建者
	private String addUser;
	// IP地址
	private String addIp;
	// 修改时间
	private Date modifiedDate;
	// 修改者
	private String modifiedUser;
	// IP地址
	private String modifiedIp;
	// 工作经历开始时间1
	private String careerFrom1;
	// 工作经历结束时间1
	private String careerEnd1;
	// 公司名称1
	private String careerCompany1;
	// 行业1
	private String industry1;
	// 职位1
	private String careerPosition1;
	// 离职原因1
	private String careerlr1;
	// 是否提共离职证明 是:y,否:n
	private String careerRequired1;
	// 薪水1
	private String careerSalary1;
	// 社保五种1
	private String careerSocial1;
	// 公积金1
	private String careerhouse1;
	// 工作经历开始时间2
	private String careerFrom2;
	// 工作经历结束时间2
	private String careerEnd2;
	// 公司名称2
	private String careerCompany2;
	// 行业2
	private String industry2;
	// 职位2
	private String careerPosition2;
	// 离职原因2
	private String careerlr2;
	// 是否提共离职证明 是:y,否:n
	private String careerRequired2;
	// 薪水2
	private String careerSalary2;
	// 社保五种2
	private String careerSocial2;
	// 公积金2
	private String careerhouse2;
	// 工作经历开始时间3
	private String careerFrom3;
	// 工作经历结束时间3
	private String careerEnd3;
	// 公司名称3
	private String careerCompany3;
	// 行业3
	private String industry3;
	// 职位3
	private String careerPosition3;
	// 离职原因3
	private String careerlr3;
	// 是否提共离职证明 是:y,否:n
	private String careerRequired3;
	// 薪水3
	private String careerSalary3;
	// 社保五种3
	private String careerSocial3;
	// 公积金3
	private String careerhouse3;
	// 工作经验下标(1~3)
	private String indexCareer;
	// other information接受的薪资和福利（税前）
	private String oiAccept;
	// 是否签订竞业避止条约
	private String oiAgreement;
	// 是否能够提供与最后的单位的解除/终止劳动合同证明
	private String oiTermination;
	// 省
	private String province;
	// 市
	private String city;
	// 区
	private String district;
	// 员工工号
	private String cardNo;
	// 硬件卡号
	private String badgenumber;
	// 入职备注
	private String remarkEntry;
	// 采暖(有:y,无:n)
	private String heating;
	// 加班费(有:y,无:n)
	private String extraWorkPay;
	// 转正前税前工资
	private Double emolumentPreTaxPositiveBefore;
	// 转正前税后工资
	private Double emolumentAfterTaxPositiveBefore;
	// 转正前税前保险公积金扣款
	private Double withholdingPositiveBefore;
	// 转正前保险基数
	private Double socialSecurityRangePositiveBefore;
	// 转正前公积金基数
	private Double houseFundinRangePositiveBefore;
	// 转正后税前工资
	private Double emolumentPreTax;
	// 转正后税后工资
	private Double emolumentAfterTax;
	// 转正后税前保险公积金扣款
	private Double withholding;
	// 工作经验(年)
	private Integer workingYear;
	// 预计入职日期
	private Date entryDateExpected;
	// 应聘部门编号
	private String departmentIdExpected;
	// 应聘部门名称
	private String departmentNameExpected;
	// 主角色编号
	private String roleId;
	// 主角色名称
	private String roleName;
	// 主部门编号（可能是三级或者三级以下要结点部门)
	private String divisionId;
	// 主部门名称（可能是三级或者三级以下要结点部门)
	private String divisionName;
	// 一级部门编号
	private String divisionId1;
	// 一级部门名称
	private String divisionName1;
	// 二级部门编号
	private String divisionId2;
	// 二级部门名称
	private String divisionName2;
	// 三级部门编号
	private String divisionId3;
	// 三级部门名称
	private String divisionName3;
	// 四级部门编号
	private String divisionId4;
	// 四级部门名称
	private String divisionName4;
	// 五级部门编号
	private String divisionId5;
	// 五级部门名称
	private String divisionName5;
	// 主部门等级
	private Integer divisionMainLevel;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getVehiclePlateNo() {
		return vehiclePlateNo;
	}

	public void setVehiclePlateNo(String vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
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
	public String getFirstNameEn() {
		return firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}
	public String getMiddleNameEn() {
		return middleNameEn;
	}

	public void setMiddleNameEn(String middleNameEn) {
		this.middleNameEn = middleNameEn;
	}
	public String getLastNameEn() {
		return lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	public String getWorkGroupName() {
		return workGroupName;
	}

	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}
	public String getWorkGroupDetailName() {
		return workGroupDetailName;
	}

	public void setWorkGroupDetailName(String workGroupDetailName) {
		this.workGroupDetailName = workGroupDetailName;
	}
	public String getWorkGroupId() {
		return workGroupId;
	}

	public void setWorkGroupId(String workGroupId) {
		this.workGroupId = workGroupId;
	}
	public String getWorkGroupDetailId() {
		return workGroupDetailId;
	}

	public void setWorkGroupDetailId(String workGroupDetailId) {
		this.workGroupDetailId = workGroupDetailId;
	}
	public String getAttachPersonalPhoto() {
		return attachPersonalPhoto;
	}

	public void setAttachPersonalPhoto(String attachPersonalPhoto) {
		this.attachPersonalPhoto = attachPersonalPhoto;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEnglishProficiency() {
		return englishProficiency;
	}

	public void setEnglishProficiency(String englishProficiency) {
		this.englishProficiency = englishProficiency;
	}
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(String targetPosition) {
		this.targetPosition = targetPosition;
	}
	public String getImmediateSuperiorName() {
		return immediateSuperiorName;
	}

	public void setImmediateSuperiorName(String immediateSuperiorName) {
		this.immediateSuperiorName = immediateSuperiorName;
	}
	public String getImmediateSuperiorId() {
		return immediateSuperiorId;
	}

	public void setImmediateSuperiorId(String immediateSuperiorId) {
		this.immediateSuperiorId = immediateSuperiorId;
	}
	public String getPrimaryDepartment() {
		return primaryDepartment;
	}

	public void setPrimaryDepartment(String primaryDepartment) {
		this.primaryDepartment = primaryDepartment;
	}
	public String getSecondaryDepartment() {
		return secondaryDepartment;
	}

	public void setSecondaryDepartment(String secondaryDepartment) {
		this.secondaryDepartment = secondaryDepartment;
	}
	public String getTertiaryDepartment() {
		return tertiaryDepartment;
	}

	public void setTertiaryDepartment(String tertiaryDepartment) {
		this.tertiaryDepartment = tertiaryDepartment;
	}
	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public String getEthnicGroup() {
		return ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
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
	public String getIdNoType() {
		return idNoType;
	}

	public void setIdNoType(String idNoType) {
		this.idNoType = idNoType;
	}
	public String getIdNoAccess() {
		return idNoAccess;
	}

	public void setIdNoAccess(String idNoAccess) {
		this.idNoAccess = idNoAccess;
	}
	public String getAttachIdNo() {
		return attachIdNo;
	}

	public void setAttachIdNo(String attachIdNo) {
		this.attachIdNo = attachIdNo;
	}
	public String getOfficialTelNo() {
		return officialTelNo;
	}

	public void setOfficialTelNo(String officialTelNo) {
		this.officialTelNo = officialTelNo;
	}
	public String getVNetNo() {
		return VNetNo;
	}

	public void setVNetNo(String VNetNo) {
		this.VNetNo = VNetNo;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getDepartedDate() {
		return departedDate;
	}

	public void setDepartedDate(Date departedDate) {
		this.departedDate = departedDate;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getPositiveDate() {
		return positiveDate;
	}

	public void setPositiveDate(Date positiveDate) {
		this.positiveDate = positiveDate;
	}
	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getContractCommenceDate() {
		return contractCommenceDate;
	}

	public void setContractCommenceDate(Date contractCommenceDate) {
		this.contractCommenceDate = contractCommenceDate;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getContracTerminationDate() {
		return contracTerminationDate;
	}

	public void setContracTerminationDate(Date contracTerminationDate) {
		this.contracTerminationDate = contracTerminationDate;
	}
	public String getTurns() {
		return turns;
	}

	public void setTurns(String turns) {
		this.turns = turns;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public String getResgisteredResidence() {
		return resgisteredResidence;
	}

	public void setResgisteredResidence(String resgisteredResidence) {
		this.resgisteredResidence = resgisteredResidence;
	}
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public String getSocialSecurityNo() {
		return socialSecurityNo;
	}

	public void setSocialSecurityNo(String socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}
	public String getSocialSecurityPermission() {
		return socialSecurityPermission;
	}

	public void setSocialSecurityPermission(String socialSecurityPermission) {
		this.socialSecurityPermission = socialSecurityPermission;
	}
	public String getSocialSecurityPayingStatus() {
		return socialSecurityPayingStatus;
	}

	public void setSocialSecurityPayingStatus(String socialSecurityPayingStatus) {
		this.socialSecurityPayingStatus = socialSecurityPayingStatus;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getSocialSecurityCommenceDate() {
		return socialSecurityCommenceDate;
	}

	public void setSocialSecurityCommenceDate(Date socialSecurityCommenceDate) {
		this.socialSecurityCommenceDate = socialSecurityCommenceDate;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getSocialSecurityTerminationDate() {
		return socialSecurityTerminationDate;
	}

	public void setSocialSecurityTerminationDate(Date socialSecurityTerminationDate) {
		this.socialSecurityTerminationDate = socialSecurityTerminationDate;
	}
	public Double getSocialSecurityRange() {
		return socialSecurityRange;
	}

	public void setSocialSecurityRange(Double socialSecurityRange) {
		this.socialSecurityRange = socialSecurityRange;
	}
	public String getHouseFundingNo() {
		return houseFundingNo;
	}

	public void setHouseFundingNo(String houseFundingNo) {
		this.houseFundingNo = houseFundingNo;
	}
	public String getHouseFundingPermission() {
		return houseFundingPermission;
	}

	public void setHouseFundingPermission(String houseFundingPermission) {
		this.houseFundingPermission = houseFundingPermission;
	}
	public String getHouseFundingPayingStatus() {
		return houseFundingPayingStatus;
	}

	public void setHouseFundingPayingStatus(String houseFundingPayingStatus) {
		this.houseFundingPayingStatus = houseFundingPayingStatus;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getHouseFundingCommenceDate() {
		return houseFundingCommenceDate;
	}

	public void setHouseFundingCommenceDate(Date houseFundingCommenceDate) {
		this.houseFundingCommenceDate = houseFundingCommenceDate;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getHouseFundingTerminationDate() {
		return houseFundingTerminationDate;
	}

	public void setHouseFundingTerminationDate(Date houseFundingTerminationDate) {
		this.houseFundingTerminationDate = houseFundingTerminationDate;
	}
	public Double getHouseFundinRange() {
		return houseFundinRange;
	}

	public void setHouseFundinRange(Double houseFundinRange) {
		this.houseFundinRange = houseFundinRange;
	}
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
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
	public String getEmergencyName3() {
		return emergencyName3;
	}

	public void setEmergencyName3(String emergencyName3) {
		this.emergencyName3 = emergencyName3;
	}
	public String getEmergencyRelationship3() {
		return emergencyRelationship3;
	}

	public void setEmergencyRelationship3(String emergencyRelationship3) {
		this.emergencyRelationship3 = emergencyRelationship3;
	}
	public String getEmergencyCompanyAndTitle3() {
		return emergencyCompanyAndTitle3;
	}

	public void setEmergencyCompanyAndTitle3(String emergencyCompanyAndTitle3) {
		this.emergencyCompanyAndTitle3 = emergencyCompanyAndTitle3;
	}
	public String getEmergencyPhoneNo3() {
		return emergencyPhoneNo3;
	}

	public void setEmergencyPhoneNo3(String emergencyPhoneNo3) {
		this.emergencyPhoneNo3 = emergencyPhoneNo3;
	}
	public String getIndexEmergency() {
		return indexEmergency;
	}

	public void setIndexEmergency(String indexEmergency) {
		this.indexEmergency = indexEmergency;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getBeginEducationalPeriod1() {
		return beginEducationalPeriod1;
	}

	public void setBeginEducationalPeriod1(Date beginEducationalPeriod1) {
		this.beginEducationalPeriod1 = beginEducationalPeriod1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
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
	public String getEducationalStatus1() {
		return educationalStatus1;
	}

	public void setEducationalStatus1(String educationalStatus1) {
		this.educationalStatus1 = educationalStatus1;
	}
	public String getAttachEducationalDegree1() {
		return attachEducationalDegree1;
	}

	public void setAttachEducationalDegree1(String attachEducationalDegree1) {
		this.attachEducationalDegree1 = attachEducationalDegree1;
	}
	public String getAttachDegree1() {
		return attachDegree1;
	}

	public void setAttachDegree1(String attachDegree1) {
		this.attachDegree1 = attachDegree1;
	}
	public String getProveEducationalDegree1() {
		return proveEducationalDegree1;
	}

	public void setProveEducationalDegree1(String proveEducationalDegree1) {
		this.proveEducationalDegree1 = proveEducationalDegree1;
	}
	public String getProveDegree1() {
		return proveDegree1;
	}

	public void setProveDegree1(String proveDegree1) {
		this.proveDegree1 = proveDegree1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getBeginEducationalPeriod2() {
		return beginEducationalPeriod2;
	}

	public void setBeginEducationalPeriod2(Date beginEducationalPeriod2) {
		this.beginEducationalPeriod2 = beginEducationalPeriod2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEndEducationalPeriod2() {
		return endEducationalPeriod2;
	}

	public void setEndEducationalPeriod2(Date endEducationalPeriod2) {
		this.endEducationalPeriod2 = endEducationalPeriod2;
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
	public String getAttachEducationalDegree2() {
		return attachEducationalDegree2;
	}

	public void setAttachEducationalDegree2(String attachEducationalDegree2) {
		this.attachEducationalDegree2 = attachEducationalDegree2;
	}
	public String getAttachDegree2() {
		return attachDegree2;
	}

	public void setAttachDegree2(String attachDegree2) {
		this.attachDegree2 = attachDegree2;
	}
	public String getProveEducationalDegree2() {
		return proveEducationalDegree2;
	}

	public void setProveEducationalDegree2(String proveEducationalDegree2) {
		this.proveEducationalDegree2 = proveEducationalDegree2;
	}
	public String getProveDegree2() {
		return proveDegree2;
	}

	public void setProveDegree2(String proveDegree2) {
		this.proveDegree2 = proveDegree2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getBeginEducationalPeriod3() {
		return beginEducationalPeriod3;
	}

	public void setBeginEducationalPeriod3(Date beginEducationalPeriod3) {
		this.beginEducationalPeriod3 = beginEducationalPeriod3;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEndEducationalPeriod3() {
		return endEducationalPeriod3;
	}

	public void setEndEducationalPeriod3(Date endEducationalPeriod3) {
		this.endEducationalPeriod3 = endEducationalPeriod3;
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
	public String getAttachEducationalDegree3() {
		return attachEducationalDegree3;
	}

	public void setAttachEducationalDegree3(String attachEducationalDegree3) {
		this.attachEducationalDegree3 = attachEducationalDegree3;
	}
	public String getAttachDegree3() {
		return attachDegree3;
	}

	public void setAttachDegree3(String attachDegree3) {
		this.attachDegree3 = attachDegree3;
	}
	public String getProveEducationalDegree3() {
		return proveEducationalDegree3;
	}

	public void setProveEducationalDegree3(String proveEducationalDegree3) {
		this.proveEducationalDegree3 = proveEducationalDegree3;
	}
	public String getProveDegree3() {
		return proveDegree3;
	}

	public void setProveDegree3(String proveDegree3) {
		this.proveDegree3 = proveDegree3;
	}
	public String getIndexEducation() {
		return indexEducation;
	}

	public void setIndexEducation(String indexEducation) {
		this.indexEducation = indexEducation;
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
	public String getSkillsProve1() {
		return skillsProve1;
	}

	public void setSkillsProve1(String skillsProve1) {
		this.skillsProve1 = skillsProve1;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
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
	public String getSkillsProve2() {
		return skillsProve2;
	}

	public void setSkillsProve2(String skillsProve2) {
		this.skillsProve2 = skillsProve2;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCertificatedDate2() {
		return certificatedDate2;
	}

	public void setCertificatedDate2(Date certificatedDate2) {
		this.certificatedDate2 = certificatedDate2;
	}
	public String getSkills3() {
		return skills3;
	}

	public void setSkills3(String skills3) {
		this.skills3 = skills3;
	}
	public String getCertificatesOrLicenses3() {
		return certificatesOrLicenses3;
	}

	public void setCertificatesOrLicenses3(String certificatesOrLicenses3) {
		this.certificatesOrLicenses3 = certificatesOrLicenses3;
	}
	public String getSkillsProve3() {
		return skillsProve3;
	}

	public void setSkillsProve3(String skillsProve3) {
		this.skillsProve3 = skillsProve3;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCertificatedDate3() {
		return certificatedDate3;
	}

	public void setCertificatedDate3(Date certificatedDate3) {
		this.certificatedDate3 = certificatedDate3;
	}
	public String getIndexSkill() {
		return indexSkill;
	}

	public void setIndexSkill(String indexSkill) {
		this.indexSkill = indexSkill;
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

	public void setIDNODetails(String IDNODetails) {
		this.IDNODetails = IDNODetails;
	}
	public String getIDNOValidity() {
		return IDNOValidity;
	}

	public void setIDNOValidity(String IDNOValidity) {
		this.IDNOValidity = IDNOValidity;
	}
	public String getPETDetails() {
		return PETDetails;
	}

	public void setPETDetails(String PETDetails) {
		this.PETDetails = PETDetails;
	}
	public String getPETValidity() {
		return PETValidity;
	}

	public void setPETValidity(String PETValidity) {
		this.PETValidity = PETValidity;
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
	@JsonSerialize(using = JsonDateTimeSerializer.class)
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
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getModifiedIp() {
		return modifiedIp;
	}

	public void setModifiedIp(String modifiedIp) {
		this.modifiedIp = modifiedIp;
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
	public String getIndustry1() {
		return industry1;
	}

	public void setIndustry1(String industry1) {
		this.industry1 = industry1;
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
	public String getCareerRequired1() {
		return careerRequired1;
	}

	public void setCareerRequired1(String careerRequired1) {
		this.careerRequired1 = careerRequired1;
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
	public String getIndustry2() {
		return industry2;
	}

	public void setIndustry2(String industry2) {
		this.industry2 = industry2;
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
	public String getCareerRequired2() {
		return careerRequired2;
	}

	public void setCareerRequired2(String careerRequired2) {
		this.careerRequired2 = careerRequired2;
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
	public String getIndustry3() {
		return industry3;
	}

	public void setIndustry3(String industry3) {
		this.industry3 = industry3;
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
	public String getCareerRequired3() {
		return careerRequired3;
	}

	public void setCareerRequired3(String careerRequired3) {
		this.careerRequired3 = careerRequired3;
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
	public String getIndexCareer() {
		return indexCareer;
	}

	public void setIndexCareer(String indexCareer) {
		this.indexCareer = indexCareer;
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
	public String getRemarkEntry() {
		return remarkEntry;
	}

	public void setRemarkEntry(String remarkEntry) {
		this.remarkEntry = remarkEntry;
	}
	public String getHeating() {
		return heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getExtraWorkPay() {
		return extraWorkPay;
	}

	public void setExtraWorkPay(String extraWorkPay) {
		this.extraWorkPay = extraWorkPay;
	}
	public Double getEmolumentPreTaxPositiveBefore() {
		return emolumentPreTaxPositiveBefore;
	}

	public void setEmolumentPreTaxPositiveBefore(Double emolumentPreTaxPositiveBefore) {
		this.emolumentPreTaxPositiveBefore = emolumentPreTaxPositiveBefore;
	}
	public Double getEmolumentAfterTaxPositiveBefore() {
		return emolumentAfterTaxPositiveBefore;
	}

	public void setEmolumentAfterTaxPositiveBefore(Double emolumentAfterTaxPositiveBefore) {
		this.emolumentAfterTaxPositiveBefore = emolumentAfterTaxPositiveBefore;
	}
	public Double getWithholdingPositiveBefore() {
		return withholdingPositiveBefore;
	}

	public void setWithholdingPositiveBefore(Double withholdingPositiveBefore) {
		this.withholdingPositiveBefore = withholdingPositiveBefore;
	}
	public Double getSocialSecurityRangePositiveBefore() {
		return socialSecurityRangePositiveBefore;
	}

	public void setSocialSecurityRangePositiveBefore(Double socialSecurityRangePositiveBefore) {
		this.socialSecurityRangePositiveBefore = socialSecurityRangePositiveBefore;
	}
	public Double getHouseFundinRangePositiveBefore() {
		return houseFundinRangePositiveBefore;
	}

	public void setHouseFundinRangePositiveBefore(Double houseFundinRangePositiveBefore) {
		this.houseFundinRangePositiveBefore = houseFundinRangePositiveBefore;
	}
	public Double getEmolumentPreTax() {
		return emolumentPreTax;
	}

	public void setEmolumentPreTax(Double emolumentPreTax) {
		this.emolumentPreTax = emolumentPreTax;
	}
	public Double getEmolumentAfterTax() {
		return emolumentAfterTax;
	}

	public void setEmolumentAfterTax(Double emolumentAfterTax) {
		this.emolumentAfterTax = emolumentAfterTax;
	}
	public Double getWithholding() {
		return withholding;
	}

	public void setWithholding(Double withholding) {
		this.withholding = withholding;
	}
	public Integer getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(Integer workingYear) {
		this.workingYear = workingYear;
	}
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getEntryDateExpected() {
		return entryDateExpected;
	}

	public void setEntryDateExpected(Date entryDateExpected) {
		this.entryDateExpected = entryDateExpected;
	}
	public String getDepartmentIdExpected() {
		return departmentIdExpected;
	}

	public void setDepartmentIdExpected(String departmentIdExpected) {
		this.departmentIdExpected = departmentIdExpected;
	}
	public String getDepartmentNameExpected() {
		return departmentNameExpected;
	}

	public void setDepartmentNameExpected(String departmentNameExpected) {
		this.departmentNameExpected = departmentNameExpected;
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
	public String getDivisionId1() {
		return divisionId1;
	}

	public void setDivisionId1(String divisionId1) {
		this.divisionId1 = divisionId1;
	}
	public String getDivisionName1() {
		return divisionName1;
	}

	public void setDivisionName1(String divisionName1) {
		this.divisionName1 = divisionName1;
	}
	public String getDivisionId2() {
		return divisionId2;
	}

	public void setDivisionId2(String divisionId2) {
		this.divisionId2 = divisionId2;
	}
	public String getDivisionName2() {
		return divisionName2;
	}

	public void setDivisionName2(String divisionName2) {
		this.divisionName2 = divisionName2;
	}
	public String getDivisionId3() {
		return divisionId3;
	}

	public void setDivisionId3(String divisionId3) {
		this.divisionId3 = divisionId3;
	}
	public String getDivisionName3() {
		return divisionName3;
	}

	public void setDivisionName3(String divisionName3) {
		this.divisionName3 = divisionName3;
	}
	public String getDivisionId4() {
		return divisionId4;
	}

	public void setDivisionId4(String divisionId4) {
		this.divisionId4 = divisionId4;
	}
	public String getDivisionName4() {
		return divisionName4;
	}

	public void setDivisionName4(String divisionName4) {
		this.divisionName4 = divisionName4;
	}
	public String getDivisionId5() {
		return divisionId5;
	}

	public void setDivisionId5(String divisionId5) {
		this.divisionId5 = divisionId5;
	}
	public String getDivisionName5() {
		return divisionName5;
	}

	public void setDivisionName5(String divisionName5) {
		this.divisionName5 = divisionName5;
	}
	public Integer getDivisionMainLevel() {
		return divisionMainLevel;
	}

	public void setDivisionMainLevel(Integer divisionMainLevel) {
		this.divisionMainLevel = divisionMainLevel;
	}
}