

<%@ page import="com.metropeeps.Event" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${event}">
            <div class="errors">
                <g:renderErrors bean="${event}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="owner"><g:message code="event.owner.label" default="Owner" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: event, field: 'owner', 'errors')}">
                                    <g:select from="${com.metropeeps.User.list()}" optionKey="id" optionValue="${{it.email}}"  name="owner.id" value="${event?.owner?.id}" ></g:select>
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="event.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: event, field: 'title', 'errors')}">
                                    <input type="text" maxlength="80" id="title" name="title" value="${fieldValue(bean:event,field:'title')}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="event.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: event, field: 'description', 'errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:event,field:'description')}"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="start"><g:message code="event.start.label" default="Start" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: event, field: 'start', 'errors')}">
                                    <joda:dateTimePicker name="start" value="${event?.start}" />
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="end"><g:message code="event.end.label" default="End" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: event, field: 'end', 'errors')}">
                                    <joda:dateTimePicker name="end" value="${event?.end}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
