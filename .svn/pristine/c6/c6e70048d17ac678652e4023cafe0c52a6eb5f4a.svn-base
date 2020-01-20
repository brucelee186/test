<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr>
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="个人资料" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">照片：</th>
					<td style="width:300px;text-align: left;"><img id="image_personalPhoto" src="<c:if test="${userDetail.attachPersonalPhotoPath != null}">${pageContext.request.contextPath}/${userDetail.attachPersonalPhotoPath}</c:if>" width="116" height="116" /></td>
					<th style="width:150px;text-align: left;"></th>
					<td style="width:300px;text-align: left;"></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_personalPhoto" name="attachPersonalPhoto" value="${userDetail.attachPersonalPhoto}" type="hidden" ><input id="file_personalPhoto" name="listFile[0]" onchange="uploadImage('personalPhoto', 0);" type="file" ></input></td>
					<th style="width:150px;text-align: left;"></th>
					<td style="width:300px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">中文姓：</th>
					<td style="width:300px;text-align: left;"><input name="lastName" value="${userDetail.lastName}" data-options="required: true,validType:'length[1,15]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>中文名：</th>
					<td><input name="firstName" value="${userDetail.firstName}" data-options="required: true,validType:'length[1,15]'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">英文姓：</th>
					<td style="width:300px;text-align: left;"><input name="lastNameEn" value="${userDetail.lastNameEn}" data-options="required: false,validType:'length[1,15]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>英文名：</th>
					<td><input name="firstNameEn" value="${userDetail.firstNameEn}" data-options="required: false,validType:'length[1,15]'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">中文全名：</th>
					<td style="width:300px;text-align: left;"><input name="chineseName" value="${userDetail.chineseName}" data-options="editable:false" style="width: 280px;" class="easyui-textbox" /></td>
					<th style="width:150px;text-align: left;">英文全名：</th>
					<td style="width:300px;text-align: left;"><input name="englishName" value="${userDetail.englishName}" data-options="editable:false" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th>出生日期：</th>
					<td><input id="birthDate" name="birthDate" value="${userDetail.birthDate}" style="width: 280px;" class="easyui-datebox" data-options="required: true, editable:false"/></td>
					<th style="width:150px;text-align: left;">性别：</th>
					<td style="width:300px;text-align: left;"><input type="radio" name="gender" <c:if test="${userDetail.gender == null }">checked="checked"</c:if><c:if test="${userDetail.gender == 'm'}">checked="checked"</c:if> value="m" >男</input> <input type="radio" name="gender" <c:if test="${userDetail.gender == 'f'}">checked="checked"</c:if> value="f">女</input></td>
				</tr>
				<tr style="">
					<th>民族：</th>
					<td><select name="ethnicGroup" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.ethnicGroup}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=m'"></select></td>
					<th>婚姻状况：</th>
					<td><input type="radio" name="maritalStatus" <c:if test="${userDetail.maritalStatus == null }">checked="checked"</c:if><c:if test="${userDetail.maritalStatus == 'n'}">checked="checked"</c:if> value="n">未婚</input> <input name="maritalStatus" <c:if test="${userDetail.maritalStatus == 'y'}">checked="checked"</c:if> value="y" type="radio" >已婚</input><input name="maritalStatus" <c:if test="${userDetail.maritalStatus == 'o'}">checked="checked"</c:if> type="radio" value="o" >离异</input></td>
				</tr>
				<tr style="">
					<th>宗教信仰：</th>
					<td><input name="religion" value="${userDetail.religion}" data-options="required: false" style="width: 280px;" class="easyui-textbox" /></td>
					<th>政治身份：</th>
					<td><select name="politicalIdentity" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.politicalIdentity}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=zz'"></select></td>
				</tr>
				<tr style="">
					<th>宅电或移动电话：</th>
					<td><input name="phoneNo" value="${userDetail.phoneNo}" data-options="required: true, validType: 'phone'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>浦发银行卡号：</th>
					<td><input name="bankCard" value="${userDetail.bankCard}" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th>证件类型：</th>
					<td><select name="idNoType" class="easyui-combobox" style="width:280px;" data-options="value:'${userDetail.idNoType}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=zjlx'"></select></td>
					<th>个人电子邮件：</th>
					<td><input name="emailPersonal" value="${userDetail.emailPersonal}" data-options="validType: 'email'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th>证件号：</th>
					<td><input name="idNo" value="${userDetail.idNo}" style="width: 280px;" class="easyui-textbox" /></td>
					<c:if test="${userDetail.statusInit == 'a'}">
						<th>是否提供证明：</th>
						<td><input type="radio" name="idNoAccess" checked="checked" >是</input> <input type="radio" name="idNoAccess" >否</input></td>
					</c:if>
				</tr>
				<tr style="">
					<th>证件附件：</th>
					<td><input id="fileName_attachIdNo" value="${userDetail.attachIdNoFileName}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachIdNo" name="attachIdNo" type="hidden" /><input id="file_attachIdNo" name="listFile[1]" type="file" onchange="uploadFile('attachIdNo', 1);"  ></input></td>
				</tr>
				<tr style="">
					<th>现住址：</th>
					<td><input name="addressAvailable" value="${userDetail.addressAvailable}" style="width: 280px;" class="easyui-textbox" /></td>
					<th>户口所在地：</th>
					<td><input name="resgisteredResidence" value="${userDetail.resgisteredResidence}" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<th>工作经验(年)：</th>
					<td><input name="workingYear" value="${userDetail.workingYear}" data-options="validType:'length[1,2]'" style="width: 280px;" class="easyui-numberbox" data-options="" /></td>
				</tr>				
			</table>
		</div>
	</td>
</tr>