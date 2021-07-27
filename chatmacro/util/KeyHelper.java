package chatmacro.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyHelper {
    public static ArrayList<String> keys = new ArrayList<String>(Arrays.asList(
            "space",
            "'",
            ",",
            "-",
            ".",
            "/",

            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",

            ";",
            "=",

            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z",

            "[",
            "\\",
            "]",
            "`",
            "esc",
            "enter",
            "tab",
            "backspace",
            "insert",
            "del",

            "right",
            "left",
            "down",
            "up",

            "pageup",
            "pagedown",
            "home",
            "end",
            "capslock",
            "scrollLck",
            "numlock",
            "printscreen",
            "pause",

            "f1",
            "f2",
            "f3",
            "f4",
            "f5",
            "f6",
            "f7",
            "f8",
            "f9",
            "f10",
            "f11",
            "f12",

            "kp0",
            "kp1",
            "kp2",
            "kp3",
            "kp4",
            "kp5",
            "kp6",
            "kp7",
            "kp8",
            "kp9",

            "kp.",
            "kp/",
            "kp*",
            "kp-",
            "kp+",
            "kpenter",
            "kp=",

            "lshift",
            "lctrl",
            "lalt",

            "rshift",
            "rctrl",
            "ralt",
            "menu"
    )
            ){

    };

    public static boolean isKey(String key){
        if(keys.contains(key.toLowerCase())){
            return true;
        }
        return false;
    }


    public static String getKeyString(int key){
        switch(key){
            case 32: return "space";
            case 39: return "'";
            case 44: return ",";
            case 45: return "-";
            case 46: return ".";
            case 47: return "/";

            case 48: return "0";
            case 49: return "1";
            case 50: return "2";
            case 51: return "3";
            case 52: return "4";
            case 53: return "5";
            case 54: return "6";
            case 55: return "7";
            case 56: return "8";
            case 57: return "9";

            case 59: return ";";
            case 61: return "=";

            case 65: return "a";
            case 66: return "b";
            case 67: return "c";
            case 68: return "d";
            case 69: return "e";
            case 70: return "f";
            case 71: return "g";
            case 72: return "h";
            case 73: return "i";
            case 74: return "j";
            case 75: return "k";
            case 76: return "l";
            case 77: return "m";
            case 78: return "n";
            case 79: return "o";
            case 80: return "p";
            case 81: return "q";
            case 82: return "r";
            case 83: return "s";
            case 84: return "t";
            case 85: return "u";
            case 86: return "v";
            case 87: return "w";
            case 88: return "x";
            case 89: return "y";
            case 90: return "z";

            case 91: return "[";
            case 92: return "\\";
            case 93: return "]";
            case 96: return "`";
            case 256: return "esc";
            case 257: return "enter";
            case 258: return "tab";
            case 259: return "backspace";
            case 260: return "insert";
            case 261: return "del";

            case 262: return "right";
            case 263: return "left";
            case 264: return "down";
            case 265: return "up";

            case 266: return "pageup";
            case 267: return "pagedown";
            case 268: return "home";
            case 269: return "end";
            case 280: return "capslock";
            case 281: return "scrollLck";
            case 282: return "numlock";
            case 283: return "printscreen";
            case 284: return "pause";

            case 290: return "f1";
            case 291: return "f2";
            case 292: return "f3";
            case 293: return "f4";
            case 294: return "f5";
            case 295: return "f6";
            case 296: return "f7";
            case 297: return "f8";
            case 298: return "f9";
            case 299: return "f10";
            case 300: return "f11";
            case 301: return "f12";

            case 320: return "kp0";
            case 321: return "kp1";
            case 322: return "kp2";
            case 323: return "kp3";
            case 324: return "kp4";
            case 325: return "kp5";
            case 326: return "kp6";
            case 327: return "kp7";
            case 328: return "kp8";
            case 329: return "kp9";

            case 330: return "kp.";
            case 331: return "kp/";
            case 332: return "kp*";
            case 333: return "kp-";
            case 334: return "kp+";
            case 335: return "kpenter";
            case 336: return "kp=";

            case 340: return "lshift";
            case 341: return "lctrl";
            case 342: return "lalt";

            case 344: return "rshift";
            case 345: return "rctrl";
            case 346: return "ralt";
            case 348: return "menu";

            default: return "" + key;
        }
    }
}
