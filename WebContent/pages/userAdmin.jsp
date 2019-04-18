<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
login success.
<f:view>
	<h:form>
		<h:dataTable value="#{user.userList}" var="user">
			<h:column>
				<f:facet name="header">
					<h:outputText value="userName" />
				</f:facet>
				<h:outputText value="#{user.username}"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="password"/>
				</f:facet>
				<h:outputText value="#{user.password}"/>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText>操作</h:outputText>
				</f:facet>
				<h:commandLink value="删除" action="#{user.delete}">
					<f:param name="userId" value="#{user.userId}"/>
				</h:commandLink>
				<h:outputLink value="/JSFDemo/pages/editUser.faces">
					<h:outputText>修改</h:outputText>
					<f:param name="userId" value="#{user.userId}"/>
				</h:outputLink>
			</h:column>
		</h:dataTable>
		
		<h:commandButton value="exit" action="exit"/>
		
	</h:form>
	<h:outputLink value="/JSFDemo/pages/addUser.faces">
		<h:commandButton value="add" action="#{user.cleanData}"/>
	</h:outputLink>
	
</f:view>
</body>
</html>