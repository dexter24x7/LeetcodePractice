package Maths;

import java.util.HashMap;
import java.util.Map;

//535. Encode and Decode TinyURL
/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design a class to encode a URL and decode a tiny URL.
There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 */
public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode(url)));
    }
}

class Codec {
    Map<Integer, String> urlMap;
    int index;
    Codec(){
        urlMap = new HashMap<>();
        index =0;
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urlMap.put(index,longUrl);
        return "http://tinyurl.com/"+index++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] urlArr = shortUrl.split("/");
        int key = Integer.parseInt(urlArr[urlArr.length-1]);
        return urlMap.get(key);
    }
}