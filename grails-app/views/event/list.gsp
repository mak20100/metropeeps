
<%@ page import="com.metropeeps.Event" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:form method="post">
	            <div class="list">
	            	User to register events to: <g:select from="${com.metropeeps.User.list()}" optionKey="id" optionValue="${{it.email}}"  name="user.id" value="${{it.id}}" ></g:select>
	                <table>
	                    <thead>
	                        <tr>
	                        	<th class="sortable">Register</th>
	                            <g:sortableColumn property="id" title="${message(code: 'event.id.label', default: 'Id')}" />
	                            <g:sortableColumn property="owner" title="${message(code: 'event.owner.label', default: 'Owner')}" />
	                            <g:sortableColumn property="title" title="${message(code: 'event.title.label', default: 'Title')}" />
	                            <g:sortableColumn property="description" title="${message(code: 'event.description.label', default: 'Description')}" />
	                            <g:sortableColumn property="start" title="${message(code: 'event.start.label', default: 'Start')}" />
	                            <g:sortableColumn property="end" title="${message(code: 'event.end.label', default: 'End')}" />
	                            <g:sortableColumn property="dateCreated" title="${message(code: 'event.dateCreated.label', default: 'Date Created')}" />
	                            <g:sortableColumn property="lastUpdated" title="${message(code: 'event.lastUpdated.label', default: 'Last Updated')}" />
	                        </tr>
	                    </thead>
	                    <tbody>
	                    
	                    <g:each in="${eventList}" status="i" var="event">
	                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                        	<td><g:checkBox name="register" value="${event.id}" checked="false"/></td>
	                            <td><g:link action="show" id="${event.id}">${fieldValue(bean: event, field: "id")}</g:link></td>
	                            <td>${event?.owner?.profile?.firstName} ${event?.owner?.profile?.lastName}</td>
	                            <td>${fieldValue(bean: event, field: "title")}</td>
	                            <td>${fieldValue(bean: event, field: "description")}</td>
	                            <td>${fieldValue(bean: event, field: "start")}</td>
	                            <td>${fieldValue(bean: event, field: "end")}</td>
	                            <td>${fieldValue(bean: event, field: "dateCreated")}</td>
	                            <td>${fieldValue(bean: event, field: "lastUpdated")}</td>
	                        </tr>
	                    </g:each>
	                    </tbody>
	                </table>
	            </div>
	            
	            <div class="paginateButtons">
	                <g:paginate total="${eventTotal}" />
	            </div>
	            <div class="buttons">
	            	<span class="button"><g:actionSubmit class="save" action="register" value="${message(code: 'default.button.register.label', default: 'Register')}" /></span>
	            	<span class="button"><g:actionSubmit class="delete" action="unregister" value="${message(code: 'default.button.unregister.label', default: 'UnRegister')}" /></span>
	            </div>
	        </g:form>
        </div>
    </body>
</html>
