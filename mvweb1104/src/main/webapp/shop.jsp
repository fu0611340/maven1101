<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
</head>
<script src="js/jquery3.6.0.js"></script>
<body bgcolor="white">
	<form><BR>
	Please enter item to add or remove: <br>
		Add Item: <SELECT id="item">
			<OPTION>Beavis & Butt-head Video collection
			<OPTION>X-files movie
			<OPTION>Twin peaks tapes
			<OPTION>NIN CD
			<OPTION>JSP Book
			<OPTION>Concert tickets
			<OPTION>Love life
			<OPTION>Switch blade
			<OPTION>Rex, Rugs & Rock n' Roll
		</SELECT><br><br>
		<INPUT TYPE="submit" id="s1" value="add">
		<INPUT TYPE="submit" id="s2" value="remove">
	</form>
	<br>
	<div id="dis"><br>
	You have the following items in your cart:
	</div>
	<script>
		function display(data) {
			$("#dis").html(data);
		}
		function sendAdd(evt) {
			evt.preventDefault();
			var data = {"item": $("#item").val(), "submit": "add"};
			$.post("carts.jsp", data, display);
		}
		function sendRemove(evt) {
			evt.preventDefault();
			var data = {"item": $("#item").val(), "submit": "remove"};
			$.post("carts.jsp", data, display);
		}
		function start() {
			$("#s1").click(sendAdd);
			$("#s2").click(sendRemove)
		}
		$(document).ready(start);
	</script>
</body>
</html>
