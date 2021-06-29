<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome To Spring MVCS</title>
</head>
<body>
<%! int cube(int n){
   return n * n *n;
}%>

<%! String firstName ="abc"; %>

<h1>First JSP Page 2323</h1>
<%= 5 * 8%>
<%= new String("Hello World").toUpperCase()%>
<%= "Cube of 3 is :"+cube(3)%>
<%= firstName%>

<h3>Port of server : <%= request.getLocalPort()%></h3>
<h3>Url Context : <%= application.getContextPath()%></h3>
</body>
</html>