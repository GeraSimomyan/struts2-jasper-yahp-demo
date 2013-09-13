<%@include file="include/header.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body>
	<%@include file="include/title.jsp"%>
	<div class="content">
		<s:form action="Welcome" >

			<div>
				<s:textfield name="firstname" label="First Name" />
			</div>
			<div>
				<s:textfield name="lastname" label="Last Name" />
			</div>
			<div>
				<s:textfield name="scheduleAppointment" label="Schedule Appointment" />
			</div>
			<div>
				<s:textfield name="doctor" label="Doctor" />
			</div>
			<div>
				<s:textarea name="comments" label="Comments" cssClass="textArea"/>
			</div>
			
			<s:submit cssClass="button white"/>
			
		</s:form>
	</div>
</body>
</html>