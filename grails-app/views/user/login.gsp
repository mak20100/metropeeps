<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
		<title>MetroPeeps Login</title>
	</head>
	<body>
		<g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <g:form controller="user" action="login" >
        	<table style="width:400px">
        		<tr class="props">
        			<td class="name">
        				<label for="email">Email</label>
        			</td>
        			<td class="value">
        				<input type="text" id="email" name="email" value="admin@metropeeps.com" size="60"/>
        			</td>
        		</tr>
        		<tr class="props">
        			<td class="name">
        				<label for="password">Password</label>
        			</td>
        			<td class="value">
        				<input type="password" id="password" name="password" value="hotspots" size="60"/>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2" style="text-align: right;">
        				<input type="submit" value="Login" />
        			</td>
        		</tr>
        	</table>
        </g:form>
	</body>
</html>