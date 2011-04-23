
<%@ page import="com.metropeeps.Profile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'profile.label', default: 'Profile')}" />
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
                            <g:sortableColumn property="id" title="${message(code: 'profile.id.label', default: 'Id')}" />
                            <g:sortableColumn property="firstName" title="${message(code: 'profile.firstName.label', default: 'First Name')}" />
                            <g:sortableColumn property="lastName" title="${message(code: 'profile.lastName.label', default: 'Last Name')}" />
                            <g:sortableColumn property="nickName" title="${message(code: 'profile.nickName.label', default: 'Nick Name')}" />
                            <g:sortableColumn property="dateCreated" title="${message(code: 'profile.dateCreated.label', default: 'Date Created')}" />
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'profile.lastUpdated.label', default: 'Last Updated')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${profileList}" status="i" var="profile">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:link action="show" id="${profile.id}">${fieldValue(bean: profile, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: profile, field: "firstName")}</td>
                            <td>${fieldValue(bean: profile, field: "lastName")}</td>
                            <td>${fieldValue(bean: profile, field: "nickName")}</td>
                            <td>${fieldValue(bean: profile, field: "dateCreated")}</td>
                            <td>${fieldValue(bean: profile, field: "lastUpdated")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${profileTotal}" />
            </div>
        </div>
    </body>
</html>
