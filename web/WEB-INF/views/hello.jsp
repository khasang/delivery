<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<form action="/examples/jsp/forms/process.jsp" method=post>
    <center>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>РЕГИСТРАЦИЯ КЛИЕНТА</font>
                <font size=1>* Обязательные поля</font>
            </th>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Имя

                    <input type="text" name="firstName" value="" size=15 maxlength=20></td>
                <td  valign=top>
                    Фамилия

                    <input type="text" name="lastName" value="" size=15 maxlength=20></td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    E-Mail

                    <input type="text" name="email" value="" size=25  maxlength=125>
                </td>
                <td  valign=top>
                    Телефон*

                    <input type="text" name="phone" value="" size=15  maxlength=20></td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Адрес доставки*

                    <input type="text" name="address" size=50 value=""  maxlength=50>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td  valign=top colspan=2>
                    Хотите получать на почту сообщения о наших акциях?

                    <input type="radio" name="notify" value="Да" checked>Yes

                    <input type="radio" name="notify" value="Нет" > No
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td  align=center colspan=2>
                    <input type="submit" value="Подтвердить"> <input type="reset"
                                                                     value="Сброс">
                </td>
            </tr>

        </table>
    </center>
</form>
</body>
</html>
