<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Contract Insert Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form commandName="sgContract" action="contract_save" method="post">
    <fieldset>
        <legend>insert the contract</legend>
        
        <p>
            <label for="content">content</label>
            <form:textarea id="content" path="content"/>
        </p>
        <p>
            <label for="updated_at">updated_at</label>
            <form:input id="updated_at" path="updated_at"/>
        </p>
        <p>
            <label for="updated_by">updated_by</label>
            <form:input id="updated_by" path="updated_by"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="insert contract">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
