<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${timetable}
    <div align="center" style="color: red">
        <h3>${timetableIllegalExc}</h3>
        <h3>${timetableIoExc}</h3>
        <h3>${timetableSoapExc}</h3>
        <br>
        <hr/>
        <br>
        <p style="color: #0f0f0f">
            For more information about Belavia soap service and how to use it properly please visit
            <a href="http://86.57.245.235/TimeTable/Service.asmx" target="_blank">Service description</a>
        </p>
    </div>
</body>
</html>
