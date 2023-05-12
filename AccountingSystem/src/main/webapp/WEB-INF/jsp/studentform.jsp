<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Student</h1>
       <form:form method="post" action="savestudent">  
      	<table >  
         <tr>  
          <td>First_Name: </td> 
          <td><form:input path="first_name"  /></td>
         </tr>  
         <tr>  
          <td>Last_Name:</td>  
          <td><form:input path="last_name" /></td>
         </tr> 
         <tr>  
          <td>Email:</td>  
          <td><form:input path="email" /></td>
         </tr> 
          <tr>  
          <td>Address:</td>  
          <td><form:input path="address" /></td>
         </tr> 
           <tr>  
          <td>City:</td>  
          <td><form:input path="city" /></td>
         </tr>
           <tr>  
          <td>State:</td>  
          <td><form:input path="state" /></td>
         </tr>
           <tr>  
          <td>Phone_Number:</td>  
          <td><form:input path="phone_number" /></td>
         </tr>
       <tr>
    <td>Course:</td>
    <td>
        <form:select path="course_id">
            <form:option value="" label="--- Select Course ---"/>
            <form:options items="${courses}" itemValue="course_id" itemLabel="name"/>
        </form:select>
    </td>
</tr>
		<tr>

<td><form:input type="hidden" path="payment_status" value="false" /></td>
</tr>

		<tr>
            <td>Branch:</td>
            <td>
                <form:select path="branch_id">
                    <form:option value="" label="--- Select Branch ---"/>
                    <form:options items="${branches}" itemValue="branch_id" itemLabel="branch_name"/>
                </form:select>
            </td>
        </tr>
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save Student" /></td>  
         </tr>  
        </table>  
       </form:form>  
