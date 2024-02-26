
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="/dictionary" method="post" class="form">
        <div class="word element">
            <label>English: </label>
            <input type="text" name="engWord" value="${engWord}">
        </div>
        <div class="submit element">
            <button type="submit" class="btn">Translate</button>
        </div>
        <div class="result element">
            <label>Vietnamese: </label>
            <span>${vnWord}</span>
        </div>
    </form>
</body>
</html>
