<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<script type="text/javascript">
    function validate() {
        var quadratic = document.forms['form']['quadratic'].value;

        if (quadratic == '' || quadratic == '0') {
            alert("Toto není kvadraticá rovnice!")
            return false;
        }
    }
</script>
<body>
<h1 style="text-align: center">Kvadratická rovnice</h1>
<hr>
<form name="form" action="action.php" method="post" style="text-align: center"
      onsubmit="return validate()">
	<label>Zadej kvadratický člen:</label>
	<input name="quadratic" style="margin-top: 10px" type="text"
	       placeholder="Zadej kvadratický člen..."><br>
	<label>Zadej lineární člen:</label>
	<input name="linear" style="margin-top: 10px" type="text"
	       placeholder="Zadej lineární člen..."><br>
	<label>Zadej absolutní člen:</label>
	<input name="absolute" style="margin-top: 10px" type="text"
	       placeholder="Zadej absolutní člen..."><br>
	<input style="margin-top: 10px" type="submit" value="Vypočítat">
</form>
</body>
</html>
