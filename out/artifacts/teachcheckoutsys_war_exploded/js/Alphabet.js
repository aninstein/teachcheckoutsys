
function Alphabet(){

}

Alphabet.character=function(index) {
    var ch;
    switch (index){
        case 1:ch='A';break;
        case 2:ch='B';break;
        case 3:ch='C';break;
        case 4:ch='D';break;
        case 5:ch='E';break;
        case 6:ch='F';break;
        case 7:ch='G';break;
        case 8:ch='H';break;
        case 9:ch='I';break;
        case 10:ch='J';break;
        case 11:ch='K';break;
        case 12:ch='L';break;
        case 13:ch='M';break;
        case 14:ch='N';break;
        case 15:ch='O';break;
        case 16:ch='P';break;
        case 17:ch='Q';break;
        case 18:ch='R';break;
        case 19:ch='S';break;
        case 20:ch='T';break;
        case 21:ch='u';break;
        case 22:ch='v';break;
        case 23:ch='w';break;
        case 24:ch='x';break;
        case 25:ch='y';break;
        case 26:ch='z';break;
        default:ch="";
        break;
    }
    return ch;
};

Alphabet.toNumber=function(index) {
    var ch;
    switch (index){
        case 'A':ch=1;break;
        case 'B':ch=2;break;
        case 'C':ch=3;break;
        case 'D':ch=4;break;
        case 'E':ch=5;break;
        case 'F':ch=6;break;
        case 'G':ch=7;break;
        case 'H':ch=8;break;
        case 'I':ch=9;break;
        case 'J':ch=10;break;
        case 'K':ch=11;break;
        case 'L':ch=12;break;
        case 'M':ch=13;break;
        case 'N':ch=14;break;
        case 'O':ch=15;break;
        case 'P':ch=16;break;
        case 'Q':ch=17;break;
        case 'R':ch=18;break;
        case 'S':ch=19;break;
        case 'T':ch=20;break;
        case 'U':ch=21;break;
        case 'V':ch=22;break;
        case 'W':ch=23;break;
        case 'X':ch=24;break;
        case 'Y':ch=25;break;
        case 'Z':ch=26;break;
        default:ch="";
            break;
    }
    return ch;
};
