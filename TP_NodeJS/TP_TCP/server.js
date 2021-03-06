/** Script to create a Server for a Chat
  */

// Imports
var net = require("net");
var colors = require("colors");
var Client = require("./client.class.js");
var Logger = require("./Logger.class.js");
var logger = new Logger();
logger.setFile("Chat.log");

// Arguments
var port = +process.argv[2] || 1234;

// Variables
var clients = [];

// Create a Server
var server = net.createServer(function(connection) { //'connection' listener    
    connection.setEncoding("utf8");

    // Create new Client
    var cl = new Client();
    cl.setConnection(connection);
    clients.push(cl);    

    connection.write(colors.cyan("Connecté au serveur\n"));
    connection.write(colors.cyan('Bienvenue sur le chat. Changer votre nom avec "/name <nom>". Quitter avec "/exit"\n'));
    sendToAllExceptEmitter(connection, colors.cyan(getClientName(getClientByConnection(connection)) + " est arrivé sur le chat\n"));
    logger.logMessage("New client on the chat : " + getClientName(getClientByConnection(connection)));

    connection.on("data", function(data) {
        onDataFromClient(connection, data);
    });

    connection.on("end", function() {
        onEndClient(connection);
    });
});
server.listen(port, function() { //'listening' listener
});

// Function to perform action when a client sends data
function onDataFromClient(fromConnection, data) {
    if (data.substr(0, 6) == '/name ') {
        var clName = data.substr(6, (data.length - 6 - 1));
        sendToAllExceptEmitter(fromConnection, colors.cyan(getClientName(getClientByConnection(fromConnection)) + " est renommé en " + clName + "\n"));
        logger.logMessage(getClientName(getClientByConnection(fromConnection)) + " est renommé en " + clName);
        getClientByConnection(fromConnection).setName(clName);
    } else {
        sendToAllExceptEmitter(fromConnection, colors.grey(getClientName(getClientByConnection(fromConnection)) + " : "));
        sendToAllExceptEmitter(fromConnection, colors.yellow(data));
        logger.logMessage(getClientName(getClientByConnection(fromConnection)) + " : " + data.substr(0, data.length - 1));
    }
};

function sendToAllExceptEmitter(connectionEmitter, message) {
    clients.forEach(function(client) {
        var clConnection = client.getConnection();
        if (clConnection != connectionEmitter) {
            client.getConnection().write(message);
        }
    });
}

// Function to perfom action when a client ends
function onEndClient(fromConnection) {
    var posToDelete = -1;
    var clConnection = getClientByConnection(fromConnection);
    var clName = getClientName(clConnection);
    for (var i = 0; i < clients.length; i++) {
        if (clients[i] == clConnection) {
            posToDelete = i;
            break;
        }
    }
    if (posToDelete > -1) {
        clients.splice(posToDelete, 1);
    }
    sendToAllExceptEmitter(fromConnection, colors.cyan(clName + " a quitté le chat\n"));
    logger.logMessage(clName + " a quitté le chat");
};

// Search for a client by its connection
function getClientByConnection(connection) {
    var theclient = undefined;
    for (var i = 0; i < clients.length; i++) {
        if (clients[i].getConnection() == connection) {
            theclient = clients[i];
        }
    }
    return theclient;
}

// Return the name for a client (or ip:port if name is undefined)
function getClientName(client) {
    var name = "";
    if (client.getName() == undefined) {
        name = client.getConnection().remoteAddress + ":" + client.getConnection().remotePort;
    } else {
        name = client.getName();
    }
    return name;
};

