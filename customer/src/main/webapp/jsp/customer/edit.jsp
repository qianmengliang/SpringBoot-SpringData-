﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>

	<script >
        $(function () {
            if (window.top!=window.self) {
                alert("这个窗口不是最顶层窗口!我在一个框架")
			}else {
                alert("这个窗口是最顶层窗口!")
			}
            var cust_id = location.search.split("=")[1];
            $.post("${pageContext.request.contextPath}/customer/findOne.do",{cust_id:cust_id},function (data) {
				$("#hidden").val(cust_id);
                $("#sChannel1").val(data.cust_name);
				$("#sChannel2").val(data.cust_level);
				$("#sChannel3").val(data.cust_Source);
				$("#sChannel4").val(data.cust_linkman);
				$("#sChannel5").val(data.cust_phone);
				$("#sChannel6").val(data.cust_mobile);
            },"json")

        })


	</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer/update.do"
		method=post>
		<input type="hidden" name="custId" value="${customer.custId }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<input type="hidden" id="hidden" name="cust_id">
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel1
											style="WIDTH: 180px" maxLength=50 name="cust_name" >
								</td>
								<td>客户级别 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_level" >
								</td>
							</TR>
							
							<TR>
								<td>信息来源：</td>
								<td>
								<INPUT class=textbox id=sChannel3
														style="WIDTH: 180px" maxLength=50 name="cust_source" >
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel4
														style="WIDTH: 180px" maxLength=50 name="cust_linkman" >
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel5
														style="WIDTH: 180px" maxLength=50 name="cust_phone" >
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel6
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" >
								</td>
							</TR>
							

							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
