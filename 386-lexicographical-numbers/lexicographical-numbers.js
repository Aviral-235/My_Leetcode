/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function(n) {
    let number=[];
    for(let i=1;i<=n;i++){
        number[i-1]=i;
    }
    number.sort();
    return number;
};