package DesignPattern.Adapter;

public class WinComputer implements Computer {
    @Override
    public String readSD(SDCard sdCard) {
        if (sdCard == null) throw new NullPointerException("sd card null");
        return sdCard.readSD();
    }
}
