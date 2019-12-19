// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_2 {
  public static void main(String[] args) {
    // >> 비트 이동 연산자 사용법

    // -왼쪽 쪽 빈자리를 원래 숫자와 같은 부호 값으로 채운다.
    // -양수면 0, 음수면 1을 채운다.
    // -오른쪽 경계를 넘어간 비트는 자른다.
    //
    int i = 0b01101001; // 105

    System.out.println(i); 
    // 00000000000000000000000001101001
    System.out.println(i >> 1); 
    // x0000000000000000000000001101001|1
    // 00000000000000000000000000110100 ==> 52
    System.out.println(i >> 2); 
    // xx000000000000000000000001101001|01
    // 00000000000000000000000000011010 ==> 26
    System.out.println(i >> 3); 
    // xxx0000000000000000000000011001|001
    // 0000000000000000000000000001101 ==> 13
    System.out.println(i >> 4); // 00000110|1 => 6
    // xxxx00000000000000000000011010|1001
    // 000000000000000000000000011010 ==> 6


    // 음수를 이동 :
    // -왼쪽 빈자리는 숫자의 부호비트로 채운다.
    //  음수니까 1로 채운다.
    // -2로 나눈 후에 소수점이 있으면
    //  그 수보다 더 작은 정수값이 되는 결과가 나온다.
    // 

    //-13 :
    //00001101 = 13
    //11110010
    //+      1 
    //11110010 = -13


    i = 0b11111111_11111111_11111111_10101001; // -87

    System.out.println(i); 

    System.out.println(i >> 1); 
    // x1111111111111111111111111010100|1   
    // 11111111111111111111111111010000   => -44 

    System.out.println(i >> 2); 
    // xx11111111111111111111111101010|01   
    // 1111111111111111111111111101010   => -22 

    System.out.println(i >> 3); 
    // xxx11111111111111111111111010100|001   
    // 11111111111111111111111111111010   => -11

    System.out.println(i >> 4);
    // xxxxx111111111111111111111010100|1001   
    // 11111111111111111111111111111010   => -6
  }
}

// 오른쪽 이동
// - 1비트 이동은 나누기 2 한 것과 같은 효과를 준다.
// - 소수점 있는 경우 그 수 보다 작은 바로 밑 정수 값이 된다.
//   실무에서는 나눗셈 연산이 비용(시간과 CPU 사용량)이 많이 들기 때문에
//   소수점 이하까지 정확하게 계산할 게 아니라면
//   오른쪽 비트 이동연산자를 사용하여 처리한다.