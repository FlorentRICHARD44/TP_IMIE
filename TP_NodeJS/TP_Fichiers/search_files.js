var log = require("./program_survey");
log.setLogFile('AppSearch.log');
log.logStart();

var fs = require('fs');
var path = require('path');

var pathFile = process.argv[2];
var extension = process.argv[3];

if (pathFile == undefined || extension == undefined) {
    console.log("Il manque des paramètres");
} else {
    fs.readdir(pathFile, function(err, files) {
        if (err) {
            console.log("Erreur dans la recherche de fichiers");
        } else {
            files.forEach(function(file) {
                if (path.extname(file) == extension) {
                    console.log(path.basename(file));
                }
            });
        }
    });    
}

log.logEnd();
