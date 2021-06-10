async function refreshUsers() {
    const req = await fetch('api/users')
    const users = (await req.json()).users

    $('#usersTable').empty()

    users.forEach(user => {
        $(`<tr><td>${user.first_name}</td><td>${user.surname}</td><td>${user.age}</td></tr>`)
            .appendTo($('#usersTable'))
    })
}


$("#userForm").submit(async function (event) {
    event.preventDefault();

    const user = $('#userForm').serializeObject()
    console.log(user)

    await fetch('api/users', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })

    await refreshUsers()
});

refreshUsers()