process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();
});

function readLine () {
    return input_stdin_array[input_currentline++];
}

// ///////////// ignore above this line ////////////////////

function isPrime(num){
    if(num===2){
        return true;
    }
    if(num===1 || num%2===0){
        return false;
    }
    var limit = Math.ceil(Math.sqrt(num));    
    for(var i=3; i<=limit; i++){
        if(num%i===0){
            return false;
        }
    }
    return true;
}

function areDigitsPrime(num){
    var hm = {};
    hm[0]=false;
    hm[1]=false;
    hm[2]=true;
    hm[3]=true;
    hm[4]=false;
    hm[5]=true;
    hm[6]=false;
    hm[7]=true;
    hm[8]=false;
    hm[9]=false;
    while(num>0){
        var digit = num%10;
        if(!hm[digit]){
            return false;
        }
        num = Math.floor(num / 10);
    }
    return true;
}

function main() {
    var first_temp = readLine().split(' ');
    var first = parseInt(first_temp[0]);
    var last = parseInt(first_temp[1]);
    // your code goes here
    var count = 0;
    for(var i=first; i<last; i++){
        if(isPrime(i) && areDigitsPrime(i)){
            //console.log(i);
            count++;
        }
    }
    console.log(count)
    return count;
}
