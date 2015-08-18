function zeroPad(number,base){
    var res = "" + number;
    while (res.length < base) {
        res = "0" + res;    
    }
    return res;
}

