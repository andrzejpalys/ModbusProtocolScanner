package com.andrzejpalys.ModbusProtocolScanner.connection;

public interface Observable {
    void registerObserver(Observer observer);
    void informObservers();
}