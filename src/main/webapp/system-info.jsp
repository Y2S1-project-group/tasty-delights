<%--
  Created by IntelliJ IDEA.
  User: MiHi
  Date: 11/10/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System-Info</title>
</head>
<body>

<%
    // HTTP 1.1
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    // HTTP 1.0
    response.setHeader("Pragma", "no-cache");
    // Proxies
    response.setHeader("Expires", "0");
    //if (session.getAttribute("username") == null) {
    //    response.sendRedirect("./employee.jsp");
    //}

%>

<%
    String version = (String) request.getAttribute("version");
    String user1 = (String) request.getAttribute("user1");
    String user2 = (String) request.getAttribute("user2");
    String user3 = (String) request.getAttribute("user3");
    String user4 = (String) request.getAttribute("user4");

    String osName = System.getProperty("os.name");
    String osVersion = System.getProperty("os.version");
    String osArch = System.getProperty("os.arch");
    String javaVersion = System.getProperty("java.version");
    String javaVendor = System.getProperty("java.vendor");
    String javaHome = System.getProperty("java.home");
    String javaClassPath = System.getProperty("java.class.path");
    String javaLibraryPath = System.getProperty("java.library.path");
    String javaIoTmpdir = System.getProperty("java.io.tmpdir");
    String javaCompiler = System.getProperty("java.compiler");
    String javaExtDirs = System.getProperty("java.ext.dirs");
    String fileSeparator = System.getProperty("file.separator");
    String pathSeparator = System.getProperty("path.separator");
    String lineSeparator = System.getProperty("line.separator");
    String userName = System.getProperty("user.name");
    String userHome = System.getProperty("user.home");
    String userDir = System.getProperty("user.dir");
    %>
<h2>System Information</h2>

<%  out.println("Tasty Delights Version: " + version); %>

    <p>Creators:
        <br>

    <% out.println(user1); %>
        <br>

    <% out.println(user2); %>
        <br>

    <% out.println(user3); %>
        <br>

    <% out.println(user4); %>
    </p>
    <br> <br>
<h2>Server Information</h2>
<%
    out.println("OS Name: " + osName + "<br>");
    out.println("OS Version: " + osVersion + "<br>");
    out.println("OS Architecture: " + osArch + "<br>");
    out.println("Java Version: " + javaVersion + "<br>");
    out.println("Java Vendor: " + javaVendor + "<br>");
    out.println("Java Home: " + javaHome + "<br>");
    out.println("Java Class Path: " + javaClassPath + "<br>");
    out.println("Java Library Path: " + javaLibraryPath + "<br>");
    out.println("Java I/O Temp Dir: " + javaIoTmpdir + "<br>");
    out.println("Java Compiler: " + javaCompiler + "<br>");
    out.println("Java Ext. Dirs: " + javaExtDirs + "<br>");
    out.println("File Separator: " + fileSeparator + "<br>");
    out.println("Path Separator: " + pathSeparator + "<br>");
    out.println("Line Separator: " + lineSeparator + "<br>");
    out.println("User Name: " + userName + "<br>");
    out.println("User Home: " + userHome + "<br>");
    out.println("User Dir: " + userDir + "<br>");

%>
</body>
</html>
