<%@include file="include/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<body>
	<%@include file="include/title.jsp"%>
	<div class="content">
		<s:set name="theme" value="'simple'" scope="page" />
	<%-- 	<s:form action="/" theme="simple"> --%>
			<%-- <table>
				<tbody>
					<tr>
						<td width="40%"><s:hidden name="firstname" value="firstname"
								theme="simple" /></td>
						<td width="40%"><s:hidden name="lastname" value="lastname" /></td>
						<td width="40%"><s:hidden name="scheduleAppointment"
								value="scheduleAppointment" /></td>
						<td width="40%"><s:hidden name="doctor" value="doctor" /></td>
						<td width="40%"><s:hidden name="comments" value="comments" /></td>
					</tr>
				</tbody>
			</table> --%>
			<div class="form-element">
				<table width="85%" style="margin-left:20%">
					<tr>
						<td width="40%"><b>First Name : </b></td>
						<td width="60%"> <s:property value="firstname" /></td>
					</tr>
				</table>
			</div>
			<div class="form-element">
			<table width="85%" style="margin-left:20%">
					<tr>
						<td width="40%"><b>Last Name : </b> </td>
						<td width="60%"><s:property value="lastname" /></td>
					</tr>
				</table>
				
			</div>

			<div class="form-element">
			<table width="85%" style="margin-left:20%">
					<tr>
						<td width="40%"><b>Schedule Appointment : </b> </td>
						<td width="60%"> <s:property
						value="scheduleAppointment" /></td>
					</tr>
				</table>
				
			</div>

			<div class="form-element">
				<table width="85%" style="margin-left:20%">
					<tr>
						<td width="40%"><b>Doctor : </b>  </td>
						<td width="60%"><s:property value="doctor" /></td>
					</tr>
				</table>
				
			</div>

			<div class="form-element">
			<table width="85%" style="margin-left:20%">
					<tr>
						<td width="40%"><b>Comments : </b> </td>
						<td width="60%"> <s:property value="comments" /></td>
					</tr>
				</table>
				
			</div>
			
	<%-- 	</s:form> --%>
		
		<div style="margin:5%;">
				<button id="back" class="button white" type="submit" value="Back">Back</button>
				<span class="button white" id="pdfDownload">PDF Download</span> 
				<span class="button white" id="print">Print</span>
				<span class="button white" id="documentDownload">document Download</span>
			</div>


		<div></div>
	</div>

</body>
</html>