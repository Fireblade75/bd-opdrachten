<html>
<head>
    <title>User Manager</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>User Manager</h2>

<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Surname</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody id="usersTable">

    </tbody>
</table>

<hr>

<form id="userForm">
    <div class="input-div">
        <label for="first_name">First name</label>
            <input type="text" id="first_name" required name="first_name">
    </div>
    <div class="input-div">
        <label for="surname">Surname</label>
            <input type="text" required name="surname" id="surname">
    </div>
    <div class="input-div">
        <label for="age">Age</label>

            <input type="number" required name="age" id="age">
    </div>
    <button type="submit">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js" integrity="sha512-Gn0tSSjkIGAkaZQWjx3Ctl/0dVJuTmjW/f9QyB302kFjU4uTNP4HtA32U2qXs/TRlEsK5CoEqMEMs7LnzLOBsA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="userscript.js" lang="javascript"></script>
</body>
</html>
