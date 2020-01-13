// 비트 이동 연산자 : 응용 II
package com.eomcs.basic.ex05;

public class Exam0450 {
    public static void main(String[] args) {
        // Yes/No 또는 true/false 값을 저장할 때 
        // 비트 연산자를 사용하면 메모리를 절약할 수 있다.

        // 비트 연산자 사용 전
        // => 각각의 상태를 별도의 변수에 저장해야 한다.
        // => 8개의 데이터를 저장하기 위해 32바이트가 소요된다.
        boolean c, cpp, java, js, python, php, html, css;
        c = true;
        cpp = false;
        java = true;
        js = false;
        python = true;
        php = false;
        html = true;
        css = false;

        // => 물론 배열을 이용할 수 있다.
        //    boolean 배열을 JVM에서 다룰 때는 각 boolean에 대해
        //    1바이트를 사용한다.
        // => 따라서 8개의 데이터를 저장하기 위해 8바이트를 사용한다.
        boolean[] lang = new boolean[8];
        lang[0] = true;
        lang[1] = false;
        lang[2] = true;
        lang[3] = false;
        lang[4] = true;
        lang[5] = false;
        lang[6] = true;
        lang[7] = false;

        // 비트 연산자 사용 후
        // => 4바이트 변수 한 개만 있으면 
        //    최대 32개의 데이터를 저장할 수 있다.
        // 어떻게?
        int lang2 = 0;
        // 00000000 00000000 00000000 00000000
        
        // 32비트에서 뒤에 8비트를 사용하여 8개의  true/false 값을 저장할 수 있다.
        // 8 비트에서 각 언어ㅢ 값을 저장할 비트를 다음과 같다고 가정하자.
        // 00000000
        // ||||||||- css
        // |||||||- html
        // ||||||- php
        // |||||- python
        // ||||- javascript
        // |||- java
        // ||- c++
        // |- c
        
        // 이렇게 준비된 32비트 메모리에서 특정 비트의 값을 1로 설정하고 싶다면
        // 다음과 같이 특정 비트의 값이 1인 수를 OR(|) 연산하라!
        lang2 |= 0x80; // c = true 
        // 00000000 | 10000000 = 10000000

        //lang2 |= 0x00; // c++ = false

        lang2 |= 0x20; // java = true
        // 10000000 | 00100000 = 10100000

        //lang2 |= 0x00; // js = false
        
        lang2 |= 0x08; // python = true
        // 10100000 | 00001000 = 10101000
        
        //lang2 |= 0x00; // php = false

        lang2 |= 0x02; // html = true
        // 10101000 | 00000010 = 10101010

        //lang2 |= 0x00; // css = false

        // 실무에서는 이렇게 비트를 이용하여 여러 개의 true/false를 상태를 저장하기도 한다.
        
    }
}