<%@page import="de.app.pd.entities.pv.Tagesertrag"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>start Fileupload</title>
</head>
<body>
	<form:form modelAttribute="fileUploadHandler" enctype="multipart/form-data">
		Select file: 
		<input type="file" name="file" />
		<input type="submit" name="_eventId_upload" value="Upload" />
	</form:form>
</body>
</html>