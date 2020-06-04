package DesignPattern.Adapter;

//适配器的重点，适配器类
public class CardAdapter implements SDCard {

    private TFCard tfCard;

    public CardAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }
    @Override
    public int writeSD(String msg) {
        System.out.println("adapter write tf card");
        return tfCard.writeTF(msg);
    }
}
