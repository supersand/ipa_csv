package csv_tool.model;

import javafx.beans.property.*;

public class Logfile
{
	private final IntegerProperty id;
	private final StringProperty var1;
    private final StringProperty timeString;
    private final StringProperty textMsg;
    private final StringProperty plc;

    public Logfile(Integer Id, String Var1, String TimeString, String TextMsg, String PLC)
    {
    	this.id = new SimpleIntegerProperty(Id);
    	this.var1 = new SimpleStringProperty(Var1);
        this.timeString = new SimpleStringProperty(TimeString);
        this.textMsg = new SimpleStringProperty(TextMsg);
        this.plc = new SimpleStringProperty(PLC);
    }

    public int getId()
    {
        return id.get();
    }

    public void setVar1(int Id)
    {
        this.id.set(Id);
    }

    public IntegerProperty idProperty()
    {
        return id;
    }

    public String getVar1()
    {
        return var1.get();
    }

    public void setVar1(String Var1)
    {
        this.var1.set(Var1);
    }

    public StringProperty var1Property()
    {
        return var1;
    }

    public String getTimeString()
    {
        return timeString.get();
    }

    public void setTimeString(String TimeString)
    {
        this.timeString.set(TimeString);
    }

    public StringProperty timeStringProperty()
    {
        return timeString;
    }

    public String getTextMsg()
    {
        return textMsg.get();
    }

    public void setTextMsg(String TextMsg)
    {
        this.textMsg.set(TextMsg);
    }

    public StringProperty textMsgProperty()
    {
        return textMsg;
    }

    public String getPLC()
    {
        return plc.get();
    }

    public void setPLC(String PLC)
    {
        this.plc.set(PLC);
    }

    public StringProperty plcProperty()
    {
        return plc;
    }

}