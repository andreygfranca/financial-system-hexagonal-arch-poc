package com.github.andreygfranca.usecase.commons;

/**
 * @author Andrey Franca 
 */
public interface UseCase<T> {
    T execute(T t);
}
