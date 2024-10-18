package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    public void shouldSetDefaultStationCountIfZeroIsProvided() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getStationCount());
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationWithinValidRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationToMin() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationToMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowMin() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSetDefaultStationCountIfNegativeIsProvided() {
        Radio radio = new Radio(-5);
        assertEquals(10, radio.getStationCount());
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationCountProvidedInConstructor() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getStationCount());
        radio.setCurrentStation(14);
        assertEquals(14, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapAroundWhenNextFromMaxStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldWrapAroundWhenPrevFromMinStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPreviousStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(101);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(-1);
        assertEquals(50, radio.getCurrentVolume());
    }
}
