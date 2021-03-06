<!-- Generated by Grails v1.2.1 -->



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Vct List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Vct</g:link></span>
        </div>
        <div class="body">
            <h1>Vct List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="commonName" title="Common Name" />
                        
                   	        <g:sortableColumn property="shared" title="Shared" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <th>State</th>
                   	    
                   	        <th>User</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${vctInstanceList}" status="i" var="vctInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${vctInstance.id}">${fieldValue(bean:vctInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:vctInstance, field:'commonName')}</td>
                        
                            <td>${fieldValue(bean:vctInstance, field:'shared')}</td>
                        
                            <td>${fieldValue(bean:vctInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:vctInstance, field:'state')}</td>
                        
                            <td>${fieldValue(bean:vctInstance, field:'user')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${vctInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
