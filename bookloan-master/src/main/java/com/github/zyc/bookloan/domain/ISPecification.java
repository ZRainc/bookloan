package com.github.zyc.bookloan.domain;


public interface ISPecification<T> {
    boolean isSatisfiedBy(T entity);
}
