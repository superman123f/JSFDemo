<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标准转换器</title>
</head>
<body>
	<f:view>
		欢迎，<h:outputText value="#{user.name}" style="color:red;"/> &nbsp;&nbsp;用户
		<b>
			日期格式：
			<h:outputText value="#{user.createTime}">
				<f:convertDateTime pattern="dd/MM/yyyy"/>
			</h:outputText>
		</b>
		<h:form>
			<h:inputText id="dateField" value="#{user.createTime}">
				<f:convertDateTime pattern="dd/MM/yyyy"/>
			</h:inputText>
			<h:message for="dateField" style="color:red"/>
			<br>
			<h:commandButton value="sumbit" action="show"/>
		</h:form>
	</f:view>
</body>
</html>