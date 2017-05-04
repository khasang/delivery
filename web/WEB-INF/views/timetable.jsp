<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center" style="color: red">
    <h3>${timetableIllegalExc}</h3>
    <h3>${timetableIoExc}</h3>
    <h3>${timetableSoapExc}</h3>
</div>

<c:if test="${timetableIllegalExc == null}">
    <c:if test="${timetableIoExc == null}">
        <c:if test="${timetableSoapExc == null}">
            <c:if test="${timetable.size() > 0}">
                <table border="1" align="center">
                    <caption>Timetable</caption>
                    <tr>
                        <th width="110">Aircraft</th>
                        <th width="70">Flight №</th>
                        <th width="100">Airport IATA</th>
                        <th width="60">Status</th>
                        <th width="150">Actual time</th>
                        <th width="150">Expected time</th>
                        <th width="150">Scheduled time</th>
                    </tr>
                    <c:forEach items = "${timetable}" begin="0" end="${timetable.size()}" var="item">
                        <tr>
                            <td>${item.aircraft}</td>
                            <td align="center">${item.flightNumber}</td>
                            <td align="center">${item.airport}</td>
                            <td align="center">${item.status}</td>
                            <td align="center">${item.actualTime}</td>
                            <td align="center">${item.expectedTime}</td>
                            <td align="center">${item.scheduleTime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${timetable.size() == 0}">
                <h2 align="center" style="color: blue">There were no flights on this day</h2>
            </c:if>
        </c:if>
    </c:if>
</c:if>

<br>
<hr/>
<br>
<p align="center" style="color: #0f0f0f">
    For more information about Belavia soap service and how to use it properly please visit
    <a href="http://86.57.245.235/TimeTable/Service.asmx" target="_blank">Service description</a>
</p>
</body>
</html>
