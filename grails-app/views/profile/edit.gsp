

<%@ page import="com.metropeeps.Profile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'profile.label', default: 'Profile')}" />
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
            <g:hasErrors bean="${profileInstance}">
            <div class="errors">
                <g:renderErrors bean="${profileInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${profileInstance?.id}" />
                <g:hiddenField name="version" value="${profileInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="firstName"><g:message code="profile.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: profileInstance, field: 'firstName', 'errors')}">
                                    <input type="text" id="firstName" name="firstName" value="${fieldValue(bean:profileInstance,field:'firstName')}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastName"><g:message code="profile.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: profileInstance, field: 'lastName', 'errors')}">
                                    <input type="text" id="lastName" name="lastName" value="${fieldValue(bean:profileInstance,field:'lastName')}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nickName"><g:message code="profile.nickName.label" default="Nick Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: profileInstance, field: 'nickName', 'errors')}">
                                    <input type="text" id="nickName" name="nickName" value="${fieldValue(bean:profileInstance,field:'nickName')}"/>
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
