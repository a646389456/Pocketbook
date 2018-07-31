package com.example.lenovo.pocketbook;

public class StuffPresenter
{
    private PlusLessInterface pluslessinterface;
    private Stuff stuff;
    private Stuff1 stuff1;

    public StuffPresenter(PlusLessInterface plusLessInterface)
    {
        this.pluslessinterface = plusLessInterface;
        stuff = new Stuff();
        stuff1 = new Stuff1();
    }
    public void plusSucceed()
    {
        pluslessinterface.dialogPlusSucceed();
    }
    public void lessSucceed()
    {
        pluslessinterface.dialogLessSucceed();
    }
    public void plus(String leixing, String pinpai, Integer jiage, Integer shuliang)
    {
        stuff.setLeixing(leixing);
        stuff.setPinpai(pinpai);
        stuff.setJiage(jiage);
        stuff.setShuliang(shuliang);
        stuff.save();
    }
    public void less(String leixing, String pinpai, Integer jiage, Integer shuliang)
    {
        stuff1.setLeixing(leixing);
        stuff1.setPinpai(pinpai);
        stuff1.setJiage(jiage);
        stuff1.setShuliang(shuliang);
        stuff1.save();
    }
    public void clear()
    {
        pluslessinterface.clear();
    }
}

