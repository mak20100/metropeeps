
<%@ page import="com.metropeeps.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}" />
                            
                            <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
                        
                            <th><g:message code="user.profile.label" default="Profile" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'user.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'user.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userList}" status="i" var="user">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${user.id}">${fieldValue(bean: user, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: user, field: "email")}</td>
                        
                            <td>${fieldValue(bean: user, field: "password")}</td>
                        
                            <td>${user?.profile?.firstName} ${user?.profile?.lastName}</td>
                        
                            <td>${fieldValue(bean: user, field: "dateCreated")}</td>
                        
                            <td>${fieldValue(bean: user, field: "lastUpdated")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userTotal}" />
            </div>
        </div>
    </body>
</html>
