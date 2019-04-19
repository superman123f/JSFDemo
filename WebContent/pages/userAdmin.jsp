<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<%@ taglib uri="http://www.qiujy.com/pager" prefix="q"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<style>
	.orders {
	  border: thin solid black;
	}
	
	.ordersHeader {
      width: 200px;
	  text-align: center;
	  //font-style: italic;
	  color: Snow;
	  background: Teal;
	}
	
	.evenColumn {
	  height: 25px;
	  text-align: center;
	  background: MediumTurquoise;
	}
	
	.oddColumn {
	  text-align: center;
	  background: PowderBlue;
	}
</style>
<body>
<f:view>
	<div style="margin:10px 0px;">
   		<h:outputText value="UserAdmin Page" style="font-size:19px"/>
   	</div>
	<h:form>
		<h:dataTable  value="#{user.userList}" var="userInfo"
	 		styleClass="orders"
	        headerClass="ordersHeader"
	        rowClasses="evenColumn,oddColumn">

			<h:column>
				<f:facet name="header">
					<h:outputText value="userName" />
				</f:facet>
				<h:outputText value="#{userInfo.username}"/>
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="password"/>
				</f:facet>
				<h:outputText value="#{userInfo.password}"/>
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="createTime"/>
				</f:facet>
				<h:outputText value="#{userInfo.createTime}">
					<f:convertDateTime pattern="yyyy/MM/dd hh:mm:ss"/>
				</h:outputText>
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText>操作</h:outputText>
				</f:facet>
				
				<h:commandLink value="删除" action="#{user.deleteUser}">
					<f:param name="userId" value="#{userInfo.userId}"/>
				</h:commandLink> &nbsp;
				
				<h:commandLink action="#{user.findUserByUserId}">
				   <h:outputText value="修改"/>
				   <f:param name="userId" value="#{userInfo.userId}"/>
				</h:commandLink>
				
			</h:column>
		</h:dataTable>
		
		<h:commandButton value="add" action="#{user.cleanData}"/>
		<h:commandButton value="exit" action="#{user.exit}"/>
		<q:pager id="myPager" for="dt" showPages="5"
					currPageClass="currPage" pageIndexClass="pagerPage" />
		
	</h:form>
	
</f:view>
</body>
</html>