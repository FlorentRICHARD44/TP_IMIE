var fs = require("fs");

function zeroPad(nr, minLen){
    var strNumber = nr.toString();
    while (strNumber.toString().length < minLen) {
        strNumber = "0" + strNumber;
    }
    return strNumber;
}
function dateToString(date) {
    return zeroPad(date.getFullYear(), 4) + "-" 
         + zeroPad(date.getMonth(), 2) + "-" 
         + zeroPad(date.getDate(), 2) + " " 
         + zeroPad(date.getHours(), 2) + ":" 
         + zeroPad(date.getMinutes(), 2) + ":" 
         + zeroPad(date.getSeconds(), 2);
}

function Log() {

};
Log.prototype.setLogFile = function(file) {
    this.file = file;
};
Log.prototype.logStart = function(){
    this.startDate = new Date();
    fs.appendFile(this.file, dateToString(this.startDate) + " : Démarrage du programme\n");
};
Log.prototype.logEnd = function(){
    this.endDate = new Date();
    fs.appendFile(this.file, dateToString(this.endDate) + " : Fin du programme après " + ((this.endDate - this.startDate) / 1000) + " second(s)\n");
};

module.exports = new Log();
