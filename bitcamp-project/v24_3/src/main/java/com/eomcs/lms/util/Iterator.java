package com.eomcs.lms.util;

// 컬렉션에서 값을 꺼내는 방법(사용 규칙)을 정의
public interface Iterator<E> {
  boolean hasNaxt();
  E next();
}
