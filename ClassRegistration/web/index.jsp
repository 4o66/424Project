<%-- 
    Document   : index
    Created on : Feb 27, 2018, 7:17:43 PM
    Author     : Russ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment System</title>
    </head>
    <body>
        <form>
  <div class="container body-content">
            

    <div class="jumbotron">
        <h1>Enrollment System Login</h1>
        <p class="lead">  </p>
       
    </div>

    <div class="row">
        <div class="col-md-4">
            <h2></h2>
        </div>
    </div>
      
      <div>  </div>  <label> LoginID:</label> <br>
            <input name="logon_ID" value="" type="text" required>
    <div> </div>
    <p></p>
       <label> Password:</label> <br>
            <input name="password" value="" type="text" required>


            <br /> <br />
            <footer>
                
     <!-- Error message area Start  -->           
                  <%
        String message = (String) request.getAttribute("message");
        if (message != null) {    
        %>
        
        <p style="color:red;"><i><%= message %></i></p>
        <% } %>
     
        <!-- message area End -->          
                
                <p>2018 - CIS424 Class Application</p>
            </footer>
        </div>
    </form>
</body>
</html>
