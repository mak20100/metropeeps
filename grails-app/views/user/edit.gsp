

<%@ page import="com.metropeeps.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${user?.id}" />
                <g:hiddenField name="version" value="${user?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="user.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: user, field: 'email', 'errors')}">
                                    <input type="text" id="email" name="email" value="${fieldValue(bean:user,field:'email')}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="profile"><g:message code="user.profile.label" default="Profile" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: user, field: 'profile', 'errors')}">
                                    <g:select optionKey="id" optionValue="${{it.firstName + ' ' + it.lastName}}" from="${com.metropeeps.Profile.list()}" name="profile.id" value="${user?.profile?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="events"><g:message code="user.events.label" default="Events" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: user, field: 'events', 'errors')}">
                                    
<ul>
<g:each var="e" in="${user?.events?}">
    <li><g:link controller="event" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="event" params="['user.id':user?.id]" action="create">Add Event</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
