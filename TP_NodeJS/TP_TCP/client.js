/** Script to create a Client for a Chat
  */

// Imports
var net = require("net");
var colors = require("colors");

// Arguments of program
var port = +process.argv[2] || 1234;
var ip = "127.0.0.1";// christophe"10.0.10.37";

// Create socket
var socket = net.connect(port, ip, function(){
});
socket.setEncoding('utf8');

// Read data from socket
socket.on("data", function(data) {
    process.stdout.write(data);
});

// Read data from console
process.stdin.on("data", function(data) {
    if (data.toString().substr(0, 5) == "/exit") {
        socket.end();
        socket.destroy();
        process.exit();
    } else {
        socket.write(data);
    }
});

