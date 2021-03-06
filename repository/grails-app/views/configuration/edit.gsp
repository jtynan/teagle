<!-- Generated by Grails v1.2.1 -->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Configuration</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Configuration List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Configuration</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Configuration</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${configurationInstance}">
            <div class="errors">
                <g:renderErrors bean="${configurationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${configurationInstance?.id}" />
                <input type="hidden" name="version" value="${configurationInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="commonName">Common Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:configurationInstance,field:'commonName','errors')}">
                                    <input type="text" id="commonName" name="commonName" value="${fieldValue(bean:configurationInstance,field:'commonName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="configurationParamComposite">Configuration Param Composite:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:configurationInstance,field:'configurationParamComposite','errors')}">
                                    <g:select name="configurationParamComposite"
from="${ConfigParamComposite.list()}"
size="5" multiple="yes" optionKey="id"
value="${configurationInstance?.configurationParamComposite}" />

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:configurationInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:configurationInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="configurationBases">Configuration Bases:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:configurationInstance,field:'configurationBases','errors')}">
                                    <g:select name="configurationBases"
from="${ConfigurationBase.list()}"
size="5" multiple="yes" optionKey="id" optionValue="commonName"
value="${configurationInstance?.configurationBases}" />

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
