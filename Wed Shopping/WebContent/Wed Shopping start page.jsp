<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import= "java.util.Date" %>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
   <%@ include file="menu.jsp" %>
   <%!
   String tagline = "Welcome to Web Market!";%>
   <div class="jumbotron">
      <div class="container">
         <h1 class="display-3">
       <a
			 class="iPhone X" href="https://www.apple.com/kr/iphone-xr/"
			 <h2>iPhone X</h2>
			 >
			 <img
			  src="https://static.turbosquid.com/Preview/2018/10/15__10_36_15/1mainturbocollection.jpg82425F00-3BAF-4CAE-8BF0-7B09658A42F0Default.jpg"
			  width= "1000" height= "800";
			></a>
			
            <style>h3 { color: FF0000}</style>
          
         </h1>
      </div>
   </div>
   <main role="main">
   <div class="container">
      <div class="text-center">
         <h3>
            <%=tagline%>
         </h3>
         <%
            Date day = new java.util.Date();
            String am_pm;
            int hour = day.getHours();
            int minute = day.getMinutes();
            int second = day.getSeconds();
            if (hour / 12 == 0) {
               am_pm = "AM";
            } else {
               am_pm = "PM";
               hour = hour - 12;
               String CT = hour + ":" +minute + ":" + second + " " + am_pm;
               out.println("현재 접속 시각: " + CT + "\n");
            }
         %>
      </div>
      <hr>
    </div>
   </main>
   <%@ include file="footer.jsp" %>
</body>
