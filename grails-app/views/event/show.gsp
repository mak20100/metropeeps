
<%@ page import="com.metropeeps.Event" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.id.label" default="Id" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "id")}</td>
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.owner.label" default="Owner" /></td>
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${eventInstance?.owner?.id}">${eventInstance?.owner?.email}</g:link></td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.title.label" default="Title" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "title")}</td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.description.label" default="Description" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "description")}</td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.date.label" default="Date" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "date")}</td>
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.startTime.label" default="Start Time" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "startTime")}</td>
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.startTime.label" default="End Time" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "endTime")}</td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.dateCreated.label" default="Date Created" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "dateCreated")}</td>
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="event.lastUpdated.label" default="Last Updated" /></td>
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "lastUpdated")}</td>
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${eventInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
