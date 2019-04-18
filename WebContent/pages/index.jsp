<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The first JSF Demo</title>
</head>
<body>
	<f:view>
		<h:form>
			<h:messages layout="table" style="color:red"/>
			<h3>Please input your name</h3>
			<h:outputText value="#{user.errMessage}"/><p>
			name:<h:inputText value="#{user.username}" required="true"/><p>
			password:
				<h:inputSecret value="#{user.password}" required="true">
					<f:validateLength minimum="6"/>
				</h:inputSecret><p>
				
			<%-- display:<h:outputText value="#{user.username}, #{user.password}"/> --%><p>
			idCard:<h:outputText value="#{user.card.cardNumber}" /><p>
			<h:commandButton value="submit" actionListener="#{user.verify}" action="#{user.outcome}" /> <!-- 根据verify的结果导航页面 -->
		</h:form>
		
		
		命令类标签：
		命令按钮：
		<h:commandButton style="width:100px;height:100px;" value="#{user.username}" image="#{user.image}" 
		actionListener="#{user.verify}" action="#{user.outcome}"/><p>
		命令链接：
		<h:commandLink value="#{user.username}" actionListener="#{user.verify}"
		action="#{user.outcome}"/>
	</f:view>
</body>
</html>