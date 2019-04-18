<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user's login page</title>
</head>
<body>
	<f:view>
		<h:form>
		    <h:outputText value="#{user.errMessage}" style="color:red;"/>
			name:<h:inputText value="#{user.username}" required="true"/><p>
			password：<h:inputSecret value="#{user.password}"/><p>
			
			<h:commandButton value="submit" actionListener="#{user.login}" action="#{user.outcome}" />
		</h:form>
		<%-- <h:commandButton value="login" actionListener="#{user.login}" action="#{user.outcome}"/>
	
		<h:commandButton style="width:100px;height:100px;" value="#{user.username}" image="#{user.image}" 
		actionListener="#{user.verify}" action="#{user.outcome}"/><p> --%>
	</f:view>
</body>
</html> 	