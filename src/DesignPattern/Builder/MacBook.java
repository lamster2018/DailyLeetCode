package DesignPattern.Builder;

//具体产品
public class MacBook extends Computer {
    @Override
    public void setOs() {
        mOs = "OS X";
    }
}
