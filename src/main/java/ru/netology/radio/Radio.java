package ru.netology.radio;

public class Radio {

    private int currentStation;
    private int currentVolume;
    private int stationCount;

    public int getStationCount() {
        return stationCount;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            this.stationCount = 10;
        } else {
            this.stationCount = stationCount;
        }
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    public Radio() {
        this(10);
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newStation) {
        if (newStation >= 0 && newStation < stationCount) {
            this.currentStation = newStation;
        }
    }

    public void next() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume >= 0 && newVolume <= 100) {
            this.currentVolume = newVolume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}
