<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<h2>Hello World!</h2> and <sp:message code="test.label"></sp:message>
	<br/>
	<sp:message code="test.message"></sp:message>
</body>
</html>
