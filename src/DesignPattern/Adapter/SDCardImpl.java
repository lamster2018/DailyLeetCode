package DesignPattern.Adapter;

// sdcard的实现类
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        String msg = "sdcard read a msg :hello word SD";
        return msg;
    }

    @Override
    public int writeSD(String msg) {
        System.out.println("sd card write msg : " + msg);
        return 1;
    }
}
