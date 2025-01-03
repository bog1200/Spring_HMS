let username = null;
let stompClient = null;

function connect() {
    const socket = new SockJS('/appointments/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        console.log(`Connected to WebSocket as ${username}`);
        // Subscribe to personalized notifications
        stompClient.subscribe(`/topic/${username}`, function (message) {
            const notification = JSON.parse(message.body);
            displayNotification(notification);
        });
    });
}

function displayNotification(notification) {
    const notificationsList = document.getElementById('notificationsList');
    const notificationItem = document.createElement('li');
    notificationItem.textContent = JSON.stringify(notification);
    notificationsList.appendChild(notificationItem);
}

// Event listener for the "Connect" button
document.getElementById('connectButton').addEventListener('click', function () {
    username = document.getElementById('usernameInput').value.trim();
    if (username) {
        document.getElementById('loginForm').style.display = 'none';
        document.getElementById('notificationArea').style.display = 'block';
        connect(); // Establish WebSocket connection
    } else {
        alert("Please enter a username to connect.");
    }
});
