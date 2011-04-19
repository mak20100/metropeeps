
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
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'event.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="owner" title="${message(code: 'event.owner.label', default: 'Owner')}" />
                           
                            <g:sortableColumn property="title" title="${message(code: 'event.title.label', default: 'Title')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'event.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="date" title="${message(code: 'event.date.label', default: 'Date')}" />
                           
                            <g:sortableColumn property="startTime" title="${message(code: 'event.startTime.label', default: 'Start Time')}" />
                            
                            <g:sortableColumn property="endTime" title="${message(code: 'event.endTime.label', default: 'End Time')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'event.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'event.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${eventInstanceList}" status="i" var="eventInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${eventInstance.id}">${fieldValue(bean: eventInstance, field: "id")}</g:link></td>
                        
                            <td>${eventInstance?.owner?.email}</td>
                            
                            <td>${fieldValue(bean: eventInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: eventInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: eventInstance, field: "date")}</td>
                            
                            <td>${fieldValue(bean: eventInstance, field: "startTime")}</td>
                            
                            <td>${fieldValue(bean: eventInstance, field: "endTime")}</td>
                        
                            <td>${fieldValue(bean: eventInstance, field: "dateCreated")}</td>
                        
                            <td>${fieldValue(bean: eventInstance, field: "lastUpdated")}</td>
                            
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${eventInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
