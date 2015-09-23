/** Class Client:
  * attributes:
  *  - connection
  *  - name
  * methods:
  *  - void setConnection(Socket connection)
  *  - Socket getConnection()
  *  - void setName(String name)
  *  - String getName()
  */
var Client = function() {   
}
Client.prototype.setConnection = function(connection) {this.connection = connection;};
Client.prototype.getConnection = function() {return this.connection;};
Client.prototype.setName = function(name) {this.name = name;};
Client.prototype.getName = function() {return this.name;};


/** Export
  * class Client
  */
module.exports = Client;

