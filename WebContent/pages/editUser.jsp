<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
			username:<h:inputText value="#{user.username}"/>
			password:<h:inputText value="#{user.password}"/>
			<h:commandButton value="save" action="#{user.updateUser}"/>
		</h:form>
	</f:view>
</body>
</html>