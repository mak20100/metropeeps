<%@ page contentType="text/html;charset=ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>MetroPeeps</title>
</head>
<body>
	<div id="pageBody">
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<div class="list" align="center">
			<table style="width: 600px">
	            <thead>
	                <tr>
	                    <g:sortableColumn property="title" title="${message(code: 'event.title.label', default: 'Title')}" />
	                    <g:sortableColumn property="description" title="${message(code: 'event.description.label', default: 'Description')}" />
	                    <g:sortableColumn property="date" title="${message(code: 'event.date.label', default: 'Date')}" />
	                    <g:sortableColumn property="startTime" title="${message(code: 'event.startTime.label', default: 'Start-Time')}" />
	                    <g:sortableColumn property="endTime" title="${message(code: 'event.endTime.label', default: 'End-Time')}" />
	                </tr>
	            </thead>
	            <tbody>
	            <g:each in="${events}" status="i" var="e">
	                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                    <td><g:link controller="event" action="show" id="${e.id}">${fieldValue(bean: e, field: "title")}</g:link></td>
	                    <td>${fieldValue(bean: e, field: "description")}</td>
	                    <td>${fieldValue(bean: e, field: "date")}</td>
	                    <td>${fieldValue(bean: e, field: "startTime")}</td>
	                    <td>${fieldValue(bean: e, field: "endTime")}</td>
	                </tr>
	            </g:each>
	            </tbody>
	        </table>
		</div>
	</div>
</body>
</html>