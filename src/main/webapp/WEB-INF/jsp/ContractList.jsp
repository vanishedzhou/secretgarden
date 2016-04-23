<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Contract List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body background="/pic/mySunshineAndSunflower.jpg">

<div id="global">
<h1>Contract</h1>
<table>
<tr>
    <td><textarea rows="18" cols="60" readonly style="background:pink">${contract.content}</textarea></td>
</tr>
<tr>
    <td><a href="contract_edit/${contract.id}">Edit</a></td>
</tr>
</table>
</div>
</body>
</html>
