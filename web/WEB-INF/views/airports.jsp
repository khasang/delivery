<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div align="center" style="color: red">
        <h3>${airportIllegalExc}</h3>
        <h3>${airportIoExc}</h3>
        <h3>${airportSoapExc}</h3>
    </div>

    <c:if test="${airportIllegalExc == null}">
        <c:if test="${airportIoExc == null}">
            <c:if test="${airportSoapExc == null}">
                <table border="1" align="center">
                    <caption>Airports</caption>
                    <tr>
                        <th width="200">Airport IATA code</th>
                        <th width="200">Name of airport</th>
                    </tr>
                    <c:forEach items = "${airports}" begin="0" end="${airports.size()}" var="item">
                        <tr>
                            <td>${item.IATA}</td>
                            <td>${item.name}</td>
                        </tr>
                    </c:forEach>
                </table>
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
