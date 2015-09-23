var fs = require("fs");

/** Class Client:
  * attributes:
  *  - file
  * methods:
  *  - void setFile(String file)
  *  - String getFile()
  *  - void logMessage(String message)
  */
var Logger = function() {
}
Logger.prototype.setFile = function(file) {this.file = file;};
Logger.prototype.getFile = function() {return this.file;};
Logger.prototype.logMessage = function(message) {
    fs.appendFile(this.file, dateToString(new Date()) + " : " + message + "\n");
};

function zeroPad(nr, minLen){
    var strNumber = nr.toString();
    while (strNumber.toString().length < minLen) {
        strNumber = "0" + strNumber;
    }
    return strNumber;
};

function dateToString(date) {
    return zeroPad(date.getFullYear(), 4) + "-" 
         + zeroPad(date.getMonth(), 2) + "-" 
         + zeroPad(date.getDate(), 2) + " " 
         + zeroPad(date.getHours(), 2) + ":" 
         + zeroPad(date.getMinutes(), 2) + ":" 
         + zeroPad(date.getSeconds(), 2);
};


module.exports = Logger;
