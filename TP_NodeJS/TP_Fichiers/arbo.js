
var fs = require("fs");
var path = require("path");

var dirPath = process.argv[2];
var deep = process.argv[3] || 1;


var searchDirsAndFiles = function(currentPath, currentDeep) {
    if (deep != undefined && (isNaN(deep) || (deep < 1))) {
        console.log("La profondeur est mal définie");
    } else {
        var files = fs.readdirSync(currentPath);
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var fileFullPath = path.join(currentPath,file)
            var stats = fs.statSync(fileFullPath);
            if (stats.isDirectory()) {
                console.log(" " + Array(currentDeep + 1).join("_") + file);
                if (currentDeep < deep) {
                    searchDirsAndFiles(fileFullPath, currentDeep + 1);
                }
            } else {
                console.log(Array(currentDeep + 1).join(" ") + file);
            }    
        }
    }
};

if (dirPath == undefined || !isNaN(dirPath)) {
    console.log("Le chemin n'est pas défini");
} else {
    fs.exists(dirPath, function(exist) {
        if (exist) {
            fs.stat(dirPath, function(err, stats) {
                if (stats.isDirectory()) {
                    searchDirsAndFiles(dirPath, 1);
                } else {
                    console.log("le chemin n'est pas un dossier");
                }
            });
        } else {
            console.log("Le chemin n'existe pas");
        }            
    });
}

